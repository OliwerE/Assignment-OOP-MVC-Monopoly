package model.domain;

/**
 * Represent registered boat.
 */
public class Boat {
  private String boatType;
  private int boatLength;
  private int boatId;

  /**
   * Returns the boat type.

   * @return Boat type.
   */
  public String getBoatType() {
    return boatType;
  }

  /**
   * Changes the boat type.

   * @param boatType A new boat type.
   */
  protected void setBoatType(String boatType) {
    this.boatType = boatType;
  }

  /**
   * Returns the boat length.

   * @return Boat length.
   */
  public int getBoatLength() {
    return boatLength;
  }

  /**
   * Changes the boat lenght.

   * @param boatLength New boat lenght
   */
  protected void setBoatLength(int boatLength) {
    this.boatLength = boatLength;
  }

  /**
   * Returns the boat id.

   * @return Boat id.
   */
  public int getBoatId() {
    return boatId;
  }

  /**
   * Changes the boat id.

   * @param boatId New boat id.
   */
  protected void setBoatId(int boatId) {
    this.boatId = boatId;
  }
}
