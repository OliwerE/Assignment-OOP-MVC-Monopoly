package controller;

/**
 * Responsible for staring the application.
 */
public class App {
  /**
   * Application starting point.

   * @param args command line arguments.
   */
  public static void main(String[] args) {
    RegistryController c_registry = new RegistryController();
    c_registry.start();
  }
}