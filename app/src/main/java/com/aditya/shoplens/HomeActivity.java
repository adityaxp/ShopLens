package com.aditya.shoplens;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    Toolbar homeActivityToolBar;
    RecyclerView shoppingMenuRecyclerView;
    List<MenuData> menuDataList;
    MenuData menuData;
    TextView welcomeTextView;
    ValueEventListener valueEventListener;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        homeActivityToolBar = (Toolbar) findViewById(R.id.homeToolBar);
        welcomeTextView = (TextView) findViewById(R.id.welcomeTextView);

        setSupportActionBar(homeActivityToolBar);
        setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        homeActivityToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        databaseReference = FirebaseDatabase.getInstance("https://shoplens-27c0d-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("User").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("userName");
        valueEventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                welcomeTextView.setText("Welcome "+ dataSnapshot.getValue().toString() +"!");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        shoppingMenuRecyclerView = findViewById(R.id.shoppingMenuRecyclerView);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(HomeActivity.this, 3);
        shoppingMenuRecyclerView.setLayoutManager(mGridLayoutManager);

        menuDataList = new ArrayList<>();
        menuData = new MenuData("Scan a product", R.drawable.qrcode);
        menuDataList.add(menuData);

        menuData = new MenuData("Check your Cart", R.drawable.shoppingcart);
        menuDataList.add(menuData);

        menuData = new MenuData("Previous Receipts", R.drawable.receipt);
        menuDataList.add(menuData);

        MenuItemAdapter menuItemAdapter = new MenuItemAdapter(HomeActivity.this, menuDataList);
        shoppingMenuRecyclerView.setAdapter(menuItemAdapter);

    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.about){
            new AlertDialog.Builder(HomeActivity.this)
                    .setTitle("About")
                    .setMessage("ShopLens v0.1 (Early Access) is an application which let's you do some stuff made by Aditya")
                    .setCancelable(false)
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    })
                    .setNegativeButton("Give Feedback", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            try {
                                Intent intent = new Intent(Intent.ACTION_SEND);
                                intent.setType("*/*");
                                intent.putExtra(android.content.Intent.EXTRA_EMAIL,new String[] { "adityabalsane10@gmail.com" });
                                intent.putExtra(Intent.EXTRA_SUBJECT, "ShopLens feedback");
                                if (intent.resolveActivity(getPackageManager()) != null) {
                                    Toast.makeText(HomeActivity.this, "Thanks for your feedback!", Toast.LENGTH_SHORT).show();
                                    startActivity(intent);
                                }
                            } catch(Exception e) {
                                Toast.makeText(HomeActivity.this, "Sorry! ShopLens couldn't find an mail app on your device :(", Toast.LENGTH_SHORT).show();
                                e.printStackTrace();
                            }
                        }
                    })
                    .show();
            return true;
        }

        if(item.getItemId() == R.id.logout) {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}





