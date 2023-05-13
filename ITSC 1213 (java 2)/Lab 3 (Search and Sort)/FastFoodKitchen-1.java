package fastfoodkitchen;

import java.util.ArrayList;

public class FastFoodKitchen {
    private ArrayList<BurgerOrder> orderList = new ArrayList<BurgerOrder>();
    private static int nextOrderNum = 1;

    public int findOrderSeq(int orderID) {
    for (int i = 0; i < orderList.size(); i++) {
        if (orderList.get(i).getOrderNum() == orderID) {
            return i;
        }
    }
    return -1;
    } 
   /**
The findOrderBin method uses binary search to search for an order in a list of orders.
* It takes an integer parameter orderId to search for.
method returns -1 to indicate that the order was not found.
*/ 
    public int findOrderBin(int orderId){
    int left = 0;
    int right = orderList.size() - 1;
    while (left <= right){
        int mid = left + (right - left) /2;
        if (orderList.get(mid).getOrderNum() == orderId) {
        return mid; }
        else if (orderList.get(mid).getOrderNum() < orderId) {
        left = mid + 1; }
        else {
        right = mid - 1;}
    }
    return -1;
    }
    
    /**
This method performs the insertion sort algorithm on the orderList.
It compares orders  and swaps them with previous.
This process will repeat until the current order is in the correct position in the list.
The method will then print out the order number and the total number of burgers for each order in the sorted list.
@return void
*/
    public void insertionSort() {
    int n = orderList.size();
    for (int i = 1; i < n; ++i) {
        BurgerOrder currentOrder = orderList.get(i);
        int j = i - 1;
 
        while (j >= 0 && getTotalBurgers(orderList.get(j)) > getTotalBurgers(currentOrder)) {
            orderList.set(j + 1, orderList.get(j));
            j = j - 1;
        }
        orderList.set(j + 1, currentOrder);
        
        }
    for (BurgerOrder order : orderList) {
        System.out.println(order.getOrderNum() + " has " + getTotalBurgers(order) + " burgers.");
    }
}
/**
 * 
 * @param order. Burger order object that represents order.
 * @return an integer that represents total amount of burgers. 
 * I have a similar one in my burgerOrder but I had to rework it and put it in fastfoodkitchen becuase totalBurgers() gave me errors. 
 */
    
private int getTotalBurgers(BurgerOrder order) {
    return order.getNumHamburger() + order.getNumCheeseburger() + order.getNumVeggieburger();
}

/**
This method sorts the orderList using the selection sort algorithm in ascending order.
@return void
*/
            
    public void selectionSort() {
        int n = orderList.size();
        
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (orderList.get(j).totalBurgers() < orderList.get(minIndex).totalBurgers()){
                    minIndex = j;
                } 
            }
            BurgerOrder temp = orderList.get(minIndex);
            orderList.set(minIndex, orderList.get(i));
            orderList.set(i, temp);
        }
    }
    
    public ArrayList<BurgerOrder> getOrderList(){
        return orderList;
    }
    
    
    public FastFoodKitchen(BurgerOrder a, BurgerOrder b, BurgerOrder c) {
        orderList.add(a);
        orderList.add(b);
        orderList.add(c);
        
    }

    public int getNextOrderNum() {
        return this.nextOrderNum;
    }
    private static void incrementNextOrderNum() {
        nextOrderNum++;
    }

    public int addOrder(int ham, int cheese, int veggie, int soda, boolean toGo) {
        int orderNum = nextOrderNum;
        BurgerOrder order = new BurgerOrder(ham, cheese, veggie, soda, toGo, orderNum);
        orderList.add(order);
        incrementNextOrderNum();
        return orderNum;
    }

    public boolean cancelLastOrder() {
        if (orderList.size() != 0) {
            int numRemove = getNextOrderNum() - 1;
            orderList.remove(numRemove);
            return true;
        }
        return false;

    }
    
    public int getNumOrdersPending() {
        return orderList.size();
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
                orderList.remove(orderID);
                return true;
            }
        }
        return false;
    }

    
    
}
