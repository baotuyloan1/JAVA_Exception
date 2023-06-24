package com.baokey.ExceptionChaining;

import com.baokey.ExceptionChaining.exceptions.StudentException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * NOTE: đừng xử lí ngoại lệ trên các layers trung gian, because code in the middle layers is often
 * used by code in higher level
 * Đó là trách nhiệm của code ở lớp trên cùng để xử lý các exceptions.
 * The top-most layer is typically the user interface such as commandline console, window or webpage
 * Typical we handle exceptions by showing a warning/error message to the user.
 */
public class StudentProgram {
  public static void main(String[] args) {
    StudentDAO dao = new StudentDAO();
    StudentManager manager = new StudentManager(dao);

    try {
      manager.findStudents("Tom");
    } catch (StudentException e) {
      /** prints out the detail exception stack trace */
      try {
        PrintStream stream = new PrintStream(new File("exceptions1.txt"));
        //        The printStackTrace(PrintStream) method writes the stack trace to a file stream
        e.printStackTrace(stream);
        stream.close();

        //        The printStackTrace(PrintWriter) method writes the stack trace to a file writer
        PrintWriter printWriter = new PrintWriter(new File("exceptions2.txt"));
        e.printStackTrace(printWriter);
        printWriter.close();

        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
          String className = stackTraceElement.getClassName();
          String methodCauseError = stackTraceElement.getMethodName();
          int lineCauseError = stackTraceElement.getLineNumber();
          String fileName = stackTraceElement.getFileName();
          String traceInfo =
              className + "." + methodCauseError + ":" + lineCauseError + " - " + fileName;
          System.out.println(traceInfo);
        }
      } catch (FileNotFoundException ex) {
        ex.printStackTrace();
      }
      e.printStackTrace();
    }
  }
}
