package com.aditya.shoplens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class ReceiptActivity extends AppCompatActivity {

    Toolbar receiptToolBar;
    ReceiptAdapter receiptAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<ReceiptData> receiptDataArrayList;
    ReceiptData receiptData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);

        receiptToolBar = (Toolbar)  findViewById(R.id.receiptToolBar);

        setSupportActionBar(receiptToolBar);
        setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        receiptToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        receiptDataArrayList = new ArrayList<>();
        RecyclerView receiptRecyclerView = (RecyclerView) findViewById(R.id.receiptRecyclerView);

        layoutManager = new LinearLayoutManager(this);
        receiptAdapter = new ReceiptAdapter(this, receiptDataArrayList);
        receiptRecyclerView.setLayoutManager(layoutManager);
        receiptRecyclerView.setAdapter(receiptAdapter);

        receiptData = new ReceiptData("765456","12-04-2022", "4554");
        receiptDataArrayList.add(receiptData);

        receiptData = new ReceiptData("654456","12-12-2022", "54");
        receiptDataArrayList.add(receiptData);

        receiptData = new ReceiptData("764556","06-04-2022", "44");
        receiptDataArrayList.add(receiptData);

        receiptAdapter.notifyDataSetChanged();


    }
}