package model;

public class Member {
  private Integer id;
  private String name;
  private Integer personalNumber;
  // private ArrayList<Boat> boats = new ArrayList<>();

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
}
