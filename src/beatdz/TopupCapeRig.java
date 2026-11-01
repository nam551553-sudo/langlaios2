package beatdz;

import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Vector;
import java.util.WeakHashMap;

/** Shoulder attachment for native capes on the full-sprite topup bodies. */
public final class TopupCapeRig {
    private TopupCapeRig() {}
    private static final Map<LangLa_ju[],Map<LangLa_ju[],LangLa_ju[]>> FITTED = new WeakHashMap<LangLa_ju[],Map<LangLa_ju[],LangLa_ju[]>>();

    public static int sourceCategory(int image) {
        int index=TopupGripAnchors.index(image);
        if(index<0)return 0;
        int raw=image-TopupGripAnchors.BASES[index];
        return raw==0 || raw>=25 ? 0 : raw<=6 ? 1 : raw<=9 ? 2 : raw<=12 ? 3 : raw<=15 ? 1 : raw<=17 ? 4 : raw<=19 ? 5 : 6;
    }

    // Rear shoulder relative to the visible hand, in the source 256 x 256 canvas.
    // Full-sprite bodies need the fastening behind the torso rather than at the front hand.
    private static final int[][] SHOULDER_OFFSETS={{0,-42},{8,-25},{-52,-30},{48,-24},{-45,-12},{0,-25},{-12,-50}};
    public static float[] shoulder(LangLa_ju body) {
        int[] offset=SHOULDER_OFFSETS[sourceCategory(body.a)];
        float x=TopupGripAnchors.x(body.a)+offset[0],y=TopupGripAnchors.y(body.a)+offset[1];
        return new float[]{body.d+(x/256f-0.5f)*body.width,body.e+(y/256f-1f)*body.height};
    }

    /** Shoulder of the original costume body, same right-facing coordinates as the cape rig. */
    public static float[] nativeShoulder(int pose) {
        switch(TopupCostumes.pose(pose)) {
            case 0: case 31: return new float[]{-2,-24};
            case 1: case 32: return new float[]{-2,-23};
            case 2: case 4: case 6: return new float[]{5,-23};
            case 3: case 5: case 7: return new float[]{5,-22};
            case 8: return new float[]{5,-28};
            case 9: return new float[]{5,-26};
            case 10: return new float[]{5,-24};
            case 11: return new float[]{5,-24};
            case 12: return new float[]{4,-22};
            case 13: return new float[]{4,-19};
            case 14: return new float[]{4,-24};
            case 15: return new float[]{4,-23};
            case 16: return new float[]{4,-25};
            case 17: return new float[]{6,-24};
            case 18: return new float[]{7,-25};
            case 19: return new float[]{-3,-25};
            case 20: return new float[]{7,-23};
            case 21: return new float[]{-5,-24};
            case 22: return new float[]{-7,-25};
            case 23: return new float[]{4,-26};
            case 24: return new float[]{5,-27};
            case 25: return new float[]{9,-24};
            case 26: return new float[]{4,-26};
            case 27: return new float[]{6,-23};
            case 28: return new float[]{8,-22};
            case 29: return new float[]{-4,-26};
            default: return new float[]{0,-22};
        }
    }

    public static void markCapeParts(Vector parts,int start) {
        for(int i=start;i<parts.size();i++) {
            LangLa_jr part=(LangLa_jr)parts.elementAt(i);
            part.wornCape=true;
            if(part.capeSourceFrames==null)part.capeSourceFrames=part.d;
        }
    }

    public static LangLa_ju[] fitFrames(LangLa_ju[] body,LangLa_ju[] source) {
        if(body==null || body.length!=33 || source==null || source.length<33)return source;
        synchronized(FITTED) {
            Map<LangLa_ju[],LangLa_ju[]> capes=FITTED.get(body);
            if(capes==null){capes=new IdentityHashMap<LangLa_ju[],LangLa_ju[]>();FITTED.put(body,capes);}
            LangLa_ju[] ready=capes.get(source);if(ready!=null)return ready;
            ready=new LangLa_ju[33];
            for(int pose=0;pose<33;pose++) {
                LangLa_ju original=source[pose],copy=new LangLa_ju(original.a);
                copy.b=original.b;copy.c=original.c;copy.width=original.width;copy.height=original.height;
                float[] target=shoulder(body[pose]),nativeAnchor=nativeShoulder(pose);
                int dx=pose==30?0:Math.round(target[0]-nativeAnchor[0]);
                int dy=pose==30?0:Math.round(target[1]-nativeAnchor[1]);
                copy.d=(short)(original.d+dx);
                copy.e=(byte)Math.max(-128,Math.min(127,original.e+dy));
                ready[pose]=copy;
            }
            capes.put(source,ready);return ready;
        }
    }

    public static void fitCapes(Vector parts) {
        LangLa_jr body=TopupWeaponRig.findBody(parts);if(body==null)return;
        for(int i=0;i<parts.size();i++) {
            LangLa_jr part=(LangLa_jr)parts.elementAt(i);if(!part.wornCape)continue;
            if(part.capeSourceFrames==null)part.capeSourceFrames=part.d;
            part.d=fitFrames(body.d,part.capeSourceFrames);
        }
    }
}
