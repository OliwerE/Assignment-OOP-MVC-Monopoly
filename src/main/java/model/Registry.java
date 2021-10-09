package model;

import java.util.ArrayList;

public class Registry {
  private RegistryStorage storage = new RegistryStorage();
  private ArrayList<Member> members;

  public Registry() {
    members = storage.loadMemberRegistry();
  }

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

  private int getNextId() {
    return members.get(members.size() - 1).getId() + 1;
  }

  public ArrayList<Member> getMembers() {
    return new ArrayList<Member>(members); // Iterator istället??
  }

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

  public Member getMemberById(int memberId) {
    return members.get(memberId - 1);
  }
}
