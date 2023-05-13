
import java.util.*;

public class Person {
private String firstName;
private String lastName;
private int id;

public Person(String firstName, String lastName, int id){
    this.firstName = firstName;
    this.lastName = lastName;
    this.id = id; 
}

public String getFirstName(){
    return firstName;
}

public String getLastName(){
    return lastName;
}

public int getId(){
    return id;
}

public void display(){
    System.out.println("Name: " + firstName + " " + lastName + " ID: " + id);
}
@Override
public boolean equals(Object other) {
    if (other == null) {
        return false;
    }
    if (this.getClass() != other.getClass()) {
        return false;
    }
    return this.getId() == ((Person) other).getId();
}
}


