package Sos_Game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner input = new Scanner(System.in);
        int select;
        do{
            System.out.println("Lütfen 3-7 arasında bir sayı giriniz ! : ");
            select = input.nextInt();

        } while( select<3 || select>7 );

        boolean fifty = false;
        if (Helper.getRandomNumber(2)==1){
            fifty=true;
        }

        Gamer gamer1 = new PcGamer(fifty, "PC");
        Gamer gamer2 = new UserGamer(!fifty, "Burhan");

        Game game = new Game(select,gamer1,gamer2);
        game.run();

    }
}