package com.example.multiscreenintents;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.GridView;
        import android.widget.TextView;
        import android.widget.Toast;

public class list_item0 extends AppCompatActivity {

    String[] alph={"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item0);


        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alph );

        GridView grid11=findViewById(R.id.grid1);

        grid11.setAdapter(adapter);


        grid11.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String text = "alphabet "+ ((TextView) view).getText().toString() + " at Position[" + position+ "] is clicked ";
                Toast.makeText(list_item0.this, text, Toast.LENGTH_SHORT).show();
            }
        });



    }
}