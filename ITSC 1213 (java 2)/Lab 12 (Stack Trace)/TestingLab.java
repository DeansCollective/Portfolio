package Testinglab;

public class TestingLab {

    private static String validate(char expected, char result) {
        if (result != expected) {
            return ("The result " + result + " does not match expected: " + expected + " --->> Failed");
        } else {
            return ("The result " + result + "match expected: " + expected + " >> OK"); 
        }
    }

    private static String validate(int expected, int result) {
        if (result != expected) {
            return ("The result " + result + " does not match expected: " + expected + " --->> Failed");
        } else {
            return ("The result " + result + "match expected: " + expected + " >> OK"); 
        }
    }

    public static void main(String[] args) {
        StringAnalyzer wa = new StringAnalyzer();
        System.out.println("Testing firstRepeatedCharacter method");
    
        String s = "aardvark";
        char result = wa.firstRepeatedCharacter(s);
        System.out.println("Test 1 firstRepeatedCharacter: " + validate('a', result));
    
        s = "roommate";
        result = wa.firstRepeatedCharacter(s);
        System.out.println("Test 2 firstRepeatedCharacter: " + validate('o', result));
    
        s = "mate";
        result = wa.firstRepeatedCharacter(s);
        System.out.println("Test 3 firstRepeatedCharacter: " + validate('0', result));
    
        System.out.println(". ");

        s = "dog";
        result = wa.firstMultipleCharacter(s);
        System.out.println("Test 3 firstRepeatedCharacter: " + validate('0', result));

        s = "ddog";
        result = wa.firstMultipleCharacter(s);
        System.out.println("Test 3 firstRepeatedCharacter: " + validate('d', result));

        s = "doog";
        result = wa.firstMultipleCharacter(s);
        System.out.println("Test 3 firstRepeatedCharacter: " + validate('o', result));

        s = "dogg";
        result = wa.firstMultipleCharacter(s);
        System.out.println("Test 3 firstRepeatedCharacter: " + validate('g', result));

        System.out.println("-------------------------");

        s = "mississippiii";
        int intResult = wa.countRepeatedCharacters(s);
        System.out.println("Test 1 countRepeatedCharacters: " + validate(4, intResult));

        s = "test";
        intResult = wa.countRepeatedCharacters(s);
        System.out.println("Test 2 countRepeatedCharacters: " + validate(0, intResult));

        s = "aabbcdaaaabbb";
        intResult = wa.countRepeatedCharacters(s);
        System.out.println("Test 3 countRepeatedCharacters: " + validate(4, intResult));
        System.out.println("-");
        
    }
    
}
