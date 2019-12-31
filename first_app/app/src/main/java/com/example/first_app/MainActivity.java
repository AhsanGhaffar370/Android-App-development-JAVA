package com.example.first_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void send_onclick(View view){
        Toast.makeText(this, "Data send Successfully...", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Data send Successfully...", Toast.LENGTH_SHORT).show();
    }

    public void receive_onclick(View view){
        Toast.makeText(this, "Data received Successfully...", Toast.LENGTH_SHORT).show();
    }

    public void delete_onclick(View view){
        Toast.makeText(this, "Data deleted Successfully...", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
