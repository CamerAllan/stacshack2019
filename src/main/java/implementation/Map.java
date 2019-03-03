package implementation;

import interfaces.IMap;
import processing.core.PApplet;
import processing.core.PImage;

public class Map {

    //public int[][] floorplan = new int[21][20];

    //0 for free space
    //1 for wall
    //2 for coin
    public int[][] floorplan = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 2, 1, 0, 1, 0, 0, 0, 0, 2, 1},
            {1, 2, 1, 0, 0, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 2, 1, 0, 1, 0, 1},
            {1, 2, 1, 0, 1, 1, 1, 2, 1, 1, 1, 2, 1, 1, 1, 2, 1, 0, 1, 0, 1},
            {1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 0, 2, 1, 2, 0, 2, 0, 0, 2, 0, 1, 0, 0, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 2, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 2, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1},
            {1, 2, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 2, 2, 1},
            {1, 2, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 2, 1},
            {1, 0, 1, 0, 0, 2, 1, 2, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1},
            {1, 0, 1, 1, 1, 0, 1, 2, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 0, 0, 0, 2, 0, 0, 2, 0, 2, 0, 0, 2, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 2, 1, 0, 1, 2, 1},
            {1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 2, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}};

//
//    public int[][] floorplan = new int[][]{
//            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
//            {0, 1, 2, 0, 0, 0, 0, 0, 0, 0, 1, 2, 2, 0, 0, 0, 2, 0, 0, 1, 0},
//            {0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 2, 1, 1, 1, 0, 1, 1, 0, 1, 0},
//            {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
//            {0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0},
//            {0, 1, 0, 2, 2, 2, 1, 0, 0, 0, 1, 0, 0, 0, 1, 2, 2, 2, 0, 1, 0},
//            {0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0},
//            {0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
//            {1, 1, 1, 1, 1, 0, 1, 2, 1, 1, 1, 1, 1, 0, 1, 2, 1, 1, 1, 1, 1},
//            {0, 0, 2, 2, 2, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
//            {1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 2, 1, 1, 1, 1, 1},
//            {0, 0, 0, 0, 1, 0, 1, 2, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
//            {0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0},
//            {0, 1, 0, 2, 2, 0, 0, 2, 0, 0, 1, 0, 0, 2, 2, 2, 0, 0, 0, 1, 0},
//            {0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0},
//            {0, 1, 0, 0, 1, 0, 0, 2, 2, 0, 2, 0, 0, 2, 0, 0, 1, 0, 0, 1, 0},
//            {0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0},
//            {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0},
//            {0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0},
//            {0, 1, 0, 2, 2, 2, 0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 1, 0},
//            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0}};


    public int[][] getGrid() {
        return floorplan;
    }

    public PImage draw(PApplet app) {

        app.background(0,0,0);
        for(int i = 0; i< floorplan.length; i++) {
            for(int j = 0; j< floorplan[i].length; j++) {
                app.fill(107,2,2);
                if(floorplan[i][j] == 1) {
                    app.rect((i * Constants.SCALE), (j * Constants.SCALE), Constants.SCALE, Constants.SCALE);
                }
                app.fill(160,109,0);
                if(floorplan[i][j] == 2) {
                    app.ellipse((i * Constants.SCALE) + 14, (j * Constants.SCALE) + 14, 10, 10);
                }
            }
        }

        return null;
    }
}
