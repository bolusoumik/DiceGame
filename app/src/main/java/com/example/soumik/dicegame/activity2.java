package com.example.soumik.dicegame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class activity2 extends AppCompatActivity {
    private EditText entername;
    private Button btn;
    private Button btn1;
    private TextView t1;
    ImageView iv_cpu, iv_player;

    TextView tv_cpu, tv_player;

    Random r;

    int cpuPoints = 0, playerPoints = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);
        entername=(EditText)findViewById(R.id.et_name) ;
        btn=(Button)findViewById(R.id.stop_btn);
        btn1=(Button)findViewById(R.id.b1);
        iv_cpu = (ImageView) findViewById(R.id.iv_cpu);
        iv_player = (ImageView) findViewById(R.id.iv_player);

        tv_cpu = (TextView) findViewById(R.id.tv_cpu);
        tv_player = (TextView) findViewById(R.id.tv_player);

        t1=(TextView)findViewById(R.id.winner);


        r = new Random();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (entername.getText().toString().trim().equals(""))
                    entername.setError("Please enter the number here.......");
                else{
                    String name= String.valueOf(entername.getText().toString());
                    tv_player.setText(name + ": " + playerPoints);
                }
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeactivity2();
            }
        });

        iv_player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cputhrow = r.nextInt(6) + 1;
                int playerthrow = r.nextInt(6) + 1;

                setImagecpu(cputhrow);
                setImageplayer(playerthrow);
                    if (cputhrow > playerthrow) {
                        cpuPoints++;
                    } else if (playerthrow > cputhrow) {
                        playerPoints++;
                    }

                   /* if(cpuPoints==10){
                        t1.setText("CPU win");
                    }else if(playerPoints==10){
                        t1.setText("you win");
                    }*/


                tv_cpu.setText("CPU: " + cpuPoints);
                String name= String.valueOf(entername.getText().toString());
                tv_player.setText(name + ": " + playerPoints);

                Animation rotate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
                iv_cpu.startAnimation(rotate);
                iv_player.startAnimation(rotate);
            }
        });
    }
    public void setImagecpu ( int num){
        switch (num) {
            case 1:
                iv_cpu.setImageResource(R.drawable.one);
                break;
            case 2:
                iv_cpu.setImageResource(R.drawable.two);
                break;
            case 3:
                iv_cpu.setImageResource(R.drawable.three);
                break;
            case 4:
                iv_cpu.setImageResource(R.drawable.four);
                break;
            case 5:
                iv_cpu.setImageResource(R.drawable.five);
                break;
            case 6:
                iv_cpu.setImageResource(R.drawable.six);
                break;
        }
    }

    public void setImageplayer(int num) {
        switch (num) {
            case 1:
                iv_player.setImageResource(R.drawable.one);
                break;
            case 2:
                iv_player.setImageResource(R.drawable.two);
                break;
            case 3:
                iv_player.setImageResource(R.drawable.three);
                break;
            case 4:
                iv_player.setImageResource(R.drawable.four);
                break;
            case 5:
                iv_player.setImageResource(R.drawable.five);
                break;
            case 6:
                iv_player.setImageResource(R.drawable.six);
                break;
        }
    }
    public void closeactivity2(){
        closeactivity2();
    }


}
