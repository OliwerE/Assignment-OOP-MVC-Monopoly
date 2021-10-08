package view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.Boat;
import model.Member;

public class Console {
  Scanner scanner = new Scanner(System.in);

  public void displayTitle() {
    System.out.println("---------- Member Registry ----------");
  }

  public void displayMainMenu() {
    System.out.println("Verbose member list (1), compact member list (2), exit (3): ");
  }

  public int getMenuInput() {
    try {
      return scanner.nextInt();
    } catch (InputMismatchException e) {
      System.out.println(e);
      return -1;
    }
  }

  public void displayVerboseMemberList(ArrayList<Member> members) {
    printLine("Verbose member list:");
    Boolean hasMembers = hasMembers(members);
    if (hasMembers) {
      printMemberList(members, true);
    } else {
      System.out.println("Registry is empty.");
    }
  }

  private void printLine(String s) {
    System.out.println(s);
  }

  private Boolean hasMembers(ArrayList<Member> members) {
    if (members.size() > 0) {
      return true;
    } else {
      return false;
    }
  }

  private void printMemberList(ArrayList<Member> members, Boolean isVerbose) {
    for (int i = 0; i < members.size(); i++) {
      System.out.println("--------");
      if (isVerbose) {
        System.out.println("Name: " + members.get(i).getName() + "\npersonal number: " + members.get(i).getPersonalNumber() + "\nid: " + members.get(i).getId());
        printBoats(members.get(i).getBoats());
      } else {
        System.out.println("Name: " + members.get(i).getName() + "\nid: " + members.get(i).getId() + "\nnumber of boats: " + members.get(i).getBoats().size());
      }
    }
  }

  private void printBoats(ArrayList<Boat> boats) {
    System.out.println("Boats:");
    for (int j = 0; j < boats.size(); j++) {
      System.out.println("----\nBoat " + Integer.toString(j + 1) + ": \nType: " + boats.get(j).getBoatType() + "\nLength: " + boats.get(j).getBoatLength() + "\n----");
    }
  }

  public void displayCompactMemberList(ArrayList<Member> members) {
    printLine("Compact member list:");
    Boolean hasMembers = hasMembers(members);
    if (hasMembers) {
      printMemberList(members, false);
    } else {
      System.out.println("Registry is empty.");
    }
  }

  public void displayCloseMessage() {
    System.out.println("Closes application...");
  }

  public void closeScanner() {
    scanner.close();
  }

  public void displayMenuInputError(int input) {
    System.out.println(input + " is not an alternative!");
  }

  public void displayMemberListMenu() {
    System.out.println("Show member (1), create member (2), delete member (3), main Menu (4): ");
  }


  /*
  public void print(String s) {
    System.out.print(s);
  }

  /*
  public String getString() {
    try {
      return scanner.next();
    } catch (InputMismatchException e) {
      System.out.println(e);
      return "";
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
  */
}
