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
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class GameBoard extends AppCompatActivity {

    Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_10, btn_11, btn_12, btn_13, btn_14, btn_15, btn_16, btn_17, btn_18, btn_19, btn_20;

    TextView score;

    private Set<Integer> coloredPositions;
    private Set<Integer> userSelectedSquares;


    private static final String[] btn_list = {"btn_1", "btn_2", "btn_3", "btn_4", "btn_5", "btn_5",
            "btn_6", "btn_7", "btn_8", "btn_9", "btn_10", "btn_11",
            "btn_12", "btn_13", "btn_14", "btn_15", "btn_16"};

    int click = 0;
    int newScore = 0;
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
        btn_17 = (Button)findViewById(R.id.btn_17);
        btn_18 = (Button)findViewById(R.id.btn_18);
        btn_19 = (Button)findViewById(R.id.btn_19);
        btn_20 = (Button)findViewById(R.id.btn_20);

        click_list = new ArrayList<String>();
        coloredPositions = new HashSet<>();
        userSelectedSquares = new HashSet<>();

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
            }
        }, 4000);

        getValues();

    }
    public void ColorRandomSquares(){

        int firstR = game_halper.getRandomNumbers(20);
        int secondR = game_halper.getRandomNumbers(20);
        int thirdR = game_halper.getRandomNumbers(20);
        int fourR = game_halper.getRandomNumbers(20);

        if (firstR != secondR && firstR != thirdR && firstR != fourR){
            PaintSquares(firstR);
        } else {
            PaintSquares(game_halper.getRandomNumbers(20));
        }
        if (secondR != firstR && secondR != thirdR && secondR != fourR){
            PaintSquares(secondR);
        } else {
            PaintSquares(game_halper.getRandomNumbers(20));
        }
        if (thirdR != secondR && thirdR != firstR && thirdR != fourR){
            PaintSquares(thirdR);
        } else {
            PaintSquares(game_halper.getRandomNumbers(20));
        }
        if (fourR != secondR && fourR != thirdR && fourR != firstR){
            PaintSquares(fourR);
        } else {
            PaintSquares(game_halper.getRandomNumbers(20));
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
        btn_17.setBackgroundColor(getResources().getColor(R.color.tile_color));
        btn_18.setBackgroundColor(getResources().getColor(R.color.tile_color));
        btn_19.setBackgroundColor(getResources().getColor(R.color.tile_color));
        btn_20.setBackgroundColor(getResources().getColor(R.color.tile_color));
    }



    public void getValues(){

        btn_1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        click = click + 1;

                        userSelectedSquares.add(1);
                        if (click == 4){
                            isAnswerCorrect();
                            Toast.makeText(getApplicationContext(),"New game!", Toast.LENGTH_SHORT).show();
                            Starter();
                        }

                    }
                }
        );
        btn_2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        click = click + 1;
                        userSelectedSquares.add(2);
                        if (click == 4){
                            isAnswerCorrect();
                            Toast.makeText(getApplicationContext(),"New game!", Toast.LENGTH_SHORT).show();
                            Starter();
                        }

                    }
                }
        );
        btn_3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        click = click + 1;
                        userSelectedSquares.add(3);
                        if (click == 4){
                            isAnswerCorrect();
                            Toast.makeText(getApplicationContext(),"New game!", Toast.LENGTH_SHORT).show();

                            Starter();
                        }

                    }
                }
        );
        btn_4.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        click = click + 1;
                        userSelectedSquares.add(4);
                        if (click == 4){
                            isAnswerCorrect();
                            Toast.makeText(getApplicationContext(),"New game!", Toast.LENGTH_SHORT).show();
                            Starter();
                        }

                    }
                }
        );
        btn_5.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        click = click + 1;
                        userSelectedSquares.add(5);
                        if (click == 4){
                            isAnswerCorrect();
                            Toast.makeText(getApplicationContext(),"New game!", Toast.LENGTH_SHORT).show();
                            Starter();
                        }

                    }
                }
        );
        btn_6.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        click = click + 1;
                        userSelectedSquares.add(6);
                        if (click == 4){
                            isAnswerCorrect();
                            Toast.makeText(getApplicationContext(),"New game!", Toast.LENGTH_SHORT).show();
                            Starter();
                        }

                    }
                }
        );
        btn_7.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        click = click + 1;
                        userSelectedSquares.add(7);
                        if (click == 4){
                            isAnswerCorrect();
                            Toast.makeText(getApplicationContext(),"New game!", Toast.LENGTH_SHORT).show();
                            Starter();
                        }

                    }
                }
        );
        btn_8.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        click = click + 1;
                        userSelectedSquares.add(8);
                        if (click == 4){
                            isAnswerCorrect();
                            Toast.makeText(getApplicationContext(),"New game!", Toast.LENGTH_SHORT).show();
                            Starter();
                        }
                    }
                }
        );
        btn_9.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        click = click + 1;
                        userSelectedSquares.add(9);
                        if (click == 4){
                            isAnswerCorrect();
                            Toast.makeText(getApplicationContext(),"New game!", Toast.LENGTH_SHORT).show();
                            Starter();
                        }
                    }
                }
        );
        btn_10.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        click = click + 1;
                        userSelectedSquares.add(10);
                        if (click == 4){
                            isAnswerCorrect();
                            Toast.makeText(getApplicationContext(),"New game!", Toast.LENGTH_SHORT).show();
                            Starter();
                        }
                    }
                }
        );
        btn_11.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        click = click + 1;
                        if (click == 4){
                            isAnswerCorrect();
                            Toast.makeText(getApplicationContext(),"New game!", Toast.LENGTH_SHORT).show();
                            Starter();
                        }
                    }
                }
        );
        btn_12.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        click = click + 1;
                        userSelectedSquares.add(12);
                        if (click == 4){
                            isAnswerCorrect();
                            Toast.makeText(getApplicationContext(),"New game!", Toast.LENGTH_SHORT).show();
                            Starter();
                        }
                    }
                }
        );
        btn_13.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        click = click + 1;
                        userSelectedSquares.add(13);
                        if (click == 4){
                            isAnswerCorrect();
                            Toast.makeText(getApplicationContext(),"New game!", Toast.LENGTH_LONG).show();
                            Starter();
                        }

                    }
                }
        );
        btn_14.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        click = click + 1;
                        userSelectedSquares.add(14);
                        click_list.add("one");
                        if (click == 4){
                            isAnswerCorrect();
                            Toast.makeText(getApplicationContext(),"New game!", Toast.LENGTH_LONG).show();
                            Starter();
                        }

                    }
                }
        );
        btn_15.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        click = click + 1;
                        userSelectedSquares.add(15);
                        click_list.add("one");
                        if (click == 4){
                            isAnswerCorrect();
                            Toast.makeText(getApplicationContext(),"New game!", Toast.LENGTH_SHORT).show();
                            Starter();
                        }
                    }
                }
        );
        btn_16.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        click = click + 1;
                        userSelectedSquares.add(16);
                        click_list.add("one");
                        if (click == 4){
                            isAnswerCorrect();
                            Toast.makeText(getApplicationContext(),"New game!", Toast.LENGTH_SHORT).show();
                            Starter();
                        }
                    }
                }
        );
        btn_17.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        click = click + 1;
                        userSelectedSquares.add(17);
                        click_list.add("one");
                        if (click == 4){
                            isAnswerCorrect();
                            Toast.makeText(getApplicationContext(),"New game!", Toast.LENGTH_SHORT).show();
                            Starter();
                        }
                    }
                }
        );
        btn_18.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        click = click + 1;
                        userSelectedSquares.add(18);
                        click_list.add("one");
                        if (click == 4){
                            isAnswerCorrect();
                            Toast.makeText(getApplicationContext(),"New game!", Toast.LENGTH_SHORT).show();
                            Starter();
                        }
                    }
                }
        );
        btn_19.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        click = click + 1;
                        userSelectedSquares.add(19);
                        click_list.add("one");
                        if (click == 4){
                            isAnswerCorrect();
                            Toast.makeText(getApplicationContext(),"New game!", Toast.LENGTH_SHORT).show();
                            Starter();
                        }
                    }
                }
        );
        btn_20.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        click = click + 1;
                        userSelectedSquares.add(20);
                        click_list.add("one");
                        if (click == 4){
                            isAnswerCorrect();
                            Toast.makeText(getApplicationContext(),"New game!", Toast.LENGTH_SHORT).show();
                            Starter();
                        }
                    }
                }
        );



    }

    public void PaintSquares(int random){



            switch (random){
                case 1:
                    btn_1.setBackgroundColor(getResources().getColor(R.color.colour_tile));
                    coloredPositions.add(1);
                    break;
                case 2:
                    btn_2.setBackgroundColor(getResources().getColor(R.color.colour_tile));
                    coloredPositions.add(2);
                    break;
                case 3:
                    btn_3.setBackgroundColor(getResources().getColor(R.color.colour_tile));
                    coloredPositions.add(3);
                    break;
                case 4:
                    btn_4.setBackgroundColor(getResources().getColor(R.color.colour_tile));
                    coloredPositions.add(4);
                    break;
                case 5:
                    btn_5.setBackgroundColor(getResources().getColor(R.color.colour_tile));
                    coloredPositions.add(5);
                    break;
                case 6:
                    btn_6.setBackgroundColor(getResources().getColor(R.color.colour_tile));
                    coloredPositions.add(6);
                    break;
                case 7:
                    btn_7.setBackgroundColor(getResources().getColor(R.color.colour_tile));
                    coloredPositions.add(7);
                    break;

                case 8:
                    btn_8.setBackgroundColor(getResources().getColor(R.color.colour_tile));
                    coloredPositions.add(8);
                    break;
                case 9:
                    btn_9.setBackgroundColor(getResources().getColor(R.color.colour_tile));
                    coloredPositions.add(9);
                    break;
                case 10:
                    btn_10.setBackgroundColor(getResources().getColor(R.color.colour_tile));
                    coloredPositions.add(10);
                    break;
                case 11:
                    btn_11.setBackgroundColor(getResources().getColor(R.color.colour_tile));
                    coloredPositions.add(11);
                    break;
                case 12:
                    btn_12.setBackgroundColor(getResources().getColor(R.color.colour_tile));
                    coloredPositions.add(12);
                    break;
                case 13:
                    btn_13.setBackgroundColor(getResources().getColor(R.color.colour_tile));
                    coloredPositions.add(13);
                    break;
                case 14:
                    btn_14.setBackgroundColor(getResources().getColor(R.color.colour_tile));
                    coloredPositions.add(14);
                    break;
                case 15:
                    btn_15.setBackgroundColor(getResources().getColor(R.color.colour_tile));
                    coloredPositions.add(15);
                    break;
                case 16:
                    btn_16.setBackgroundColor(getResources().getColor(R.color.colour_tile));
                    coloredPositions.add(16);
                    break;
                case 17:
                    btn_17.setBackgroundColor(getResources().getColor(R.color.colour_tile));
                    coloredPositions.add(16);
                    break;
                case 18:
                    btn_18.setBackgroundColor(getResources().getColor(R.color.colour_tile));
                    coloredPositions.add(16);
                    break;
                case 19:
                    btn_19.setBackgroundColor(getResources().getColor(R.color.colour_tile));
                    coloredPositions.add(16);
                    break;
                case 20:
                    btn_20.setBackgroundColor(getResources().getColor(R.color.colour_tile));
                    coloredPositions.add(16);
                    break;
                default:
                    Toast.makeText(getApplicationContext(), "Error in switch", Toast.LENGTH_SHORT).show();
                    break;
            }


    }
    public void isAnswerCorrect() {

        boolean correct = userSelectedSquares.containsAll(coloredPositions);
        if (correct == true){
            newScore = newScore + 1;
            score.setText("Score is " + newScore);
        }

        coloredPositions.clear();
        userSelectedSquares.clear();

    }
}
