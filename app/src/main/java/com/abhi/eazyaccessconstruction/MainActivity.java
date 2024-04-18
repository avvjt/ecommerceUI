package com.abhi.eazyaccessconstruction;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.abhi.eazyaccessconstruction.adapter.ProductAdapter;
import com.abhi.eazyaccessconstruction.adapter.ProductCategoryAdapter;
import com.abhi.eazyaccessconstruction.model.ProductCategory;
import com.abhi.eazyaccessconstruction.model.Products;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ProductCategoryAdapter productCategoryAdapter;
    RecyclerView productCatRecycler, prodItemRecycler;
    ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);



        List<ProductCategory> productCategoryList = new ArrayList<>();
        productCategoryList.add(new ProductCategory(1, "Trending"));
        productCategoryList.add(new ProductCategory(2, "Most Popular"));
        productCategoryList.add(new ProductCategory(3, "All Body Products"));
        productCategoryList.add(new ProductCategory(4, "Skin Care"));
        productCategoryList.add(new ProductCategory(5, "Hair Care"));
        productCategoryList.add(new ProductCategory(6, "Make Up"));
        productCategoryList.add(new ProductCategory(7, "Fragrance"));

        setProductRecycler(productCategoryList);

        List<Products> productsList = new ArrayList<>();
        productsList.add(new Products(1, "Japanese Cherry Blossom", "250 ml", "$ 17.00", R.drawable.prod2));
        productsList.add(new Products(2, "African Mango Shower Gel", "350 ml", "$ 25.00", R.drawable.prod1));
        productsList.add(new Products(1, "Japanese Cherry Blossom", "250 ml", "$ 17.00", R.drawable.prod2));
        productsList.add(new Products(2, "African Mango Shower Gel", "350 ml", "$ 25.00", R.drawable.prod1));
        productsList.add(new Products(1, "Japanese Cherry Blossom", "250 ml", "$ 17.00", R.drawable.prod2));
        productsList.add(new Products(2, "African Mango Shower Gel", "350 ml", "$ 25.00", R.drawable.prod1));

        setProdItemRecycler(productsList);

    }


    private void setProductRecycler(List<ProductCategory> productCategoryList){

        productCatRecycler = findViewById(R.id.cat_recycler);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        productCatRecycler.setLayoutManager(layoutManager);
        productCategoryAdapter = new ProductCategoryAdapter(this, productCategoryList);
        productCatRecycler.setAdapter(productCategoryAdapter);

    }

    private void setProdItemRecycler(List<Products> productsList){

        prodItemRecycler = findViewById(R.id.product_recycler);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        prodItemRecycler.setLayoutManager(layoutManager);
        productAdapter = new ProductAdapter(this, productsList);
        prodItemRecycler.setAdapter(productAdapter);

    }
}