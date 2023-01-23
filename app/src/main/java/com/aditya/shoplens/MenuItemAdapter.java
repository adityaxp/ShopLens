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

public class MenuItemAdapter extends RecyclerView.Adapter< MenuItemAdapterViewHolder > {

    private Context mContext;
    private List<MenuData> menuDataList;

    MenuItemAdapter(Context mContext, List< MenuData > menuDataList) {
        this.mContext = mContext;
        this.menuDataList = menuDataList;
    }

    @Override
    public MenuItemAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.shopping_menu_recyclerview_row_item, parent, false);
        return new MenuItemAdapterViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(final MenuItemAdapterViewHolder holder, int position) {
        holder.mImage.setImageResource(menuDataList.get(position).getMenuItemImage());
        holder.mTitle.setText(menuDataList.get(position).getMenuItemTitle());

        final int pos = position;

        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                if(menuDataList.get(pos).getMenuItemTitle().equals("Scan a product")){
                    intent = new Intent(mContext, ProductScannerActivity.class);
                    mContext.startActivity(intent);
                }
                if(menuDataList.get(pos).getMenuItemTitle().equals("Check your Cart")){
                    intent = new Intent(mContext, CartActivity.class);
                    mContext.startActivity(intent);
                }
                if(menuDataList.get(pos).getMenuItemTitle().equals("Previous Receipts")){
                    intent = new Intent(mContext, ReceiptActivity.class);
                    mContext.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuDataList.size();
    }
}

class MenuItemAdapterViewHolder extends RecyclerView.ViewHolder {

    ImageView mImage;
    TextView mTitle;
    CardView mCardView;

    MenuItemAdapterViewHolder(View itemView) {
        super(itemView);

        mImage = itemView.findViewById(R.id.ivImage);
        mTitle = itemView.findViewById(R.id.tvTitle);
        mCardView = itemView.findViewById(R.id.cardview);
    }
}