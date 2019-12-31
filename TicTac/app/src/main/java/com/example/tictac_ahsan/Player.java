package com.example.tictac_ahsan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Player extends AppCompatActivity {

    public static final String i1_msg="msg1";
    public static final String i2_msg="msg2";
    public static final String i3_msg="msg3";

    public void act1(View view) {
        Intent intent = new Intent(this, MainActivity.class);

        Bundle extras=new Bundle();


        String item1 = ((EditText)findViewById(R.id.p1_name)).getText().toString();
        String item2 = ((EditText)findViewById(R.id.p2_name)).getText().toString();
        String item3 = ((EditText)findViewById(R.id.series)).getText().toString();

        //for more than one values we can write in this way
        extras.putString(i1_msg,item1);
        extras.putString(i2_msg,item2);
        extras.putString(i3_msg,item3);

        intent.putExtras(extras);

        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
    }
}
