package recyclerview.com.phanhai.framgia.recycleview.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by phanhai on 6/3/16.
 */
public class ProductModel {
    @SerializedName("image")
    private String image;

    @SerializedName("name")
    private String name;

    @SerializedName("price")
    private double price;

    public ProductModel(String image, String name, double price) {
        this.image = image;
        this.name = name;
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
