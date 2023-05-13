public class ArrayUtil {
    private int intArray[]; //instance variable 

    public ArrayUtil(){ //Default Constructor
        intArray = new int[0];
    }

    public ArrayUtil(int[] array) { //Parameter Constructor
        intArray = array;
    }

    public void setIntArray(int[] arr){ //Setters set instance variables to values 
        intArray = arr;  
    }

    public int[] getIntArray(){ //getter
        return this.intArray;
    }

    public int minValue(){ //getter 
        if (intArray.length == 0){
            return 0; 
        }
        int tempMinInt = intArray[0]; //this is our current minimum value 
        for (int i = 0; i < intArray.length ;i++){ //this checks if there is a value less than out minimun value and sets our minimum value to the new smallest value
            if (intArray[i] < tempMinInt)
            tempMinInt = intArray[i];
        }
        return tempMinInt;
    }

    public int maxValue(){ //getter 
        if (intArray.length == 0){
            return 0; 
        }
        int tempMaxInt = intArray[0]; //this is our current max value
        for (int i = 0; i < intArray.length ;i++){ //this checks if there is a value greater than out maximum value and sets our maximum value to the new greatest value
            if (intArray[i] > tempMaxInt) 
            tempMaxInt = intArray[i];
        }
        return tempMaxInt;
    }

    public int countUniqueIntegers() { //getter
        if (intArray.length == 0){
            return 0; 
        }
        int count = 0;
            boolean unique = false;
            for(int i = 0; i < intArray.length; i++){ //this counts unique values 
                for (int j = i + 1; j < intArray.length; j++) {
                    if(intArray[i] == intArray[j]){
                        unique = true;
                        break;
                    }
                }
                if (!unique) {
                    count++;
                }
                unique = false;
            }
            return count;
    }
}
