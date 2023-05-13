package trojanowskideanproject3;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.ArrayList;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.IOException;

/**
 *
 * ITSC 1213 
 * University of North Carolina at Charlotte
 */

public class FastFoodKitchen {

    private ArrayList<BurgerOrder> orderList = new ArrayList();
    private ArrayList<BurgerOrder> completedList = new ArrayList();


    private static int nextOrderNum = 1;

    public FastFoodKitchen() {
    Scanner fileScanner;
    try {
        fileScanner = new Scanner(new File("src/trojanowskideanproject3/burgerOrders.txt"));
        String line;
        while (fileScanner.hasNext()) {
            line = fileScanner.nextLine();
            if (!(line.startsWith("orderID"))) {
                String[] ourLine = line.split(",");
                try {
                    int orderNum = Integer.parseInt(ourLine[0]);
                    int numHamburgers = Integer.parseInt(ourLine[1]);
                    int numCheeseburgers = Integer.parseInt(ourLine[2]);
                    int numVeggieburgers = Integer.parseInt(ourLine[3]);
                    int numSodas = Integer.parseInt(ourLine[4]);
                    boolean orderToGo = Boolean.parseBoolean(ourLine[5]);
                    BurgerOrder add = new BurgerOrder(numHamburgers, numCheeseburgers, numVeggieburgers, numSodas, orderToGo, orderNum);
                    orderList.add(add);
                } catch (NumberFormatException ex) {
                    System.out.println("NumberFormatException: " + ex.getMessage());
                } catch (InputMismatchException ex) {
                    System.out.println("InputMismatchException: " + ex.getMessage());
                }
            }
        }
        fileScanner.close();
    } catch (FileNotFoundException ex) {
        System.out.println("FileNotFoundException ERROR");
    }
}

       
    public void endOfDayReport() {
    try {
        FileOutputStream fs;
        fs = new FileOutputStream("C:\\Users\\troja\\Documents\\NetBeansProjects\\trojanowskideanproject3\\src\\trojanowskideanproject3\\EndOfDayReport.txt");
        PrintWriter outfs = new PrintWriter(fs);
        
        outfs.println("completed orders for the day: ");
        for (Object order : completedList) {
            outfs.println(order.toString());
        }
        
        outfs.println("uncompleted orders for the day: ");
        for (Object order : orderList) {
            outfs.println(order.toString());
        }
        
        outfs.close();
        fs.close();
    } catch (FileNotFoundException e) {
        System.out.println("File not found");
    } catch (IOException e) {
        System.out.println("IOException ERROR");
    }
}
          

    public void burgerOrders2() {
    try {
        FileOutputStream fs = new FileOutputStream("C:\\Users\\troja\\Documents\\NetBeansProjects\\trojanowskideanproject3\\src\\trojanowskideanproject3\\burgerOrders2.txt.txt");
        PrintWriter outfs = new PrintWriter(fs);
        outfs.println("order ID, numHamburgers, numCheeseburgers, numVeggieburgers, numSodas, toGo");
        for (int i = 0; i < orderList.size(); i++) {
            outfs.println(orderList.get(i).getOrderNum() + "," +
                           orderList.get(i).getNumHamburger() + "," +
                           orderList.get(i).getNumCheeseburgers() + "," +
                           orderList.get(i).getNumVeggieburgers() + "," +
                           orderList.get(i).getNumSodas() + "," +
                           orderList.get(i).isOrderToGo());
        }
        outfs.close();
        fs.close();
    } catch (FileNotFoundException e) {
        System.out.println("File not found");
    } catch (IOException e) {
        System.out.println("IOException ERROR");
    }
}

    public static int getNextOrderNum() {
        return nextOrderNum;
    }

    private void incrementNextOrderNum() {
        nextOrderNum++;
    }

    public int addOrder(int ham, int cheese, int veggie, int soda, boolean toGo) {
        int orderNum = getNextOrderNum();
        orderList.add(new BurgerOrder(ham, cheese, veggie, soda, toGo, orderNum));
        incrementNextOrderNum();
        orderCallOut(orderList.get(orderList.size() - 1));
        return orderNum;

    }

    public boolean isOrderDone(int orderID) {
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getOrderNum() == orderID) {
                return false;
            }
        }
        return true;
    }

    public boolean cancelOrder(int orderID) {
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getOrderNum() == orderID) {
                orderList.remove(i);
                return true;
            }
        }
        return false;
    }

    public int getNumOrdersPending() {
        return orderList.size();
    }

    public boolean cancelLastOrder() {

        if (!orderList.isEmpty()) { // same as  if (orderList.size() > 0) 
            orderList.remove(orderList.size() - 1);
            return true;
        }

        return false;
    }

    private void orderCallOut(BurgerOrder order) {
        if (order.getNumCheeseburgers() > 0) {
            System.out.println("You have " + order.getNumHamburger() + " hamburgers");
        }
        if (order.getNumCheeseburgers() > 0) {
            System.out.println("You have " + order.getNumCheeseburgers() + " cheeseburgers");
        }
        if (order.getNumVeggieburgers() > 0) {
            System.out.println("You have " + order.getNumVeggieburgers() + " veggieburgers");
        }
        if (order.getNumSodas() > 0) {
            System.out.println("You have " + order.getNumSodas() + " sodas");
        }

    }

    public void completeSpecificOrder(int orderID) {
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getOrderNum() == orderID) {
                System.out.println("Order number " + orderID + " is done!");
                if (orderList.get(i).isOrderToGo()) {
                    orderCallOut(orderList.get(i));
                }
                completedList.add(orderList.get(i));
                orderList.remove(i);
            }
        }

    }

    public void completeNextOrder() {
        int nextOrder = orderList.get(0).getOrderNum();
        completeSpecificOrder(nextOrder);

    }

    // Part 2
    public ArrayList<BurgerOrder> getOrderList() {
        return orderList;
    }

    public int findOrderSeq(int whatWeAreLookingFor) {
        for (int j = 0; j < orderList.size(); j++) {
            if (orderList.get(j).getOrderNum() == whatWeAreLookingFor) {
                return j;
            }
        }
        return -1;
    }

//    public int findOrderBin(int whatWeAreLookingFor) {
//        int left = 0;
//        int right = orderList.size() - 1;
//        while (left <= right) {
//            int middle = (left + right) / 2;
//            if (whatWeAreLookingFor < orderList.get(middle).getOrderNum()) {
//                right = middle - 1;
//            } else if (whatWeAreLookingFor > orderList.get(middle).getOrderNum()) {
//                left = middle + 1;
//            } else {
//                return middle;
//            }
//        }
//        return -1;
//    }

  public int findOrderBin(int orderID){
        int left = 0;
        int right = orderList.size()-1;
        while (left <= right){
            int middle = ((left + right)/2);
            if (orderID < orderList.get(middle).getOrderNum()){
                right = middle-1;
            }
            else if(orderID > orderList.get(middle).getOrderNum()){
                left = middle +1;
            }
            else{
                return middle;
            }
        }
        return -1;
        
    }
    public void selectionSort(){
        for (int i = 0; i< orderList.size()-1; i++){
            int minIndex = i;
            for (int k = i+1; k < orderList.size(); k++){
                if (orderList.get(minIndex).getTotalBurgers() > orderList.get(k).getTotalBurgers()){
                    minIndex = k;
                }
            }
            BurgerOrder temp = orderList.get(i);
            orderList.set(i , orderList.get(minIndex));
            orderList.set(minIndex, temp);
        }
    }

    public void insertionSort() {
        for (int j = 1; j < orderList.size(); j++) {
            BurgerOrder temp = orderList.get(j);
            int possibleIndex = j;
            while (possibleIndex > 0 && temp.getTotalBurgers() < orderList.get(possibleIndex - 1).getTotalBurgers()) {
                orderList.set(possibleIndex, orderList.get(possibleIndex - 1));
                possibleIndex--;
            }
            orderList.set(possibleIndex, temp);
        }
    }
    
//    public void selectionSort() { //weird method!
//
//        for (int j = 0; j < orderList.size() - 1; j++) {
//            int minIndex = j;
//            for (int k = j + 1; k < orderList.size(); k++) {
//
//                 if (orderList.get(minIndex).getTotalBurgers() > orderList.get(j).getTotalBurgers()){
//                    minIndex = k;
//                }
//            }
//            BurgerOrder temp = orderList.get(j);
//            orderList.set(j, orderList.get(minIndex));
//            orderList.set(minIndex, temp);
//
//        }
//    }

}
