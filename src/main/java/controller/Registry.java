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
    console.print("Register boat (1), Change info (2), back (3): ");
    Integer i = console.getInteger();
    handleMemberMenuInput(i, m);
  }

  private void handleMemberMenuInput(Integer input, Member m) {
    if (input == 1) {
      // register boat
    } else if (input == 2) {
      // change info
    } else if (input == 3) {
      // BACK
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
