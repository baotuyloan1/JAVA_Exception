package com.baokey.tryWithResources;
/**
 * @author BAO 6/24/2023
 */
public class ResourceDemo2 implements AutoCloseable {

  void show() {
    System.out.println("inside show2");
  }

  @Override
  public void close() {
    System.out.println("close from resoure demo2");
  }
}
