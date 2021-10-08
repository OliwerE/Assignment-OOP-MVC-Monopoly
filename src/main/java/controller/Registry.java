package controller;

import model.Member;

public class Registry {
  private model.Registry registry = new model.Registry();
  private view.Console console = new view.Console();

  public void start() {
      devMembers();
      console.printLine("---------- Member Registry ----------");
      mainMenuInput();
  }

  private void devMembers() { // testing.. remove!
    registry.createMember("medlem1", 123456);
    registry.createMember("Medlem2", 234567);
    registry.createMember("medlem3", 345678);
  }

  private void mainMenuInput() {
    console.print("Verbose member list (1), compact member list (2), exit (3): ");
    Integer i = console.getInteger();
    handleMainMenuInput(i); 
  }

  private void handleMainMenuInput(Integer input) {
    if (input == 1) {
      console.printVerboseMemberList(registry.getMembers());
      listMenuInput();
    } else if (input == 2) {
      console.printCompactMemberList(registry.getMembers());
      listMenuInput();
    } else if (input == 3) {
      System.out.println("Closes application...");
      // persistence?
      console.closeScanner();
      System.exit(0);
    } else {
      // error
    }
  }

  private void listMenuInput() {
    console.print("Show member (1), create member (2), delete member (3), main Menu (4): ");
    Integer i = console.getInteger();
    handleListMenuInput(i);
  }

  private void handleListMenuInput(Integer input) {
    if (input == 1) {
      console.print("Select member id: ");
      Integer memberId = console.getInteger();
      Member member = registry.getMemberById(memberId);
      console.printMember(member);
      memberMenuInput(member);
    } else if (input == 2) {
      console.print("Create Member:\nEnter name: ");
      String name = console.getString();
      console.print("Enter personal number: ");
      Integer personalNumber = console.getInteger();

      Boolean isSuccess = registry.createMember(name, personalNumber);

      if (isSuccess) {
        console.printLine("Member created!");
        mainMenuInput();
      } else {
        console.printLine("Name is too short!"); // kan inte inträffa pga scanner.next !!
        mainMenuInput();
      }

    } else if (input == 3) {
      Boolean isRemoved = deleteMember();
      if (isRemoved) {
        console.printLine("Member removed!");
      } else {
        console.printLine("Member not found in registry.");
      }
      console.printCompactMemberList(registry.getMembers()); // byt till metod! code dup.
      listMenuInput();
    } else if (input == 4) {
      mainMenuInput();
    } else {
      // error
    }
  }

  private void memberMenuInput(Member m) {
    console.print("Register boat (1), Change info (2), main menu (3): ");
    Integer i = console.getInteger();
    handleMemberMenuInput(i, m);
  }

  private void handleMemberMenuInput(Integer input, Member m) {
    if (input == 1) {
      console.print("Enter type (sailboat = 1, motorsailer = 2, kayak/canoe = 3, other = 4): ");
      Integer boatType = console.getInteger();
      console.print("Enter length: ");
      Integer boatLength = console.getInteger();
      Boolean isRegistered = m.registerBoat(boatType, boatLength);
      if (isRegistered) {
        console.printLine("Boat registered!");
      } else {
        console.printLine("Boat has not been registered");
      }
      memberMenuInput(m);
    } else if (input == 2) {
      console.print(registry.getUpdateMemberText());
      Integer alt = console.getInteger();

      if (alt == 1) {
        // Change name
        System.out.print("Enter new name: ");
        m.setName(console.getString());
        memberMenuInput(m);
      } else if (alt == 2) {
        // change personal number
        System.out.print("Enter new personal number: ");
        m.setPersonalNumber(console.getInteger());
        memberMenuInput(m);
      } else if (alt == 3) {
        // change boat info
        if (m.getBoats().size() > 0) {
          System.out.print("Select boat (1-" + Integer.toString(m.getBoats().size() + 1) + "): ");
          m.setPersonalNumber(console.getInteger());
        } else {
          System.out.println("Member does not have registered boats!");
          memberMenuInput(m);
        }
        
      } else {
        // ERROR!
      }

    } else if (input == 3) {
      mainMenuInput();
    } else {
      // ERROR
    }
  }

  private boolean deleteMember() {
    console.print("Select member number: ");
    Integer memberId = console.getInteger();
    boolean isRemoved = registry.deleteMember(memberId);
    return isRemoved;
  }

}
