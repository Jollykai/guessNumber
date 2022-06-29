import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello! I'll guess the number(positive) you've guessed");
        System.out.print("Please specify the range from 1 to ... ");

        Scanner scanner = new Scanner(System.in);
        Game game = new Game(scanner.nextInt());
        game.setAttemptsNumber(getNumberOfAttempts(game.getMaxRange(), 1));


        while (game.isContinuePlaying()) {
            int numberOfAttempts = game.getAttemptsNumber();
            System.out.println("Nice! Think I need no more than " + numberOfAttempts + " attempts for guess!\n" +
                    "Enter \"-\" if my guess smaller than number you think of and enter \"+\" if it is bigger!\n" +
                    "Enter \"=\" if guess is correct!");
            System.out.println("----------------");

            String answer;
            double min = 1;
            double max = game.getMaxRange();
            label:
            while (numberOfAttempts > 0) {
                numberOfAttempts--;
                int middleNum = (int)Math.round((max - min) / 2 + min);
                if (min == max) {
                    System.out.println("Your num is: " + middleNum + " !");
                    break;
                }
                System.out.println("Think num is: " + middleNum + " is it correct? ");
                System.out.println("Attempts left: " + numberOfAttempts);
                System.out.println("min is : " + min + " max is: " + max);
                answer = scanner.next();
                switch (answer) {
                    case "-":
                        max = middleNum - 1;
                        break;
                    case "+":
                        min = middleNum + 1;
                        break;
                    case "=":
                        System.out.println("Nice game!");
                        break label;
                }
            }

            System.out.println("One more time? (y/n)");
            if (scanner.next().equals("n")) {
                game.setContinuePlaying(false);
            }
        }
    }

    private static int getNumberOfAttempts(int range, int guessNumber) {
        if (range / 2 != 1) {
            guessNumber = getNumberOfAttempts(range / 2, ++guessNumber);
        } else return guessNumber + 1;
        return guessNumber;
    }
}
