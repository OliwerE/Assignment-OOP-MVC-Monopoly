package model;

import java.util.ArrayList;

public class Member {
  private Integer id;
  private String name;
  private int personalNumber;
  private ArrayList<Boat> boats = new ArrayList<>();

  public Integer getId() {
    return id;
  }

  protected void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPersonalNumber() {
    return personalNumber;
  }

  public void setPersonalNumber(int personalNumber) {
    this.personalNumber = personalNumber;
  }

  /* används ej?
  protected void addBoat(Boat b) {
    boats.add(b);
  }
  */

  public ArrayList<Boat> getBoats() {
    return new ArrayList<Boat>(boats);
  }

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

  private int getNextBoatId() {
    return boats.get(boats.size() - 1).getBoatId() + 1;
  }

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

  public Boolean changeBoatLength(int boatId, Integer newLength) { // flytta till Boat?
    Boat b = boats.get(boatId - 1);
    
    if (newLength > 0) {
      b.setBoatLength(newLength);
      return true;
    } else {
      return false;
    }
  }

  public Boolean removeBoat(Boat b) {
    boats.remove(b);
    if (boats.contains(b)) {
      return false;
    } else {
      return true;
    }
  }
}
