package view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.Boat;
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
        System.out.println("Name: " + members.get(i).getName() + "\npersonal number: " + members.get(i).getPersonalNumber() + "\nid: " + members.get(i).getId());

        System.out.println("Boats:");
        for (int j = 0; j < members.get(i).getBoats().size(); j++) { // kopierad till printMember!! skapa metod
          ArrayList<Boat> boats = members.get(i).getBoats();
          System.out.println("----\nBoat " + Integer.toString(j + 1) + ": \nType: " + boats.get(j).getBoatType() + "\nLength: " + boats.get(j).getBoatLength() + "\n----");
        }

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
        System.out.println("Name: " + members.get(i).getName() + "\nid: " + members.get(i).getId() + "\nnumber of boats: " + members.get(i).getBoats().size());
      }
      System.out.println("--------");
    } else {
      System.out.println("Registry is empty.");
    }
  }

  public void printMember(Member m) {
    System.out.println("--------");
    System.out.println("Name: " + m.getName() + "\nPersonal number: " + m.getPersonalNumber() + "\nId: " + m.getId());
    
    System.out.println("Boats:");
    for (int j = 0; j < m.getBoats().size(); j++) { // kopierad till printMember!! skapa metod
      ArrayList<Boat> boats = m.getBoats();
      System.out.println("----\nBoat " + Integer.toString(j + 1) + ": \nType: " + boats.get(j).getBoatType() + "\nLength: "
          + boats.get(j).getBoatLength() + "\n----");
    }
    
    System.out.println("--------");
  }

  public void closeScanner() {
    scanner.close();
  }

}
