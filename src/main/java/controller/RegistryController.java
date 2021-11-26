package controller;

import java.util.ArrayList;
import model.domain.Boat;
import model.domain.Member;
import model.persistence.RegistryStorage;
import view.UserInterface;

/**
 * Responsible for model-view communication.
 */
public class RegistryController {
  private model.domain.Registry registry = new model.domain.Registry();
  private view.UserInterface ui;
  private model.persistence.RegistryStorage registryStorage = new RegistryStorage();

  /**
   * Add userInterface to Registry controller.

   * @param u User interface.
   */
  public RegistryController(UserInterface u) {
    ui = u;
  }

  /**
   * Returns the registry object.

   * @return Registry object.
   */
  protected model.domain.Registry getRegistry() {
    return registry;
  }

  /**
   * Loads persistent registry data.
   */
  protected void loadPersistentData() {
    ui.displayLoadMembersMessage();
    Boolean isSuccess = registryStorage.loadMemberRegistry(registry);
    ui.displayLoadMembersStatus(isSuccess);
  }

  /**
   * Saves registered members.
   */
  protected void saveToPersistentStorage() {
    ui.displaySaveMembersMessage();
    Boolean isSuccess = registryStorage.saveMemberRegistry(registry.getMembers());
    ui.displaySaveMembersStatus(isSuccess);
  }

  /**
   * Handles register boat to a member.

   * @param member Owner of the boat.
   */
  protected void registerBoat(Member member) {
    Boat b = registry.createBoat(ui.getBoatType(), ui.getBoatLength());
    registry.addBoat(member, b);
    ui.displayBoatRegisteredStatus();
  }

  /**
   * Handles change boat type.

   * @param member Boat owner.
   */
  protected void changeBoatType(Member member) {
    int boatId = ui.getBoatNumber();
    if (boatId > member.getBoats().size()) {
      ui.boatDoesNotExistMessage();
    } else {
      Boat boat = member.getBoats().get(boatId - 1);
      registry.changeBoatType(member, boat, ui.getBoatType());
      ui.displayBoatUpdateMessage();
    }
  }

  /**
   * Handles change boat length.

   * @param member Boat owner.
   */
  protected void changeBoatLength(Member member) {
    int boatId = ui.getBoatNumber();
    if (boatId > member.getBoats().size()) {
      ui.boatDoesNotExistMessage();
    } else {
      Boat boat = member.getBoats().get(boatId - 1);
      registry.changeBoatLength(member, boat, ui.getBoatLength());
      ui.displayBoatUpdateMessage();
    }
  }

  /**
   * Removes boat from member.

   * @param m Boat owner.
   */
  protected void removeBoat(Member m) {
    int boatNumber = ui.getBoatNumber();
    if (boatNumber <= m.getBoats().size()) {
      Boat b = m.getBoats().get(boatNumber - 1);
      registry.removeBoat(m, b);
      ui.displayBoatRemovedMessage();
    } else {
      ui.displayBoatRemovedMessage();
    }
  }

  /**
   * Handles change name.

   * @param member Member changing name.
   */
  protected void changeName(Member member) {
    registry.changeMemberName(member, ui.getMemberName());
  }

  /**
   * Handles change personal number.

   * @param member Member changing personal number.
   */
  protected void changePersonalNumber(Member member) {
    registry.changePersonalNumber(member, ui.getPersonalNumber());
  }

  /**
   * Handles registration of new member.
   */
  protected void createMember() {
    String name = ui.getMemberName();
    int personalNumber = ui.getPersonalNumber();

    if (name.length() > 0 && personalNumber != -1) {
      Member m = registry.createMember(name, personalNumber);
      registry.addMember(m);
      ui.displayRegisterMemberStatus(true);
    } else {
      ui.displayRegisterMemberStatus(false);
    }
  }

  /**
   * Handles removal of a member.
   */
  protected void deleteMember() {
    int memberId = ui.getMemberId();
    
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
