package controller;

import model.Member;

/**
 * Responsible for model-view communication.
 */
public class RegistryController {
  private model.Registry registry = new model.Registry();
  private view.Console console = new view.Console();

  /**
   * Starts the application.
   */
  public void start() {
    console.displayTitle();
    mainMenu();
  }

  /**
   * Display and handles main menu input.
   */
  private void mainMenu() {
    console.displayMainMenu();
    int input = console.getIntInput();

    if (input == 1) {
      verboseMemberList();
    } else if (input == 2) {
      compactMemberList();
    } else if (input == 3) {
      closeApplication();
    } else {
      console.displayMenuInputError(input);
      mainMenu();
    }
  }

  /**
   * Displays verbose member list.
   */
  private void verboseMemberList() {
    console.displayVerboseMemberList(registry.getMembers());
    memberListMenu(true);
  }

  /**
   * Displays compact member list.
   */
  private void compactMemberList() {
    console.displayCompactMemberList(registry.getMembers());
    memberListMenu(false);
  }

  /**
   * Closes the application.
   */
  private void closeApplication() {
    console.displayCloseMessage();
    console.closeScanner();

    // FIX: Save to "file"

    System.exit(0);
  }

  /**
   * Handles the member list menu.

   * @param isVerbose If member list is verbose.
   */
  private void memberListMenu(Boolean isVerbose) {
    console.displayMemberListMenu();
    int input = console.getIntInput();

    if (input == 1) {
      showMember(isVerbose);
    } else if (input == 2) {
      createMember();
    } else if (input == 3) {
      deleteMember();
    } else if (input == 4) {
      mainMenu();
    } else {
      console.displayMenuInputError(input);
    }
    backToMemberList(isVerbose);
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
    Member member = registry.getMemberById(console.getIntInput());
    console.displayMember(member);
    memberMenu(member, isVerbose);
  }

  /**
   * Displays and handles the member menu.

   * @param member Current member.
   * @param isVerbose If the previous member list was verbose.
   */
  private void memberMenu(Member member, Boolean isVerbose) {
    console.displayMemberMenu();
    int input = console.getIntInput();

    if (input == 1) {
      registerBoat(member);
    } else if (input == 2) {
      changeBoatType(member);
    } else if (input == 3) {
      changeBoatLength(member);
    } else if (input == 4) {
      changeName(member);
    } else if (input == 5) {
      changePersonalNumber(member);
    } else if (input == 6) {
      backToMemberList(isVerbose);
    } else {
      console.displayMenuInputError(input);
    }
    console.displayMember(member); // remove input from showMember!
    memberMenu(member, isVerbose);
  }

  /**
   * Handles register boat to a member.

   * @param member Owner of the boat.
   */
  private void registerBoat(Member member) {
    Boolean isRegistered = member.registerBoat(console.getBoatType(), console.getBoatLength());
    console.displayBoatRegisteredStatus(isRegistered);
  }

  /**
   * Handles change boat type.

   * @param member Boat owner.
   */
  private void changeBoatType(Member member) {
    Boolean isChanged = member.changeBoatType(console.getBoatId(), console.getBoatType());
    console.displayBoatUpdateMessage(isChanged);
  }

  /**
   * Handles change boat length.

   * @param member Boat owner.
   */
  private void changeBoatLength(Member member) {
    Boolean isChanged = member.changeBoatLength(console.getBoatId(), console.getBoatLength());
    console.displayBoatUpdateMessage(isChanged);
  }

  /**
   * Handles change name.

   * @param member Member changing name.
   */
  private void changeName(Member member) {
    member.setName(console.getMemberName()); // add status msg
  }

  /**
   * Handles change personal number.

   * @param member Member changing personal number.
   */
  private void changePersonalNumber(Member member) {
    member.setPersonalNumber(console.getPersonalNumber()); // add status msg
  }

  /**
   * Handles registration of new member.
   */
  private void createMember() {
    Boolean isRegistered = registry.createMember(console.getMemberName(), console.getPersonalNumber());
    console.displayRegisterMemberStatus(isRegistered);
  }

  /**
   * Handles removal of a member.
   */
  private void deleteMember() {
    console.deleteMemberMessage();
    Boolean isRemoved = registry.deleteMember(console.getIntInput());
    console.displayDeleteMemberStatus(isRemoved);
  }
}
