import java.util.Scanner;

public class TaskWeek {

    public static void main(String[] args) {
        String inputline = "";
        inputline = inputline.trim();
        Scanner myScanner = new Scanner(System.in);

        String[][] schedule = new String[7][2];
        schedule[0][0] = "Sunday";
        schedule[0][1] = "do home work";
        schedule[1][0] = "Monday";
        schedule[1][1] = "go to courses; watch a film";
        schedule[2][0] = "Tuesday";
        schedule[2][1] = "a trip out of town";
        schedule[3][0] = "Wednesday";
        schedule[3][1] = "bicycle training";
        schedule[4][0] = "Thursday";
        schedule[4][1] = "buy products";
        schedule[5][0] = "Friday";
        schedule[5][1] = "drink beer with friends";
        schedule[6][0] = "Saturday";
        schedule[6][1] = "reading a favorite book";

        while (!inputline.equals("exit")) {
            System.out.println("Please, input the day of the week: ");
            inputline = myScanner.nextLine().trim();
            switch (inputline.toLowerCase()) {
                case "sunday":
                    System.out.println(" Your tasks for " + schedule[0][0] + ": " + schedule[0][1]);
                    break;
                case "monday":
                    System.out.println("Your tasks for " + schedule[1][0] + ": " + schedule[1][1]);
                    break;
                case "tuesday":
                    System.out.println("Your tasks for " + schedule[2][0] + ": " + schedule[2][1]);
                    break;
                case "wednesday":
                    System.out.println("Your tasks for " + schedule[3][0] + ": " + schedule[3][1]);
                    break;
                case "thursday":
                    System.out.println("Your tasks for " + schedule[4][0] + ": " + schedule[4][1]);
                    break;
                case "friday":
                    System.out.println("Your tasks for " + schedule[5][0] + ": " + schedule[5][1]);
                    break;
                case "saturday":
                    System.out.println("Your tasks for " + schedule[6][0] + ": " + schedule[6][1]);
                    break;
                default:
                    System.out.println("Sorry, I don't understand you, please try again");
                case "exit":
            }
        }
    }
}