package com.zenovux.langla;

import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.uikit.UIApplication;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.backends.iosrobovm.IOSApplication;
import com.badlogic.gdx.backends.iosrobovm.IOSApplicationConfiguration;
import com.listener.AppEventListener;
import com.listener.IDialogTextListener;
import com.listener.VoiceRecordPermissionCallback;
import com.tgame.model.Caption;
import com.boot.GameM;

public class IOSLauncher extends IOSApplication.Delegate implements AppEventListener, IDialogTextListener  {
    @Override
    protected IOSApplication createApplication() {
        IOSApplicationConfiguration config = new IOSApplicationConfiguration();
        System.setProperty("langla.profile", "vps");
        GameM.a(this);
        GameM.b(this);
        Caption.loadVN();
        return new IOSApplication(GameM.l(), config);
    }

    public static void main(String[] argv) {
        NSAutoreleasePool pool = new NSAutoreleasePool();
        UIApplication.main(argv, null, IOSLauncher.class);
        pool.close();
    }

    @Override
    public void a() {

    }

    @Override
    public void a(VoiceRecordPermissionCallback var1) {

    }

    @Override
    public boolean b() {
        return false;
    }

    @Override
    public void a(byte[] var1) {

    }

    @Override
    public byte[] b(byte[] var1) {
        return new byte[0];
    }

    @Override
    public boolean c() {
        return false;
    }

    @Override
    public void a(Input.TextInputListener var1, String var2, String var3, String var4) {
        com.badlogic.gdx.Gdx.input.getTextInput(var1, var2, var3, var4);
    }

    @Override
    public int a(String var1, String var2) {
        return 0;
    }
}
