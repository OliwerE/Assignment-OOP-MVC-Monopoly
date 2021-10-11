package view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.domain.Boat;
import model.domain.Member;

/**
 * Responsible for the user interface.
 */
public class Console {
  private Scanner scanner = new Scanner(System.in, "UTF-8");

  /**
   * Displays the title of the application.
   */
  public void displayTitle() {
    System.out.println("---------- Member Registry ----------");
  }

  /**
   * Displays the main menu.
   */
  public void displayMainMenu() {
    System.out.print("Verbose member list (1), compact member list (2), exit (3): ");
  }

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
   * Displays the verbose member list.

   * @param members Members from the registry.
   */
  public void displayVerboseMemberList(ArrayList<Member> members) {
    printLine("Verbose member list:");
    Boolean hasMembers = hasMembers(members);
    if (hasMembers) {
      printMemberList(members, true);
    } else {
      System.out.println("Registry is empty.");
    }
  }

  /**
   * Prints a line in the terminal.

   * @param s The line to print.
   */
  public void printLine(String s) {
    System.out.println(s);
  }

  /**
   * Checks if the registry contains members.

   * @param members Member registry.
   * @return If the member registry contains members.
   */
  private Boolean hasMembers(ArrayList<Member> members) {
    if (members.size() > 0) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Prints all members.

   * @param members All members to print.
   * @param isVerbose If the member information should be verbose.
   */
  private void printMemberList(ArrayList<Member> members, Boolean isVerbose) {
    for (int i = 0; i < members.size(); i++) {
      if (isVerbose) {
        displayMember(members.get(i));
      } else {
        System.out.println("--------");
        System.out.println("Name: " + members.get(i).getName());
        System.out.println("id: " + members.get(i).getId());
        System.out.println("number of boats: " + members.get(i).getBoats().size());
      }
    }
  }

  /**
   * Prints boats owned by one member.

   * @param boats Boats registered by one member.
   */
  private void printBoats(ArrayList<Boat> boats) {
    System.out.println("Boats:");
    for (int j = 0; j < boats.size(); j++) {
      System.out.println("----");
      System.out.println("Boat id: " + boats.get(j).getBoatId());
      System.out.println("Type: " + boats.get(j).getBoatType());
      System.out.println("Length: " + boats.get(j).getBoatLength());
    }
  }

  /**
   * Displays a compact member list.

   * @param members Members to be displayed.
   */
  public void displayCompactMemberList(ArrayList<Member> members) {
    printLine("Compact member list:");
    Boolean hasMembers = hasMembers(members);
    if (hasMembers) {
      printMemberList(members, false);
    } else {
      System.out.println("Registry is empty.");
    }
  }

  /**
   * Displays close message.
   */
  public void displayCloseMessage() {
    System.out.println("Closes application...");
  }

  /**
   * Closes the input scanner.
   */
  public void closeScanner() {
    scanner.close();
  }

  /**
   * Displays menu input error.

   * @param input Input from user.
   */
  public void displayMenuInputError(int input) {
    System.out.println(input + " is not an alternative!");
  }

  /**
   * Displays member list menu.
   */
  public void displayMemberListMenu() {
    System.out.print("Show member (1), create member (2), delete member (3), main Menu (4): ");
  }

  /**
   * Displays one member.

   * @param m Member to be displayed.
   */
  public void displayMember(Member m) {
    System.out.println("--------");
    System.out.println("Name: " + m.getName());
    System.out.println("Personal number: " + m.getPersonalNumber());
    System.out.println("Id: " + m.getId());
    printBoats(m.getBoats());
  }

  /**
   * Displays member menu.
   */
  public void displayMemberMenu() {
    System.out.print("Register boat (1), change boat type (2), change boat lenght (3)");
    System.out.print(", Change name (4), change personal number (5), back (6): ");
  }

  /**
   * Handles get boat id from user.

   * @return Boat id from user.
   */
  public int getBoatId() {
    System.out.print("Enter boat id: ");
    return getIntInput();
  }

  /**
   * Handles get member name from user.

   * @return Member name from user.
   */
  public String getMemberName() {
    System.out.print("Enter name: ");
    return getStringInput();
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
   * Handles get personal number from user.

   * @return Personal number from user.
   */
  public int getPersonalNumber() {
    System.out.print("Enter personal number: ");
    return getIntInput();
  }

  /**
   * Displays member registration status.

   * @param isSuccess If the member has been registered.
   */
  public void displayRegisterMemberStatus(Boolean isSuccess) {
    if (isSuccess) {
      System.out.print("Member has been registered!");
    } else {
      System.out.print("Member has not been registered.");
    }
  }

  /**
   * Display delete member message.
   */
  public void deleteMemberMessage() {
    System.out.print("Enter member id: ");
  }

  /**
   * Displays delete member status.

   * @param isSuccess If the member has been removed
   */
  public void displayDeleteMemberStatus(Boolean isSuccess) {
    if (isSuccess) {
      System.out.print("Member has been removed!");
    } else {
      System.out.print("Member has not been removed.");
    }
  }

  /**
   * Handles get boat type from user.

   * @return Boat type from user.
   */
  public int getBoatType() {
    System.out.print("Enter boat type (1 = Sailboat, 2 = Motorsailer, 3 = Kayak/Canoe, 4 = Other): ");
    return getIntInput();
  }

  /**
   * Handles get boat length from user.

   * @return Boat length from user.
   */
  public int getBoatLength() {
    System.out.print("Enter boat length: ");
    return getIntInput();
  }

  /**
   * Displays register boat status.

   * @param isSuccess If the boat has been registered.
   */
  public void displayBoatRegisteredStatus(Boolean isSuccess) {
    if (isSuccess) {
      System.out.print("Boat has been registered!");
    } else {
      System.out.print("Boat has not been registered.");
    }
  }

  /**
   * Displays update boat status.

   * @param isSuccess If the boat has been updated.
   */
  public void displayBoatUpdateMessage(Boolean isSuccess) {
    if (isSuccess) {
      System.out.println("Boat has been updated!");
    } else {
      System.out.println("Boat has not been updated.");
    }
  }
}
