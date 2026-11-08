package beatdz;

import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Vector;
import java.util.WeakHashMap;

/** Reparents an entire native weapon rig to the hand of the visible topup costume. */
public final class TopupWeaponRig {
    private TopupWeaponRig() {}
    /** H[400] references missing 16000 and unrelated creature artwork 16001/16003/16004. */
    public static boolean missingHeldArtwork(int appearance) { return appearance == 400; }
    private static final Map<LangLa_ju[], Map<LangLa_ju[], LangLa_ju[]>> FITTED = new WeakHashMap<LangLa_ju[], Map<LangLa_ju[], LangLa_ju[]>>();
    private static final Map<LangLa_ju[], Map<LangLa_ju[], LangLa_ju[]>> FITTED_TANTO = new WeakHashMap<>();

    // Original Quyền Năng Trượng, costume variant H[23][9].
    // Image variant, transform, X, Y. Source grip landmarks are on the shaft.
    private static final int[][] REFERENCE = {
        {0,0,-3,14},{0,0,-3,15},{1,0,-1,26},{1,0,-1,27},{1,0,-1,26},{1,0,-1,27},{1,0,-1,26},{1,0,-1,27},
        {0,0,-3,8},{0,0,-3,10},{0,0,-3,12},{0,0,-1,12},{0,0,-2,14},{0,0,-2,17},{1,0,-1,24},{1,4,0,9},
        {2,1,-10,3},{0,4,-10,-5},{2,0,-1,0},{0,0,6,10},{0,0,0,12},{0,7,0,6},{1,6,11,-2},
        {2,1,-10,-3},{0,4,-11,-14},{2,0,2,-7},{0,0,9,2},{0,0,0,7},{0,4,-10,-7},{1,6,14,-7},
        {0,0,0,0},{0,0,-3,14},{0,0,-3,15}
    };
    private static final int[][] REFERENCE_IMAGES = {{65,37,20,9},{41,63,13,20},{68,32,33,13}};
    private static final int[] TANTO_IMAGE_BASES = {58, 130, 135, 140, 145, 2940, 3034};
    // Source grip in game pixels for the three sprites in each five-frame set.
    private static final int[][] TANTO_GRIPS = {
            {12, 7, 8, 13, 49, 21},   // Candy cane
            {31, 14, 16, 27, 37, 17}, // Pumpkin lantern
            {31, 14, 16, 27, 37, 17}, // Red lantern
            {31, 14, 16, 27, 37, 17}, // Lotus lantern
            {31, 14, 16, 27, 37, 17}, // Diamond lantern
            {15, 8, 10, 16, 48, 22}, // Magic staff
            {14, 9, 10, 17, 49, 24}  // Longevity staff
    };

    /** Grip position of the native shared costume weapon skeleton, facing right. */
    public static float[] nativeGrip(int pose) {
        int[] f = REFERENCE[TopupCostumes.pose(pose)], image = REFERENCE_IMAGES[f[0]];
        return transformedGrip(f[1], f[2], f[3], image[0], image[1], image[2], image[3]);
    }

    private static float[] transformedGrip(int transform, float x, float y, float w, float h, float u, float v) {
        switch (transform) {
            case 1: return new float[]{x-w/2+u,y-v}; // mirror X, rotate 180
            case 2: return new float[]{x-h/2+v,y-w+u};
            case 3: return new float[]{x+h/2-v,y-u};
            case 4: return new float[]{x+w/2-u,y-v};
            case 5: return new float[]{x+h/2-v,y-w+u};
            case 6: return new float[]{x-h/2+v,y-u};
            case 7: return new float[]{x+w/2-u,y-h+v};
            default: return new float[]{x-w/2+u,y-h+v};
        }
    }

    static float[] tantoGrip(LangLa_ju frame, int pose) {
        for (int i = 0; i < TANTO_IMAGE_BASES.length; i++) {
            int offset = frame.a - TANTO_IMAGE_BASES[i];
            if (offset < 0 || offset >= 5) continue;
            int sprite = offset % 3;
            int[] size = REFERENCE_IMAGES[sprite];
            int[] grip = TANTO_GRIPS[i];
            return transformedGrip(frame.b, frame.d, frame.e, size[0], size[1],
                    grip[2 * sprite], grip[2 * sprite + 1]);
        }
        return nativeGrip(pose);
    }

    /** Exact source-hand landmark transformed by the currently drawn body frame. */
    public static float[] hand(LangLa_ju body) {
        return new float[]{body.d+(TopupGripAnchors.x(body.a)/256f-0.5f)*body.width,
                body.e+(TopupGripAnchors.y(body.a)/256f-1f)*body.height};
    }

    public static LangLa_jr findBody(Vector parts) {
        for (int i=0;i<parts.size();i++) {
            LangLa_jr part=(LangLa_jr)parts.elementAt(i);
            if (part.b==98 && part.d!=null && part.d.length==33 && TopupGripAnchors.index(part.d[0].a)>=0) return part;
        }
        return null;
    }

    public static void markWeaponParts(Vector parts,int start) {
        for(int i=start;i<parts.size();i++) {
            LangLa_jr part=(LangLa_jr)parts.elementAt(i);
            part.heldWeapon=true;
            if(part.weaponSourceFrames==null)part.weaponSourceFrames=part.d;
        }
    }

    public static LangLa_ju[] fitFrames(LangLa_ju[] body,LangLa_ju[] source) {
        return fitFrames(body, source, false);
    }

    public static void markTantoParts(Vector parts, int start) {
        markWeaponParts(parts, start);
        for (int i = start; i < parts.size(); i++) ((LangLa_jr) parts.elementAt(i)).heldTanto = true;
    }

    static LangLa_ju[] fitFrames(LangLa_ju[] body, LangLa_ju[] source, boolean tanto) {
        // Custom held items (e.g. the power hammer) have 128 entries; engine poses use 0..32.
        if(body==null || body.length!=33 || source==null || source.length<33)return source;
        Map<LangLa_ju[], Map<LangLa_ju[], LangLa_ju[]>> cache = tanto ? FITTED_TANTO : FITTED;
        synchronized(cache) {
            Map<LangLa_ju[],LangLa_ju[]> weapons=cache.get(body);
            if(weapons==null){weapons=new IdentityHashMap<LangLa_ju[],LangLa_ju[]>();cache.put(body,weapons);}
            LangLa_ju[] ready=weapons.get(source);if(ready!=null)return ready;
            ready=new LangLa_ju[33];
            for(int pose=0;pose<33;pose++) {
                LangLa_ju original=source[pose],copy=new LangLa_ju(original.a);
                copy.b=original.b;copy.c=original.c;copy.width=original.width;copy.height=original.height;
                float[] target=hand(body[pose]),nativeHand=tanto ? tantoGrip(original, pose) : nativeGrip(pose);
                int dx=pose==30?0:Math.round(target[0]-nativeHand[0]);
                int dy=pose==30?0:Math.round(target[1]-nativeHand[1]);
                copy.d=(short)(original.d+dx);
                copy.e=(byte)Math.max(-128,Math.min(127,original.e+dy));
                ready[pose]=copy;
            }
            weapons.put(source,ready);return ready;
        }
    }

    public static void fitHeldWeapons(Vector parts) {
        LangLa_jr body=findBody(parts);if(body==null)return;
        for(int i=0;i<parts.size();i++) {
            LangLa_jr part=(LangLa_jr)parts.elementAt(i);if(!part.heldWeapon)continue;
            if(part.weaponSourceFrames==null)part.weaponSourceFrames=part.d;
            part.d=fitFrames(body.d,part.weaponSourceFrames,part.heldTanto);
        }
    }

    /** Restore only the small palm region above the handle, as a real grip occlusion. */
    public static void drawHand(Graphics graphics,Vector parts,LangLa_jr body,int pose,int x,int y,boolean mirror) {
        if(body==null || pose==30)return;
        boolean armed=false;for(int i=0;i<parts.size();i++)if(((LangLa_jr)parts.elementAt(i)).heldWeapon){armed=true;break;}
        if(!armed)return;
        LangLa_ju frame=body.d[TopupCostumes.pose(pose)];
        mImage image=LangLa_fq.requestIconChar(frame.a);if(image==null || image.c<=1 || image.d<=1)return;
        int hx=TopupGripAnchors.x(frame.a),hy=TopupGripAnchors.y(frame.a);
        int sx=Math.max(0,Math.round((hx-9)*image.c/256f)),sy=Math.max(0,Math.round((hy-9)*image.d/256f));
        int right=Math.min(image.c,Math.round((hx+9)*image.c/256f)),bottom=Math.min(image.d,Math.round((hy+9)*image.d/256f));
        int sw=right-sx,sh=bottom-sy;if(sw<=0 || sh<=0)return;
        float w=sw*frame.width/(float)image.c,h=sh*frame.height/(float)image.d;
        float left=frame.d-frame.width/2f+sx*frame.width/(float)image.c;
        float top=frame.e-frame.height+sy*frame.height/(float)image.d;
        if(mirror)left=-left-w;
        graphics.drawTopupGripRegion(image,sx,sy,sw,sh,x+left,y+top,w,h,mirror);
    }
}
