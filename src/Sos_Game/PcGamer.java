package Sos_Game;

public class PcGamer extends Gamer{


    public PcGamer(boolean fifty, String name) {
        super(fifty, name);
    }

    @Override
    public int[] getTargetArea(String[][] matris){
        int matrislenght = matris[0].length;
        int[]result = new int[2];
        int totalStar = Helper.starNumber(matris);
        int randomStarNumber = Helper.getRandomNumber(totalStar);
        int n=0;
        for(int i=0;i<matrislenght;i++){
            for(int j=0;j<matrislenght;j++){
                if (matris[i][j]=="*"){
                n++;
                }
                if (n==randomStarNumber){
                    result[0]=i;
                    result[1]=j;
                    return result;
                }
            }
        }
        return result;
    }


}
