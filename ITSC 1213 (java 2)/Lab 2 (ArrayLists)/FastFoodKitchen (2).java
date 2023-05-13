import java.util.ArrayList;

public class FastFoodKitchen {
    private ArrayList<BurgerOrder> orderList = new ArrayList<BurgerOrder>();
    private static int nextOrderNum = 1;

    public FastFoodKitchen(BurgerOrder a, BurgerOrder b, BurgerOrder c) {
        orderList.add(a);
        orderList.add(a);
        orderList.add(a);
        
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
