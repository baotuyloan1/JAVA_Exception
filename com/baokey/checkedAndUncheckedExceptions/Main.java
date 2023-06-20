package com.baokey.checkedAndUncheckedExceptions;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    /**
     * The exceptions that are subtypes of Exception (exclude(ngoại trừ) subtypes of
     * RuntimeException) are categorized as checked exceptions. When we use code that can throw
     * checked exceptions, we must handle them, otherwise the compiler will complain.
     *
     * <p>Thực tế, we don't have to catch unchecked exceptions which are subtypes of Error and
     * RuntimeException. Methods also don't have to declare to throw unchecked exceptions. it's
     * because programs thông thường cannot được recovered from unchecked exceptions.
     *
     * <p>NOTE: unchecked exceptions are subtypes of RuntimeException, although it is a subtype of
     * Exception.
     */
    try {
      createFile("hello.txt", "Helloword");
    } catch (IOException e) {
      System.err.println(e);
    }

    setAge(11);

    List<String> list = new ArrayList<>();

    /**
     * The get() method of the ArrayList class can throw IndexOutOfBoundsException if the index is
     * out of range. But the code doesn't have to catch because it is an unchecked exception.
     */
    String item = list.get(1);
  }

  public static void createFile(String path, String text) throws IOException {
    FileWriter writer = new FileWriter(path, true);
    writer.write(text);
    writer.close();
  }

  public static void setAge(int age) throws RuntimeException {
    if (age < 1 || age > 99) {
      throw new IllegalArgumentException("Invalid age");
    }
    int newAge = age;
  }
}
