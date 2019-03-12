package sun.common.util;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
/**
 * Created by soundyoung on 17/10/10.
 * 动画
 */
public class CommonAnimation {

    /**控件显示的Animation**/
    public static TranslateAnimation showAnimation(int durtime){

        TranslateAnimation mShowAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                -1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
        mShowAction.setDuration(durtime);

        return mShowAction;

    }

    /**控件隐藏的Animation**/
    public static TranslateAnimation hideAnimation(int durtime){

        TranslateAnimation mHiddenAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                -1.0f);
        mHiddenAction.setDuration(durtime);

        return mHiddenAction;

    }
}
