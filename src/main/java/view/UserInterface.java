package view;

import java.util.ArrayList;
import model.domain.Boat;
import model.domain.Boat.BoatType;
import model.domain.Member;

/**
 * Responsible for the user interface.
 */
public class UserInterface extends StatusMessage {
  private UserInput input = new UserInput();

  /**
   * Main menu input alternatives.
   */
  public enum MainMenuInput {
    Verbose, Compact, Exit, Error
  }

  /**
   * Member list menu alternatives.
   */
  public enum MemberListMenuInput {
    ShowMember, CreateMember, DeleteMember, MainMenu, Error
  }

  /**
   * Member menu alternatives.
   */
  public enum MemberMenuInput {
    RegisterBoat, ChangeBoatType, ChangeBoatLength, RemoveBoat, ChangeName, ChangePersonalNumber, MemberListMenu, Error
  }

  /**
   * Request and return user input from the main menu.

   * @return User input.
   */
  public MainMenuInput mainMenu() {
    this.printLine("Verbose member list (1), compact member list (2), exit (3): ");
    int userInput = input.getIntInput();

    if (userInput == 1) {
      return MainMenuInput.Verbose;
    } else if (userInput == 2) {
      return MainMenuInput.Compact;
    } else if (userInput == 3) {
      return MainMenuInput.Exit;
    } else {
      return MainMenuInput.Error;
    }
  }

  /**
   * Request and return user input from the member list menu.

   * @return User input.
   */
  public MemberListMenuInput memberListMenu() {
    this.printLine("Show member (1), create member (2), delete member (3), main Menu (4): ");
    int userInput = input.getIntInput();

    if (userInput == 1) {
      return MemberListMenuInput.ShowMember;
    } else if (userInput == 2) {
      return MemberListMenuInput.CreateMember;
    } else if (userInput == 3) {
      return MemberListMenuInput.DeleteMember;
    } else if (userInput == 4) {
      return MemberListMenuInput.MainMenu;
    } else {
      return MemberListMenuInput.Error;
    }
  }

  /**
   * Request and return user input from the member menu.

   * @return User input.
   */
  public MemberMenuInput memberMenu() {
    // Gradle doesn't like long strings...
    String memberMenuText1 = "Register boat (1), change boat type (2), change boat lenght (3)";
    String memberMenuText2 = ", remove boat(4), Change name (5), change personal number (6), back (7): ";
    this.printLine(memberMenuText1 + memberMenuText2);
    int userInput = input.getIntInput();

    if (userInput == 1) {
      return MemberMenuInput.RegisterBoat;
    } else if (userInput == 2) {
      return MemberMenuInput.ChangeBoatType;
    } else if (userInput == 3) {
      return MemberMenuInput.ChangeBoatLength;
    } else if (userInput == 4) {
      return MemberMenuInput.RemoveBoat;
    } else if (userInput == 5) {
      return MemberMenuInput.ChangeName;
    } else if (userInput == 6) {
      return MemberMenuInput.ChangePersonalNumber;
    } else if (userInput == 7) {
      return MemberMenuInput.MemberListMenu;
    } else {
      return MemberMenuInput.Error;
    }

  }

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
      System.out.println("Boat : " + Integer.toString(j + 1));
      System.out.println("Type: " + boatTypeToString(boats.get(j)));
      System.out.println("Length: " + boats.get(j).getBoatLength());
    }
  }

  /**
   * Converts boat type enumeration to string.

   * @param b Get boat type from.
   * @return Boat type string.
   */
  private String boatTypeToString(Boat b) {
    BoatType type = b.getBoatType();

    if (type == BoatType.Sailboat) {
      return "Sailboat";
    } else if (type == BoatType.Motorsailer) {
      return "Motorsailer";
    } else if (type == BoatType.KayakCanoe) {
      return "Kayak/Canoe";
    } else {
      return "Other";
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
  public int getBoatNumber() {
    System.out.print("Enter boat number: ");
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
  public int getMemberId() {
    System.out.print("Enter member id: ");
    return input.getIntInput();
  }

  /**
   * Handles get boat type from user.

   * @return Boat type from user.
   */
  public BoatType getBoatType() {
    while (true) {
      System.out.print("Enter boat type (1 = Sailboat, 2 = Motorsailer, 3 = Kayak/Canoe, 4 = Other): ");
      int userInput = input.getIntInput();

      if (userInput == 1) {
        return BoatType.Sailboat;
      } else if (userInput == 2) {
        return BoatType.Motorsailer;
      } else if (userInput == 3) {
        return BoatType.KayakCanoe;
      } else if (userInput == 4) {
        return BoatType.Other;
      } else {
        continue;
      }
    }
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
