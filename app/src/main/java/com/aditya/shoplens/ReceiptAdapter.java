package com.aditya.shoplens;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReceiptAdapter extends RecyclerView.Adapter< ReceiptAdapterViewHolder > {

    private Context mContext;
    private List<ReceiptData> receiptDataList;

    ReceiptAdapter(Context mContext, List< ReceiptData > receiptDataList) {
        this.mContext = mContext;
        this.receiptDataList = receiptDataList;
    }

    @Override
    public ReceiptAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.receipt_row_item, parent, false);
        return new ReceiptAdapterViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(final ReceiptAdapterViewHolder holder, int position) {
        holder.receiptID.setText("Receipt ID: " + receiptDataList.get(position).getReceiptID());
        holder.receiptDate.setText("Receipt Date: " +receiptDataList.get(position).getReceiptDate());
        holder.receiptAmount.setText("Receipt Amount: " +receiptDataList.get(position).getReceiptAmount());


        final int pos = position;

    }

    @Override
    public int getItemCount() {
        return receiptDataList.size();
    }
}

class ReceiptAdapterViewHolder extends RecyclerView.ViewHolder {

    TextView receiptID, receiptDate,receiptAmount;



    ReceiptAdapterViewHolder(View itemView) {
        super(itemView);

        receiptID = itemView.findViewById(R.id.receiptID);
        receiptDate = itemView.findViewById(R.id.receiptDate);
        receiptAmount = receiptAmount = itemView.findViewById(R.id.receiptAmount);

    }
}