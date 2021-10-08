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

  public void setId(Integer id) {
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

  public void setBoat(Boat b) {
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
}
