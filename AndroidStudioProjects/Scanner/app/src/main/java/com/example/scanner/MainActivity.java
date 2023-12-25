package com.example.scanner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {
    Button btscan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //assign variable
        btscan = findViewById(R.id.bt_scan);
        btscan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                IntentIntegrator integrator = new IntentIntegrator(
                        MainActivity.this
                );
                //set prompt text
                integrator.setPrompt("For flash use volume up key");
                //set beep
                integrator.setBeepEnabled(true);
                //locked orientation
                integrator.setOrientationLocked(true);
                //set capture activity
                integrator.setCaptureActivity(Capture.class);
                //Initiate scan
                integrator.initiateScan();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //initialize intent result
        IntentResult intentResult = IntentIntegrator.parseActivityResult(
                requestCode,resultCode,data
        );
        //Check condition
        if(intentResult.getContents() != null){
            //When result content is not null
            //Initialize alert dialog
            AlertDialog.Builder builder = new AlertDialog.Builder(
                    MainActivity.this
            );
            //Set title
            builder.setTitle("Result");
            //Set message
            builder.setMessage(intentResult.getContents());
            //Set positive button
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //dismiss dialog
                    dialogInterface.dismiss();
                }
            });
            //show alert dialog
            builder.show();
        }else{
            //When result is null
            //display toast
            Toast.makeText(getApplicationContext(),"OOPS....",Toast.LENGTH_SHORT).show();
        }
    }
}
