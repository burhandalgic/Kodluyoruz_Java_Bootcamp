package Sos_Game;

import lombok.Data;

public abstract class Gamer {
    private String name;
    private int point;
    private String gameChar;

    public Gamer(boolean fifty , String name) {
        this.name=name;
        this.point = 0;
        if (fifty){
            this.gameChar = "S";
        }else{
            this.gameChar = "O";
        }

    }

    public abstract int[] getTargetArea (String[][] matris);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getGameChar() {
        return gameChar;
    }

    public void setGameChar(String gameChar) {
        this.gameChar = gameChar;
    }
}
