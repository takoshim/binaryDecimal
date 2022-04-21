import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Prompt user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter any binary number");
        long binary = scanner.nextLong();

        int result = toDecimal(binary);
        System.out.println("Binary " + binary + " is equal to decimal " + result);
    }
    public static int toDecimal(long binary) {
        // Returns 1 if 1;
        if (binary == 1) {
            return 1;
        }
        // Changes binary into array of String
        String binaryInString = Long.toString(binary);
        String[] arrayOfStringBinary = binaryInString.split("");

        // Define necessary variables
        int exponentialValue = 0;
        int decimal = 0;

        // Loop from smallest to largest digits
        for (int i = arrayOfStringBinary.length - 1; i >= 0; i--) {
            int d = Integer.parseInt(arrayOfStringBinary[i]);
            decimal += d * (Math.pow(2.0, exponentialValue));
            exponentialValue++;
        }
        return decimal;
    }
}

