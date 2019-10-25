package com.example.hw2infs3634;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Order extends AppCompatActivity {


    RecyclerView orderlist;
    List<OrderRecord> orderrecordList;
    DatabaseHelper db;
    OrderRecord Orderrecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.orderpage );

        orderlist = (RecyclerView) findViewById( R.id.orderlist );

        //call data from database
        db = new DatabaseHelper( this );
        orderrecordList = db.getAllOrders();
        OrderAdapter OrderAdapter = new OrderAdapter( Order.this, orderrecordList );
        orderlist.setAdapter( OrderAdapter );


        //Gridlayout and do the recyeleview
        GridLayoutManager GLManger = new GridLayoutManager( Order.this, 1 );
        orderlist.setLayoutManager( GLManger );

    }

    //click submit btn and run submit order (drop all data)
   /* public void submitorderbtn(View view) {
            db.submitorder ( orderpagefoodname.getText().toString(), orderpagequantity,Integer.parseInt( orderpagetotal.getText().toString() ));
        Toast.makeText(Order.this,"Done!",Toast.LENGTH_SHORT).show();
    }

     */


    private void totalprice(String amount) {
        TextView msg = (TextView) findViewById( R.id.orderamount );
        msg.setText( ""+amount );
    }
    //add dollor sign $
    private String fintotalamount(int price) {
        String msg = "$" + price;
        return msg;
    }

    //do the calculation : price time order quantity
    private int cal(){
        int total =0;
        for (OrderRecord order:orderrecordList)
            total+=((order.getFoodPrice()*order.getFoodQua1()));
        return total;

    }

    //convert amount to String then show msg
    public void fin (View view){
        int i = cal();
        String amount = fintotalamount( i );
         totalprice( amount );
    }

}






