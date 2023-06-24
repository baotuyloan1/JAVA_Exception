package com.baokey.CustomException;

public class StudentTest {
  public static void main(String[] args) {
    StudentManager manager = new StudentManager();
    try {
      Student student = manager.find("111");
    } catch (StudentNotFoundException e) {
      e.printStackTrace();
    }
  }
}
