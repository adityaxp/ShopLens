package com.aditya.shoplens;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProductInfoActivity extends AppCompatActivity {

    Intent intent;
    String productID = "";
    Toolbar productInfoToolBar;
    TextView productIDTextView, productNameTextView, productCategoryTextView, productDateTextView, productExpiryDateTextView, productPriceTextView, productDescriptionTextView, productStockTextView;
    Button addToCartButton, buyNowButton;
    ImageView productImageView;
    String productImageURL = "";
    String productPrice = "";
    String productName = "";
    ValueEventListener valueEventListener;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_info);

        intent = getIntent();
        productID = intent.getStringExtra("ProductID");

        productInfoToolBar = (Toolbar) findViewById(R.id.productInfoToolBar);
        productIDTextView = (TextView) findViewById(R.id.productIDTextView);
        productNameTextView = (TextView) findViewById(R.id.productNameTextView);
        productCategoryTextView = (TextView) findViewById(R.id.productCategoryTextView);
        productDateTextView = (TextView) findViewById(R.id.productDateTextView);
        productExpiryDateTextView = (TextView) findViewById(R.id.productExpiryDateTextView);
        productPriceTextView = (TextView) findViewById(R.id.productPriceTextView);
        productDescriptionTextView = (TextView) findViewById(R.id.productStockTextView);
        productStockTextView = (TextView)findViewById(R.id.productStockTextView);
        addToCartButton = (Button) findViewById(R.id.addToCartButton);
        buyNowButton = (Button) findViewById(R.id.buyNowButton);
        productImageView = (ImageView) findViewById(R.id.productImageView);

        productIDTextView.setText(productIDTextView.getText() + "209475");

        databaseReference = FirebaseDatabase.getInstance("https://shoplens-27c0d-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("Products").child(productID);
        valueEventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    productNameTextView.setText("Product Name : "+ dataSnapshot.child("ProductName").getValue().toString());
                    productCategoryTextView.setText("Product Category : " + dataSnapshot.child("ProductCategory").getValue().toString());
                    productDateTextView.setText("Product Manufacturing Date : " + dataSnapshot.child("ProductManufacturingDate").getValue().toString());
                    productExpiryDateTextView.setText("Product Expiry : " + dataSnapshot.child("ProductExpiry").getValue().toString());
                    productPriceTextView.setText("Product Price : " + dataSnapshot.child("ProductPrice").getValue().toString());
                    productStockTextView.setText("Product Stock : " + dataSnapshot.child("ProductStock").getValue().toString());
                    productDescriptionTextView.setText("Product Description : " + dataSnapshot.child("ProductDesc").getValue().toString());
                    Glide.with(ProductInfoActivity.this).load(dataSnapshot.child("ProductImageURL").getValue().toString()).into(productImageView);
                    productImageURL = dataSnapshot.child("ProductImageURL").getValue().toString();
                    productName = dataSnapshot.child("ProductName").getValue().toString();
                    productPrice = dataSnapshot.child("ProductPrice").getValue().toString();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CartData cartData = new CartData(productID, productImageURL, productNameTextView.getText().toString(), productPriceTextView.getText().toString());
                FirebaseDatabase.getInstance("https://shoplens-27c0d-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("UserCart").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(productID).setValue(cartData).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(ProductInfoActivity.this, "Product added to cart", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ProductInfoActivity.this, CartActivity.class);
                        startActivity(intent);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ProductInfoActivity.this, "Failed!", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        buyNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductInfoActivity.this, ShoppingCartLottieActivity.class);
                startActivity(intent);
            }
        });


        setSupportActionBar(productInfoToolBar);
        setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        productInfoToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


    }
}