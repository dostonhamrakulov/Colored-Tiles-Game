package com.idoston.coloured_tiles_game;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class GameBoard extends AppCompatActivity {

    Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_10, btn_11, btn_12, btn_13, btn_14, btn_15, btn_16;
    TextView score;

    private Set<Integer> colorablePositions;
    private Set<Integer> userSelectedSquares;


    private static final String[] btn_list = {"btn_1", "btn_2", "btn_3", "btn_4", "btn_5", "btn_5",
            "btn_6", "btn_7", "btn_8", "btn_9", "btn_10", "btn_11",
            "btn_12", "btn_13", "btn_14", "btn_15", "btn_16"};

    int click = 0;
    ArrayList<String> click_list;
    Game_Halper game_halper;
    Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_board2);

        score  = (TextView) findViewById(R.id.score);

        btn_1 = (Button)findViewById(R.id.btn_1);
        btn_2 = (Button)findViewById(R.id.btn_2);
        btn_3 = (Button)findViewById(R.id.btn_3);
        btn_4 = (Button)findViewById(R.id.btn_4);
        btn_5 = (Button)findViewById(R.id.btn_5);
        btn_6 = (Button)findViewById(R.id.btn_6);
        btn_7 = (Button)findViewById(R.id.btn_7);
        btn_8 = (Button)findViewById(R.id.btn_8);
        btn_9 = (Button)findViewById(R.id.btn_9);
        btn_10 = (Button)findViewById(R.id.btn_10);
        btn_11 = (Button)findViewById(R.id.btn_11);
        btn_12 = (Button)findViewById(R.id.btn_12);
        btn_13 = (Button)findViewById(R.id.btn_13);
        btn_14 = (Button)findViewById(R.id.btn_14);
        btn_15 = (Button)findViewById(R.id.btn_15);
        btn_16 = (Button)findViewById(R.id.btn_16);

        click_list = new ArrayList<String>();
        game_halper = new Game_Halper();

        timer = new Timer();

        //Toast.makeText(getApplicationContext(),"Start painting!", Toast.LENGTH_LONG).show();

        IntialColors();
        Starter();





    }
    public void Starter(){

        ColorRandomSquares();

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                IntialColors();
                Toast.makeText(getApplicationContext(),"Time is up!", Toast.LENGTH_LONG).show();
            }
        }, 4000);

        getValues();
    }
    public void ColorRandomSquares(){

        int firstR = game_halper.getRandomNumbers(16);
        int secondR = game_halper.getRandomNumbers(16);
        int thirdR = game_halper.getRandomNumbers(16);
        int fourR = game_halper.getRandomNumbers(16);

        if (firstR != secondR && firstR != thirdR && firstR != fourR){
            PaintSquares(firstR);
        } else {
            PaintSquares(game_halper.getRandomNumbers(16));
        }
        if (secondR != firstR && secondR != thirdR && secondR != fourR){
            PaintSquares(secondR);
        } else {
            PaintSquares(game_halper.getRandomNumbers(16));
        }
        if (thirdR != secondR && thirdR != firstR && thirdR != fourR){
            PaintSquares(thirdR);
        } else {
            PaintSquares(game_halper.getRandomNumbers(16));
        }
        if (fourR != secondR && fourR != thirdR && fourR != firstR){
            PaintSquares(fourR);
        } else {
            PaintSquares(game_halper.getRandomNumbers(16));
        }

    }
    public void IntialColors(){

        btn_1.setBackgroundColor(getResources().getColor(R.color.tile_color));
        btn_2.setBackgroundColor(getResources().getColor(R.color.tile_color));
        btn_3.setBackgroundColor(getResources().getColor(R.color.tile_color));
        btn_4.setBackgroundColor(getResources().getColor(R.color.tile_color));
        btn_5.setBackgroundColor(getResources().getColor(R.color.tile_color));
        btn_6.setBackgroundColor(getResources().getColor(R.color.tile_color));
        btn_7.setBackgroundColor(getResources().getColor(R.color.tile_color));
        btn_8.setBackgroundColor(getResources().getColor(R.color.tile_color));
        btn_9.setBackgroundColor(getResources().getColor(R.color.tile_color));
        btn_10.setBackgroundColor(getResources().getColor(R.color.tile_color));
        btn_11.setBackgroundColor(getResources().getColor(R.color.tile_color));
        btn_12.setBackgroundColor(getResources().getColor(R.color.tile_color));
        btn_13.setBackgroundColor(getResources().getColor(R.color.tile_color));
        btn_14.setBackgroundColor(getResources().getColor(R.color.tile_color));
        btn_15.setBackgroundColor(getResources().getColor(R.color.tile_color));
        btn_16.setBackgroundColor(getResources().getColor(R.color.tile_color));
    }



    public void getValues(){

        btn_1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        click = click + 1;
                        if (click < 5){
                            click_list.add("one");
                        } else {
                            Toast.makeText(getApplicationContext(),"New game!", Toast.LENGTH_LONG).show();
                            //Restarter();
                        }

                    }
                }
        );
        btn_2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        click = click + 1;
                        click_list.add("one");
                        if (click == 4){
                            Toast.makeText(getApplicationContext(),"New game!", Toast.LENGTH_LONG).show();
                            //Restarter();
                        }

                    }
                }
        );
        btn_13.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        click = click + 1;
                        click_list.add("one");
                        if (click == 4){
                            Toast.makeText(getApplicationContext(),"New game!", Toast.LENGTH_LONG).show();
                            //Restarter();
                        }

                    }
                }
        );
        btn_5.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        click = click + 1;
                        click_list.add("one");
                        if (click == 4){
                            Toast.makeText(getApplicationContext(),"New game!", Toast.LENGTH_LONG).show();
                            //Restarter();
                        }

                    }
                }
        );
        btn_6.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        click = click + 1;
                        click_list.add("one");
                        if (click == 4){
                            Toast.makeText(getApplicationContext(),"New game!", Toast.LENGTH_LONG).show();
                            //Restarter();
                        }

                    }
                }
        );
        btn_7.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        click = click + 1;
                        click_list.add("one");
                        if (click == 4){
                            Toast.makeText(getApplicationContext(),"New game!", Toast.LENGTH_LONG).show();
                            //Restarter();
                        }

                    }
                }
        );
        btn_8.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        click = click + 1;
                        click_list.add("one");
                        if (click == 4){
                            Toast.makeText(getApplicationContext(),"New game!", Toast.LENGTH_LONG).show();
                            //Restarter();
                        }
                    }
                }
        );
        btn_9.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        click = click + 1;
                        click_list.add("one");
                        if (click == 4){
                            Toast.makeText(getApplicationContext(),"New game!", Toast.LENGTH_LONG).show();
                            //Restarter();
                        }
                    }
                }
        );
        btn_10.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        click = click + 1;
                        click_list.add("one");
                        if (click == 4){
                            Toast.makeText(getApplicationContext(),"New game!", Toast.LENGTH_LONG).show();
                            //Restarter();
                        }
                    }
                }
        );
        btn_11.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        click = click + 1;
                        click_list.add("one");
                        if (click == 4){
                            Toast.makeText(getApplicationContext(),"New game!", Toast.LENGTH_LONG).show();
                            //Restarter();
                        }
                    }
                }
        );
        btn_12.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        click = click + 1;
                        click_list.add("one");
                        if (click == 4){
                            Toast.makeText(getApplicationContext(),"New game!", Toast.LENGTH_LONG).show();
                            //Restarter();
                        }
                    }
                }
        );
        btn_13.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        click = click + 1;
                        click_list.add("one");
                        if (click == 4){
                            Toast.makeText(getApplicationContext(),"New game!", Toast.LENGTH_LONG).show();
                            //Restarter();
                        }

                    }
                }
        );
        btn_14.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        click = click + 1;
                        click_list.add("one");
                        if (click == 4){
                            Toast.makeText(getApplicationContext(),"New game!", Toast.LENGTH_LONG).show();
                            //Restarter();
                        }

                    }
                }
        );
        btn_15.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        click = click + 1;
                        click_list.add("one");
                        if (click == 4){
                            Toast.makeText(getApplicationContext(),"New game!", Toast.LENGTH_LONG).show();
                            //Restarter();
                        }
                    }
                }
        );
        btn_16.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        click = click + 1;
                        click_list.add("one");
                        if (click == 4){
                            Toast.makeText(getApplicationContext(),"New game!", Toast.LENGTH_LONG).show();
                            //Restarter();
                        }
                    }
                }
        );



    }

    public void PaintSquares(int random){



            switch (random){
                case 1:
                    btn_1.setBackgroundColor(getResources().getColor(R.color.colour_tile));
                    break;
                case 2:
                    btn_2.setBackgroundColor(getResources().getColor(R.color.colour_tile));
                    break;
                case 3:
                    btn_3.setBackgroundColor(getResources().getColor(R.color.colour_tile));
                    break;
                case 4:
                    btn_4.setBackgroundColor(getResources().getColor(R.color.colour_tile));
                    break;
                case 5:
                    btn_5.setBackgroundColor(getResources().getColor(R.color.colour_tile));
                    break;
                case 6:
                    btn_6.setBackgroundColor(getResources().getColor(R.color.colour_tile));
                    break;
                case 7:
                    btn_7.setBackgroundColor(getResources().getColor(R.color.colour_tile));
                    break;

                case 8:
                    btn_8.setBackgroundColor(getResources().getColor(R.color.colour_tile));
                    break;
                case 9:
                    btn_9.setBackgroundColor(getResources().getColor(R.color.colour_tile));
                    break;
                case 10:
                    btn_10.setBackgroundColor(getResources().getColor(R.color.colour_tile));
                    break;
                case 11:
                    btn_11.setBackgroundColor(getResources().getColor(R.color.colour_tile));
                    break;
                case 12:
                    btn_12.setBackgroundColor(getResources().getColor(R.color.colour_tile));
                    break;
                case 13:
                    btn_13.setBackgroundColor(getResources().getColor(R.color.colour_tile));
                    break;
                case 14:
                    btn_14.setBackgroundColor(getResources().getColor(R.color.colour_tile));
                    break;
                case 15:
                    btn_15.setBackgroundColor(getResources().getColor(R.color.colour_tile));
                    break;
                case 16:
                    btn_16.setBackgroundColor(getResources().getColor(R.color.colour_tile));
                    break;
                default:
                    Toast.makeText(getApplicationContext(), "Error in switch", Toast.LENGTH_LONG).show();
                    break;
            }


    }
}
