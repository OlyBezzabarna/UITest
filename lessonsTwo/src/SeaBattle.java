import java.util.Random;
import java.util.Scanner;

public class SeaBattle {
    public static void main(String[] args) {
        System.out.println("All set. Get a ready to rumble");
        Random myRandom = new Random();
        int[][] intAr = new int[6][6];
        int r = myRandom.nextInt(5) + 1;
        int b = myRandom.nextInt(5) + 1;
        String[][] stArray = {{" 0 ", " 1 ", " 2 ", " 3 ", " 4 ", " 5 "},
                {" 1 ", " - ", " - ", " - ", " - ", " - "},
                {" 2 ", " - ", " - ", " - ", " - ", " - "},
                {" 3 ", " - ", " - ", " - ", " - ", " - "},
                {" 4 ", " - ", " - ", " - ", " - ", " - "},
                {" 5 ", " - ", " - ", " - ", " - ", " - "}};
        //stArray[r][b] = " @ ";
        for (int i = 0; i < stArray.length; i++) {
            for (int j = 0; j < stArray[i].length; j++) {
                System.out.print(stArray[i][j] + "|");
            }
            System.out.println();
        }
        String value = "";
        Scanner myScanner = new Scanner(System.in);
        int lin = 7;
        int col = 7;
        do {
            System.out.println("Please enter a line number from 1 to 5: ");
            do {
                value = myScanner.nextLine();
                System.out.println("Line number: " + value);
                lin = Integer.valueOf(value);
                System.out.println(lin > 0 && lin < 6 ? "ok" : "Please enter a line number from 1 to 5: ");
            }
            while (lin < 1 || lin > 5);
            do {
                System.out.println("Please enter a column number from 1 to 5: ");
                value = myScanner.nextLine();
                System.out.println("Column number: " + value);
                col = Integer.valueOf(value);
                System.out.println(col > 0 && col < 6 ? "ok" : "");
            }
            while (col < 1 || col > 5);
            stArray[lin][col] = " * ";
            for (int i = 0; i < stArray.length; i++) {
                for (int j = 0; j < stArray[i].length; j++) {
                    System.out.print(stArray[i][j] + "|");
                }
                System.out.println();
            }
        }
        while (stArray[r][b] != stArray[lin][col]);
        System.out.println(lin == r && col == b ? stArray[lin][col] = " X " : "");
        System.out.println("You have won!");
        for (int i = 0; i < stArray.length; i++) {
            for (int j = 0; j < stArray[i].length; j++) {
                System.out.print(stArray[i][j] + "|");
            }
            System.out.println();
        }
    }
}









