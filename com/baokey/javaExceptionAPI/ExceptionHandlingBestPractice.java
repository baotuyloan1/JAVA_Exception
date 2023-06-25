package com.baokey.javaExceptionAPI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author BAO 6/25/2023
 */
public class ExceptionHandlingBestPractice {
  public static void main(String[] args) {

    /*
     *1. Clean up Resources in a Finally Block or Use a Try-With-Resource Statement
     *
     *2. Throw Specific Exception
     *
     * 3. Do not catch the Exception class rather catch specific subclasses.
     *
     * 4. Never catch a Throwable class.
     *
     * 5. Always correctly wrap the exceptions in custom exceptions 1 cách chính xác để tránh mất dấu thông tin về stack trace
     *
     * 6. Catch the most specific exception first
     *
     * 7. Don’t ignore exceptions rather log the exceptions
     *
     * 8. Never throw any exception from finally block
     *
     * 9. Don’t use printStackTrace() statement or similar methods: never leave printStackTrace() after finishing your code. Vì có khả năng 1 trong các động nghiệp sẽ gặp 1 trong những stack traces đó và sẽ không có bất kỳ kiến thức nào về cách sử lý nó vì nó không có bất kỳ thông tin nào đi kèm
     *
     * 10. Use finally blocks instead of catch blocks if you are not going to handle the exception
     *
     * 11. Validate user input to catch adverse conditions very early in request processing
     * Always validate user input in a very early stage, even before it reached to the actual controller. It will help you to minimize the exception handling code in your core application logic. It also helps you in making application consistent if there is some error in user input.
     *
     * 12. Throw Exceptions With Descriptive Messages
     */

    // nên sử lý trước khi đưa nó đến controller , xử lí đầu tiên để tránh việc logic rắc rối
    /**
     * if (user.getEmail == null) { throw new BadRequestException(); }
     *
     * <p>if (user.getAddress == null) { throw new BadRequestException(); }
     *
     * <p>if (user == null) { throw new UserNotFoundException(); }
     */
    File file = new File("hello1.txt");
    try (FileInputStream inputStream = new FileInputStream(file);
        FileInputStream inputStream1 = new FileInputStream(file)) {
      /** Use the inputStream to read a file. */
    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  /** 2. Throw Specific Exception */
  // should
  public void someMethod() throws IllegalArgumentException {}

  // avoid
  public void someMethod1() throws Exception {}

  /** 3. Do not catch the Exception class rather catch specific subclasses */

  // avoid
  public void downCastPrimitiveType() {
    try {
      //      System.out.println("i [" + i + "]");

    } catch (Exception e) {
      e.printStackTrace();
      //    } catch (RuntimeException e) {
      e.printStackTrace();
      //    } catch (NullPointerException e) {
      e.printStackTrace();
    }
  }

  // better
  public void someMethod2() {
    try {
      System.out.println("123");
    } catch (NullPointerException e) {
      e.printStackTrace();
    } catch (RuntimeException e) {
      e.printStackTrace();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /** Never catch a Throwable class */
  public void doNotCatchThrowable() {
    try {
      throw new RuntimeException();
    } catch (Throwable t) {
      // don't do this
      t.printStackTrace();
    }
  }

  /**
   * Always correctly wrap the exceptions in custom exceptions 1 cách chính xác để tránh mất dấu
   * thông tin về stack trace
   */

  //  avoid
  public void wrapExceptionInCorrect() {
    try {
      throw new NoSuchMethodException();
    } catch (NoSuchMethodException e) {
      throw new RuntimeException("Some information: " + e.getMessage());
    }
  }

  // better
  public void wrapExceptionCorrect() throws Exception {
    try {
      throw new NoSuchMethodException();
    } catch (NoSuchMethodException e) {
      throw new Exception("Some information: ", e);
    }
  }

  /** 7. Don’t ignore exceptions rather log the exceptions */
  // avoid
  public void doNotIgnoreExceptions() {
    try {
    } catch (NumberFormatException e) {
      //      this will never happen
    }
  }

  public void shouldLogAnException() {
    try {

    } catch (NumberFormatException e) {
      System.out.println("This should never happen");
      e.printStackTrace();
    }
  }
}
