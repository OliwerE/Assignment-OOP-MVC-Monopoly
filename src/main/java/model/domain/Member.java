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
   * Register a new boat.

   * @param boatType Type of boat.
   * @param length Length of boat.
   */
  public void registerBoat(BoatType boatType, int length) {
    Boat newBoat = new Boat();
    newBoat.setBoatType(boatType);
    newBoat.setBoatLength(length);
    boats.add(newBoat);
  }

  /**
   * Updates boat type.

   * @param boat Boat to modify.
   * @param newType New boat type.
   * @return If the boat has been updated.
   */
  public Boolean changeBoatType(Boat boat, BoatType newType) { // flytta till Boat?
    if (boats.contains(boat)) {
      boat.setBoatType(newType);
      return true;
    } else {
      return false;
    }
  }

  /**
   * Updates boat length.

   * @param boat  Boat to modify.
   * @param newLength New boat length.
   * @return If the boat has been updated.
   */
  public Boolean changeBoatLength(Boat boat, Integer newLength) {
    if (boats.contains(boat)) {
      if (newLength > 0) {
        boat.setBoatLength(newLength);
        return true;
      } else {
        return false;
      }
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
