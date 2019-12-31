package com.example.multiscreenintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String i1_msg="com.example.multiscreenintents.msg1";
    public static final String i2_msg="com.example.multiscreenintents.msg2";
    public static final String i3_msg="com.example.multiscreenintents.msg3";
    public static final String q1_msg="com.example.multiscreenintents.msg4";
    public static final String q2_msg="com.example.multiscreenintents.msg5";
    public static final String q3_msg="com.example.multiscreenintents.msg6";

    public void place_order(View view)
    {
        Intent intent=new Intent(this, order_comp.class);
        Bundle extras=new Bundle();


        String item1 = ((EditText)findViewById(R.id.item1)).getText().toString();
        String item2 = ((EditText)findViewById(R.id.item2)).getText().toString();
        String item3 = ((EditText)findViewById(R.id.item3)).getText().toString();

        String quant1 = ((EditText)findViewById(R.id.qty1)).getText().toString();
        String quant2 = ((EditText)findViewById(R.id.qty2)).getText().toString();
        String quant3 = ((EditText)findViewById(R.id.qty3)).getText().toString();

//       for one value we can write in this way
//        intent.putExtra(q1_msg,quant1);
//        startActivity(intent);

        //for more than one values we can write in this way
        extras.putString(i1_msg,item1);
        extras.putString(i2_msg,item2);
        extras.putString(i3_msg,item3);
        extras.putString(q1_msg,quant1);
        extras.putString(q2_msg,quant2);
        extras.putString(q3_msg,quant3);

        intent.putExtras(extras);
        startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

}

//how to set text in input type number field
//((EditText)findViewById(R.id.qty1)).setText("2", TextView.BufferType.EDITABLE);

