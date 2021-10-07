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
        System.out.println("--------");
        System.out.println(
            "Name: " + members.get(i).getName() + "\npersonal number: " + members.get(i).getPersonalNumber() + "\nid: " + members.get(i).getId() + "\nboat information: FIX!");
      }
    } else {
      System.out.println("Registry is empty.");
    }
  }

  public void printCompactMemberList(ArrayList<Member> members) {
    System.out.println("Compact member list:");
    if (members.size() > 0) {
      for (int i = 0; i < members.size(); i++) {
        System.out.println("--------");
        System.out.println("Name: " + members.get(i).getName() + "\nid: " + members.get(i).getId() + "\nnumber of boats: " + 0);
      }
      System.out.println("--------");
    } else {
      System.out.println("Registry is empty.");
    }
  }

}
