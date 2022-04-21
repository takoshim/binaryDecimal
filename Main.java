import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Prompt user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter any binary number");
        String binary = scanner.nextLine();

        // Split String into digits
        String[] arrayOfStringBinary = binary.split("");

        // Define necessary variables
        int exponentialValue = 0;
        int theDecimal = 0;

        // Loop from smallest to largest digits
        for(int i=arrayOfStringBinary.length-1; i >=0; i--) {
            int d = Integer.parseInt(arrayOfStringBinary[i]);
            theDecimal += d * (Math.pow(2.0, exponentialValue));
            exponentialValue++;
        }
        System.out.println("The decimal number: " + theDecimal);
    }
}


