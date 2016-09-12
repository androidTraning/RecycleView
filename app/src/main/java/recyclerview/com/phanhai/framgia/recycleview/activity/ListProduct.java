package recyclerview.com.phanhai.framgia.recycleview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import recyclerview.com.phanhai.framgia.recycleview.R;
import recyclerview.com.phanhai.framgia.recycleview.adapter.ProductAdapter;
import recyclerview.com.phanhai.framgia.recycleview.interfaces.NetworkInterface;
import recyclerview.com.phanhai.framgia.recycleview.model.ListProductModel;
import recyclerview.com.phanhai.framgia.recycleview.model.ProductModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListProduct extends AppCompatActivity implements Callback<ListProductModel> {
    RecyclerView recycleView;
    List<ProductModel> listProducts = new ArrayList<>();
    ProductAdapter mAdapter;
    int page = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_product);

        recycleView = (RecyclerView) findViewById(R.id.recycleId);
        recycleView.setVisibility(View.GONE);
        mAdapter = new ProductAdapter(this, listProducts);
        StaggeredGridLayoutManager mLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recycleView.setLayoutManager(mLayoutManager);
        recycleView.setAdapter(mAdapter);

        loadData();
    }


    private  void loadData() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("").addConverterFactory(GsonConverterFactory.create()).build();
        NetworkInterface api = retrofit.create(NetworkInterface.class);
        Call<ListProductModel> call = api.loadQuestions("list_product");
        call.enqueue(ListProduct.this);
    }

    @Override
    public void onResponse(Call<ListProductModel> call, Response<ListProductModel> response) {
        listProducts.clear();
        listProducts.addAll(response.body().products);
        mAdapter.notifyDataSetChanged();
        recycleView.setVisibility(View.VISIBLE);
        Log.d("Tag", "Request data " + new Gson().toJson(response));
    }

    @Override
    public void onFailure(Call<ListProductModel> call, Throwable t) {
        Toast.makeText(this, "Loi roi ", Toast.LENGTH_LONG);
    }
}
