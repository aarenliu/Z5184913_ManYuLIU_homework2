package com.example.hw2infs3634;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List <MenuData> menuDataList;
    MenuData FoodData;
    SQLiteDatabase DB;
    DatabaseHelper DatabaseHelper1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        DatabaseHelper1 = new DatabaseHelper(this);
        Button myorderbtn = (Button) findViewById( R.id.myorderbtn );

        //click my order btn : link to My Order page to view the order record
        myorderbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity( new Intent( MainActivity.this,Order.class ) );
            }
        } );

        recyclerView = (RecyclerView)findViewById( R.id.recyclerview );

        //Gridlayout and do the recyeleview
        GridLayoutManager GLManger = new GridLayoutManager( MainActivity.this,1);
        recyclerView.setLayoutManager( GLManger );

        menuDataList = new ArrayList<>(  );

        //add food/drink deatil "name","description","price","image" into the menu List

        FoodData = new MenuData( "Beef Burger","BurgerQueen is on of the most influential beef burgers in 2019! With double beef patties and cheddar cheese, chopped onion, pickles, mayo & special sauce ","15",R.drawable.burger);
        menuDataList.add(FoodData);
        FoodData = new MenuData( "Triple Cheese Burger","TripleCheese is on of the most influential cheese burgers in 2019! With Triple beef patties and cheddar cheese, grilled onion,lettuce ,tomato & special sauce ","20",R.drawable.triple_cheese_burger);
        menuDataList.add(FoodData);
        FoodData = new MenuData( "Pizza","Get a Pizza Party right now! Diced tomato, crumbled. mushrooms, streaky bacon rashers & onion","10",R.drawable.pizza);
        menuDataList.add(FoodData);
        FoodData = new MenuData( "Fish","The Best Fish and Chip Shops in Sydney","10",R.drawable.fish);
        menuDataList.add(FoodData);
        FoodData = new MenuData( "Spicy Chicken Wrap","New!  Wholemeal tortilla with chicken breast, lettuce, tomato, grilled onions, mayo & spicy special sauce","10",R.drawable.spicy_chicken_wrap);
        menuDataList.add(FoodData);
        FoodData = new MenuData( "Chicken Burger","ChickenKing is on of the most influential chicken burgers in 2019!With double chicken breast and cheddar cheese, chopped onion, lettuce & special sauce","15",R.drawable.chicken_burger);
        menuDataList.add(FoodData);
        FoodData = new MenuData( "Chicken Nuggets","100% Homemade Chicken Nuggets!Don't miss it!","8",R.drawable.chicken_nuggets);
        menuDataList.add(FoodData);
        FoodData = new MenuData( "Hash Brown","100% Homemade Hash Brown! Don't miss it!","6",R.drawable.hash_brown);
        menuDataList.add(FoodData);
        FoodData = new MenuData( "Chicken Caesar Salad","Chicken breasts,fresh lettuce, bacon,shaved parmesan & special sauce ","15",R.drawable.chicken_caesar_salad);
        menuDataList.add(FoodData);
        FoodData = new MenuData( "Coffee","Flat White: Single shot of espresso and steamed full cream milk ","5",R.drawable.coffee);
        menuDataList.add(FoodData);
        FoodData = new MenuData( "Sparkling Water","Fresh Fparkling Fater","5",R.drawable.sparkling_water);
        menuDataList.add(FoodData);
        FoodData = new MenuData( "Fanta","Orange Flavour","5",R.drawable.fanta);
        menuDataList.add(FoodData);
        FoodData = new MenuData( "Sprite","Lemon Lime Flavour.","5",R.drawable.sprite);
        menuDataList.add(FoodData);
        FoodData = new MenuData( "Coca-Cola","Coca-Cola","5",R.drawable.coca_cola);
        menuDataList.add(FoodData);
        FoodData = new MenuData( "Coca-Cola Vanilla","Coca-Cola Vanilla Flavour ","5",R.drawable.coca_cola_vanilla);
        menuDataList.add(FoodData);

        Adapter myAdapter = new Adapter (MainActivity.this, menuDataList);
        recyclerView.setAdapter( myAdapter);


    }



}
