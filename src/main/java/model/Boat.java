package model;

public class Boat {
  private String boatType;
  private Integer boatLength;

  public String getBoatType() {
    return boatType;
  }

  protected void setBoatType(String boatType) {
    this.boatType = boatType;
  }

  public Integer getBoatLength() {
    return boatLength;
  }

  protected void setBoatLength(Integer boatLength) {
    this.boatLength = boatLength;
  }
}
