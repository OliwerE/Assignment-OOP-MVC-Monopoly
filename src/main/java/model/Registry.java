package model;

import java.util.ArrayList;

/**
 * Responsible for boat registry.
 */
public class Registry {
  private RegistryStorage storage = new RegistryStorage();
  private ArrayList<Member> members;

  /**
   * Constructs boat registry .
   */
  public Registry() {
    members = storage.loadMemberRegistry();
  }

  /**
   * Create new member.

   * @param name  Name of the new member.
   * @param personalNumber Personal number.
   * @return If the member has been created.
   */
  public Boolean createMember(String name, int personalNumber) { // TODO: Add personal number!!!
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

   * @param memberId Unique id of the member to remove.
   * @return If the member has been removed
   */
  public boolean deleteMember(int memberId) {
    Boolean removed = false;
    for (Member m : members) {
      if (memberId == m.getId()) {
        members.remove(m);
        removed = true;
        break;
      }
    }

    if (removed) {
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
    return members.get(memberId - 1);
  }
}
