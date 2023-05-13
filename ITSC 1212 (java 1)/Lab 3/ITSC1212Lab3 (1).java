import java.awt.Color;

public class ITSC1212Lab3 {
    public static void main(String[] args) { 
         /* 
        //World w = new World(100, 100); 
        //Turtle tom = new Turtle (w); 
        //tom.forward();
        World w= new World (500, 500); 
        Turtle tom= new Turtle (100,250,w); 
        tom.forward(); 
        //Moves tom forward 100 pixels 
        tom.turn(270); 
        tom.penUp(); 
        //Turns tom so it faces left, then moves the pen up 
        tom.forward(50); 
        //Moves tom forward 50 pixels 
        tom.turn(180); 
        tom.penDown(); 
        tom.forward(); 
        //Turns tom around so he faces right, puts the pen down, and draws // a line 100 pixels long
        tom.penUp();
        tom.forward(15);
        tom.penDown();
        tom.forward(50);
        tom.turn(90);
        tom.forward(100);
        tom.turn(90);
        tom.forward(50);
        tom.turn(90);
        tom.forward(100);
        // this is the M
        tom.penUp();
        tom.turn(90);
        tom.forward(65);
        tom.penDown();
        tom.turn(90);
        tom.forward(100);
        tom.turn(180);
        tom.forward(100);
        tom.turn(135);
        tom.forward(50);
        tom.turn(270);
        tom.forward(50);
        tom.turn(135);
        tom.forward(100);
        //done with the O
*/

        World w = new World(500,500);
        Turtle tom = new Turtle(w);
        /* 
        tom.forward(50);
        tom.turn(60);
        tom.forward(50);
        tom.turn(60);
        tom.forward(50);
        tom.turn(60);
        tom.forward(50);
        tom.turn(60);
        tom.forward(50);
        tom.turn(60);
        tom.forward(50);
        tom.turn(60);

        tom.setPenColor(Color.CYAN);
        tom.turn(90);
        tom.forward(50);
        tom.turn(60);
        tom.forward(50);
        tom.turn(60);
        tom.forward(50);
        tom.turn(60);
        tom.forward(50);
        tom.turn(60);
        tom.forward(50);
        tom.turn(60);
        tom.forward(50);
        tom.turn(60);

        tom.setPenColor(Color.MAGENTA);
        tom.turn(90);
        tom.forward(50);
        tom.turn(60);
        tom.forward(50);
        tom.turn(60);
        tom.forward(50);
        tom.turn(60);
        tom.forward(50);
        tom.turn(60);
        tom.forward(50);
        tom.turn(60);
        tom.forward(50);
        tom.turn(60);

        tom.setPenColor(Color.GRAY);
        tom.turn(90);
        tom.forward(50);
        tom.turn(60);
        tom.forward(50);
        tom.turn(60);
        tom.forward(50);
        tom.turn(60);
        tom.forward(50);
        tom.turn(60);
        tom.forward(50);
        tom.turn(60);
        tom.forward(50);
        tom.turn(60);
        tom.setVisible(false); 
        */
        
        tom.hexagon(100);

        tom.setPenColor(Color.CYAN);
        tom.turn(90);
        tom.hexagon(100);

        tom.setPenColor(Color.MAGENTA);
        tom.turn(90);
        tom.hexagon(100);

        tom.setPenColor(Color.GRAY);
        tom.turn(90);
        tom.hexagon(100);

        tom.setPenColor(Color.RED);
        tom.turn(45);
        tom.setPenWidth(10);
        tom.hexagon(120);

        tom.setPenWidth(10);
        tom.hexagon(60);

        tom.setPenWidth(10);
        tom.hexagon(30);

        tom.setVisible(false); 







    }
}
