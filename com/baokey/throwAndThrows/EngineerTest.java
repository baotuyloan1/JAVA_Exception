package com.baokey.throwAndThrows;

import java.io.IOException;

public class EngineerTest {
  public static void main(String[] args) {

    /**
     * làm thế nào để chúng ta biết 1 phương thức có thể ném ra các ngoại lệ (exceptions) hay không?
     * và làm thế nào chúng ta biết 1 phương thức ném ra những ngoại lệ nào
     *
     * <p>the throws keyword is used in methods signature to specify exceptions can be thrown If
     * code in the method can throw checked exceptions, the method must declare to throw exceptions
     * in its signature, otherwise we will get compile error. And the caller code should handle
     * those exceptions.
     *
     * <p>if code in the method can throw unchecked exceptions, the method is not required to
     * declare to throw those exceptions. That's why in the Engineer example, the setAge() method
     * does not declare to throw IllegalArgumentException(). And the caller code can choose to
     * handle unchecked exceptions or not,
     *
     * <p>3. Some rules regarding throw and throws:
     *
     * <p>if code in a method throws checked exceptions, the method must specify those exceptions in
     * the throws clause. Unchecked exceptions are not required to be caught or declared The
     * exceptions specified in the throws clause can be broader(rộng hơn) than the ones can be
     * thrown in the method's body.
     *
     * <p>A method can declare to throw exceptions although its code doesn’t throw any exceptions.
     * This is possible because the code can throw exceptions when it involves in the future
     *
     * <p>Constructors can throw exceptions and declare to throw exceptions just like normal methods
     */
    int age = 30;
    Engineer newEngineer = null;

    try {
      newEngineer = new Engineer();
    } catch (RuntimeException e) {
      throw new RuntimeException(e);
    }
    newEngineer.setAge(age);
    try {
      newEngineer.divide(3, 0);
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }

    try {
      newEngineer.encryptFile("xzczxc");
    } catch (IOException e) {
      System.out.println("A");
      throw new RuntimeException(e);
    }

    try {
      System.out.println(newEngineer.cout(2, 3));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }
}
