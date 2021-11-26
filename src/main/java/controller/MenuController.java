package controller;

import java.util.ArrayList;
import model.domain.Member;
import view.UserInput;
import view.UserInterface.MainMenuInput;
import view.UserInterface.MemberListMenuInput;
import view.UserInterface.MemberMenuInput;

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
    MainMenuInput input = ui.mainMenu();

    if (input == MainMenuInput.Verbose) {
      verboseMemberList();
    } else if (input == MainMenuInput.Compact) {
      compactMemberList();
    } else if (input == MainMenuInput.Exit) {
      closeApplication();
    } else {
      ui.displayMenuInputError();
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
    MemberListMenuInput input = ui.memberListMenu();

    if (input == MemberListMenuInput.ShowMember) {
      showMember(isVerbose);
    } else if (input == MemberListMenuInput.CreateMember) {
      registryController.createMember();
      backToMemberList(isVerbose);
    } else if (input == MemberListMenuInput.DeleteMember) {
      registryController.deleteMember();
      backToMemberList(isVerbose);
    } else if (input == MemberListMenuInput.MainMenu) {
      mainMenu();
    } else {
      ui.displayMenuInputError();
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
    ArrayList<Member> members = registryController.getRegistry().getMembers();
    
    Boolean exist = false;
    for (Member m : members) {
      if (m.getId() == memberId) {
        exist = true;
      }
    }

    if (!exist) {
      ui.memberDoesNotExistMessage();
      memberListMenu(isVerbose);
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
    MemberMenuInput input = ui.memberMenu();

    if (input == MemberMenuInput.RegisterBoat) {
      registryController.registerBoat(member);
      ui.displayMember(member);
      memberMenu(member, isVerbose);
    } else if (input == MemberMenuInput.ChangeBoatType) {
      registryController.changeBoatType(member);
      ui.displayMember(member);
      memberMenu(member, isVerbose);
    } else if (input == MemberMenuInput.ChangeBoatLength) {
      registryController.changeBoatLength(member);
      ui.displayMember(member);
      memberMenu(member, isVerbose);
    } else if (input == MemberMenuInput.RemoveBoat) {
      registryController.removeBoat(member);
      ui.displayMember(member);
      memberMenu(member, isVerbose);
    } else if (input == MemberMenuInput.ChangeName) {
      registryController.changeName(member);
      ui.displayMember(member);
      memberMenu(member, isVerbose);
    } else if (input == MemberMenuInput.ChangePersonalNumber) {
      registryController.changePersonalNumber(member);
      ui.displayMember(member);
      memberMenu(member, isVerbose);
    } else if (input == MemberMenuInput.MemberListMenu) {
      backToMemberList(isVerbose);
    } else {
      ui.displayMenuInputError();
      ui.displayMember(member);
      memberMenu(member, isVerbose);
    }
  }
}
