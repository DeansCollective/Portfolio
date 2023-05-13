import java.util.Random;
import java.util.Scanner;
import java.awt.Color;
public class ITSC1212Lab8 {
    
    static int randomX = ((int)(Math.random() * 100)) * 5;
    static int randomY = ((int)(Math.random() * 100)) * 5;
    static World w = new World(500,500);
    static Turtle tom = new Turtle(w); 

    public static void main(String[] args) throws InterruptedException {
        Scanner scnr = new Scanner(System.in);
        boolean win = false;
        tom.setVisible(false);
        System.out.println("Press 2 for easy mode. Press 1 for hard mode");
        System.out.println("Easy mode is if your within 20.");
        int gameMode = scnr.nextInt();

        if (gameMode == 2){
            System.out.println("Welcome to Easy Mode!");
        while (win == false){
            int randomXmax = (randomX + 20);
            int randomXmin = (randomX - 20);
            int randomYmax = (randomY + 20);
            int randomYmin = (randomY - 20);
            System.out.print("Enter a guess between 500 and 1 for the X position: ");
            int guessX = scnr.nextInt();
    
            System.out.print("Enter a guess between 500 and 1 for the Y position: ");
            int guessY = scnr.nextInt();

            if ((guessX >= randomXmin) && (guessX <= randomXmax)){
                System.out.println("The x coordinate is correct!");
            }
            else if (guessX > randomX){
                System.out.println("Your x was too high");
                colorGuessX(guessX);
            }
            else if (guessX < randomX){
                System.out.println("Your x was too low");
                colorGuessX(guessX);

            }

            if (((guessY >= randomYmin) && (guessY <= randomYmax))){
                System.out.println("The y coordinate is correct");
            }
            else if (guessY > randomY){
                System.out.println("Your y was too high");
                colorGuessY(guessY);
            }
            else if (guessY < randomY){
                System.out.println("Your y was too low");
                colorGuessY(guessY);
            }
            if ((guessX >= randomXmin) && (guessX <= randomXmax) && (guessY >= randomYmin) && (guessY <= randomYmax)) {
                win = true;
            }
        }
    }
            else {
                System.out.println("Welcome to Hard Mode!");
            while (win == false){
                System.out.print("Enter a guess between 500 and 1 for the X position: ");
                int guessX = scnr.nextInt();
        
                System.out.print("Enter a guess between 500 and 1 for the Y position: ");
                int guessY = scnr.nextInt();
    
                if (guessX == randomX){
                    System.out.println("The x coordinate is correct");
                }
                else if (guessX > randomX){
                    System.out.println("The x was too high");
                    colorGuessX(guessX);
                }
                else if (guessX < randomX){
                    System.out.println("The x was too low");
                    colorGuessX(guessX);
    
                }
    
                if (guessY == randomY){
                    System.out.println("The y coordinate is correct");
                }
                else if (guessY > randomY){
                    System.out.println("The y was too high");
                    colorGuessY(guessY);
                }
                else if (guessY < randomY){
                    System.out.println("The y was too low");
                    colorGuessY(guessY);
                }
                if ((guessX == randomX) && (guessY == randomY)){
                    win = true;
                }
            }
        }
        System.out.println("Correct! good job");
        System.out.println("The correct X coordination is: " + randomX);
        System.out.println("The correct Y coordination is: " + randomY);

    }
    public static void colorGuessY(int y) throws InterruptedException {
		// Set up a new Turtle to start drawing horizontal lines
		Thread.sleep(10);
		Turtle jen = new Turtle(w);
		jen.setVisible(false);
		jen.setPenColor(Color.black);
		jen.setHeading(90);
		jen.penUp();
		jen.moveTo(0, y);
		jen.penDown();

		// Draw lines to block off areas of the World where the Turtle isn't
		if (y > randomY) {
			for (int i = y; i <= 500; i++) {
				jen.moveTo(0, i);
				jen.forward(499);
			}
		} else {
			for (int i = y; i >= 0; i--) {
				jen.moveTo(0, i);
				jen.forward(499);
			}
		}

	}

	public static void colorGuessX(int x) throws InterruptedException {
		// Set up a new Turtle to start drawing vertical lines
		Thread.sleep(10);
		Turtle jen = new Turtle(w);
		jen.setVisible(false);
		jen.setPenColor(Color.black);
		jen.setHeading(180);
		jen.penUp();
		jen.moveTo(x, 0);
		jen.penDown();

		// Draw lines to block off areas of the World where the Turtle isn't
		if (x > randomX) {
			for (int i = x; i <= 500; i++) {
				jen.moveTo(i, 0);
				jen.forward(499);
			}
		} else {
			for (int i = x; i >= 0; i--) {
				jen.moveTo(i, 0);
				jen.forward(499);
			}
		}

	}

  }