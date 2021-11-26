package model.domain;

import java.util.ArrayList;
import model.domain.Boat.BoatType;

/**
 * Responsible for boat registry.
 */
public class Registry {
  private ArrayList<Member> members = new ArrayList<>();

  /**
   * Adds persistent member to the members registry.

   * @param name Name of the member.
   * @param personalNumber Personal number.
   * @param id Member id.
   * @return The loaded member.
   */
  public Member loadPersistentMember(String name, int personalNumber, int id) {
    Member m = new Member();
    m.setName(name);
    m.setPersonalNumber(personalNumber);
    m.setId(id);
    members.add(m);
    return m;
  }

  /**
   * Create new member.

   * @param name  Name of the new member.
   * @param personalNumber Personal number.
   */
  public Member createMember(String name, int personalNumber) {
    Member m = new Member();
    m.setId(getNextId());
    m.setName(name);
    m.setPersonalNumber(personalNumber);
    return m;
  }

  /**
   * Add member to registry.

   * @param m The member to be added.
   */
  public void addMember(Member m) {
    members.add(m);
  }

  /**
   * Returns next available member id.

   * @return Next available member id.
   */
  private int getNextId() {
    return members.get(members.size() - 1).getId() + 1;
  }

  /**
   * Changes member name in the registry.

   * @param m Member.
   * @param newName New name.
   */
  public void changeMemberName(Member m, String newName) {
    m.setName(newName);
  }

  /**
   * Changes personal number in the registry.

   * @param m Member.
   * @param newPersonalNumber New personal number.
   */
  public void changePersonalNumber(Member m, int newPersonalNumber) {
    m.setPersonalNumber(newPersonalNumber);
  }

  /**
   * Returns all members stored in the registry.

   * @return All members.
   */
  public ArrayList<Member> getMembers() {
    return new ArrayList<Member>(members); // Iterator istället??
  }

  /**
   * Removes a member.

   * @param memberToRemove Member to remove.
   * @return If the member has been removed
   */
  public boolean deleteMember(Member memberToRemove) {
    if (members.contains(memberToRemove)) {
      members.remove(memberToRemove);
      return true;
    } else {
      return false;
    }
  }

  /**
   * Returns a member based on an unique id.

   * @param memberId Id of the requested member.
   * @return The requested member.
   */
  public Member getMemberById(int memberId) {
    for (Member m : members) {
      if (m.getId() == memberId) {
        return m;
      }
    }
    return null;
  }

  /**
   * Creates a new boat.

   * @param boatType Type of boat.
   * @param length Length of boat.
   * @return The new boat.
   */
  public Boat createBoat(BoatType boatType, int length) {
    Boat newBoat = new Boat();
    newBoat.setBoatType(boatType);
    newBoat.setBoatLength(length);
    return newBoat;
  }

  /**
   * Adds new boat to a member.

   * @param m Add new boat to.
   * @param b New boat.
   */
  public void addBoat(Member m, Boat b) {
    m.addBoat(b);
  }

  /**
   * Changes boat type.

   * @param m Boat owner.
   * @param boat Boat to be changed.
   * @param newType New boat type.
   */
  public void changeBoatType(Member m, Boat boat, BoatType newType) {
    m.changeBoatType(boat, newType);
  }

  /**
   * Changes boat length.

   * @param m Boat owner.
   * @param boat Boat to be changed. 
   * @param newLength New boat length.
   */
  public void changeBoatLength(Member m, Boat boat, int newLength) {
    m.changeBoatLength(boat, newLength);
  }

  /**
   * Removes a boat from a member.

   * @param m Boat owner.
   * @param b Boat to be removed.
   */
  public void removeBoat(Member m, Boat b) {
    m.removeBoat(b);
  }
}
