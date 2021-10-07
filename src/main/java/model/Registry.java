package model;

import java.util.ArrayList;

public class Registry {
  private ArrayList<String> members = new ArrayList<>();

  public Registry() {
    // constructor
  }

  public String getCreateMemberText() {
    return "Create Member:\nEnter name: ";
  }

  public Boolean createMember(String name) {
    
    return true; // change
  }
}
