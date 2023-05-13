import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        /*BurgerOrder order1 = new BurgerOrder(3, 5, 4, 10, false, 1);
        BurgerOrder order2 = new BurgerOrder(3, 5, 4, 10, false, 1);
        BurgerOrder order3 = new BurgerOrder(3, 5, 4, 10, false, 1);

        System.out.println("BurgerOrder{" + "numHamburgers" + order1.getNumHamburger() + "numCheeseburgers= " + order1.getNumCheeseburger() + "numveggieburgers" + order1.getNumVeggieburger() + "numSodas=" + order1.getNumSoda() + "orderToGo=" + order1.isOrderToGo() + "orderNum" + order1.getOrderNum() + "}");
        System.out.println("BurgerOrder{" + "numHamburgers" + order2.getNumHamburger() + "numCheeseburgers= " + order2.getNumCheeseburger() + "numveggieburgers" + order2.getNumVeggieburger() + "numSodas=" + order2.getNumSoda() + "orderToGo=" + order2.isOrderToGo() + "orderNum" + order2.getOrderNum() + "}");
        System.out.println("BurgerOrder{" + "numHamburgers" + order3.getNumHamburger() + "numCheeseburgers= " + order3.getNumCheeseburger() + "numveggieburgers" + order3.getNumVeggieburger() + "numSodas=" + order3.getNumSoda() + "orderToGo=" + order3.isOrderToGo() + "orderNum" + order3.getOrderNum() + "}");
        */

        BurgerOrder order1 = new BurgerOrder(3, 5, 4, 10, false, 1);
        BurgerOrder order2 = new BurgerOrder(3, 5, 4, 10, false, 1);
        BurgerOrder order3 = new BurgerOrder(3, 5, 4, 10, false, 1);

        FastFoodKitchen kitchen = new FastFoodKitchen(order1, order2, order3);
        Scanner sc = new Scanner(System.in);
//
        while (kitchen.getNumOrdersPending() != 0) {
            // see what the user wants to do
            System.out.println("Please select from the following menu of options, by typing a number:");
            System.out.println("\t 1. Order food");
            System.out.println("\t 2. Cancel last order");
            System.out.println("\t 3. Show number of orders currently pending.");
            System.out.println("\t 4. Is order done");
            System.out.println("\t 5. Cancel Order");
            System.out.println("\t 6. Exit");

            int num = sc.nextInt();
            switch (num) {

                case 1:
                    System.out.println("How many hamburgers do you want?");
                    int ham = sc.nextInt();
                    System.out.println("How many cheeseburgers do you want?");
                    int cheese = sc.nextInt();
                    System.out.println("How many veggieburgers do you want?");
                    int veggie = sc.nextInt();
                    System.out.println("How many sodas do you want?");
                    int sodas = sc.nextInt();
                    System.out.println("Is your order to go? (Y/N)");
                    char letter = sc.next().charAt(0);
                    boolean TOGO = false;
                    if (letter == 'Y' || letter == 'y') {
                        TOGO = true;
                    }
                    int orderNum = kitchen.addOrder(ham, cheese, veggie, sodas, TOGO);
                    System.out.println("Thank-you. Your order number is " + orderNum);
                    System.out.println();
                    break;
                case 2:
                    boolean ready = kitchen.cancelLastOrder();
                    if (ready) {
                        System.out.println("Thank you. The last order has been canceled");
                    } else {
                        System.out.println("Sorry. There are no orders to cancel.");
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.println("There are " + kitchen.getNumOrdersPending() + " pending orders");
                    break;
                case 4:
                    System.out.println("What is the order number?");
                    int orderNumber = sc.nextInt();
                    boolean complete = kitchen.isOrderDone(orderNumber);
                    if (complete == true) {
                        System.out.println("No order was found");
                    } else {
                        System.out.println("Your order in being prepared");
                    }
                    break;
                case 5:
                    System.out.println("What is the order number?");
                    int orderNumber1 = sc.nextInt();
                    boolean completed = kitchen.cancelOrder(orderNumber1);
                    if (completed == true) {
                        System.out.println("Your order has been successfully cancelled");
                    } else {
                        System.out.println("Sorry, we can’t find your order number in the system");
                    }
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Sorry, but you need to enter a 1, 2, 3 or a 4");

            } // end switch statements

        } // end while loop


    }
}
