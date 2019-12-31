package com.example.tictacgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //player representation
    // 0 - X
    // 1 - o
    // 2 - null
    int activePlayer = 0;
    int[] gameState= {2,2,2,2,2,2,2,2,2};

    int x_wins=0;
    int o_wins=0;
    int switch_turn=0;

    int[][] winPos= {{0,1,2},{3,4,5},{6,7,8},
                    {0,3,6},{1,4,7},{2,5,8},
                    {0,4,8},{2,4,6}};

    public void tapped(View view1)
    {
        ImageView img= (ImageView) view1;

        int tappedImg = Integer.parseInt(img.getTag().toString());

        if(gameState[tappedImg] == 2)
        {
            //select who's turn for next match
//            int count=0;
//            for(int i=0;i<9;i++){
//                if(gameState[i]==2)
//                    count++;
//            }
//            if(count==9)
//            {
//                switch_turn=1;
//            }


            gameState[tappedImg] =activePlayer;
//            img.setTranslationY(-1000f);

            if(activePlayer==0)
            {
                img.setImageResource(R.drawable.x);
                activePlayer=1;
                ((TextView)findViewById(R.id.status1)).setText("Player2 Turn to play");
            }
            else{
                img.setImageResource(R.drawable.o);
                activePlayer=0;
                ((TextView)findViewById(R.id.status1)).setText("Player1 Turn to play");
            }
//            img.animate().translationYBy(1000f).setDuration(300);
        }

//        //check who won
//        for(int[] check: winPos)
//        {
//            if( gameState[check[0]] == gameState[check[1]] && gameState[check[1]]== gameState[check[2]] && gameState[check[0]]!=2)
//            {
//                if(gameState[check[0]] == 0)
//                {
//                    //win position for X:
//                    final Handler handler = new Handler();
//                    handler.postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            //Do something after 2sec
//                            x_wins++;
//                            ((TextView)findViewById(R.id.p1)).setText(String.valueOf(x_wins));
//                            reset("X Wins The Match", "Let's start a new match");
//                        }
//                    }, 2000);
//                }
//                else{
//                    //win position for O:
//                    final Handler handler = new Handler();
//                    handler.postDelayed(new Runnable() {
//                        @Override
//                        public void run() {
//                            //Do something after 2sec
//                            o_wins++;
//                            ((TextView)findViewById(R.id.p2)).setText(String.valueOf(o_wins));
//                            reset("O Wins The Match", "Let's start a new match");
//                        }
//                    }, 2000);
//                }
//            }
//        }

        //simple method
        if(     (gameState[0]==0 && gameState[1]==0 && gameState[2]==0) ||
                (gameState[3]==0 && gameState[4]==0 && gameState[5]==0) ||
                (gameState[6]==0 && gameState[7]==0 && gameState[8]==0) ||
                (gameState[0]==0 && gameState[3]==0 && gameState[6]==0) ||
                (gameState[1]==0 && gameState[4]==0 && gameState[7]==0) ||
                (gameState[2]==0 && gameState[5]==0 && gameState[8]==0) ||
                (gameState[0]==0 && gameState[4]==0 && gameState[8]==0) ||
                (gameState[2]==0 && gameState[4]==0 && gameState[6]==0))
        {
            //win position for X:
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //Do something after 2sec
                    x_wins++;
                    ((TextView)findViewById(R.id.p1)).setText(String.valueOf(x_wins));
                    reset("Player1 Wins The Match", "Let's start a new match");
                }
            }, 2000);
        }

        else if((gameState[0]==1 && gameState[1]==1 && gameState[2]==1) ||
                (gameState[3]==1 && gameState[4]==1 && gameState[5]==1) ||
                (gameState[6]==1 && gameState[7]==1 && gameState[8]==1) ||
                (gameState[0]==1 && gameState[3]==1 && gameState[6]==1) ||
                (gameState[1]==1 && gameState[4]==1 && gameState[7]==1) ||
                (gameState[2]==1 && gameState[5]==1 && gameState[8]==1) ||
                (gameState[0]==1 && gameState[4]==1 && gameState[8]==1) ||
                (gameState[2]==1 && gameState[4]==1 && gameState[6]==1))
        {
            //win position for O:
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //Do something after 2sec
                    o_wins++;
                    ((TextView)findViewById(R.id.p2)).setText(String.valueOf(o_wins));
                    reset("Player2 Wins The Match", "Let's start a new match");
                }
            }, 2000);
        }

    }

    public void GameDraw(View view)
    {
        reset("Match Draw", "Let's start a new match");
    }

    public void GameRestart(View view){
        reset("Match Restarted", "Let's start a new series");
        x_wins=0;
        o_wins=0;
        ((TextView)findViewById(R.id.p1)).setText(String.valueOf(x_wins));
        ((TextView)findViewById(R.id.p2)).setText(String.valueOf(o_wins));
    }

    public void reset(String toast_msg, String toast_msg1)
    {
        //win position for X:
        Toast.makeText(this, toast_msg, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, toast_msg1, Toast.LENGTH_SHORT).show();


        activePlayer = 0;
        ((TextView)findViewById(R.id.status1)).setText("Player1 Turn to play");

        for (int i =0; i<gameState.length; i++)
        {
            gameState[i]=2;
        }

        ImageView image0=findViewById(R.id.imageView0);
        image0.setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

//set text when action performed or anything clicked
//            TextView text1= (TextView) view;
//            text1.setText("write msg");

//set text
//            TextView text1= findViewById(R.id.tsextview_idname);
//            text1.setText("write msg");

//how to get tag of image
//            ImageView view2=(ImageView)findViewById(R.id.imageView0);
//            String image0_TagName = String.valueOf(view2.getTag());
//            OR
//            String image1=img.getTag().toString();

//set image when image view clicked
//            ImageView img1= (ImageView) view1;
//            img1.setImageResource(R.drawable.image_name);

//How to set image using image id
//            ImageView image1=findViewById(R.id.imageView0);
//            image1.setImageResource(R.drawable.image_name);

//How to set image to null using image id
//            ImageView image1=findViewById(R.id.imageView0);
//            image1.setImageResource(0);


//                    we have to write like this if we use older version to cast id
//                    ImageView image1=(ImageView) findViewById(R.id.imageView0);


// string to int conversion
//String str = String.valueOf(int_value);