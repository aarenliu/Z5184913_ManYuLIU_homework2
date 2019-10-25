package com.example.hw2infs3634;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class OrderAdapter extends RecyclerView.Adapter<OrderViewHolder>{

    private Order context;
    private List<OrderRecord> OrderList;




    public OrderAdapter(Order context, List<OrderRecord> OrderList) {
        this.context = context;
        this.OrderList = OrderList;
    }


    @NonNull

    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.orderre, parent, false );

        return new OrderViewHolder( view );
    }


    @Override
    public void onBindViewHolder(@NonNull final OrderViewHolder holder1, int p) {
        holder1.orderpagequantity.setText( OrderList.get(p ).getFoodQua1() + "");
        holder1.orderpagefoodname.setText( OrderList.get( p ).getFoodName() );
        holder1.orderpagetotal.setText( OrderList.get( p ).getFoodPrice() +"" );

    }



    @Override
    public int getItemCount() {
        return OrderList.size();
    }

}

class OrderViewHolder extends RecyclerView.ViewHolder {
    TextView orderpagetotal, orderpagefoodname, orderpagequantity;
    CardView ordercardview;



    public OrderViewHolder(View orderView) {
        super( orderView );

        orderpagetotal = itemView.findViewById( R.id.orderpagetotal );
        orderpagefoodname = itemView.findViewById( R.id.orderpagefoodname );
        orderpagequantity = itemView.findViewById( R.id.orderpagequantity );
        ordercardview = itemView.findViewById( R.id.ordercardview );

    }

}
