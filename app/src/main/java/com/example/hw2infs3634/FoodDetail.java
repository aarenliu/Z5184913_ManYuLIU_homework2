package com.example.hw2infs3634;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;



public class FoodDetail extends AppCompatActivity {

    SQLiteDatabase DB;
    TextView fooddesp;
    ImageView foodimage;
    FloatingActionButton btnCart;
    TextView foodname;
    TextView Price;
    DatabaseHelper db;

//geting the data from menu list and showing it in food detail page
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_food_detail );


        fooddesp = (TextView) findViewById( R.id.desdestail );
        foodimage = (ImageView) findViewById( R.id.image2 );
        btnCart = (FloatingActionButton) findViewById( R.id.btnCart );
        foodname = (TextView) findViewById( R.id.foodname );
        Price = (TextView) findViewById( R.id.Price );
        Button myorderbtn = findViewById( R.id.myorderbtn );
        db = new DatabaseHelper(this);


        Bundle Bundle1 = getIntent().getExtras();

        if (Bundle1 != null) {

            fooddesp.setText( Bundle1.getString( "Description" ) );
            foodimage.setImageResource( Bundle1.getInt( "Image" ) );
            foodname.setText( Bundle1.getString( "Foodname" ) );
            Price.setText( Bundle1.getString( "Price" ) );

        }


    }
    // initial order amount is 0
    int orderquantity = 0;

    // when pressing the plus btn, the order quantity should be increase by 1
    public void incquantity(View view) {
        orderquantity = orderquantity + 1;
        displayorderquantity( orderquantity );

    }

    // when pressing the minus btn, the order quantity should be decrease by 1
    public void decquantity(View view) {
        orderquantity = orderquantity - 1;
        displayorderquantity( orderquantity );

    }

    // display the final order quantity, the number will be changed when user press the plus/minus btn
    private void displayorderquantity(int orderquantity) {
        EditText displayquantity = (EditText) findViewById( R.id.quantitychangevalue );
        displayquantity.setText( "" + orderquantity );
    }

    //show the total amount for current order
    private void totalamount(String amount) {
        TextView msg = (TextView) findViewById( R.id.reusltTxt );
        msg.setText( "" + amount );
    }

    //show the final total amount ($..) for current order
    private String fintotalamount(int price) {
        String msg = "$" + price;
        return msg;
    }

    //do the calculation : price times quantity
    private int cal() {
        //as Price is TextView, so it need to change to "int" for calculation
        String pri = Price.getText().toString();
        int price = Integer.parseInt( pri );
        int i = price * orderquantity;
        return i;

    }

    //press the orderbtn, run the calculation and show the final total amount for current order
    public void orderbtn(View view) {
        int i = cal();
        String amount = fintotalamount( i );
        totalamount( amount );
        db.addData( foodname.getText().toString(), orderquantity,Integer.parseInt( Price.getText().toString() ));
        Toast.makeText(FoodDetail.this,"Added!",Toast.LENGTH_SHORT).show();
    }


}

