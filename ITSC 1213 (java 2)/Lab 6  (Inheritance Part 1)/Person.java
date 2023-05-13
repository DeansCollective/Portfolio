/**

Class a named, last-named, and ID-carrying individual.
The methods include requesting identification, getting the person's first and last names, and displaying their information.
The class makes it possible to create things that stand in for people.
@author Dean
*/
import java.util.*;

public class Person {
//attributes
private String firstName;
private String lastName;
private int id;
/**
 * Constructor for Person.
 * @param firstName is first name
 * @param lastName is last name
 * @param id is ID number
 */
public Person(String firstName, String lastName, int id){
    this.firstName = firstName;
    this.lastName = lastName;
    this.id = id; 
}

/**
 * Method for persons name.
 * @return first name
 */
public String getFirstName(){
    return firstName;
}

/**
 * Method for persons name.
 * @return last name
 */
public String getLastName(){
    return lastName;
}

/**
 * Method for ID number.
 * @return ID number
 */
public int getId(){
    return id;
}

/**
 * Method to display info.
 */
public void display(){
    System.out.println("Name: " + firstName + " " + lastName + " ID: " + id);
}
}