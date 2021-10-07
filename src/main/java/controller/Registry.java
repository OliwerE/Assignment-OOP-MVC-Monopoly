package controller;

public class Registry {
  private model.Registry registry = new model.Registry();
  private view.Console console = new view.Console();

  public void start() {
      console.printLine("---------- Member Registry ----------");
      mainMenuInput();
  }

  private void mainMenuInput() {
    console.print("Verbose member list (1), compact member list (2), create member (3) exit (4): ");
    Integer i = console.getInteger();
    handleMainMenuInput(i); 
  }

  private void handleMainMenuInput(Integer input) {
    if (input == 1) {
      // verbose member list
    } else if (input == 2) {
      console.printCompactMemberList(registry.getMembers());
      listMenuInput();
    } else if (input == 3) {
      console.print(registry.getCreateMemberText());

      Boolean isSuccess = registry.createMember(console.getString());

      if(isSuccess) {
        console.printLine("Member created!");
        mainMenuInput();
      } else {
        console.printLine("Name is too short!"); // kan inte inträffa pga scanner.next !!
        mainMenuInput();
      }

    } else if (input == 4) {
      System.out.println("Closes application...");
      // persistence?
      System.exit(0);
    } else {
      // error
    }
  }

  private void listMenuInput() {
    console.print("Show Member info (1), change member info (2), register boat (3), delete member (4), main Menu (5): ");
    Integer i = console.getInteger();
    handleListMenuInput(i);
  }

  private void handleListMenuInput(Integer input) {
    if (input == 1) {
      // show member info
    } else if (input == 2) {
      // change member info
    } else if (input == 3) {
      // register boat
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
