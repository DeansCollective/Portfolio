public class budget {
    public static void main(String[] args) {
        //Project 1
        double rent = 625;
        double internet = 27;
        double grocery = 250;
        double fun = 150;
        //Created an int for a the future algorithm for saving 100$
        int extra = 100;
        //Created integers for the month and wage to help with the math
        double wage = 10;
        double weeksInaMonth = 4;
        //This algorithm find hours he would have to work per week per month
        double expenses = rent + internet + grocery + fun;
        double totalhours = expenses/wage;
        double weeklyhours = totalhours/weeksInaMonth; 
        //This algorithm finds hours he would have to work to save 100$ per week per month 
        double saving = rent + internet + grocery + fun + extra;
        double savinghours = saving/wage;
        double savingWeeklyHours = savinghours/weeksInaMonth;

        System.out.println("Hourly wage is 10$");
        System.out.println("Montly rent " + rent);
        System.out.println("Monthly internet bill " + internet);
        System.out.println("Monthly grocery bill " + grocery);
        System.out.println("Monthly fun " + fun);
        System.out.println("Putting money away for savings is " + extra + "$");
        System.out.println("Monthly item expense " + expenses );
        //Used a math formula that rounds up. You would be broke if it rounded down.
        System.out.println("How many hours per week you would have to work to break even is " +(int) Math.ceil(weeklyhours));
        System.out.println("How many hours per week you would have to work to save $100 is " +(int) Math.ceil(savingWeeklyHours));
        

         


    }

}
