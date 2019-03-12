package sun.common.widget.recycler;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by soundyoung on 17/8/1.
 * 为recycler设置间距
 * 用法//RecycleView 增加边距
 int spacingInPixels = 8;
 mClassifyItemrecy.addItemDecoration(new SpacesItemDecoration(spacingInPixels));

 mClassifyItemrecy.setAdapter(mAdapter);
 */
public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private int space;

    public SpacesItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {
        outRect.left = space;
        outRect.right = space;
        outRect.bottom = space;

        // Add top margin only for the first item to avoid double space between items
        if (parent.getChildPosition(view) == 0)
            outRect.top = space;
    }

}
