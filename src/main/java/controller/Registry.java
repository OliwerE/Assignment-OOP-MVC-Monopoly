package controller;

public class Registry {
  model.Registry registry = new model.Registry();

  public void start(view.Console c) {
    c.mainMenu();
    Integer i = c.getInteger();
    System.out.println("valde: " + i);
  }
}
