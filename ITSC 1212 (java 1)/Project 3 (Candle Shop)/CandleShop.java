import java.util.Scanner;

 //ITSC 1212 Candle class for Project 3
 
 public class CandleShop {
  public static void main(String[] args) {
    
    Scanner scnr = new Scanner(System.in);  
    Candle blue = new Candle(null, 0, 0, 0);
    Candle red = new Candle(null, 0, 0, 0);
    Candle green = new Candle(null, 0, 0, 0);

    System.out.println("Owner enter the first item ");
    blue.name = scnr.nextLine();
    System.out.println("Enter the Type: ");
    blue.type = scnr.nextInt();
    System.out.println("Enter the Cost: ");
    blue.cost = scnr.nextDouble();
    
        if (blue.cost <= 0){
          System.out.println("Your number cant be lower than 0 ");
          blue.cost = scnr.nextDouble();
        } else {
          System.out.println("Enter Burn Time: ");
          
        }
    blue.burnTime = scnr.nextInt();
    scnr.nextLine();
    
        if (blue.burnTime <= 0) {
          System.out.println("Your number cant be lower than 0 ");
          blue.burnTime = scnr.nextInt();
        } else {
          System.out.println("Owner enter the second item ");
        }
    
    red.name = scnr.nextLine();
    System.out.println("Enter the Type: ");
    red.type = scnr.nextInt();
    System.out.println("Enter the Cost: ");
    red.cost = scnr.nextDouble();
    
      if (red.cost <= 0){
        System.out.println("Your number cant be lower than 0 ");
        red.cost = scnr.nextDouble();
      } else {
        System.out.println("Enter the Burn Time: ");
      }
      red.burnTime = scnr.nextInt();
      scnr.nextLine();
    
      if (red.burnTime <= 0) { 
        System.out.println("Your number cant be lower than 0 ");
        red.burnTime = scnr.nextInt();
      } else {
        System.out.println("Owner enter the third item ");
      }
    
    green.name = scnr.nextLine();
    System.out.println("Type: ");
    green.type = scnr.nextInt();
    System.out.println("Cost: ");
    green.cost = scnr.nextDouble();
    
        if (green.cost < 0){
          System.out.println("Your number cant be lower than 0 ");
          green.cost = scnr.nextDouble();
        } else {
          System.out.println("Enter the Burn Time: ");

        }
    
    green.burnTime = scnr.nextInt();
    
        if (green.burnTime < 0) {
          System.out.println("Your number cant be lower than 0 ");
          green.burnTime = scnr.nextInt();
        } else {
          System.out.println("customer enter how many candles you would like to buy ");
        }
    
    double Type1;
    double Type2;
    double Type3;
    
    System.out.println("The Name is "+blue.name);
    System.out.println("The Type is "+blue.type);
    System.out.println("The Cost in dollars is "+blue.cost);
    System.out.println("The Burn Time is "+blue.burnTime+" minutes.");
    System.out.println("Type 1 ");
    Type1 = scnr.nextDouble();
    
        if (Type1 <= 0) {
          System.out.println("Your number cant be lower than 0 ");
          Type1 = scnr.nextInt();
        } else {
          System.out.print("");
        }
    
    double B1 = Type1 * blue.cost;
    
    System.out.println("The Name is "+red.name);
    System.out.println("The Type is "+red.type);
    System.out.println("The Cost in dollars is "+red.cost);
    System.out.println("The Burn Time is "+red.burnTime+" minutes.");
    System.out.println("Type 2 ");
    Type2 = scnr.nextDouble();
    
      if (Type2 <= 0) {
        System.out.println("Your number cant be lower than 0 ");
        Type2 = scnr.nextInt();
      } else {
        System.out.print("");
      }
    
    double B2 = Type2 * blue.cost;
    
    System.out.println("The Name is "+green.name);
    System.out.println("The Type is "+green.type);
    System.out.println("The Cost in dollars is "+green.cost);
    System.out.println("The Burn Time is "+green.burnTime+" minutes.");
    System.out.println("Type 3 ");
    Type3 = scnr.nextDouble();
    
        if (Type3 <= 0) {
          System.out.println("Your number cant be lower than 0 ");
          Type3 = scnr.nextInt();
        } else {
          System.out.print("");
        }
    
    double B3 = Type3 * blue.cost;
    
    double totalCost;
    totalCost = B1 + B2 + B3; 
    double discountCost = totalCost;
    
        if (discountCost >= 20.01 && discountCost <= 35) {
          discountCost = totalCost -(totalCost * 0.05);
        }
        if (discountCost >= 35.01 && discountCost <= 50) {
          discountCost = totalCost -(totalCost * 0.07);
        } 
        if (discountCost >= 50.01 && discountCost <= 100) {
          discountCost = totalCost -(totalCost * 0.1);
        }
        if (discountCost >= 100.01) {
          discountCost = totalCost -(totalCost * 0.05);
        }
    
    System.out.println();
    System.out.println("Your Order Summary is ");
    int i1 = 0;
    System.out.print((int)Type1+" Type 1 "+blue.name+" Candles ");
    
        while (i1 < (int)Type1)  {
          i1++;
          System.out.print("#");
    }
    
    System.out.println();
    int i2 = 0;
    System.out.print((int)Type2+" Type 2 "+red.name+" Candles ");
    
        while (i2 < (int)Type2)  {
          i2++;
          System.out.print("!");
        }
    
    System.out.println();
    int i3 = 0;
    System.out.print((int)Type3+" Type 3 "+green.name+" Candles ");
    
        while (i3 < (int)Type3)  {
          i3++;
          System.out.print("*");
        }
        
    System.out.println();
    System.out.println("Your Total Cost before discount is " + totalCost);
    System.out.println("Your Discounted price is " + discountCost);
    
    int totalBurnTime = blue.burnTime + red.burnTime + green.burnTime;
    System.out.println("The Total Burn Time is " +totalBurnTime);
    
    double costPerMinute = totalBurnTime / discountCost;
    System.out.println("The Cost Per Minute is " + String.format("%.2f", costPerMinute));

    // Bonus-Bonus-Bonus

    int rewardPoints = (((int)Type1 + (int)Type2 + (int)Type3 )/ 10);
    if(rewardPoints > 0) {
    System.out.println("Your Reward Points are "+ rewardPoints);
    }
    scnr.close();
  } 
}