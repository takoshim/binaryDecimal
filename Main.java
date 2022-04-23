import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Prompt user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter any binary number");
        long binary = scanner.nextLong();
        int decimalResult = toDecimal(binary);
        System.out.println("Binary " + binary + " is equal to decimal " + decimalResult);

        // Prompts user
        System.out.println("Enter any decimal number");
        int decimal = scanner.nextInt();
        long binaryResult = toBinary(decimal);
        System.out.println("Decimal " + decimal + " is equal to binary " + binaryResult);
    }

    /**
     * This function returns a decimal number in int type.
     * @param binary - binary value wanted to be a decimal
     * @return decimal
     */
    public static int toDecimal(long binary) {

        // Returns 1 if 1;
        if (binary == 1) {
            return 1;
        }
        // Changes long type binary into String
        String binaryString = Long.toString(binary);

        // Splits String type binary into array of String
        String[] binaryArrayString = binaryString.split("");

        // Define necessary variables
        int exponentialPower = 0;
        int decimal = 0;

        // Loop from small digit to larger digit
        for (int i = binaryArrayString.length - 1; i >= 0; i--) {
            int d = Integer.parseInt(binaryArrayString[i]);

            // Multiplies each digit by exponential of 2
            decimal += d * (Math.pow(2.0, exponentialPower));
            exponentialPower++;
        }
        return decimal;
    }

    /**
     * This function returns a binary number in type long.
     * @param decimal - decimal value wanted to be a binary
     * @return binary
     */
    public static long toBinary(int decimal) {

        // Returns 0 if 0
        if (decimal ==0) {
            return 0;
        }

        // Defines necessary variables
        int quotient = decimal;
        String binaryStringReversed = "";

        // Concatenates the remainders form binary in reversed order
        while (quotient != 0) {
            binaryStringReversed = binaryStringReversed.concat(Integer.toString(quotient %2));
            quotient /= 2;
        }

        // Splits String type reversed order binary into array of String
        String[] binaryArrayStringReversed = binaryStringReversed.split("");

        // Reverses the order of result
        String binaryString = "";
        for (int i=binaryArrayStringReversed.length-1; i>=0;  i--) {
            binaryString = binaryString.concat(binaryArrayStringReversed[i]);
        }

        // Parses String type binary into type long and returns
        return Long.parseLong(binaryString);
    }
}

