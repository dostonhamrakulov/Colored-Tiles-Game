package com.idoston.coloured_tiles_game;

import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;
import java.util.Timer;

public class GameBoard extends AppCompatActivity {

    Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_10, btn_11, btn_12, btn_13, btn_14, btn_15, btn_16, btn_17, btn_18, btn_19, btn_20;
    TableLayout tableLayout;
    TextView score;
    private ProgressBar spinner;

    private Set<Integer> coloredPositions;
    private Set<Integer> userSelectedSquares;


    int click = 0;
    int newScore = 0;
    Game_Halper game_halper;
    Timer timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_board2);

        score  = (TextView) findViewById(R.id.score);

        spinner=(ProgressBar)findViewById(R.id.progressBar);


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

        tableLayout = (TableLayout) findViewById(R.id.table_layout);

        coloredPositions = new HashSet<>();
        userSelectedSquares = new HashSet<>();

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        game_halper = new Game_Halper();

        timer = new Timer();


        //Toast.makeText(getApplicationContext(),"Start painting!", Toast.LENGTH_LONG).show();

        IntialColors();
        Starter();





    }
    public void Starter(){
        //tableLayout.setVisibility(View.INVISIBLE);
        spinner.setVisibility(View.VISIBLE);
        final Handler handler = new Handler();
        //IntialColors();
        //Toast.makeText(getApplicationContext(),"Preparing game board!", Toast.LENGTH_LONG).show();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                spinner.setVisibility(View.GONE);
                tableLayout.setVisibility(View.VISIBLE);

            }
        }, 3000);



        ColorRandomSquares();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {


            }
        }, 3000);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                IntialColors();

            }
        }, 3000);
        //IntialColors();
        getValues();

    }
    public void ColorRandomSquares(){

        coloredPositions.clear();
        userSelectedSquares.clear();

        for (int i = 0; i < GameConstants.SQUARES; i++){
//            if (coloredPositions.size() <= GameConstants.SQUARES ){
                int random = game_halper.getRandomNumbers(GameConstants.TILES);
                if (coloredPositions.contains(random) == false){
                    PaintSquares(random);
                }
           // }
        }
        if (coloredPositions.size() < GameConstants.SQUARES ){
            int random = game_halper.getRandomNumbers(GameConstants.TILES);
            if (coloredPositions.contains(random) == false){
                PaintSquares(random);
            }
        }
        if (coloredPositions.size() < GameConstants.SQUARES ){
            int random2 = game_halper.getRandomNumbers(GameConstants.TILES);
            if (coloredPositions.contains(random2) == false){
                PaintSquares(random2);
            }
        }
        if (coloredPositions.size() < GameConstants.SQUARES ){
            int random3 = game_halper.getRandomNumbers(GameConstants.TILES);
            if (coloredPositions.contains(random3) == false){
                PaintSquares(random3);
            }
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
                        } else if (click > 4){
                            click = 0;
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
                        } else if (click > 4){
                            click = 0;
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
                        } else if (click > 4){
                            click = 0;
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
                        } else if (click > 4){
                            click = 0;
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
                        } else if (click > 4){
                            click = 0;
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
                        } else if (click > 4){
                            click = 0;
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
                        } else if (click > 4){
                            click = 0;
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
                        } else if (click > 4){
                            click = 0;
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
                        } else if (click > 4){
                            click = 0;
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
                        } else if (click > 4){
                            click = 0;
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
                        } else if (click > 4){
                            click = 0;
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
                        } else if (click > 4){
                            click = 0;
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
                        } else if (click > 4){
                            click = 0;
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
                        if (click == 4){
                            isAnswerCorrect();
                            Toast.makeText(getApplicationContext(),"New game!", Toast.LENGTH_LONG).show();
                            Starter();
                        } else if (click > 4){
                            click = 0;
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
                        if (click == 4){
                            isAnswerCorrect();
                            Toast.makeText(getApplicationContext(),"New game!", Toast.LENGTH_SHORT).show();
                            Starter();
                        } else if (click > 4){
                            click = 0;
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
                        if (click == 4){
                            isAnswerCorrect();
                            Toast.makeText(getApplicationContext(),"New game!", Toast.LENGTH_SHORT).show();
                            Starter();
                        } else if (click > 4){
                            click = 0;
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
                        if (click == 4){
                            isAnswerCorrect();
                            Toast.makeText(getApplicationContext(),"New game!", Toast.LENGTH_SHORT).show();
                            Starter();
                        } else if (click > 4){
                            click = 0;
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
                        if (click == 4){
                            isAnswerCorrect();
                            Toast.makeText(getApplicationContext(),"New game!", Toast.LENGTH_SHORT).show();
                            Starter();
                        } else if (click > 4){
                            click = 0;
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
                        if (click == 4){
                            isAnswerCorrect();
                            Toast.makeText(getApplicationContext(),"New game!", Toast.LENGTH_SHORT).show();
                            Starter();
                        } else if (click > 4){
                            click = 0;
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
                        if (click == 4){
                            isAnswerCorrect();
                            Toast.makeText(getApplicationContext(),"New game!", Toast.LENGTH_SHORT).show();
                            Starter();
                        } else if (click > 4){
                            click = 0;
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
                    coloredPositions.add(17);
                    break;
                case 18:
                    btn_18.setBackgroundColor(getResources().getColor(R.color.colour_tile));
                    coloredPositions.add(18);
                    break;
                case 19:
                    btn_19.setBackgroundColor(getResources().getColor(R.color.colour_tile));
                    coloredPositions.add(19);
                    break;
                case 20:
                    btn_20.setBackgroundColor(getResources().getColor(R.color.colour_tile));
                    coloredPositions.add(20);
                    break;
                default:
                    Toast.makeText(getApplicationContext(), "Error in switch", Toast.LENGTH_SHORT).show();
//                    if (coloredPositions.contains(14) == false){
//                        btn_14.setBackgroundColor(getResources().getColor(R.color.colour_tile));
//                        coloredPositions.add(14);
//                    } else if (coloredPositions.contains(15) == false){
//                        btn_15.setBackgroundColor(getResources().getColor(R.color.colour_tile));
//                        coloredPositions.add(15);
//                    } else if (coloredPositions.contains(16) == false){
//                        btn_16.setBackgroundColor(getResources().getColor(R.color.colour_tile));
//                        coloredPositions.add(16);
//                    } else if (coloredPositions.contains(17) == false){
//                        btn_17.setBackgroundColor(getResources().getColor(R.color.colour_tile));
//                        coloredPositions.add(17);
//                    } else if (coloredPositions.contains(18) == false){
//                        btn_18.setBackgroundColor(getResources().getColor(R.color.colour_tile));
//                        coloredPositions.add(18);
//                    } else if (coloredPositions.contains(19) == false){
//                        btn_19.setBackgroundColor(getResources().getColor(R.color.colour_tile));
//                        coloredPositions.add(19);
//                    } else if (coloredPositions.contains(20) == false){
//                        btn_20.setBackgroundColor(getResources().getColor(R.color.colour_tile));
//                        coloredPositions.add(20);
//                    } else if (coloredPositions.contains(15) == false){
//                        btn_15.setBackgroundColor(getResources().getColor(R.color.colour_tile));
//                        coloredPositions.add(1);
//                    } else if (coloredPositions.contains(1) == false){
//                        btn_1.setBackgroundColor(getResources().getColor(R.color.colour_tile));
//                        coloredPositions.add(1);
//                    } else if (coloredPositions.contains(2) == false){
//                        btn_2.setBackgroundColor(getResources().getColor(R.color.colour_tile));
//                        coloredPositions.add(2);
//                    } else if (coloredPositions.contains(3) == false){
//                        btn_3.setBackgroundColor(getResources().getColor(R.color.colour_tile));
//                        coloredPositions.add(3);
//                    } else if (coloredPositions.contains(4) == false){
//                        btn_4.setBackgroundColor(getResources().getColor(R.color.colour_tile));
//                        coloredPositions.add(4);
//                    } else if (coloredPositions.contains(5) == false){
//                        btn_5.setBackgroundColor(getResources().getColor(R.color.colour_tile));
//                        coloredPositions.add(5);
//                    } else if (coloredPositions.contains(6) == false){
//                        btn_6.setBackgroundColor(getResources().getColor(R.color.colour_tile));
//                        coloredPositions.add(6);
//                    } else if (coloredPositions.contains(7) == false){
//                        btn_7.setBackgroundColor(getResources().getColor(R.color.colour_tile));
//                        coloredPositions.add(7);
//                    } else if (coloredPositions.contains(8) == false){
//                        btn_8.setBackgroundColor(getResources().getColor(R.color.colour_tile));
//                        coloredPositions.add(8);
//                    } else if (coloredPositions.contains(9) == false){
//                        btn_9.setBackgroundColor(getResources().getColor(R.color.colour_tile));
//                        coloredPositions.add(9);
//                    } else if (coloredPositions.contains(10) == false){
//                        btn_10.setBackgroundColor(getResources().getColor(R.color.colour_tile));
//                        coloredPositions.add(10);
//                    } else if (coloredPositions.contains(11) == false){
//                        btn_11.setBackgroundColor(getResources().getColor(R.color.colour_tile));
//                        coloredPositions.add(11);
//                    } else if (coloredPositions.contains(11) == false){
//                        btn_11.setBackgroundColor(getResources().getColor(R.color.colour_tile));
//                        coloredPositions.add(11);
//                    } else if (coloredPositions.contains(12) == false){
//                        btn_12.setBackgroundColor(getResources().getColor(R.color.colour_tile));
//                        coloredPositions.add(12);
//                    } else if (coloredPositions.contains(13) == false){
//                        btn_13.setBackgroundColor(getResources().getColor(R.color.colour_tile));
//                        coloredPositions.add(13);
//                    }
                    break;
            }


    }
    public void isAnswerCorrect() {

        boolean correct = userSelectedSquares.containsAll(coloredPositions);
        if (correct == true){
            newScore = newScore + 1;
            score.setText("Score is " + newScore);

        }
        click = 0;
        coloredPositions.clear();
        userSelectedSquares.clear();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main_action, menu);

        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(GameBoard.this, "Sorry, there is no any option for setting!!!", Toast.LENGTH_LONG).show();
            return true;
        }
        switch(id){
            case R.id.id_about_us:

                Toast.makeText(GameBoard.this, "I am Junior Android Developer!!!", Toast.LENGTH_LONG).show();
                return true;
            case R.id.id_contact_us:
                Toast.makeText(GameBoard.this, "If you want to cantact me, please write email to doston2509@gmail.com!!!",
                        Toast.LENGTH_LONG).show();
                return true;
            case R.id.id_search:
                Toast.makeText(GameBoard.this, "Sorry, there is no any option for search!!!", Toast.LENGTH_LONG).show();
                return true;
            case R.id.id_exit_app:
                Exit_alert();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void Exit_alert(){
        AlertDialog.Builder alert_builder = new AlertDialog.Builder(this);
        alert_builder.setMessage("Do you want to close this app?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(GameBoard.this, "Good bye!!!", Toast.LENGTH_SHORT).show();
                        moveTaskToBack(true);
                        android.os.Process.killProcess(android.os.Process.myPid());
                        System.exit(1);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        AlertDialog alert = alert_builder.create();
        alert.setTitle("Alert!!!");
        alert.show();
    }
}
