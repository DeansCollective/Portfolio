import java.util.Scanner;

public  class BlackJack {  
    public static void main(String[] args) throws InterruptedException {
        Deck myDeck = new Deck();
        Scanner scnr = new Scanner(System.in);
        int i = 0;
        int playerTotal;
        int houseTotal;

        while (i < 3) {
        houseTotal = myDeck.drawCard().getValue(true) + myDeck.drawCard().getValue(true);
        playerTotal = myDeck.drawCard().getValue(true) + myDeck.drawCard().getValue(true);
        System.out.println("The House is showing: " + houseTotal);
        while (playerTotal <=21) {
            System.out.println("Player is showing: " + playerTotal);
            System.out.println("Would you like to hit or stand?");
            System.out.print("Enter 0 for stand or 1 for hit:");
            int choice = scnr.nextInt();
            if ( choice == 0) { 
                break;
            } else if (choice == 1) {
                Card nextCard = myDeck.drawCard();
                System.out.println("Player draws the " + nextCard.declareCard());
                playerTotal += nextCard.getValue(true);
            } else {
                System.out.println("Please enter a correct character");
            }
        }


        if (playerTotal > 21) {
            System.out.println("The Player is busted!");
        } else {
            System.out.println("The Player point count is " + playerTotal); 
            System.out.println("The House is playing next.");
            while ( houseTotal < 17) { 
                Card nextCard = myDeck.drawCard();
                System.out.println("House draws the " + nextCard.declareCard());
                houseTotal += nextCard.getValue(true);
            } if (houseTotal >= 17 && houseTotal <=21) {
                System.out.println("The House stands!");
            } else {
                System.out.println("The house has busted!");
            }
        }

        if (houseTotal <playerTotal) {
            Thread.sleep(1000);
            System.out.println("The Player is the winner");
            System.out.println(" ");}
        else if (houseTotal > 21){
            Thread.sleep(1000);
            System.out.println("The player is the winner!");
            System.out.println(" ");}
        else if (houseTotal > playerTotal) {
            Thread.sleep(1000);
            System.out.println("The House is the winner");
            System.out.println(" ");}
        else if (houseTotal == playerTotal) {
            Thread.sleep(1000);
            System.out.println("Tie Game!");
            System.out.println(" ");}
        i++;
        }
        scnr.close();       
    }
}
