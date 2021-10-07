package view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.Member;

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

  public void printVerboseMemberList(ArrayList<Member> members) {
    System.out.println("Verbose member list:");
    if (members.size() > 0) {
      for (int i = 0; i < members.size(); i++) {
        // test:
        System.out.println(
            "Name: " + members.get(i).getName() + " , personal number: " + members.get(i).getPersonalNumber() + " , id: " + members.get(i).getId() + " , boat information FIX!");
      }
    } else {
      System.out.println("Registry is empty.");
    }
  }

  public void printCompactMemberList(ArrayList<Member> members) {
    System.out.println("Compact member list:");
    if (members.size() > 0) {
      for (int i = 0; i < members.size(); i++) {
        // test:
        System.out.println("Name: " + members.get(i).getName() + " , id: " + members.get(i).getId() + " , number of boats: " + 0);
      }
    } else {
      System.out.println("Registry is empty.");
    }
  }

}
