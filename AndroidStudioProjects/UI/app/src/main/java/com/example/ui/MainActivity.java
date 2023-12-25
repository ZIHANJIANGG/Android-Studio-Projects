package com.example.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.ByteArrayOutputStream;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imageView;
    private EditText editText;
    private ProgressBar progressBar;

    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.Button);

        ImageView image = (ImageView) findViewById(R.id.image);
        //encode bitmap
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img);
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String imageString = Base64.encodeToString(imageBytes,Base64.DEFAULT);
        //decode base64 string to image
        imageBytes = Base64.decode(imageString, Base64.DEFAULT);
        Bitmap decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
        image.setImageBitmap(decodedImage);

        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        button.setOnClickListener(this);

    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.Button:
                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("你愿意给我钱吗？");
                progressDialog.setMessage(" 我愿意 ");
                progressDialog.setCancelable(true);
                progressDialog.show();

                break;
            default:
                break;
        }
    }

}

