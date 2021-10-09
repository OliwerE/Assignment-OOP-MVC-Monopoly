package model;

import java.util.ArrayList;

interface RegistryPersistence {
  public ArrayList<Member> loadMemberRegistry();
  public Boolean saveMemberRegistry(ArrayList<Member> r);
}
