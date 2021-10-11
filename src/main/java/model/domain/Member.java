package model.domain;

import java.util.ArrayList;

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
  public void setName(String name) {
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
  public void setPersonalNumber(int personalNumber) {
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
   * Returns boat type menu string.

   * @return Boat type menu string
   */
  public String getBoatTypesMenu() {
    return "Enter boat type (1 = Sailboat, 2 = Motorsailer, 3 = Kayak/Canoe, 4 = Other): ";
  }

  /**
   * Register a new boat.

   * @param type Type of boat.
   * @param length Length of boat.
   * @return If boat has been registered.
   */
  public Boolean registerBoat(int type, int length) {
    Boat newBoat = new Boat();
    if (type == 1) {
      newBoat.setBoatType("Sailboat");
    } else if (type == 2) {
      newBoat.setBoatType("Motorsailer");
    } else if (type == 3) {
      newBoat.setBoatType("Kayak/Canoe");
    } else if (type == 4) {
      newBoat.setBoatType("Other");
    } else {
      return false;
    }
    newBoat.setBoatLength(length);
    newBoat.setBoatId(getNextBoatId());
    boats.add(newBoat);
    return true;
  }

  /**
   * Next available boat id.

   * @return An unique boat id.
   */
  private int getNextBoatId() {
    if (boats.size() > 0) {
      return boats.get(boats.size() - 1).getBoatId() + 1;
    } else {
      return 1;
    }
  }

  /**
   * Updates boat type.

   * @param boat Boat to modify.
   * @param newType New boat type.
   * @return If the boat has been updated.
   */
  public Boolean changeBoatType(Boat boat, Integer newType) { // flytta till Boat?
    if (newType == 1) {
      boat.setBoatType("Sailboat");
    } else if (newType == 2) {
      boat.setBoatType("Motorsailer");
    } else if (newType == 3) {
      boat.setBoatType("Kayak/Canoe");
    } else if (newType == 4) {
      boat.setBoatType("Other");
    } else {
      return false;
    }
    return true;
  }

  /**
   * Updates boat length.

   * @param boat  Boat to modify.
   * @param newLength New boat length.
   * @return If the boat has been updated.
   */
  public Boolean changeBoatLength(Boat boat, Integer newLength) { // flytta till Boat?
    if (newLength > 0) {
      boat.setBoatLength(newLength);
      return true;
    } else {
      return false;
    }
  }

  /**
   * Removes a boat.

   * @param b  Boat to remove.
   * @return If the boat has been removed.
   */
  protected Boolean removeBoat(Boat b) {
    boats.remove(b);
    if (boats.contains(b)) {
      return false;
    } else {
      return true;
    }
  }
}
