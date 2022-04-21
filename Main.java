import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // int[] theBinary = {1,0,0,1,0,1,1};
        // int[] theBinary = {1,0,0,1,0,0,1,0,0,1,0,0};
        String binary = "1001011";
        String[] arrayOfStringBinary = binary.split("");
        int exponentialValue = 0;
        int theDecimal = 0;
        for(int i=arrayOfStringBinary.length-1; i >=0; i--) {
            int d = Integer.parseInt(arrayOfStringBinary[i]);
            theDecimal += d * (Math.pow(2.0, exponentialValue));
            exponentialValue++;
        }
        System.out.println("The decimal number: " + theDecimal);
    }
}


