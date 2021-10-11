package model.domain;

import java.util.ArrayList;

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
   * @return If the member has been created.
   */
  public Boolean createMember(String name, int personalNumber) {
    if (name.length() > 0) {
      Member m = new Member();
      m.setId(getNextId());
      m.setName(name);
      m.setPersonalNumber(personalNumber);
      members.add(m);
      return true; // true if success
    } else {
      return false;
    }
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
   * Returns next available member id.

   * @return Next available member id.
   */
  private int getNextId() {
    return members.get(members.size() - 1).getId() + 1;
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
}
