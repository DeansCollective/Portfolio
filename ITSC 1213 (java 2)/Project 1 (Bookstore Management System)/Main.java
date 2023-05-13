
package trojanowskideanproject;

import java.util.*;

public class Main {
    private static ArrayList<Book> books = new ArrayList<>();
    private static ArrayList<CD> cds = new ArrayList<>();
    private static ArrayList<DVD> dvds = new ArrayList<>();
    private static ArrayList<CartItem> cart = new ArrayList<>();
    private static ArrayList<Member> members = new ArrayList<>();

    public static double calculateTotal(ArrayList<CartItem> cart, Member member) {
        double total = 0;
        for (CartItem item : cart) {
            total += item.getPrice();
        }
        if (member.getSubscriptionType().equals("Premium")) {
            total += member.getSubscriptionFee();
        }
    return total;
    }
    
    public static String getCreditCardInformation() {
    Random card = new Random();
    String creditCardNumber = "";
    String cvv = "";
    String expirationDate = "";

    for (int i = 0; i < 16; i++) {
        creditCardNumber += card.nextInt(10);
    }
    
    for (int i = 0; i < 3; i++) {
        cvv += card.nextInt(10);
    }
    
    for (int i = 0; i < 4; i++) {
        expirationDate += card.nextInt(10);
    }
    
    return "Credit Card Number: " + creditCardNumber + "\nCVV: " + cvv + "\nExpiration Date: " + expirationDate;
}

    
    public static void main(String[] args) {
        books.add(new Book("The Firekeeper's Daughter", 6.00));
        books.add(new Book("The Hidden Treasure", 22.00));

        cds.add(new CD("Horror", 5.00));
        cds.add(new CD("Funny", 11.00));

        dvds.add(new DVD("Shark boy", 12.00));
        dvds.add(new DVD("LavaGirl", 12.00));

        members.add(new Member("Steven", "Free-tier"));
        members.add(new Member("Jessica", "Premium"));

        
        Scanner scanner = new Scanner(System.in);
        int userInput = 0;
        
        System.out.println("Welcome to the automated media store! Please select an option:");
        System.out.println("Or if you're a store admin press the secret key to access settings "); //key is 1234


        while(userInput != 5) {
            
        System.out.println("1. Purchase a book");
        System.out.println("2. Purchase a CD");
        System.out.println("3. Purchase a DVD");
        System.out.println("4. Continue to checkout");
        System.out.println("5. Exit");


        userInput = scanner.nextInt();

        switch (userInput) {
        case 1:
            System.out.println("Pick a book:");
            for (int i = 0; i < books.size(); i++) {
                System.out.println((i + 1) + ". " + books.get(i).getName() + " for $" + books.get(i).getPrice());
            }
            int bookInput = scanner.nextInt();
            if (bookInput >= 1 && bookInput <= books.size()) {
                Book selectedBook = books.get(bookInput - 1);
                cart.add(new CartItem(selectedBook.getName(), selectedBook.getPrice()));
                System.out.println("You selected " + selectedBook.getName() + " for $" + selectedBook.getPrice());
                books.remove(selectedBook);
            } else {
                System.out.println("Cant choose that.");
            }
            break;
        case 2:
            System.out.println("Pick a CD:");
            for (int i = 0; i < cds.size(); i++) {
                System.out.println((i + 1) + ". " + cds.get(i).getName()+ " for $" + cds.get(i).getPrice());
            }
            int cdInput = scanner.nextInt();
            if (cdInput > 0 && cdInput <= cds.size()) {
                CD selectedCD = cds.get(cdInput - 1);
                cart.add(new CartItem(selectedCD.getName(), selectedCD.getPrice()));
                System.out.println("You selected " + selectedCD.getName() + " for $" + selectedCD.getPrice());
                cds.remove(selectedCD);
            } else {
                System.out.println("Cant choose that.");
            }
            break;
        case 3:
            System.out.println("Pick a DVD:");
            for (int i = 0; i < dvds.size(); i++) {
                System.out.println((i + 1) + ". " + dvds.get(i).getName() + " for $" + dvds.get(i).getPrice());
            }
            int dvdInput = scanner.nextInt();
            if (dvdInput > 0 && dvdInput <= dvds.size()) {
                DVD selectedDVD = dvds.get(dvdInput - 1);
                cart.add(new CartItem(selectedDVD.getName(), selectedDVD.getPrice()));
                System.out.println("You selected " + selectedDVD.getName() + " for $" + selectedDVD.getPrice());
                dvds.remove(selectedDVD);
            } else {
                System.out.println("Cant choose that.");
            }
            break;
        case 4:
            System.out.println("I see you are done shopping!\nPlease select which member is making this purchase.");
            for (int i = 0; i < members.size(); i++) {
                System.out.println((i + 1) + ". " + members.get(i).getName() + " status: " + members.get(i).getSubscriptionType());
            }
            System.out.println((members.size() + 1) + ". Register new member (Free)");
            System.out.println((members.size() + 2) + ". Register new member (Premium)");

            int memberInput = scanner.nextInt();
            if (memberInput > 0 && memberInput <= members.size()) {
                Member selectedMember = members.get(memberInput - 1);
                System.out.println("Selected member: " + selectedMember.getName());
                double total = calculateTotal(cart, selectedMember);
                System.out.println("Total: $" + total);
                cart.clear();
                //userInput = 5; if you want the program to end after they complete their pruchase 
            } else if (memberInput == members.size() + 1) {
                System.out.println("Please enter the name of the new member (Free):");
                String name = scanner.next();
                Member newMember = new Member(name, "Free-tier");
                members.add(newMember);
                double total = calculateTotal(cart, newMember);
                System.out.println("Total: $" + total);
                cart.clear();
                //userInput = 5; if you want the program to end after they complete their pruchase 
                
            } else if (memberInput == members.size() + 2) {
                System.out.println("Please enter the name of the new member (Premium):");
                String name = scanner.next();
                Member newMember = new Member(name, "Premium");
                members.add(newMember);
                double total = calculateTotal(cart, newMember);
                System.out.println("Total: $" + total);
                cart.clear();
                //userInput = 5; if you want the program to end after they complete their pruchase 
            } else {
                System.out.println("Invalid selection.");
            }
            break;

        case 5:
            System.out.println("Exiting program. Thank you for using our automated media store!");
            break;
        case 1234:
            System.out.print("Hello store admin \nwhose credit card information would you like to steal. \n");
            for (int i = 0; i < members.size(); i++) {
                System.out.println((i + 1) + ". " + members.get(i).getName());
            }
            int thisVariableDoesntMatter = scanner.nextInt();
            String creditCard = getCreditCardInformation();
            System.out.println("Credit card information: " + creditCard + "\n");

        break;
        default:
            System.out.println("Invalid selection.");
            break;
    }
    }
}
}
