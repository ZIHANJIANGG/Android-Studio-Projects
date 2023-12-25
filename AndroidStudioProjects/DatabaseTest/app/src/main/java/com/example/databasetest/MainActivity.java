package com.example.databasetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private MydatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new MydatabaseHelper(this,"BookStore.dp",null,1);
        Button createDatabase = (Button) findViewById(R.id.create_database);
        Button addData = (Button) findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("names","The Da Vinci Code");
                values.put("author","Dan Brown");
                values.put("pages",454);
                db.insert("Book",null,values);
                values.clear();
                values.put("names","Lost Symbol");
                values.put("pages",510);
                values.put("author","Din Brown");
                db.insert("Book",null,values);

            }
        });
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.getWritableDatabase();
            }
        });
    }
}