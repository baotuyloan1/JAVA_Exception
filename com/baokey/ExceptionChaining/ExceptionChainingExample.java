package com.baokey.ExceptionChaining;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionChainingExample {
  public static void main(String[] args) {
    /**
     * Exception chainig is the process of re-throwing multiple exceptions across different
     * abstraction layers of a program. The key principle here is that, these exceptions are chained
     * together to maintain the stack trace from the exception at lowest layer to the one at the
     * highest layer.
     *
     * <p>Each abstraction layer defines its own exception classes. When code in a layer throw an
     * exception, the higher layer re-throws it under a new type of exceptions which corresponds to
     * the abstraction level of that layer. In turn, the next higher layer re-throws the exception
     * under its own type of exception and so on. This process continues util a layer handles the
     * exception instead of re-throwing. During this chaining process, the higher exception always
     * wraps lower exceptions as its cause. Therefore, when an exceptions occurs, the programmer has
     * a complete stack strace(list) of the exceptions, which í very helpful for debugging.
     *
     * <p>2. Why is Exception Chaining? The main purpose of exception chaining is to preserver the
     * original exception when it propagates(lan truyền) across multiple logical layers in a
     * program. This is very helpful for debugging process when an exception is thrown, as the
     * programmer can analyze the full stack tract of the exceptions.
     *
     * <p>In addition, exception chaining also helps promoting( việc thúc đẩy) abstractions among
     * logical layers in a program. as each layer defines its own exceptions which are specific for
     * that layer. For example, the StudentBusinessclass throws StudentException would be more
     * meaningful than SQLException, right?
     *
     * <p>exception chaining is sometimes referred as exception propagation, as when a layer throws
     * an exception, the exception propagates through higher layers until a layer handles it such as
     * displaying a message/warning to the user.
     */
  }

  public static void setBrithday(String birthDate) throws InvalidBirthDayException {
    DateFormat formatter = new SimpleDateFormat();
    try {
      Date birthDay = formatter.parse(birthDate);
    } catch (ParseException ex) {
//      ParseException is re-thrown under new exception called InvalidBirthDayException
      throw new InvalidBirthDayException("date of birth is invalid", ex);
    }
  }
}
