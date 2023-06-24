package com.baokey.tryWithResources;
/**
 * @author BAO 6/24/2023
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * What is try-with-resources statement ?
 *
 * <p>The try-with-resources statement is a try statement that declares one or more resources.
 *
 * <p>A resource is an object that must be closed after the program is finished with it. The
 * try-with-resources statement ensures that each resource is closed at the end of the statement.
 *
 * <p>Anny object that implements java.lang.AutoCloseable, which includes(bao gồm) all objects which
 * implement java.io.Closeable, can be used as a resource.
 *
 * <p>An object that may hold resources (such as file or socket handles) until it is closed. The
 * close() method of AutoCloseable object is called automatically when exiting a try-with-resources
 * block for which the object has been declared in the resource specification header. This
 * construction ensures(đảm bảo) prompt(ngay lặp tức) release(giải phóng), avoiding resource
 * exhaustion exceptions and errors that may xảy ra nếu không có resource.
 *
 * <p>close() in AutoCloseable{} throws Exception if this resources cannot be closed.
 */
public class TryWithResources {

  public static void main(String[] args) {
    /** Declare one or more resources in a try-with-resources statement */

    /**
     * BufferedReader instance is declared in a try-with-resource statement, it will be closed
     * regardless(bất kể khi) of whether the try statement completes normally or abruptly(đột ngột)
     * (as a result of the method BufferedReader.readLine throwing an IOEException) nó vẫn được
     * đóng)
     *
     * <p>BufferedReader implements the Closeable interface, which extends the AutoCloseAlbe
     * interface. The close() method of an AutoCloseAble object is called automatically when exiting
     * a try-with-resource block for which object has been declared in the resource specification
     * header hence the BufferedReader resource class is automatically closed by calling close()
     * method of an AutoCloseable object.
     */
    try (FileReader fileReader = new FileReader("hello.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        BufferedReader bufferedReader1 = new BufferedReader(fileReader)) {
      String sCurrentLine;
      while ((sCurrentLine = bufferedReader.readLine()) != null) {
        System.out.println(sCurrentLine);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println("================");
    try (ResourceDemo1 resourceDemo1 = new ResourceDemo1();
        ResourceDemo2 resourceDemo2 = new ResourceDemo2()) {
      int x = 10 / 0;
      resourceDemo1.show();
      resourceDemo2.show();
    } catch (ArithmeticException e) {
      System.out.println(e);
    }

    /**
     * One more additional point is the close method of the Closable interface throws exceptions of
     * type IOException while the close method of the AutoCLoseable interface throws exceptions of
     * type Exception. Consequently(do đó), subclasses of the AutoCloseable interface can override
     * this behavior of the close method to throw specialized exceptions, such as IOException, or no
     * exception at all.
     */
  }
}
