public class Magpie {
    
    /**
     * A default constuctor
     */
    public Magpie(){
    }
   
    /**
     * Get a default greeting
     */
    public String getGreeting() {
        return "Hello, let's talk.";
    }

    /**
     * Gives a response to a user statement
     */
    public String getResponse(String statement) {
        String response = "";
        statement = statement.trim();
        if (statement.indexOf("mother") >= 0) {
            response = "Tell me more about your mother.";
        } 
        else if (statement.indexOf("no") >= 0) {
            response = "Why so negative?";
        } 
        else if (statement.indexOf("kiki") >= 0) {
            response = "He sounds like a good teacher.";
        }
        else if (statement.indexOf("what") >= 0) {
            response = "What?";
        }
        else if (statement.indexOf("Stop") >= 0) {
            response = "No you.";
        }
        else if (statement.indexOf("school") >= 0){
            response = "Can you talk about your school.";
        }
        else if (statement.length() <=0) {
            response = "Say something, please. ";
        }
        else if (response.length() == 0) {
            response = getRandomResponse();
        }
        return response;
    }

    /**
     * Pick a generic response to use if nothing else fits.
     */
    private String getRandomResponse() {
        final int NUMBER_OF_RESPONSES = 8;
        double r = Math.random();
        int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
        String response = "";

        if (whichResponse == 0) {
            response = "Interesting, tell me more.";
        }  
        if (whichResponse == 1) {
            response = "Hmmm.";
        } 
        if (whichResponse == 2) {
            response = "Do you really think so?";
        } 
        if (whichResponse == 3) {
            response = "You don't say.";
        }
        if (whichResponse == 4) {
            response = "Damn.";
        }
        if (whichResponse == 5) {
            response = "Is that right?";
        }
        if (whichResponse == 6){
            response = "I dont think so?";
        }
        if (whichResponse == 7){
            response = "Wow! Crazy!";
        }
    

        return response;
    }
}
