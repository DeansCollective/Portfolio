import java.util.Scanner;

public class ITSC1212Lab4 {
    
    public static void main(String[] args) {
        String startMessage = "****************************  START  *******************************\n";
        String endMessage = "\n****************************   END   *******************************\n";
        System.out.println(startMessage);
        
        // create a scanner object to use for user input
        Scanner scnr = new Scanner(System.in);
        //**************************** DO NOT MODIFY ANYTHING BEFORE THIS LINE ****************************
        // Add your code here
        //String name = scnr.nextLine();
        //name = name.toUpperCase();
        //System.out.println("Welcome to ITSC 1212 " + name);
        String name = "Dean";
        String welcomeMessage = "Welcome to ITSC1212 " + name;
        welcomeMessage = welcomeMessage.toUpperCase();
        System.out.println(welcomeMessage);
        System.out.println("The lenght of the message is; " + (welcomeMessage.length() + name.length()));
        System.out.println("The word 'to' is located at index: " + welcomeMessage.indexOf("to"));
        //Shouldn't it be welcomeMessage.indexOf? I only put name.indexOf becuase the outpit of -1 is what we see in the instructions
        
        // Part B 
        // Recalling method definitions 
        // Math.random() - Gives you a random number from 0.0-.99 
        // Math.abs (int) - Makes any number absolute. Ex: -4 would be 4 
        // Math.pow(double, double) - lets you power the first number by the second number 
        // Math.sqrt(double) square roots the double number 
        // Filling in chart with correct range of numbers for each method 
        //(int) (Math.random()) -| (Math.random()) 0.0 0.99 
        // (int) (Math.random() 5) value in range from 1-5 * * 2) value in range from 1-2 
        // (int) (Math.random() 
        // (int) (Math.random()* 9 + 1) value in range from

        




         //**************************** DO NOT MODIFY ANYTHING BELOW THIS LINE ****************************
        System.out.println(endMessage);
    }
    
}
