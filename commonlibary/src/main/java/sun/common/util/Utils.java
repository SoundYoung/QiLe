package sun.common.util;

import android.content.Context;
import android.view.WindowManager;

/**
 * Created by soundyoung on 17/10/11.
 * 一些常用的功能
 */
public class Utils {

    /**获取屏幕宽度**/
    public static int getScreenWidth (Context context) {
        WindowManager wm = (WindowManager)context
                .getSystemService(Context.WINDOW_SERVICE);

        return wm.getDefaultDisplay().getWidth();
    }

    /**获取屏幕高度**/
    public static int getScreenHeight (Context context) {
        WindowManager wm = (WindowManager)context
                .getSystemService(Context.WINDOW_SERVICE);
        return  wm.getDefaultDisplay().getHeight();
    }
}
