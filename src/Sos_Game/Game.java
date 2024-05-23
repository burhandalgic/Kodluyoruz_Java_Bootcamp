package Sos_Game;

public class Game {

    private int matrisLenght;
    private String[][]matris;

    Gamer gamer1;

    Gamer gamer2;

    public Game(int matrisLenght, Gamer gamer1, Gamer gamer2) {
        this.matrisLenght = matrisLenght;
        this.matris = new String[matrisLenght][matrisLenght];
        this.gamer1 = gamer1;
        this.gamer2 = gamer2;
        fillMatris();
        printMatris();
        System.out.println(gamer1.getName() + " oyun karakteri => " + gamer1.getGameChar());
        System.out.println(gamer2.getName() + " oyun karakteri => " + gamer2.getGameChar());
    }


    void run() throws InterruptedException {
        boolean fifty = false;
        if (Helper.getRandomNumber(2)==1){
            fifty=true;
        }
        int[] newTarget;
        int score;

        if (fifty){
            newTarget = gamer2.getTargetArea(matris);
            matris[newTarget[0]][newTarget[1]]=gamer2.getGameChar();
            printMatris();
        }
        while (true){
            newTarget = gamer1.getTargetArea(matris);
            matris[newTarget[0]][newTarget[1]]=gamer1.getGameChar();
            Thread.sleep(1000);
            ////
            score=scoreCalculate(newTarget[0],newTarget[1],gamer1.getGameChar());
            if ( score > 0  ){
                System.out.println("*****SOS******* " + gamer1.getName() + " " + score + " puan kazandı...." );
                gamer1.setPoint(getGamer1().getPoint()+score);
            }

            /////
            printMatris();
            if (Helper.starNumber(matris)==0){
                break;
            }

            newTarget = gamer2.getTargetArea(matris);
            matris[newTarget[0]][newTarget[1]]=gamer2.getGameChar();

            score=scoreCalculate(newTarget[0],newTarget[1],gamer2.getGameChar());
            if ( score > 0  ){
                System.out.println("*****SOS******* " + gamer2.getName() + " " + score + " puan kazandı...." );
                gamer2.setPoint(getGamer2().getPoint()+score);
            }


            printMatris();
            if (Helper.starNumber(matris)==0){
                break;
            }

        }
        System.out.println("Oyun Bitti ! ");
        System.out.println(gamer1.getName()+ " puanı : " + gamer1.getPoint() );
        System.out.println(gamer2.getName()+ " puanı : " + gamer2.getPoint() );

        if (gamer1.getPoint()==gamer2.getPoint()){
            System.out.println("Oyun berabere bitti!");
        }else if (gamer1.getPoint()>gamer2.getPoint()){
            System.out.println("Kazanan " + gamer1.getName());
        }else {
            System.out.println("Kazanan " + gamer2.getName());
        }




    }

    public int scoreCalculate(int x, int y, String move){
        int score=0;
        int n = matrisLenght;

        if(move.equals("S")){
            if(y<=n-3 && x<=n-1){
                if((((matris[x][y+1])+(matris[x][y+2])).equals("OS"))){  //sağa yatay
                    score+=1;
                }}
            if(x<=n-3 && y<=n-1) {
                if((((matris[x+1][y])+(matris[x+2][y])).equals("OS"))){ //üstten dikey
                    score+=1;
                }}
            if(y>=2 && x<=n-1 ){
                if((((matris[x][y-1])+(matris[x][y-2])).equals("OS"))){ //sola yatay
                    score+=1;
                }}
            if(x>=2 && y<=n-1 ){
                if((((matris[x-1][y])+(matris[x-2][y])).equals("OS"))){ //alttan dikey
                    score+=1;
                }}
            if(x<=n-3 && y<=n-3){
                if((((matris[x+1][y+1])+(matris[x+2][y+2])).equals("OS"))) { //sağ alta çapraz
                    score+=1;
                }}
            if(x<=n-3 && y>=2){
                if((((matris[x+1][y-1])+(matris[x+2][y-2])).equals("OS"))){  //sol alta çapraz
                    score+=1;
                }}
            if(x>=2 && y>=2){
                if((((matris[x-1][y-1])+(matris[x-2][y-2])).equals("OS"))){  //sol üste çapraz
                    score+=1;
                }}
            if(x>=2 && y<=n-3){
                if((((matris[x-1][y+1])+(matris[x-2][y+2])).equals("OS"))){  //sağ üste çapraz
                    score+=1;
                }}

        }
        else if(move.equals("O")){
            if(x<=n-1 && y>=1 && y<=n-2 && ((matris[x][y-1]).equals("S")) && ((matris[x][y+1]).equals("S"))){
                score+=1;
            }
            if(x<n-1 && x!=0 && y<=n-1 && ((matris[x-1][y]).equals("S")) && ((matris[x+1][y]).equals("S"))){
                score+=1;
            }
            if(x!=0 && x<=n-2 && y!=0 && y<=n-2){
                if(((matris[x-1][y-1]).equals("S")) && ((matris[x+1][y+1]).equals("S"))){
                    score+=1;
                }
                if(((matris[x-1][y+1]).equals("S")) && ((matris[x+1][y-1]).equals("S"))){
                    score+=1;
                }
            }
        }
        return score;

    }




    void fillMatris (){
        for (int i = 0 ; i<matrisLenght;i++){
            for (int j = 0 ; j<matrisLenght;j++) {
                matris[i][j]="*";
            }
            }
        }

    void printMatris (){
        System.out.println(gamer1.getName()+ " puanı : " + gamer1.getPoint() );
        System.out.println(gamer2.getName()+ " puanı : " + gamer2.getPoint() );

        System.out.print("  ");
        for (int k = 0 ; k<matrisLenght; k++){
            System.out.print(k + " ");
        }
        System.out.println();
        for (int i = 0 ; i<matrisLenght;i++){
            System.out.print(i + " ");
            for (int j = 0 ; j<matrisLenght;j++) {
                System.out.print(matris[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------");
    }

    public int getMatrisLenght() {
        return matrisLenght;
    }

    public void setMatrisLenght(int matrisLenght) {
        this.matrisLenght = matrisLenght;
    }

    public String[][] getMatris() {
        return matris;
    }

    public void setMatris(String[][] matris) {
        this.matris = matris;
    }

    public Gamer getGamer1() {
        return gamer1;
    }

    public void setGamer1(Gamer gamer1) {
        this.gamer1 = gamer1;
    }

    public Gamer getGamer2() {
        return gamer2;
    }

    public void setGamer2(Gamer gamer2) {
        this.gamer2 = gamer2;
    }
}




