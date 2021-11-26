package model.persistence;

import java.util.ArrayList;
import model.domain.Boat.BoatType;
import model.domain.Member;
import model.domain.Registry;

/**
 * Responsible to simulate persistent storage.
 */
public class RegistryStorage implements RegistryPersistence {
  /**
   * Simulates persistent loading of members.

   * @return Loaded members.
   */
  public Boolean loadMemberRegistry(Registry registry) {
    // Add members
    int[] personalNumbers = {123456, 234567, 345678};
    for (int i = 0; i < 3; i++) {
      String name = "Medlem" + Integer.toString(i + 1);
      int personalNumber = personalNumbers[i];
      int id = i + 1;
      Member m = registry.loadPersistentMember(name, personalNumber, id);

      // Add boats
      if (i == 0) {
        m.registerBoat(BoatType.Sailboat, 200);
        m.registerBoat(BoatType.KayakCanoe, 100);
      } else if (i == 2) {
        m.registerBoat(BoatType.Motorsailer, 150);
      }
    }
    return true; // = Hard coded success.
  }

  /**
   * Simulates persistent saving of members.

   * @param r Members to save.
   * @return If the members has been saved.
   */
  public Boolean saveMemberRegistry(ArrayList<Member> r) {
    return true; // = Hard coded Success.
  }
}
