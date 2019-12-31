package com.example.tictac_ahsan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class end1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end1);
    }


    public void startA(View view) {
        Intent intent = new Intent(this, Player.class);
        startActivity(intent);
    }

}
