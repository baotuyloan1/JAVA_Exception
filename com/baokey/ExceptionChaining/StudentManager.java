package com.baokey.ExceptionChaining;

import com.baokey.ExceptionChaining.exceptions.DAOException;
import com.baokey.ExceptionChaining.exceptions.StudentException;

public class StudentManager {
    private StudentDAO dao;

    public StudentManager(StudentDAO dao) {
        this.dao = dao;
    }

    public void findStudents(String keyword) throws StudentException {
        try {
            dao.list();
        } catch (DAOException e) {
            throw new StudentException("Error finding students",e);
        }
    }
}
