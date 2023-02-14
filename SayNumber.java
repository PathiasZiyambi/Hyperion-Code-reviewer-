package SayNumber;
import java.util.Scanner;

// Class called SayNumber, which contains a static method called sayNumber that takes an integer num as input and returns
// the standard way of reading a number as a string.
public class SayNumber {
  // SayNumber class defines two private static arrays of strings: ones and tens. These arrays hold the English names for
  // the numbers 0-19 and multiples of ten up to 90.
  private static String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
  private static String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
  // The sayNumber method first checks if the input number num is zero, in which case it returns the string "Zero.".
  public static String sayNumber(int num) {
    if (num == 0) {
      return "Zero.";
    }
    // If the number is not zero, the method divides the number into its constituent parts: billions, millions, 
    // thousands, and hundreds.
    String result = "";
    int billion = num / 1000000000;
    int million = (num - billion * 1000000000) / 1000000;
    int thousand = (num - billion * 1000000000 - million * 1000000) / 1000;
    int hundred = num - billion * 1000000000 - million * 1000000 - thousand * 1000;

    if (billion != 0) {
      result = sayNumber(billion) + " billion";
    }

    if (million != 0) {
      if (!result.isEmpty()) {
        result += ", ";
      }
      result += sayNumber(million) + " million";
    }

    if (thousand != 0) {
      if (!result.isEmpty()) {
        result += ", ";
      }
      result += sayNumber(thousand) + " thousand";
    }

    if (hundred != 0) {
      if (!result.isEmpty()) {
        result += ", ";
      }
      result += sayNumberLessThanThousand(hundred);
    }

    return result + ".";
  }
  // The sayNumberLessThanThousand method converts a number less than 1000 into English. It first separates the
  // number into its hundreds and rest parts, and then converts the hundreds part to English if it is not zero.
  // It then converts the rest part to English by looking up its name in the ones and tens arrays, depending on 
  // whether it is less than 20 or not.
  private static String sayNumberLessThanThousand(int num) {
    int hundred = num / 100;
    int rest = num - hundred * 100;
    String result = "";

    if (hundred != 0) {
      result = ones[hundred] + " hundred";
    }

    if (rest != 0) {
      if (!result.isEmpty()) {
        result += " and ";
      }
      if (rest < 20) {
        result += ones[rest];
      } else {
        int ten = rest / 10;
        int one = rest - ten * 10;
        result += tens[ten] + " " + ones[one];
      }
    }

    return result;
  }
  // The main method simply reads an integer from standard input using a Scanner object, calls the sayNumber 
  // method with this integer, and prints the result to standard output.
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a number: ");
    int num = scanner.nextInt();
    System.out.println(sayNumber(num));
    scanner.close();
  }
}

