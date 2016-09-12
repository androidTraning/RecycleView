package recyclerview.com.phanhai.framgia.recycleview.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by phanhai on 6/3/16.
 */

public class ProductImageView extends ImageView {

    public ProductImageView(Context context) {
        super(context);
    }

    public ProductImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ProductImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        setMeasuredDimension(width, width);
    }
}
