public class TimeConversion {
    
    /**
     * Constructor
     */
    TimeConversion(){

    }


    /**
     * TO DO: showDecaseconds method
     * Given a number of seconds calculates 
     * and display decaseconds
    */
    public void showDecaseconds(int seconds){ 
    // add your code here
    //The format for the code is simple, I have an algorithm, an explanation and a print stament. I kept the theme constant. 
    double decaseconds = seconds / 10;
    System.out.println("1 second is .1 decasecond");
    System.out.println("Your time in decaseconds is: " + decaseconds);

    }
   


    /**
     * TO DO: showJiffies method
     * Given a number of seconds calculates 
     * and display jiffies
    */
    public void showJiffies(int seconds){
    // add your code here
    double jiffies = seconds / .01;
    System.out.println("1 second is 10 jiffies");
    System.out.println("Your time in jiffies is: " + jiffies);

    }

    /** 
     * TO DO: showNewYorkMinutes method
     * Given a number of seconds calculates 
     * and display New York minutes
    */
    public void showNewYorkMinutes(int seconds){
    // add your code here
    double NewYorkMinutes = seconds * .05;
    System.out.println("1 second is 1/20 new york minutes");
    System.out.println("Your time in new york minutes is: " + NewYorkMinutes);

    }

    /**
     * TO DO: showNanoCenturies method
     * Given a number of seconds calculates 
     * and display Nanocenturies
    */ 
    public void showNanoCenturies(int seconds){
    // add your code here
    double nanoCenturies = seconds / 3.156; 
    System.out.println("3.156 seconds in one NanoCenturies");
    System.out.println("Your time in NanoCenturies is " + nanoCenturies);


    }

     /**
     * TO DO: showScaramuccis method
     * Given a number of seconds calculates 
     * and display Scaramuccis
    */ 
    public void showScaramuccis(int seconds){
    // add your code here
    //The math here is 60 x 60 x 11 x 24
    double scaramuccis = seconds / 950400;
    System.out.println("950400 seconds in 1 Scaramuccis");
    System.out.println("Your time in Scaramuccis is " + scaramuccis);



    }


    
}//end class