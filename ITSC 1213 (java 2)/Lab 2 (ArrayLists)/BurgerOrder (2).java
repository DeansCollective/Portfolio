public class BurgerOrder {
    
    private int numHamburgers = 0;
    private int numCheeseburgers = 0;
    private int numVeggieburgers = 0;
    private int numSodas = 0;
    private boolean orderToGo = false;
    private int orderNum = 2;

    public BurgerOrder(int numHamburgers, int numCheeseburgers, int numVeggieburgers, int numSodas, boolean orderToGo, int orderNum) {
        this.numHamburgers = numHamburgers;
        this.numCheeseburgers = numCheeseburgers;
        this.numVeggieburgers = numVeggieburgers;
        this.numSodas = numSodas;
        this.orderToGo = orderToGo;
        this.orderNum = orderNum;
    }

    public int getNumHamburger() {
        return this.numHamburgers;
    }
    public void setNumHamburger(int num) {
        if (numHamburgers > 0) {
            this.numHamburgers = num;
        } else {
            System.out.println("You can not pass " + num + "Hamburgers!");
        }
    }

    public int getNumCheeseburger() {
        return this.numCheeseburgers;
    }
    public void setNumCheeseHamburger(int num) {
        if (num > 0) {
            this.numCheeseburgers = num;
        } else {
            System.out.println("You can not pass " + num + "Hamburgers!");
        }
    }

    public int getNumVeggieburger() {
        return this.numVeggieburgers;
    }
    public void setNumVeggieHamburger(int num) {
        if (num > 0) {
            this.numVeggieburgers = num;
        } else {
            System.out.println("You can not pass " + num + "Hamburgers!");
        }
    }

    public int getNumSoda() {
        return this.numSodas;
    }
    public void setNumSoda(int num) {
        if (num > 0) {
            this.numSodas = num;
        } else {
            System.out.println("You can not pass " + num + "Hamburgers!");
        }
    }

    public boolean isOrderToGo() {
        return this.orderToGo;
    }
    public void setOrderToGo(boolean orderToGo) {
        this.orderToGo = orderToGo;
    }

    public int getOrderNum() {
        return this.orderNum;
    }
    public void setOrderNum(int num) {
        this.orderNum = num;
    }
}
