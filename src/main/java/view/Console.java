package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
  Scanner scanner = new Scanner(System.in);

  public void mainMenu() {
    System.out.println("---------- Member Registry ----------");
    System.out.print("Verbose member list (1), compact member list (2), exit (3): ");
  }

  public Integer getInteger() {
    try {
      return scanner.nextInt();
    } catch (InputMismatchException e) {
      System.out.println(e);
      return -1; // Error
    }
  }
}
