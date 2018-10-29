package com.example;

/**
 * This is a class.
 */
public class Greeter {

  /**
   * This is a constructor.
   */
  public Greeter() {

  }

/**

 * @PARAM someone the name of a person 
 * @RETURN  The Greeting String
 
 */

  public final String greet(final String someone) {
    return String.format("Hello, %s!", someone);
  }
}
