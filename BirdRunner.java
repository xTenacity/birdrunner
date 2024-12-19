
import java.util.Scanner;

public class BirdRunner {

    public static void main(String[] args) {
        /*
        SCENARIO:
        As an avian veterinary student, I want to identify groups of similar birds so I can study them for my final exams.
        Possible Extensions: I would like to be quizzed on descriptors based on the bird.
        Dataset: 100 Birds of the World
 */   

        //read file
        BirdManager.readNames();
        //run game
        runGame();
    }

    public static void runGame() {
        boolean running = true;
        Scanner scan = new Scanner(System.in);
        while (running) {
            System.out.println("Bird Study Program");
            System.out.println("1. Play\n2. Look at bird list\n3. Exit");
            
            //make sure the response is 1 2 or 3
            String response = scan.nextLine();
            while (!response.equals("1") && !response.equals("2") && !response.equals("3")) {
                System.out.println("Bad input, try again");
                response = scan.nextLine();
            }
            //checks the responses - explicitly it should only be 1 2 and 3
            switch (response) {
                case "1" -> BirdManager.startGame(scan);
                case "2" -> BirdManager.printBirds();
                case "3" -> {
                    System.out.println("Exiting the program. Goodbye!");
                    running = false;
                }
            }
        }
        //close scanner
        scan.close();
    }
    
}