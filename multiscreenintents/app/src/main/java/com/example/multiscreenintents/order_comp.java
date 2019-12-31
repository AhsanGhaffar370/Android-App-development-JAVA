package com.example.multiscreenintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class order_comp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_comp);


        Intent intent= getIntent();

        //for one input we can take value in this manner
//        String q1=intent.getStringExtra(MainActivity.q1_msg);

        Bundle extras=intent.getExtras();

        String item1= null;
        String item2= null;
        String item3= null;
        String q1= null;
        String q2= null;
        String q3= null;

        try {
            item1 = extras.getString(MainActivity.i1_msg);
            item2 = extras.getString(MainActivity.i2_msg);
            item3 = extras.getString(MainActivity.i3_msg);

            q1 = extras.getString(MainActivity.q1_msg);
            q2 = extras.getString(MainActivity.q2_msg);
            q3 = extras.getString(MainActivity.q3_msg);


            ((TextView)findViewById(R.id.qnt1)).setText(q1);
            ((TextView)findViewById(R.id.qnt2)).setText(q2);
            ((TextView)findViewById(R.id.qnt3)).setText(q3);

            ((TextView)findViewById(R.id.it1)).setText(item1);
            ((TextView)findViewById(R.id.it2)).setText(item2);
            ((TextView)findViewById(R.id.it3)).setText(item3);
        }
        catch (Exception e) {
            e.printStackTrace();
        }


        //save bundle values in array of string
        String[] order_array1={q1,q2,q3};

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, order_array1);

        ListView listView1 = findViewById(R.id.list1);

        listView1.setAdapter(adapter1);



        //save bundle values in arraylist of string
        //https://www.callicoder.com/java-arraylist/

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(item1);
        arrayList.add(item2);
        arrayList.add(item3);


//        String[] order_array2={item1,item2,item3};

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);

        ListView listView2 = findViewById(R.id.list2);

        listView2.setAdapter(adapter2);


        final Intent intent1=new Intent(this, list_item0.class);
        final Intent intent2=new Intent(this, list_item1.class);
        final Intent intent3=new Intent(this, list_item2.class);

        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String text = "Item" + position+ " " + ((TextView) view).getText().toString();
                Toast.makeText(order_comp.this, text, Toast.LENGTH_SHORT).show();

                if(position==0){
                    startActivity(intent1);
                }

                if(position==1){
                    startActivity(intent2);
                }

                if(position==2){
                    startActivity(intent3);
                }
            }
        });
    }
}
