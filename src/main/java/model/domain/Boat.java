package model.domain;

/**
 * Represent registered boat.
 */
public class Boat {
  private String boatType;
  private int boatLength;

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
}
