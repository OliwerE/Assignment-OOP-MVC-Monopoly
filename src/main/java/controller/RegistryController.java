package controller;

import java.util.ArrayList;
import model.domain.Boat;
import model.domain.Member;
import model.persistence.RegistryStorage;

/**
 * Responsible for model-view communication.
 */
public class RegistryController {
  private model.domain.Registry registry = new model.domain.Registry();
  private view.UserInterface ui = new view.UserInterface();
  private model.persistence.RegistryStorage registryStorage = new RegistryStorage();

  /**
   * Starts the application.
   */
  public void start() {
    ui.displayTitle();
    loadPersistentData();
    mainMenu();
  }

  private void loadPersistentData() {
    ui.displayLoadMembersMessage();
    Boolean isSuccess = registryStorage.loadMemberRegistry(registry);
    ui.displayLoadMembersStatus(isSuccess);
  }

  /**
   * Display and handles main menu input.
   */
  private void mainMenu() {
    ui.displayMainMenu();
    int input = ui.getScanner().getIntInput();

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
    ui.displayVerboseMemberList(registry.getMembers());
    memberListMenu(true);
  }

  /**
   * Displays compact member list.
   */
  private void compactMemberList() {
    ui.displayCompactMemberList(registry.getMembers());
    memberListMenu(false);
  }

  /**
   * Closes the application.
   */
  private void closeApplication() {
    ui.displayCloseMessage();
    saveToPersistentStorage();
    ui.getScanner().closeScanner();
  }

  private void saveToPersistentStorage() {
    ui.displaySaveMembersMessage();
    Boolean isSuccess = registryStorage.saveMemberRegistry(registry.getMembers());
    ui.displaySaveMembersStatus(isSuccess);
  }

  /**
   * Handles the member list menu.

   * @param isVerbose If member list is verbose.
   */
  private void memberListMenu(Boolean isVerbose) {
    ui.displayMemberListMenu();
    int input = ui.getScanner().getIntInput();

    if (input == 1) {
      showMember(isVerbose);
      backToMemberList(isVerbose);
    } else if (input == 2) {
      createMember();
      backToMemberList(isVerbose);
    } else if (input == 3) {
      deleteMember();
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
    int memberId = ui.getScanner().getIntInput();

    if (memberId > registry.getMembers().size()) {
      ui.memberDoesNotExistMessage();
    } else {
      Member member = registry.getMemberById(memberId);
      ui.displayMember(member);
      memberMenu(member, isVerbose);
    }
  }

  /**
   * Displays and handles the member menu.

   * @param member Current member.
   * @param isVerbose If the previous member list was verbose.
   */
  private void memberMenu(Member member, Boolean isVerbose) {
    ui.displayMemberMenu();
    int input = ui.getScanner().getIntInput();

    if (input == 1) {
      registerBoat(member);
      ui.displayMember(member);
      memberMenu(member, isVerbose);
    } else if (input == 2) {
      changeBoatType(member);
      ui.displayMember(member);
      memberMenu(member, isVerbose);
    } else if (input == 3) {
      changeBoatLength(member);
      ui.displayMember(member);
      memberMenu(member, isVerbose);
    } else if (input == 4) {
      changeName(member);
      ui.displayMember(member);
      memberMenu(member, isVerbose);
    } else if (input == 5) {
      changePersonalNumber(member);
      ui.displayMember(member);
      memberMenu(member, isVerbose);
    } else if (input == 6) {
      backToMemberList(isVerbose);
      ui.displayMember(member);
      memberMenu(member, isVerbose);
    } else {
      ui.displayMenuInputError(input);
      ui.displayMember(member);
      memberMenu(member, isVerbose);
    }
  }

  /**
   * Handles register boat to a member.

   * @param member Owner of the boat.
   */
  private void registerBoat(Member member) {
    Boolean isRegistered = member.registerBoat(ui.getBoatType(), ui.getBoatLength());
    ui.displayBoatRegisteredStatus(isRegistered);
  }

  /**
   * Handles change boat type.

   * @param member Boat owner.
   */
  private void changeBoatType(Member member) {
    int boatId = ui.getBoatId();
    if (boatId > member.getBoats().size()) {
      ui.boatDoesNotExistMessage();
    } else {
      Boat boat = member.getBoats().get(boatId - 1);
      Boolean isChanged = member.changeBoatType(boat, ui.getBoatType());
      ui.displayBoatUpdateMessage(isChanged);
    }
  }

  /**
   * Handles change boat length.

   * @param member Boat owner.
   */
  private void changeBoatLength(Member member) {
    int boatId = ui.getBoatId();
    if (boatId > member.getBoats().size()) {
      ui.boatDoesNotExistMessage();
    } else {
      Boat boat = member.getBoats().get(boatId - 1);
      Boolean isChanged = member.changeBoatLength(boat, ui.getBoatLength());
      ui.displayBoatUpdateMessage(isChanged);
    }

  }

  /**
   * Handles change name.

   * @param member Member changing name.
   */
  private void changeName(Member member) {
    member.setName(ui.getMemberName()); // add status msg
  }

  /**
   * Handles change personal number.

   * @param member Member changing personal number.
   */
  private void changePersonalNumber(Member member) {
    member.setPersonalNumber(ui.getPersonalNumber()); // add status msg
  }

  /**
   * Handles registration of new member.
   */
  private void createMember() {
    Boolean isRegistered = registry.createMember(ui.getMemberName(), ui.getPersonalNumber());
    ui.displayRegisterMemberStatus(isRegistered);
  }

  /**
   * Handles removal of a member.
   */
  private void deleteMember() {
    ui.deleteMemberMessage();
    int memberId = ui.getScanner().getIntInput();
    
    ArrayList<Member> members = registry.getMembers();
    Member memberToRemove;
    Boolean isFound = false;
    for (Member m : members) {
      if (memberId == m.getId()) {
        memberToRemove = m;
        Boolean isRemoved = registry.deleteMember(memberToRemove);
        ui.displayDeleteMemberStatus(isRemoved);
        isFound = true;
        break;
      }
    }

    if (!isFound) {
      ui.memberDoesNotExistMessage();
    }
  }
}
