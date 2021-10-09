package model;

import java.util.ArrayList;

public class RegistryStorage implements RegistryPersistence {
  public ArrayList<Member> loadMemberRegistry() {

    return new ArrayList<Member>(); // add hardcoded loading
  }

  public void saveMemberRegistry(ArrayList<Member> r) {

  }
}
