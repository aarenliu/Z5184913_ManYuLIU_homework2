package com.example.hw2infs3634;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private String TABLE_NAME = "My_Order_Record";

    private String C2 = "foodname";

    private String C4 = "foodquantity";
    private String C5 = "totalprice";



    public DatabaseHelper(Context context){
        super(context,"My_Order_Record", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        String createOrderTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY NOT NULL , " + C2 + " TEXT, " + C4 + " INTEGER, " + C5 + " REAL)";
        sqLiteDatabase.execSQL( createOrderTable );

    }

    public void addData(String foodName, int foodQuantity, double price){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(C2, foodName);
        values.put(C4, foodQuantity);
        values.put(C5, price);

        // Inserting Row
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public void submitorder (String foodName, TextView foodQuantity, double price){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = String.format("DELETE FROM orderrecordList");
        db.execSQL(query);

    }



    public ArrayList<OrderRecord> getAllOrders() {
        ArrayList<OrderRecord> orderRecord = new ArrayList<OrderRecord>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);


        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                OrderRecord r = new OrderRecord(cursor.getString(1), cursor.getInt(2), cursor.getInt(3));
                // Adding order to list
                orderRecord.add(r);
            } while (cursor.moveToNext());
        }

        // return order list
        return orderRecord;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }



}



