package model;

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

  /* används ej?
  protected void addBoat(Boat b) {
    boats.add(b);
  }
  */

  /**
   * Get registered boats.

   * @return Boats registered to the member.
   */
  public ArrayList<Boat> getBoats() {
    return new ArrayList<Boat>(boats);
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

   * @param boatId Id of the boat to modify.
   * @param newType New boat type.
   * @return If the boat has been updated.
   */
  public Boolean changeBoatType(int boatId, Integer newType) { // flytta till Boat?
    Boat b = boats.get(boatId - 1);

    if (newType == 1) {
      b.setBoatType("Sailboat");
    } else if (newType == 2) {
      b.setBoatType("Motorsailer");
    } else if (newType == 3) {
      b.setBoatType("Kayak/Canoe");
    } else if (newType == 4) {
      b.setBoatType("Other");
    } else {
      return false;
    }
    return true;
  }

  /**
   * Updates boat length.

   * @param boatId  Id of the boat to modify.
   * @param newLength New boat length.
   * @return If the boat has been updated.
   */
  public Boolean changeBoatLength(int boatId, Integer newLength) { // flytta till Boat?
    Boat b = boats.get(boatId - 1);
    
    if (newLength > 0) {
      b.setBoatLength(newLength);
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
  public Boolean removeBoat(Boat b) {
    boats.remove(b);
    if (boats.contains(b)) {
      return false;
    } else {
      return true;
    }
  }
}
