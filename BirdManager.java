import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BirdManager {
    private final static Bird[] birds = new Bird[100];

    public static void readNames() {
        
        try {
            Scanner nameScanner = new Scanner(new File("birdNames.txt"));
            Scanner dietScanner = new Scanner(new File("birdDiets.txt"));
            Scanner colorScanner = new Scanner(new File("birdColors.txt"));
            Scanner endangeredScanner = new Scanner(new File("endangered.txt"));
            int i = 0;
            while (nameScanner.hasNextLine()) {
                birds[i] = new Bird(nameScanner.nextLine(), dietScanner.nextLine().split(", "), colorScanner.nextLine(), endangeredScanner.nextLine());
                i++;
            }
            nameScanner.close();
            dietScanner.close();
            colorScanner.close();
            endangeredScanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public static void startGame(Scanner scan) {
        Bird bird = birds[(int)(Math.random()*birds.length)];
        System.out.println(bird);


        //question 1
        System.out.println("Let's Start!\nFirst hint - This bird's endangerment status is \"" + bird.getEndangered() + "\".");
        String answer = scan.nextLine();
        boolean win = true;

        //question 2
        if (!answer.equals(bird.getName())) {
            System.out.println("Wrong!\nSecond hint - This bird's diet consists of " + bird.getDiet() + ".");
            answer = scan.nextLine();

            //question 3
            if (!answer.equals(bird.getName())) {
                System.out.println("Wrong!\nFinal hint - This bird's color is " + bird.getColor());
                answer = scan.nextLine();

                //loss
                if (!answer.equals(bird.getName())) {
                    System.out.println("Wrong!\nGood game, the bird's name is the " + bird.getName() + ".");
                    win = false;
                }
            }
        }
        //win
        if (win) {
            System.out.println("You win! It was indeed the " + bird.getName() + "!");
        }
        System.out.println("Thanks for playing!\n\n");
    }

    public static void printBirds() {
        //print list
        for (Bird bird : birds) {
            System.out.println(bird);
        }
        System.out.println("\n\n");
    }

}
