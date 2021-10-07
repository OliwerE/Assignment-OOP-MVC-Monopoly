package controller;

public class Registry {
  private model.Registry registry = new model.Registry();
  private view.Console console = new view.Console();

  public void start() {
      console.printLine("---------- Member Registry ----------");
      console.print("Verbose member list (1), compact member list (2), create member (3) exit (4): ");
      Integer i = console.getInteger();
      System.out.println("valde: " + i);
      handleMainMenuInput(i);
  }

  private void handleMainMenuInput(Integer input) {
    if (input == 1) {
      // verbose member list
    } else if (input == 2) {
      // Compact member list
    } else if (input == 3) {
      console.print(registry.getCreateMemberText());
      // String name = console.getString();
      // console.printLine(name);
      registry.createMember(console.getString());
    } else if (input == 4) {
      System.out.println("Closes application...");
      // persistence?
      System.exit(0);
    } else {
      // error
    }
  }
}
