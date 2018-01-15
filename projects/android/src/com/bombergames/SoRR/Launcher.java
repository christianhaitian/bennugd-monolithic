package com.bombergames.SoRR;

import org.libsdl.app.SDLActivity;
import android.content.*;
import android.net.Uri;


/*
 * A sample wrapper class that just calls SDLActivity
 */

public class Launcher extends SDLActivity {
    // Taken from
    // http://digitalsynapsesblog.blogspot.com.es/2011/09/cocos2d-x-launching-url-on-android.html
    public static void openURL(String url) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        mSingleton.startActivity(i);
    }

    /**
     * This method is called by SDL before loading the native shared libraries.
     * It can be overridden to provide names of shared libraries to be loaded.
     * The default implementation returns the defaults. It never returns null.
     * An array returned by a new implementation must at least contain "SDL2".
     * Also keep in mind that the order the libraries are loaded may matter.
     * @return names of shared libraries to be loaded (e.g. "SDL2", "main").
     */
    protected String[] getLibraries() {
        return new String[] {
                "SDL2",
                "SDL2_mixer",
                "bgdrtm",
                "main"
        };
    }
}
