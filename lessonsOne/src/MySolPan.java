import java.util.Random;
import java.util.Scanner;

public class MySolPan {
    public static void main(String[] args) {
        String up = "";
        Scanner myScanner = new Scanner(System.in);
        int i = 101;


        System.out.println("Let the game begin!");
        System.out.println("Enter your name");
        up = myScanner.nextLine();
        //System.out.println(up);


        while (i != 0) {
            Random myRandom = new Random();
            int[] intAr= new int[100] ;
            int r = myRandom.nextInt(100);
            intAr[r] = 1;
           // System.out.println("The target number " + r);

            String in = "";
            System.out.println("Please enter a number");
            in = myScanner.nextLine();
            int ino = Integer.valueOf(in);

               if (ino < r){
                System.out.println("Your number is too small. Please, try again.");
            } else {
                System.out.println("");
                if (intAr[ino] !=0 && intAr[r] == intAr[ino]) {
                    System.out.println("Congratulations, " + up + "!");
                } else {
                    System.out.println("Your number is too big. Please, try again.");
                }
            }
        }
    }
}