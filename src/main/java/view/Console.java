package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
  Scanner scanner = new Scanner(System.in);

  public void printLine(String s) {
    System.out.println(s);
  }

  public void print(String s) {
    System.out.print(s);
  }

  public Integer getInteger() {
    try {
      return scanner.nextInt();
    } catch (InputMismatchException e) {
      System.out.println(e);
      return -1;
    }
  }

  public String getString() {
    try {
      return scanner.next();
    } catch (InputMismatchException e) {
      System.out.println(e);
      return "";
    }
  }

}
