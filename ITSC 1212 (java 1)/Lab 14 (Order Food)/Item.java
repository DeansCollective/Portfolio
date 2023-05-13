public class Item { //instance variables 
    private String itemID;
    private String name; 
    private double price; 

    public Item (String itemID, String name, double price){ //constructers 
    this.itemID = itemID; 
    this.name = name;
    this.price = price; 
    }

    public String GetItemID (){ //these 3 are getters (methods)
        return itemID; 
    }
    public String GetName (){
        return name;
    }
    public double Getprice () {
        return price; 
    }

    public void SetItemID (String ID){ //these 3 are setters (methods)
        this.itemID = ID;
    }
    public void Setname (String what){
        this.name = what;
    }
    public void Setprice (double cash){
        this.price = cash;
    }

    public String toString (){
        return "Item ID:" + itemID + " >> " + name + " >> $" + price;

    }
    
}
