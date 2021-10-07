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

      // TODO: Add list nav!
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
}
