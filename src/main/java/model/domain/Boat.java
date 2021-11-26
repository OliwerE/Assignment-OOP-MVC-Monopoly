package model.domain;

/**
 * Represent registered boat.
 */
public class Boat {
  private BoatType boatType;
  private int boatLength;

  /**
   * Boat type alternatives.
   */
  public enum BoatType {
    Sailboat, Motorsailer, KayakCanoe, Other
  }

  /**
   * Returns the boat type.

   * @return Boat type.
   */
  public BoatType getBoatType() {
    return boatType;
  }

  /**
   * Changes the boat type.

   * @param boatType A new boat type.
   */
  protected void setBoatType(BoatType boatType) {
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
