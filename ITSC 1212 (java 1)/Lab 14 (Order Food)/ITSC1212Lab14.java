import java.util.Scanner;

public class ITSC1212Lab14 {
    static String foodTruck = "Deans Deli;";
    static String myName = "Dean";
    static Item arr[] = {
    new Item("A1", "Pasta", 5.00),
    new Item("A2", "Cheese Sticks", 5.00),
    new Item("A3", "Cheese Potato", 5.00),
    new Item("A4", "Candy", 5.00),
    new Item("A5", "Hot Dog", 5.00),
    new Item("A6", "Lunchables", 5.00),
    new Item("A7", "Crackers", 5.00),
    new Item("A8", "Pickles", 5.00),
    new Item("A9", "Skittles", 5.00),
    new Item("A10", "Chips", 5.00)
    };
    static int lens = 10;

    public static void main(String[] args) throws InterruptedException {
        String decarativeLine = "****************************************";
        Thread.sleep(500); 
        System.out.println(decarativeLine);
        Thread.sleep(500); 
        System.out.println();
        System.out.println("Welcome to Deans Deli; My name is Dean! Your chef and server!");
        System.out.println("What is your name?");
        Thread.sleep(500); 
        Scanner scnr = new Scanner(System.in);
        String name = scnr.nextLine();
        Thread.sleep(500); 
        System.out.println("Hello " + name + "!");
        Thread.sleep(500); 

        System.out.println("Hi " + name + " Please take a look at out menu");
        for (int i = 0; i < 10; i++){
            System.out.println(arr[i]);
            Thread.sleep(200); 
        }
        System.out.print("how many items would you like to order ");
        int x = scnr.nextInt(); // x is user input (count of orders)
        scnr.nextLine();
        Item order[] = new Item[x]; // it creates an array the size of a persons order
        for (int i = 0;i < x; i++){
            System.out.print("What item # would you like to order ");
            String j = scnr.nextLine();
        for (Item t : arr){
            t.GetItemID(); 
            if (t.GetItemID().equalsIgnoreCase(j) ){ 
            order[i] = t; //sets order meneu @ index to be equal to array (the meneu) at the users choice j.

            }
        }
    }

double total = 0;
for (Item t: order){ //item t loops through everthing in the order
total += t.Getprice(); //assign new variable t .getprice(); add it to total and print below
}

    String orderConf = "Thank you for your order " + name + " ";
    for(int i = 0; i < order.length; i++){
        if ((i+1) == order.length){
            orderConf += (order[i] ); 
        }
        else {
            orderConf += (order[i] + ", "); 
        }
    }

        System.out.println(orderConf);
        System.out.println("_______________________________________________");
        System.out.println("\t\t" + total);
        System.out.println();
        System.out.println(decarativeLine);
        scnr.close();
    }
    }
