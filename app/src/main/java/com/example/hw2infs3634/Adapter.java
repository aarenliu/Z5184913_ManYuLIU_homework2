package com.example.hw2infs3634;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<FoodViewHoolder> {


    private MainActivity context;
    private List<MenuData> Foodlist;




    public Adapter(MainActivity context, List<MenuData> foodlist) {
        this.context = context;
        Foodlist = foodlist;
    }


    @NonNull

    @Override
    public FoodViewHoolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from( parent.getContext() ).inflate( R.layout.recycler, parent, false );

        return new FoodViewHoolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull final FoodViewHoolder holder, int p) {

        holder.imageView.setImageResource( Foodlist.get(p ).getFoodimage() );
        holder.foodprice.setText( Foodlist.get( p ).getFoodPrice() );
        holder.fooddes.setText( Foodlist.get( p ).getFoodDes() );
        holder.foodtitle.setText( Foodlist.get( p ).getFoodName() );

        holder.cardView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent i = new Intent( context,FoodDetail.class );
                    i.putExtra( "Image", Foodlist.get(holder.getAdapterPosition() ).getFoodimage());
                    i.putExtra( "Description", Foodlist.get(holder.getAdapterPosition()).getFoodDes());
                    i.putExtra( "Price", Foodlist.get(holder.getAdapterPosition()).getFoodPrice());
                    i.putExtra( "Foodname", Foodlist.get(holder.getAdapterPosition()).getFoodName());
                    context.startActivity(i);
            }
        });

            }


        @Override
        public int getItemCount() {
            return Foodlist.size();
        }

    }

    class FoodViewHoolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView foodtitle, fooddes, foodprice;
        CardView cardView;


        public FoodViewHoolder(View foodView) {
            super( foodView );

            imageView = itemView.findViewById( R.id.image );
            foodtitle = itemView.findViewById( R.id.foodtitle );
            fooddes = itemView.findViewById( R.id.MenuDes );
            foodprice = itemView.findViewById( R.id.FoodPrice );
            cardView = itemView.findViewById( R.id.menucardview );


        }





    }
