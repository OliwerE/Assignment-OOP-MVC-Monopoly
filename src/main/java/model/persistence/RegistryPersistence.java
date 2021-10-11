package model.persistence;

import java.util.ArrayList;
import model.domain.Member;
import model.domain.Registry;

/**
 * Responible for persistent saving and loading of the registry.
 */
interface RegistryPersistence {
  /**
   * Loads members from persistent storage.

   * @return Members stored in the registry.
   */
  public Boolean loadMemberRegistry(Registry registry);

  /**
   * Saves members to persistent storage.

   * @param registry Members to save.
   * @return If the members has been saved.
   */
  public Boolean saveMemberRegistry(ArrayList<Member> registry);
}
