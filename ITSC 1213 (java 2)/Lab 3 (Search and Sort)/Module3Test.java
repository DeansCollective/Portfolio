
package fastfoodkitchen;

public class Module3Test {
    public static void main(String[] args) {
    BurgerOrder order1 = new BurgerOrder(1, 2, 3, 4, true, 1);
    BurgerOrder order2 = new BurgerOrder(2, 3, 4, 5, false, 2);
    BurgerOrder order3 = new BurgerOrder(3, 4, 5, 6, true, 3);
    FastFoodKitchen kitchentwo = new FastFoodKitchen(order1, order2, order3);
    /**

This is the findOrderSeq and findOrderBin methods using FastFoodKitchen class to determine the order position.
The findOrderSeq method uses sequential search to find the order position, while the findOrderBin method uses binary search.
Both methods take the order number as an argument and return the order position.
*/
    
    int orderPosition = kitchentwo.findOrderSeq(3);
    System.out.println("Your order position is " + orderPosition);
    
//part D
orderPosition = kitchentwo.findOrderBin(3);
System.out.println("Using binary search >> order position is " + orderPosition);

    }
}
