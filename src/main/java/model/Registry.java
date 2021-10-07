package model;

import java.util.ArrayList;

public class Registry {
  private ArrayList<Member> members = new ArrayList<>();
  private Integer nextMemberId = 1;

  public Registry() {
    // constructor
  }

  public String getCreateMemberText() {
    return "Create Member:\nEnter name: ";
  }

  public Boolean createMember(String name) {
    if (name.length() > 0) {
      Member m = new Member();
      m.setId(nextMemberId);
      nextMemberId += 1;
      m.setName(name);
      members.add(m);
      return true; // true if success
    } else {
      return false;
    }
  }
}
