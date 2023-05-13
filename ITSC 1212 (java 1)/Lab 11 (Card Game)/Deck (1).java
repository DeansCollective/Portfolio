import java.util.Random;
public class Deck {
    
    //This is how you get a card out of the deck

    public Card drawCard() {
    Random rand=new Random();
    int value=rand.nextInt(13)+1;
    String suit = null;
    int s=rand.nextInt(4)+1;
    switch(s) {
    case 1:
        suit = "Spades";
        break;
    case 2:
        suit = "Clubs";
        break;
    case 3:
        suit = "Hearts";
        break;
    case 4:
        suit = "Diamonds";
        break;
    }
    return new Card(value,suit);
    }
    
    } 
    