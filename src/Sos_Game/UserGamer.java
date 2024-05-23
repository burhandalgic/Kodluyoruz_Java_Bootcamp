package Sos_Game;

import java.util.Scanner;

public class UserGamer extends Gamer{

    public static Scanner scan = new Scanner(System.in);

    public UserGamer(boolean fifty, String name) {
        super(fifty, name);
    }

    @Override
    public int[] getTargetArea(String[][] matris) {
        int matrislenght = matris[0].length;
        int[]result = new int[2];
        int x, y;

        while (true) {
            System.out.print("Satır sayısını giriniz : ");
            x = scan.nextInt();
            System.out.print("Sütun sayısını giriniz : ");
            y = scan.nextInt();
            if (x < 0 || x >= matrislenght || y < 0 || y >= matrislenght) {
                System.out.println("Koordinat dışı tekrar giriniz!");
                continue;
            } else if (  matris[x][y] != "*" ) {
                System.out.println("Dolu alan tekrar deneyin !");
            }else break;
        }
        result[0]=x;
        result[1]=y;
        return result;
    }


}
