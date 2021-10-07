package controller;

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
    }else if (input == 3) {
      System.out.println("Closes application...");
      // persistence?
      System.exit(0);
    } else {
      // error
    }
  }

  private void listMenuInput() {
    console.print("Show Member info (1), change member info (2), create member (3), delete member (4), register boat (5), main Menu (6): ");
    Integer i = console.getInteger();
    handleListMenuInput(i);
  }

  private void handleListMenuInput(Integer input) {
    if (input == 1) {
      // show member info
    } else if (input == 2) {
      // change member info
    } else if (input == 3) {
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

    } else if (input == 4) {
      Boolean isRemoved = deleteMember();
      if (isRemoved) {
        console.printLine("Member removed!");
      } else {
        console.printLine("Member not found in registry.");
      }
      console.printCompactMemberList(registry.getMembers()); // byt till metod! code dup.
      listMenuInput();
    } else if (input == 5) {
      // register boat
    } else if (input == 6) {
      mainMenuInput();
    } else {
      // error
    }
  }

  private boolean deleteMember() {
    console.print("Select member number: ");
    Integer memberId = console.getInteger();
    boolean isRemoved = registry.deleteMember(memberId);
    return isRemoved;
  }

}
