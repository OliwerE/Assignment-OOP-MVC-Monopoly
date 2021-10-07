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
    view.Console c = new view.Console();
    Registry c_registry = new Registry();
    c_registry.start(c);
  }
}
