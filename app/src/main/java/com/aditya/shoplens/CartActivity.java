package com.aditya.shoplens;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    Toolbar cartToolBar;
    CartDataAdapter cartDataAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<CartData> cartDataList;
    CartData cartData;
    Button addItemButton, checkOutButton;
    DatabaseReference databaseReference;
    ValueEventListener valueEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartToolBar = (Toolbar) findViewById(R.id.cartToolBar);
        setSupportActionBar(cartToolBar);
        setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        cartToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        cartDataList = new ArrayList<>();
        RecyclerView shoppingCartRecyclerView = (RecyclerView) findViewById(R.id.shoppingCartRecyclerView);

        layoutManager = new LinearLayoutManager(this);
        cartDataAdapter = new CartDataAdapter(this, cartDataList);
        shoppingCartRecyclerView.setLayoutManager(layoutManager);
        shoppingCartRecyclerView.setAdapter(cartDataAdapter);

//        cartData = new CartData("1234", "https://www.google.com/imgres?imgurl=https%3A%2F%2Fimages.pexels.com%2Fphotos%2F268533%2Fpexels-photo-268533.jpeg%3Fauto%3Dcompress%26cs%3Dtinysrgb%26dpr%3D1%26w%3D500&imgrefurl=https%3A%2F%2Fwww.pexels.com%2Fsearch%2Freflection%2F&tbnid=_-Vib8M68QmuuM&vet=12ahUKEwjMuPaYhJv7AhUTDrcAHXdSC48QMygEegUIARDVAQ..i&docid=GAYubCMnDcwZgM&w=500&h=333&q=images&ved=2ahUKEwjMuPaYhJv7AhUTDrcAHXdSC48QMygEegUIARDVAQ", "ABCD", "1250");
//        cartDataList.add(cartData);
//        cartDataAdapter.notifyDataSetChanged();


        checkOutButton = (Button) findViewById(R.id.checkOutButton);
        addItemButton = (Button) findViewById(R.id.addItemButton);
        addItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartActivity.this, ProductScannerActivity.class);
                startActivity(intent);
            }

        });


        databaseReference =  FirebaseDatabase.getInstance("https://shoplens-27c0d-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("UserCart").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        valueEventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot itemSnapshot: dataSnapshot.getChildren()){
                    CartData groupData = itemSnapshot.getValue(CartData.class);
                    cartDataList.add(groupData);
                }
                cartDataAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(CartActivity.this, "Failed!!", Toast.LENGTH_SHORT).show();
            }
        });

        checkOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartActivity.this, ShoppingCartLottieActivity.class);
                startActivity(intent);
            }
        });




    }
}