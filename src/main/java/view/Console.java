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
    System.out.print("Verbose member list (1), compact member list (2), exit (3): ");
  }

  public int getIntInput() {
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
      if (isVerbose) {
        displayMember(members.get(i));
      } else {
        System.out.println("--------\nName: " + members.get(i).getName() + "\nid: " + members.get(i).getId() + "\nnumber of boats: " + members.get(i).getBoats().size());
      }
    }
  }

  private void printBoats(ArrayList<Boat> boats) {
    System.out.println("Boats:");
    for (int j = 0; j < boats.size(); j++) {
      System.out.println("----\nBoat id: " + boats.get(j).getBoatId() + "\nType: " + boats.get(j).getBoatType() + "\nLength: " + boats.get(j).getBoatLength());
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
    System.out.print("Show member (1), create member (2), delete member (3), main Menu (4): ");
  }

  public void displayMember(Member m) {
    System.out.println("--------\nName: " + m.getName() + "\nPersonal number: " + m.getPersonalNumber() + "\nId: " + m.getId());
    printBoats(m.getBoats());
  }

  public void displayMemberMenu() {
    System.out.print("Register boat (1), change boat type (2), change boat lenght (3), Change name (4), change personal number (5), back (6): ");
  }

  public int getBoatId() {
    System.out.print("Enter boat id: ");
    return getIntInput();
  }

  public String getMemberName() {
    System.out.print("Enter name: ");
    return getStringInput();
  }

  public String getStringInput() {
    try {
      return scanner.next();
    } catch (InputMismatchException e) {
      System.out.println(e);
      return "";
    }
  }

  public int getPersonalNumber() {
    System.out.print("Enter personal number: ");
    return getIntInput();
  }

  public void displayRegisterMemberSuccess() {
    System.out.print("Member has been registered!");
  }

  public void displayRegisterMemberError() {
    System.out.print("Member has not been registered.");
  }

  public void deleteMemberMessage() {
    System.out.print("Enter member id: ");
  }

  public void deleteMemberSuccess() {
    System.out.print("Member has been removed!");
  }

  public void deleteMemberError() {
    System.out.print("Member has not been removed.");
  }

  public int getBoatType() {
    System.out.print("Enter boat type (1 = Sailboat, 2 = Motorsailer, 3 = Kayak/Canoe, 4 = Other): ");
    return getIntInput();
  }

  public int getBoatLength() {
    System.out.print("Enter boat length: ");
    return getIntInput();
  }

  public void displayBoatRegisteredSuccess() {
    System.out.print("Boat has been registered!");
  }

  public void displayBoatRegisteredError() {
    System.out.print("Boat has not been registered.");
  }

  public void displayBoatUpdateSuccess() {
    System.out.print("Boat has been updated!");
  }

  public void displayBoatUpdateError() {
    System.out.print("Boat has not been updated.");
  }
}
