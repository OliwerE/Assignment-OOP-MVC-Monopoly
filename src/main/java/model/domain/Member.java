package model.domain;

import java.util.ArrayList;
import model.domain.Boat.BoatType;

/**
 * Represent a member in the registry.
 */
public class Member {
  private Integer id;
  private String name;
  private int personalNumber;
  private ArrayList<Boat> boats = new ArrayList<>();

  /**
   * Returns the member id.

   * @return Member id.
   */
  public Integer getId() {
    return id;
  }

  /**
   * Changes the member id.

   * @param id New member id.
   */
  protected void setId(Integer id) {
    this.id = id;
  }

  /**
   * Returns the member name.

   * @return Member name.
   */
  public String getName() {
    return name;
  }

  /**
   * Changes the member name.

   * @param name New member name.
   */
  protected void setName(String name) {
    this.name = name;
  }

  /**
   * Returns the personal number.

   * @return Personal number.
   */
  public int getPersonalNumber() {
    return personalNumber;
  }

  /**
   * Changes the personal number.

   * @param personalNumber New personal number.
   */
  protected void setPersonalNumber(int personalNumber) {
    this.personalNumber = personalNumber;
  }

  /**
   * Get registered boats.

   * @return Boats registered to the member.
   */
  public ArrayList<Boat> getBoats() {
    return new ArrayList<Boat>(boats);
  }

  /**
   * Add boat to member.

   * @param b Boat to be added.
   */
  protected void addBoat(Boat b) {
    boats.add(b);
  }

  /**
   * Updates boat type.

   * @param boat Boat to modify.
   * @param newType New boat type.
   */
  protected void changeBoatType(Boat boat, BoatType newType) {
    boat.setBoatType(newType);
  }

  /**
   * Updates boat length.

   * @param boat  Boat to modify.
   * @param newLength New boat length.
   */
  protected void changeBoatLength(Boat boat, Integer newLength) {
    boat.setBoatLength(newLength);
  }

  /**
   * Removes a boat.

   * @param b  Boat to remove.
   */
  protected void removeBoat(Boat b) {
    boats.remove(b);
  }
}
