package com.baokey.CatchingException;

import java.io.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 * The order of catch blocks does matter If the protected code can throw different exceptions which
 * are not in the same inheritance tree, i.e. they don’t have parent-child relationship, the catch
 * blocks can be sorted any order.
 *
 * <p>However, keep in mind this rule: if the exceptions have parent-child relationship, the catch
 * blocks must be sorted by the most specific exceptions first, then by the most general ones.
 *
 * <p>In the above example, FileNotFoundException is a child of IOException so its catch block must
 * come first. If we try to catch the IOException before FileNotFoundException, the compiler will
 * issue an error like this: error: exception FileNotFoundException has already been caught
 *
 * <p>Why? It’s because if we handle the most general exceptions first, the more specific exceptions
 * will be omitted, which is not good, as Java encourages handling exceptions as much specific as
 * possible.
 *
 * <p>3. Catching one exception for all We can catch all exceptions by only one catch block.
 * Howerver, this practice is not recommended, as it makes the programmers lazy:catching one is
 * obviously quicker than catching many. That means the programmers do not take responsibility to
 * handle exceptions carefully. The good practice recommends catching specific exceptions so the
 * program can handle different situations well.
 *
 * <p>Java doesn’t prohibit(cấm) you from catching one for all, but when doing so, you should have
 * good reasons to do that.
 *
 * <p>Since Java 7, we can combine multiple exceptions in a single catch clause. This becomes very
 * handy(tiện dụng) in case we want to apply the same handling for those exceptions
 *
 * <p>5. What should you do in the catch blocks?
 *
 * <p>It’s up to you to write anything inside the catch blocks. Remember the main purpose of the
 * catch blocks is to recover the program from the exceptions and continue execution, such as
 * notifying the user about the error, ask he or she to wait, try again or exit, etc.
 *
 * <p>Typically, you can do the following things in the catch blocks (not limited to):
 *
 * <p>- Print out the exception details via System.err class’ methods, then exit the method:
 *
 * <p>System.err.println(ex); System.err.println(ex.getMessage());
 *
 * <p>- Print the full stack trace of the exception and exit the method: ex.printStackTrace(); -
 * Log the exceptions then exit the method. You can use Java’s built-in logging functionalities or a
 * third-part library like log4j. - Display an error message dialog in case the program is a desktop
 * application (Swing or JavaFX). - Redirect the user to an error page in case the program is a web
 * application (Servlets & JSP).
 */
public class CatchingMultiException {
  public static void main(String[] args) {
    /** There are many catch blocks as the number of exceptions */
    try {
      //      FileReader throws FileNotFoundException
      LineNumberReader lineReader = new LineNumberReader(new FileReader("hello1.txt"));
      //      String readLine() throws IOException
      String line = lineReader.readLine();
      lineReader.close();
      System.out.println(line);
    } catch (FileNotFoundException ex) {
      ex.printStackTrace();
    } catch (IOException ex) {
      ex.printStackTrace();
    }

    /** one exception for all */
    try {
      LineNumberReader lineNumberReader = new LineNumberReader(new FileReader("hello.txt"));
      String line = lineNumberReader.readLine();
      lineNumberReader.close();
      System.out.println(line);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    /**
     * That means it’s illegal to group exceptions which have parent-child relationship. For
     * example, it’s illegal to write a multi-catch statement like this:
     *
     * <p>The compiler will complain: 1 error: Alternatives in a multi-catch statement cannot be
     * related by subclassing
     */
    //    try {
    //      LineNumberReader lineReader = new LineNumberReader(new FileReader("hello.txt"));
    //      String line = lineReader.readLine();
    //      lineReader.close();
    //
    //      System.out.println(line);
    //
    //    } catch (FileNotFoundException | IOException ex) {
    //      System.err.println("Find not found");
    //    }
  }

  public static void doCrypto(int cipherMode, String key, File inputFile, File outputFile) {
    try {
      Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
      Cipher cipher = Cipher.getInstance("AES");
      cipher.init(cipherMode, secretKey);

      FileInputStream inputStream = new FileInputStream(inputFile);
      byte[] inputBytes = new byte[(int) inputFile.length()];
      inputStream.read(inputBytes);

      byte[] outputBytes = cipher.doFinal(inputBytes);

      FileOutputStream outputStream = new FileOutputStream(outputFile);
      outputStream.write(outputBytes);

      inputStream.close();
      outputStream.close();

    } catch (NoSuchPaddingException ex) {
      System.err.println("no padding");
    } catch (NoSuchAlgorithmException ex) {
      System.err.println("no algorithm");
    } catch (InvalidKeyException ex) {
      System.err.println("invalid key");
    } catch (BadPaddingException ex) {
      System.err.println("bad padding");
    } catch (IllegalBlockSizeException ex) {
      System.err.println("illegal block");
    } catch (IOException ex) {
      System.err.println("error reading file");
    }
  }

  public static void doCrypto1(int cipherMode, String key, File inputFile, File outputFile) {
    try {
      Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
      Cipher cipher = Cipher.getInstance("AES");
      cipher.init(cipherMode, secretKey);

      FileInputStream inputStream = new FileInputStream(inputFile);
      byte[] inputBytes = new byte[(int) inputFile.length()];
      inputStream.read(inputBytes);

      byte[] outputBytes = cipher.doFinal(inputBytes);

      FileOutputStream outputStream = new FileOutputStream(outputFile);
      outputStream.write(outputBytes);

      inputStream.close();
      outputStream.close();

    } catch (Exception ex) {
      System.err.println("error");
    }
  }

  //  Since Java 7
  public static void doCrypto2(int cipherMode, String key, File inputFile, File outputFile) {
    try {
      Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
      Cipher cipher = Cipher.getInstance("AES");
      cipher.init(cipherMode, secretKey);

      FileInputStream inputStream = new FileInputStream(inputFile);
      byte[] inputBytes = new byte[(int) inputFile.length()];
      inputStream.read(inputBytes);

      byte[] outputBytes = cipher.doFinal(inputBytes);

      FileOutputStream outputStream = new FileOutputStream(outputFile);
      outputStream.write(outputBytes);

      inputStream.close();
      outputStream.close();

      /**
       * Note that we can group only un-related exceptions together. That means it’s illegal to
       * group exceptions which have parent-child relationship. F
       */
    } catch (NoSuchPaddingException
        | NoSuchAlgorithmException
        | InvalidKeyException
        | BadPaddingException
        | IllegalBlockSizeException
        | IOException ex) {
      System.err.println("error");
    }
  }
}
