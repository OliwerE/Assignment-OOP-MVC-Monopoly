package model;

import java.util.ArrayList;

public class Registry {
  private ArrayList<Member> members = new ArrayList<>();
  private Integer nextMemberId = 1;

  public Registry() {
    // constructor
  }

  public Boolean createMember(String name, Integer personalNumber) { // TODO: Add personal number!!!
    if (name.length() > 0) {
      Member m = new Member();
      m.setId(nextMemberId);
      nextMemberId += 1;
      m.setName(name);
      m.setPersonalNumber(personalNumber);
      members.add(m);
      return true; // true if success
    } else {
      return false;
    }
  }

  public ArrayList<Member> getMembers() {
    return new ArrayList<Member>(members); // Iterator istället??
  }

  public boolean deleteMember(Integer memberId) {
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
}
