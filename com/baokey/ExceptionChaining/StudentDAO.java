package com.baokey.ExceptionChaining;

import com.baokey.ExceptionChaining.exceptions.DAOException;
import java.sql.SQLException;

public class StudentDAO {
  public void list() throws DAOException {
    try {
      DatabaseUtils.executeQuery("SELECT");
    } catch (SQLException e) {
      throw new DAOException("Error quering students from database", e);
    }
  }
}
