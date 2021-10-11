package controller;

import java.util.ArrayList;
import model.domain.Member;
import view.UserInput;

/**
 * Responsible for the menus in the user interface.
 */
public class MenuController {
  private view.UserInterface ui = new view.UserInterface();
  private RegistryController registryController = new RegistryController(ui);

  /**
   * Starts the application.
   */
  public void start() {
    ui.displayTitle();
    registryController.loadPersistentData();
    mainMenu();
  }

  /**
   * Display and handles main menu input.
   */
  private void mainMenu() {
    String mainMenuText = "Verbose member list (1), compact member list (2), exit (3): ";
    ui.printLine(mainMenuText);
    UserInput scanner = ui.getScanner();
    int input = scanner.getIntInput();

    if (input == 1) {
      verboseMemberList();
    } else if (input == 2) {
      compactMemberList();
    } else if (input == 3) {
      closeApplication();
    } else {
      ui.displayMenuInputError(input);
      mainMenu();
    }
  }

  /**
   * Displays verbose member list.
   */
  private void verboseMemberList() {
    ArrayList<Member> members = registryController.getRegistry().getMembers();
    ui.displayVerboseMemberList(members);
    memberListMenu(true);
  }

  /**
   * Displays compact member list.
   */
  private void compactMemberList() {
    ArrayList<Member> members = registryController.getRegistry().getMembers();
    ui.displayCompactMemberList(members);
    memberListMenu(false);
  }

  /**
   * Closes the application.
   */
  private void closeApplication() {
    ui.displayCloseMessage();
    registryController.saveToPersistentStorage();
    ui.getScanner().closeScanner();
  }

  /**
   * Handles the member list menu.

   * @param isVerbose If member list is verbose.
   */
  private void memberListMenu(Boolean isVerbose) {
    String memberListMenuText = "Show member (1), create member (2), delete member (3), main Menu (4): ";
    ui.printLine(memberListMenuText);
    UserInput scanner = ui.getScanner();
    int input = scanner.getIntInput();

    if (input == 1) {
      showMember(isVerbose);
    } else if (input == 2) {
      registryController.createMember();
      backToMemberList(isVerbose);
    } else if (input == 3) {
      registryController.deleteMember();
      backToMemberList(isVerbose);
    } else if (input == 4) {
      mainMenu();
    } else {
      ui.displayMenuInputError(input);
      backToMemberList(isVerbose);
    }
  }

  /**
   * Goes back to the member list.

   * @param isVerbose If the last member list was verbose.
   */
  private void backToMemberList(Boolean isVerbose) {
    if (isVerbose) {
      verboseMemberList();
    } else {
      compactMemberList();
    }
  }

  /**
   * Displays a members information.

   * @param isVerbose If the previous member list was verbose.
   */
  private void showMember(Boolean isVerbose) { // remove input from showMember!
    int memberId = ui.getMemberId();

    if (memberId > registryController.getRegistry().getMembers().size()) {
      ui.memberDoesNotExistMessage();
    } else {
      Member member = registryController.getRegistry().getMemberById(memberId);
      ui.displayMember(member);
      memberMenu(member, isVerbose);
    }
  }

  /**
   * Displays and handles the member menu.

   * @param member    Current member.
   * @param isVerbose If the previous member list was verbose.
   */
  private void memberMenu(Member member, Boolean isVerbose) {
    // Gradle doesn't like long strings..
    String memberMenuText1 = "Register boat (1), change boat type (2), change boat lenght (3)";
    String memberMenuText2 = ", remove boat(4), Change name (5), change personal number (6), back (7): ";
    ui.printLine(memberMenuText1 + memberMenuText2);
    int input = ui.getScanner().getIntInput();

    if (input == 1) {
      registryController.registerBoat(member);
      ui.displayMember(member);
      memberMenu(member, isVerbose);
    } else if (input == 2) {
      registryController.changeBoatType(member);
      ui.displayMember(member);
      memberMenu(member, isVerbose);
    } else if (input == 3) {
      registryController.changeBoatLength(member);
      ui.displayMember(member);
      memberMenu(member, isVerbose);
    } else if (input == 4) {
      registryController.removeBoat(member);
      ui.displayMember(member);
      memberMenu(member, isVerbose);
    } else if (input == 5) {
      registryController.changeName(member);
      ui.displayMember(member);
      memberMenu(member, isVerbose);
    } else if (input == 6) {
      registryController.changePersonalNumber(member);
      ui.displayMember(member);
      memberMenu(member, isVerbose);
    } else if (input == 7) {
      backToMemberList(isVerbose);
    } else {
      ui.displayMenuInputError(input);
      ui.displayMember(member);
      memberMenu(member, isVerbose);
    }
  }
}
