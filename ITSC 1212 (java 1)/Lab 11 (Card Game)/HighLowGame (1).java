import java.util.Scanner;
public class HighLowGame {

public static void main(String[] args) {
Scanner scnr = new Scanner(System.in);
Deck deck = new Deck();
int winCount=0;
int loseCount=0;
int tieCount=0;
char ch=' ';
do {
Card card1=deck.drawCard(); // drawing card #1
System.out.println("The first card is "+card1.declareCard()); //gets a user input
System.out.println("Is the next higher or lower?");
System.out.println("2 for higher, 1 for lower");
int choice=scnr.nextInt();

Card card2=deck.drawCard(); // gets card #2
System.out.println("The next card is "+card2.declareCard());
boolean higher=card2.getValue()>card1.getValue(); // win or lose?
if(card1.getValue()==card2.getValue()) {
System.out.println("Card vallues were same, no winner or loser this round.");
tieCount++;
}
else if((higher && choice==2) || (!higher && choice==1)) {
System.out.println("You Won!");
winCount++;
}
else {
System.out.println("Incorrect!");
loseCount++;
}

scnr.nextLine(); //repeating the process
System.out.println("press 1 to play again. 2 to stop.");
ch=Character.toLowerCase(scnr.nextLine().charAt(0));
System.out.println();
}while(ch=='1');

System.out.println("Your Win count is "+winCount);
System.out.println("Your Loss count is "+loseCount);
System.out.println("Your Tie count is "+tieCount);

}
}
