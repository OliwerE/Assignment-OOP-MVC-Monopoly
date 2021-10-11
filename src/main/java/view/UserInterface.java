package view;

import java.util.ArrayList;
import model.domain.Boat;
import model.domain.Member;

/**
 * Responsible for the user interface.
 */
public class UserInterface extends StatusMessage {
  private UserInput input = new UserInput();

  public UserInput getScanner() {
    return input;
  }

  /**
   * Displays the title of the application.
   */
  public void displayTitle() {
    System.out.println("---------- Member Registry ----------");
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
   * Handles get boat id from user.

   * @return Boat id from user.
   */
  public int getBoatId() {
    System.out.print("Enter boat id: ");
    return input.getIntInput();
  }

  /**
   * Handles get member name from user.

   * @return Member name from user.
   */
  public String getMemberName() {
    System.out.print("Enter name: ");
    String i = input.getStringInput();
    return i;
  }

  /**
   * Handles get personal number from user.

   * @return Personal number from user.
   */
  public int getPersonalNumber() {
    System.out.print("Enter personal number: ");
    return input.getIntInput();
  }

  /**
   * Display delete member message.
   */
  public void deleteMemberMessage() {
    System.out.print("Enter member id: ");
  }

  /**
   * Handles get boat type from user.

   * @return Boat type from user.
   */
  public int getBoatType(String inputText) {
    System.out.print(inputText);
    return input.getIntInput();
  }

  /**
   * Handles get boat length from user.

   * @return Boat length from user.
   */
  public int getBoatLength() {
    System.out.print("Enter boat length: ");
    return input.getIntInput();
  }
}
