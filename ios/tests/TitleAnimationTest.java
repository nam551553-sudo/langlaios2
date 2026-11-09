import beatdz.*;
import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.GdxNativesLoader;
import java.lang.reflect.Proxy;
import java.nio.file.*;
import java.util.Arrays;

public class TitleAnimationTest {
    static void check(boolean ok,String message){if(!ok)throw new AssertionError(message);}
    static Object defaultValue(Class<?> type){
        if(type==boolean.class)return false;
        if(type==int.class)return 1;
        if(type==float.class)return 0f;
        if(type==long.class)return 0L;
        return null;
    }
    public static void main(String[] args)throws Exception{
        GdxNativesLoader.load();
        Path cache=java.nio.file.Files.createTempDirectory("title-animation-test");
        Gdx.files=(com.badlogic.gdx.Files)Proxy.newProxyInstance(com.badlogic.gdx.Files.class.getClassLoader(),new Class[]{com.badlogic.gdx.Files.class},(p,m,a)->{
            if(m.getName().equals("local") || m.getName().equals("internal"))return new com.badlogic.gdx.files.FileHandle(cache.resolve((String)a[0]).toFile());
            return defaultValue(m.getReturnType());
        });
        Gdx.app=(Application)Proxy.newProxyInstance(Application.class.getClassLoader(),new Class[]{Application.class},(p,m,a)->m.getName().equals("getType")?Application.ApplicationType.Desktop:defaultValue(m.getReturnType()));
        Gdx.graphics=(com.badlogic.gdx.Graphics)Proxy.newProxyInstance(com.badlogic.gdx.Graphics.class.getClassLoader(),new Class[]{com.badlogic.gdx.Graphics.class},(p,m,a)->defaultValue(m.getReturnType()));
        Gdx.gl=Gdx.gl20=(GL20)Proxy.newProxyInstance(GL20.class.getClassLoader(),new Class[]{GL20.class},(p,m,a)->defaultValue(m.getReturnType()));
        verifyAnimation(32400, 15, 120);
        verifyAnimation(32600, 64, 50);
        mImage legacy=Binary.createImage(128,72);
        LangLa_fq.e.put(Short.valueOf((short)1174),legacy);
        check(new Char.DanhHieuByBeatdz(1174).currentFrame()!=null && !legacy.smoothScaling,"Legacy title behavior changed");
        System.out.println("PASS: frame order, smoothing and missing-frame fallback for danhhieu1 and danhhieu2, plus legacy title.");
        System.exit(0);
    }

    private static void verifyAnimation(int firstId, int frameCount, int frameMs) throws Exception {
        int[] ids=new int[frameCount];
        for(int i=0;i<frameCount;i++){
            ids[i]=firstId+i;
            LangLa_fq.e.put(Short.valueOf((short)ids[i]),Binary.createImage(128,72));
        }
        Char.DanhHieuByBeatdz title=new Char.DanhHieuByBeatdz(ids);
        title.timeMS=frameMs;
        title.size=60;
        check(title.displaySize(400)==(firstId==32600?120:240),"Wrong title display scale");
        check(title.displayY(100)==(firstId==32600?80:70),"Wrong title vertical placement");
        check(Arrays.equals(ids,title.array_Id),"Frame order changed");
        TextureRegion ready=title.currentFrame();
        check(ready!=null && ready.getRegionWidth()==128 && ready.getRegionHeight()==72,"Cached title not rendered");
        boolean filtered=false;
        for(int id:ids)filtered|=((mImage)LangLa_fq.e.get(Short.valueOf((short)id))).smoothScaling;
        check(filtered,"Title smoothing not enabled");
        Arrays.fill(title.array,null);
        for(int id:ids)LangLa_fq.e.put(Short.valueOf((short)id),LangLa_fq.a);
        check(title.currentFrame()==ready,"Missing frame flickers instead of retaining ready frame");
    }
}
