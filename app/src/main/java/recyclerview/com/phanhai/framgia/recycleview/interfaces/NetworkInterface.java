package recyclerview.com.phanhai.framgia.recycleview.interfaces;

import recyclerview.com.phanhai.framgia.recycleview.model.ListProductModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by phanhai on 6/3/16.
 */

public interface NetworkInterface {
    @GET("/api/json/get/bUqWNgwPUy?indent=2")
    Call<ListProductModel> loadQuestions(@Query("list_product") String tags);
}
