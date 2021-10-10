package model;

import java.util.ArrayList;

/**
 * Responsible to simulate persistent storage.
 */
public class RegistryStorage implements RegistryPersistence {
  /**
   * Simulates persistent loading of members.

   * @return Loaded members.
   */
  public ArrayList<Member> loadMemberRegistry() {

    ArrayList<Member> registry = new ArrayList<Member>();

    // Add members
    int[] personalNumbers = {123456, 234567, 345678};
    for (int i = 0; i < 3; i++) {
      Member m = new Member();
      m.setName("Medlem" + Integer.toString(i + 1));
      m.setPersonalNumber(personalNumbers[i]);
      m.setId(i + 1);
      registry.add(m);
    }

    // Add boats to members
    registry.get(0).registerBoat(1, 200);
    registry.get(0).registerBoat(3, 100);
    registry.get(2).registerBoat(2, 150);


    return registry;
  }

  /**
   * Simulates persistent saving of members.

   * @param r Members to save.
   * @return If the members has been saved.
   */
  public Boolean saveMemberRegistry(ArrayList<Member> r) {
    return true; // = simulated Success
  }
}
