package model;

import java.util.ArrayList;

public class Member {
  private Integer id;
  private String name;
  private Integer personalNumber;
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

  public void setPersonalNumber(Integer personalNumber) {
    this.personalNumber = personalNumber;
  }

  public Integer getPersonalNumber() {
    return personalNumber;
  }

  protected void setBoat(Boat b) {
    boats.add(b);
  }

  public ArrayList<Boat> getBoats() {
    return new ArrayList<Boat>(boats);
  }

  public Boolean registerBoat(Integer type, Integer length) {
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
    boats.add(newBoat);
    return true;
  }

  public Boolean changeBoatType(Boat b, Integer newType) {
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
}
