package view;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Responsible for user input.
 */
public class UserInput {
  private Scanner scanner = new Scanner(System.in, "UTF-8");

  /**
   * Handles integer input from the user.

   * @return User input.
   */
  public int getIntInput() {
    try {
      return scanner.nextInt();
    } catch (InputMismatchException e) {
      System.out.println(e);
      return -1;
    }
  }

  /**
   * Returns string input from user.

   * @return User input.
   */
  public String getStringInput() {
    try {
      return scanner.next();
    } catch (InputMismatchException e) {
      System.out.println(e);
      return "";
    }
  }

  /**
   * Closes the input scanner.
   */
  public void closeScanner() {
    scanner.close();
  }

}
