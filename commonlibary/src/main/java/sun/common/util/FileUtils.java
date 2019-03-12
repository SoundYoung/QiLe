package sun.common.util;

import android.content.Context;
import android.os.Environment;

/**
 * Created by soundyoung on 2017/12/12.
 * 文件管理
 */
public class FileUtils {

    public static String getSystemFilePath(Context context) {
        String cachePath;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                || !Environment.isExternalStorageRemovable()) {
            cachePath = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath();
//            cachePath = context.getExternalCacheDir().getPath();//也可以这么写，只是返回的路径不一样，具体打log看
        } else {
            cachePath = context.getFilesDir().getAbsolutePath();
//            cachePath = context.getCacheDir().getPath();//也可以这么写，只是返回的路径不一样，具体打log看
        }
        return cachePath;
    }

    /**
     * 返回应用程序的OBB文件目录（如果有的话），注意如果该应用程序没有任何OBB文件，这个目录是不存在的
     *  /storage/sdcard0/Android/data/com.example.qymh
     * **/
    public static String getObbPatch (Context context) {
        String obbPath = context.getObbDir().getAbsolutePath();
        return obbPath;
    }

    /**
     *返回通过Context.openFileOutput()创建和存储的文件系统的绝对路径，应用程序文件，这些文件会在程序被卸载的时候全部删掉。
     * /data/data/com.example.qymh/cache
     * **/
    public static String getCacheDir (Context context) {
        return  context.getCacheDir().getAbsolutePath();
    }

    /**
     * 这是一个可以存放你自己应用程序自定义的文件，你可以通过该方法返回的File实例来创建或者访问这个目录
     * ，注意该目录下的文件只有你自己的程序可以访问。
     * /data/data/com.example.qymh/test.txt
     *
     * **/
    public static String getDir (Context context,String test) {
        return context.getDir(test, Context.MODE_WORLD_WRITEABLE).getAbsolutePath();
    }

    /**
     *
     *
     * 使用这个方法需要写外部存储的权限“<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />”
     * ，调用该方法会返回应用程序的外部文件系统（Environment.getExternalStorageDirectory()）目录的绝对路径，
     * 它是用来存放应用的缓存文件，它和getCacheDir目录一样，目录下的文件都会在程序被卸载的时候被清除掉。
     * /storage/sdcard0/Android/data/com.example.qymh/cache
     * **/
    public static String getExternalCachePath  (Context context) {
        return context.getExternalCacheDir().getAbsolutePath();
    }

    /**
     *使用这个方法需要写外部存储的权限“<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />”，
     * 这个目录是与应用程序相关的外部文件系统，它和getExternalCacheDir不一样的是只要应用程序存在它就会一直存在，
     * 这些文件只属于你的应用，不能被其它人访问。同样，这个目录下的文件在程序被卸载时也会被一同删除。
     * /storage/sdcard0/Android/data/com.example.qymh/files/Music
     *
     * Environment.DIRECTORY_MUSIC
     * Music
     Podcasts
     Ringtones
     Alarms
     Notifications
     Pictures
     Movies
     *
     * **/
    public static String getExternalPath (Context context,String string) {
        return context.getExternalFilesDir(string).getAbsolutePath();
    }


    /**
     * /data/data/com.example.qymh/databases/xxx.db
     * **/
    public static String getDataBasePath (Context context,String xxx) {
       return context.getDatabasePath(xxx).getAbsolutePath();
    }
}
