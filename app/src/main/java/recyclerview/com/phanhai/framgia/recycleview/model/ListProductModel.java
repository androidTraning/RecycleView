package recyclerview.com.phanhai.framgia.recycleview.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by phanhai on 6/3/16.
 */

public class ListProductModel {
    @SerializedName("data")
    public List<ProductModel> products;
}
