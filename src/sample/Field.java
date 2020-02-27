package sample;

import java.util.Random;

public class Field {

    private Tile[][] arr;

    public Tile[][] getArr() {
        return arr;
    }

    public void setArr(Tile[][] arr) {
        this.arr = arr;
    }

    public Field() {
        initGame();
    }

    private void initGame() {
        arr = new Tile[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] = new Tile();

            }

        }
    }

    public boolean isWinner() {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (arr[i][j].isValue()) {
                    count++;
                }
            }
        }
        if (count == 16 || count == 0) {
            System.out.println("You Won");
            return true;
        }
        return false;

    }

    public void toggleTiles(int index) {
        int x = index % 4;
        int y = index / 4;

        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr.length; i++) {
                if (!(x == i && y == j) && Math.abs(x - i) <= 1 && Math.abs(y - j) <= 1) {
                    arr[i][j].toggle();
                }
            }
        }
    }

    public void shuffle(){
        Random random = new Random();
        do {
            for (int i = 0; i < 20; i++) {
                toggleTiles(random.nextInt(15));
            }
        }
        while(isWinner());
    }
}
