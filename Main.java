import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Prompt user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter any binary number");
        String binaryString = scanner.nextLine();
        long decimal = changeBinaryInStringToDecimalInLong(binaryString);
        System.out.println("Binary " + binaryString + " is equal to decimal " + decimal);

        // Prompts user
        System.out.println("Enter any decimal number");
        long decimalLong = scanner.nextLong();
        String binaryResult = changeDecimalInLongToBinaryInString(decimalLong);
        System.out.println("Decimal " + decimal + " is equal to binary " + binaryResult);
    }

    /**
     * This function returns a decimal number in long type.
     * @param binaryString - binary value needing to be decimal
     * @return decimal in long
     */
    public static long changeBinaryInStringToDecimalInLong(String binaryString) {

        // Returns 1 if 1;
        if (binaryString == "1") {
            return 1;
        }

        // Splits String type binary into array of String
        String[] binaryArrayString = binaryString.split("");

        // Define necessary variables
        int exponentialPower = 0;
        long decimal = 0;

        // Loop from small digit to larger digit
        for (int i = binaryArrayString.length - 1; i >= 0; i--) {
            long d = Long.parseLong(binaryArrayString[i]);

            // Multiplies each digit by exponential of 2
            decimal += d * (Math.pow(2.0, exponentialPower));
            exponentialPower++;
        }
        return decimal;
    }

    /**
     * This function returns a binary number in type String.
     * @param decimalLong - decimal value needing to be binary
     * @return binary in String
     */
    public static String changeDecimalInLongToBinaryInString(long decimalLong) {

        // Returns 0 if 0
        if (decimalLong ==0) {
            return "0";
        }

        // Defines necessary variables
        long quotient = decimalLong;
        String binaryStringReversed = "";

        // Concatenates the remainders form binary in reversed order
        while (quotient != 0) {
            binaryStringReversed = binaryStringReversed.concat(Long.toString(quotient %2));
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
        return binaryString;
    }
}

