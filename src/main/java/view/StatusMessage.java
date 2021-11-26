package view;

/**
 * Responsible for status messages in the user interface.
 */
public class StatusMessage {
  /**
   * Displays loading members message.
   */
  public void displayLoadMembersMessage() {
    System.out.println("Loading members...");
  }

  /**
   * Displays if members has been loaded.

   * @param isSuccess If members has been loaded
   */
  public void displayLoadMembersStatus(Boolean isSuccess) {
    if (isSuccess) {
      System.out.println("Members has been loaded!");
    } else {
      System.out.println("Error: Could not load members.");
    }
  }

  /**
   * Displays close message.
   */
  public void displayCloseMessage() {
    System.out.println("Closes application...");
  }

  /**
   * Displays saving members message.
   */
  public void displaySaveMembersMessage() {
    System.out.println("Saving members...");
  }

  /**
   * Displays if the members has been saved.

   * @param isSuccess If the members has been saved
   */
  public void displaySaveMembersStatus(Boolean isSuccess) {
    if (isSuccess) {
      System.out.println("Members has been saved!");
    } else {
      System.out.println("Error: Members has not been saved.");
    }
  }

  /**
   * Displays member does not exist.
   */
  public void memberDoesNotExistMessage() {
    System.out.println("Member does not exist!");
  }

  /**
   * Displays boat does not exist.
   */
  public void boatDoesNotExistMessage() {
    System.out.println("Boat does not exist!");
  }

  /**
   * Displays menu input error.
   */
  public void displayMenuInputError() {
    System.out.println("Not an alternative!");
  }

  /**
   * Displays member registration status.

   * @param isSuccess If the member has been registered.
   */
  public void displayRegisterMemberStatus(Boolean isSuccess) {
    if (isSuccess) {
      System.out.print("Member has been registered!");
    } else {
      System.out.print("Member has not been registered.");
    }
  }

  /**
   * Displays delete member status.

   * @param isSuccess If the member has been removed
   */
  public void displayDeleteMemberStatus(Boolean isSuccess) {
    if (isSuccess) {
      System.out.print("Member has been removed!");
    } else {
      System.out.print("Member has not been removed.");
    }
  }

  /**
   * Success message for register boat.
   */
  public void displayBoatRegisteredStatus() {
    System.out.print("Boat has been registered!");
  }

  /**
   * Displays update boat status.
   */
  public void displayBoatUpdateMessage() {
    System.out.println("Boat has been updated!");
  }

  /**
   * Displays remove boat status.
   */
  public void displayBoatRemovedMessage() {
    System.out.println("Boat has been removed!");
  }
}
