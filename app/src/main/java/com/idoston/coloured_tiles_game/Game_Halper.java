package com.idoston.coloured_tiles_game;

import java.util.Random;

/**
 * Created by Doston on 12/16/2017.
 */

public class Game_Helper {

    public Game_Helper() {
    }

    public int getRandomNumbers(int size){

        Random rand = new Random();
        int newSize = size + 1;
        return rand.nextInt(newSize)+1;
    }
}
