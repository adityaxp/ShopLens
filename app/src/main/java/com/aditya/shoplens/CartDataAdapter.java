package com.aditya.shoplens;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class CartDataAdapter extends RecyclerView.Adapter<CartDataAdapter.CartDataViewHolder> {

    int lastPosition = -1;
    ArrayList<CartData> cartDataArrayList;
    Context context;


    public CartDataAdapter(Context context, ArrayList<CartData> cartDataArrayList) {
        this.context = context;
        this.cartDataArrayList = cartDataArrayList;
    }


    public static class CartDataViewHolder extends RecyclerView.ViewHolder{

        ImageView productImageView;
        TextView productNameTextView;
        TextView productID;
        TextView productPrice;
        CardView cartCardView;
        Button removeButton;

        public CartDataViewHolder(@NonNull View itemView) {
            super(itemView);
            productImageView = itemView.findViewById(R.id.productImage);
            productNameTextView = itemView.findViewById(R.id.productName);
            productID = itemView.findViewById(R.id.productID);
            productPrice = itemView.findViewById(R.id.productPrice);
            cartCardView = itemView.findViewById(R.id.cartCardView);
            removeButton = itemView.findViewById(R.id.removeButton);
        }
    }


    @NonNull
    @Override
    public CartDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_row_item, parent, false);
        CartDataViewHolder cartDataViewHolder = new CartDataViewHolder(view);
        return cartDataViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final CartDataViewHolder holder, int position) {
        final CartData cartData = cartDataArrayList.get(position);



        Glide.with(context)
                .load(cartDataArrayList.get(position).getProductImage())
                .into(holder.productImageView);
        holder.productNameTextView.setText(cartData.getProductName());
        holder.productPrice.setText("Product Price: Rs." +cartData.getProductPrice());
        holder.productID.setText("Product ID: " + cartData.getProductID());
        holder.removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        setAnimation(holder.itemView, position);

    }

    public void setAnimation(View view, int position){
        if(position > lastPosition){
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF,0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            scaleAnimation.setDuration(1500);
            view.startAnimation(scaleAnimation);
            lastPosition = position;
        }

    }

    @Override
    public int getItemCount() {
        return cartDataArrayList.size();
    }
}
