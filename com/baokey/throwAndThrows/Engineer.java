package com.baokey.throwAndThrows;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Engineer implements ThrowInterface {

  public Engineer() throws RuntimeException {
  }

  protected int age;

  public void setAge(int age) throws IllegalArgumentException {
    if (age < 21 || age > 59) {
      /**
       * the throw keyword is used to throw a new exception object if the passed-in parameter has
       * invalid value. When the statement started by the throw keyword gets executed, the current
       * method stops its execution and control returned to the caller code which can have an
       * exception handler
       */
      throw new IllegalArgumentException("Invalid age");
    }
    this.age = age;
  }

  public int divide(int a, int b) throws Exception {
    if (b == 0) {
      throw new Exception("Cannot be divided by zero");
    }
    return a / b;
  }

  // The exceptions specified in the throws clause can be broader than the ones can be thrown in the
  // method’s body.
  //  Here, code in the method can throw FileNotFoundException but the method declares to throw
  // IOException. This is possible because IOException is the parent class of FileNotFoundException.
  public void deleteDir(String path) throws IOException {
    if (path == null) {
      throw new FileNotFoundException("Directory not found");
    }
  }

  //  a method can declare to throw exceptions although its code doesn't throw any exceptions. THis
  // is possible because the code can throw exceptions when it involved in the future.
  public void encryptFile(String path) throws IOException {
    //    no exceptions thrown here

  }

  @Override
  public String toString() {
    return "Engineer{" + "age=" + age + '}';
  }


  @Override
  public int cout(int a, int b) throws IOException {
    return a+b;
  }
}
