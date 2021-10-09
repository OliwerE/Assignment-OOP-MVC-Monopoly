package controller;

import model.Member;
import java.util.ArrayList;

public class Registry {
  private model.Registry m_registry = new model.Registry();
  private view.Console v_console = new view.Console();

  private void devMembers() { // testing.. remove!
    m_registry.createMember("medlem1", 123456);
    m_registry.createMember("Medlem2", 234567);
    m_registry.createMember("medlem3", 345678);

    ArrayList<Member> r = m_registry.getMembers();

    r.get(0).registerBoat(1, 200);
    r.get(0).registerBoat(3, 100);

    r.get(2).registerBoat(2, 150);

  }

  public void start() {
      devMembers(); // REMOVE!
      v_console.displayTitle();
      mainMenu();
  }

  private void mainMenu() {
    v_console.displayMainMenu();
    int input = v_console.getIntInput();

    if (input == 1) {
      verboseMemberList();
    } else if (input == 2) {
      compactMemberList();
    } else if (input == 3) {
      closeApplication();
    } else {
      v_console.displayMenuInputError(input);
      mainMenu();
    }
  }

  private void verboseMemberList() {
    v_console.displayVerboseMemberList(m_registry.getMembers());
    memberListMenu(true);
  }

  private void compactMemberList() {
    v_console.displayCompactMemberList(m_registry.getMembers());
    memberListMenu(false);
  }

  private void closeApplication() {
    v_console.displayCloseMessage();
    v_console.closeScanner();

    // FIX: Save to "file"

    System.exit(0);
  }

  private void memberListMenu(Boolean isVerbose) {
    v_console.displayMemberListMenu();
    int input = v_console.getIntInput();

    if (input == 1) {
      showMember(isVerbose);
    } else if (input == 2) {
      createMember();
    } else if (input == 3) {
      deleteMember();
    } else if (input == 4) {
      mainMenu();
    } else {
      v_console.displayMenuInputError(input);
    }

    backToMemberList(isVerbose);
  }

  private void backToMemberList(Boolean isVerbose) {
    if (isVerbose) {
      verboseMemberList();
    } else {
      compactMemberList();
    }
  }

  private void showMember(Boolean isVerbose) { // remove input from showMember!
    Member member = m_registry.getMemberById(v_console.getIntInput());
    v_console.displayMember(member);
    memberMenu(member, isVerbose);
  }

  private void memberMenu(Member member, Boolean isVerbose) {
    v_console.displayMemberMenu();
    int input = v_console.getIntInput();

    if (input == 1) {
      registerBoat(member);
    } else if (input == 2) {
      // change boat type
      changeBoatType(member);
    } else if (input == 3) {
      // change boat length
      changeBoatLength(member);
    } else if (input == 4) {
      changeName(member);
    } else if (input == 5) {
      changePersonalNumber(member);
    } else if (input == 6) {
      // back
      backToMemberList(isVerbose);
    } else {
      v_console.displayMenuInputError(input);
    }
    
    v_console.displayMember(member); // remove input from showMember!
    memberMenu(member, isVerbose);
  }

  private void registerBoat(Member member) {
    Boolean isRegistered = member.registerBoat(v_console.getBoatType(), v_console.getBoatLength());
    if (isRegistered) {
      v_console.displayBoatRegisteredSuccess();
    } else {
      v_console.displayBoatRegisteredError();
    }
  }

  private void changeBoatType(Member member) {
    Boolean isChanged = member.changeBoatType(v_console.getBoatId(), v_console.getBoatType());
    boatChangeMessage(isChanged);
  }

  private void boatChangeMessage(Boolean isChanged) {
    if (isChanged) {
      v_console.displayBoatUpdateSuccess();
    } else {
      v_console.displayBoatUpdateError();
    }
  }

  private void changeBoatLength(Member member) {
    Boolean isChanged = member.changeBoatLength(v_console.getBoatId(), v_console.getBoatLength());
    boatChangeMessage(isChanged);
  }

  private void changeName(Member member) {
    member.setName(v_console.getMemberName());
  }

  private void changePersonalNumber(Member member) {
    member.setPersonalNumber(v_console.getPersonalNumber());
  }

  private void createMember() {
    Boolean isRegistered = m_registry.createMember(v_console.getMemberName(), v_console.getPersonalNumber());
    if (isRegistered) {
      v_console.displayRegisterMemberSuccess();
    } else {
      v_console.displayRegisterMemberError();
    }
  }

  private void deleteMember() {
    v_console.deleteMemberMessage();
    Boolean isRemoved = m_registry.deleteMember(v_console.getIntInput());
    if (isRemoved) {
      v_console.deleteMemberSuccess();
    } else {
      v_console.deleteMemberError();
    }
  }
}
