package model;

public class Boat {
  private String boatType;
  private int boatLength;
  private int boatId;

  public String getBoatType() {
    return boatType;
  }

  protected void setBoatType(String boatType) {
    this.boatType = boatType;
  }

  public int getBoatLength() {
    return boatLength;
  }

  protected void setBoatLength(int boatLength) {
    this.boatLength = boatLength;
  }

  public int getBoatId() {
    return boatId;
  }

  public void setBoatId(int boatId) {
    this.boatId = boatId;
  }
}
