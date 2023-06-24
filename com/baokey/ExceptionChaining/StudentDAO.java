package com.baokey.ExceptionChaining;

import com.baokey.ExceptionChaining.exceptions.DAOException;
import java.sql.SQLException;

public class StudentDAO {
  public void list() throws DAOException {
    try {
      DatabaseUtils.executeQuery("SELECT");
    } catch (SQLException e) {
/**
 * nếu không truyền SQLException vào DAOException it’s hard to detect bugs exactly as the truth is hidden.
 * nên là các chain exceptions nó phải liên tục cùng nhau
 */
      throw new DAOException("Error quering students from database", e);
    }
  }
}
