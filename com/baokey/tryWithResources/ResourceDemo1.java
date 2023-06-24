package com.baokey.tryWithResources;
/**
 * @author BAO 6/24/2023
 */
public class ResourceDemo1 implements AutoCloseable {

  void show() {
    System.out.println("inside show 1");
  }

  @Override
  public void close() {
    System.out.println("close from resourceDemo1");
  }
}
