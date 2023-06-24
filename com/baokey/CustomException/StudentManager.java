package com.baokey.CustomException;

import java.sql.SQLException;

public class StudentManager {
  public Student find(String studentID) throws StudentNotFoundException {
    if (studentID.equals("12345")) {
      return new Student();
    } else {
      throw new StudentNotFoundException("Could not find student with ID" + studentID);
    }
  }

  public void save(Student student) throws StudentStoreException {
    try {
      throw new SQLException("Query false");
    } catch (SQLException e) {
      throw new StudentStoreException("Failed to save Student", null);
    }
  }
}
