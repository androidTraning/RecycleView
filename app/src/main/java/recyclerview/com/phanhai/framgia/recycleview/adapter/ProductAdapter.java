package recyclerview.com.phanhai.framgia.recycleview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import recyclerview.com.phanhai.framgia.recycleview.R;
import recyclerview.com.phanhai.framgia.recycleview.customview.ProductImageView;
import recyclerview.com.phanhai.framgia.recycleview.model.ProductModel;

/**
 * Created by phanhai on 6/3/16.
 */
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {
    private Context mContext;
    List<ProductModel> mListProduct;


    public ProductAdapter(Context context, List<ProductModel> listProduct) {
        this.mContext = context;
        this.mListProduct = listProduct;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View productItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        return new MyViewHolder(productItemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ProductModel productData = mListProduct.get(position);
        holder.name.setText(productData.getName());
        Glide.with(mContext).load(productData.getImage()).into(holder.productImg);
        holder.price.setText(String.valueOf(productData.getPrice()));
    }

    @Override
    public int getItemCount() {
        return mListProduct.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, price;
        public ProductImageView productImg;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.nameId);
            price = (TextView) view.findViewById(R.id.priceId);
            productImg = (ProductImageView) view.findViewById(R.id.productImgId);
        }
    }
}
