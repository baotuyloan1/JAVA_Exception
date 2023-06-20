package com.baokey.ExceptionChaining;

import com.baokey.ExceptionChaining.exceptions.StudentException;

public class StudentProgram {
  public static void main(String[] args) {
    StudentDAO dao = new StudentDAO();
    StudentManager manager = new StudentManager(dao);

    try {
      manager.findStudents("Tom");
    } catch (StudentException e) {
      e.printStackTrace();
    }
  }
}
