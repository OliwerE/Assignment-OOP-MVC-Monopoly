package model;

import java.util.ArrayList;

interface RegistryPersistence {
  public ArrayList<Member> loadMemberRegistry();
  public void saveMemberRegistry(ArrayList<Member> r);
}
