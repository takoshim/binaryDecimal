import java.util.Scanner;
/*********************************
 * Your Name: Takeo Shimazu
 * Class and Section: Sp22 CIS D036A 01Y, 64Z Java Programming
 * Assignment Number: 2a Part 1
 * Due Date: Apr 28, 2022
 * Date Submitted: Apr 23, 2022
 *
 * Design
 *
 * variables
 *  for Binary to Decimal change
 *  - String -> String[] -> long
 *  for Decimal to Binary change
 *  - long -> String -> String[] -> String
 *
 * Input
 *  I generalized the program to accept user input.
 *
 * Processing
 *  (Please refer to the detailed comments)
 *
 * Printing
 *  (Please refer to the detailed comments)
 *******************************/

public class Main {
    public static void main(String[] args) {

        // Prompts user to input binary number.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter any binary number");

        // Reads user's input as String because binary numbers temps to be oversize for even type long
        String binaryString = scanner.nextLine();

        // Calls the function
        long decimal = changeBinaryInStringToDecimalInLong(binaryString);

        // Printing the result
        System.out.println("Binary " + binaryString + " is equal to decimal " + decimal);

        // Prompts user to input decimal number.
        System.out.println("Enter any decimal number");

        // Reads user's input into type long. It's more suitable than int type because of its lengthy.
        long decimalLong = scanner.nextLong();

        // Calls the function.
        String binaryResult = changeDecimalInLongToBinaryInString(decimalLong);

        // Printing the result.
        System.out.println("Decimal " + decimal + " is equal to binary " + binaryResult);
    }

    /**
     * This function returns a decimal number in long type.
     * If wrapper classes are allowed to be used, the implementation will be easier.
     * @param binaryString - binary value needing to be decimal
     * @return decimal in long
     */
    public static long changeBinaryInStringToDecimalInLong(String binaryString) {

        // Returns 1 if input is binary 1. (special case that cannot be calculated the below loop process)
        if (binaryString == "1") {
            return 1;
        }

        // Splits String type binary into array of String using "".
        String[] binaryArrayString = binaryString.split("");

        // Define necessary variables
        int exponentialPower = 0;
        long decimal = 0;          // returned value

        // Loop from small digit of the binary to larger digits
        for (int i = binaryArrayString.length - 1; i >= 0; i--) {
            long d = Long.parseLong(binaryArrayString[i]);

            // Multiplies each digit by exponential of 2, then adds up.
            decimal += d * (Math.pow(2.0, exponentialPower));
            exponentialPower++;
        }
        return decimal;
    }

    /**
     * This function returns a binary number in type String.
     * If wrapper classes are allowed to be used, the implementation will be easier.
     * @param decimalLong - decimal value needing to be binary
     * @return binary in String
     */
    public static String changeDecimalInLongToBinaryInString(long decimalLong) {

        // Returns 0 if input is 0 (special case that cannot be calculated the below loop process)
        if (decimalLong ==0) {
            return "0";
        }

        // Defines necessary variables
        long quotient = decimalLong;
        String binaryStringReversed = "";

        // Concatenates the remainders to form binary in reversed order.
        while (quotient != 0) {
            binaryStringReversed = binaryStringReversed.concat(Long.toString(quotient %2));
            quotient /= 2;
        }

        // Splits String type reversed order binary into array of String in order to reverse the order of digits.
        String[] binaryArrayStringReversed = binaryStringReversed.split("");

        // Reverses the order of result.
        String binaryString = "";
        for (int i=binaryArrayStringReversed.length-1; i>=0;  i--) {
            binaryString = binaryString.concat(binaryArrayStringReversed[i]);
        }

        // Parses String type binary into type long and returns
        return binaryString;
    }
}

