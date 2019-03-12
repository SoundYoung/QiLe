package sun.common.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import sun.common.R;



/**
 * Created by soundyoung on 17/10/9.
 * 选择照片dialog
 */
public class ImageChooseDialog extends Dialog {

    Context context;

    public ImageChooseDialog(Context context) {
        super(context);
        this.context = context;
    }

    public ImageChooseDialog(Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.dialog_img);
    }
}

