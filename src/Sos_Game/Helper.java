package Sos_Game;

public class Helper {


    public static int getRandomNumber(int number){
        double result1 = Math.random()*number;
        int result2 = (int)result1;
        return result2 + 1 ;
    }

    public static int starNumber (String[][] matris){
        int matrislenght = matris[0].length;
        int result = 0;
        for(int i=0;i<matrislenght;i++){
            for(int j=0;j<matrislenght;j++){
                if (matris[i][j]=="*"){
                    result++;
                }
            }
        }
        return result;
    }

}
