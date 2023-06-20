package com.baokey.javaExceptionAPI;

/**
 * Below Throwable, there are 3 subtypes: Error, Exception, RuntimeException
 *
 * <p>Error: represents system errors occurred in abnormal(bất bình thường) conditions. It is the
 * base class for all Errors in JAVA. Remember that we should not catch errors, because the program
 * cannot be recovered in the events of errors. You may know two well-known errors are
 * StackOverflowError and OutOfMemoryError.
 *
 * <p>Exception: this the base class for all exceptions in JAVA. And most of the time, we throw and
 * catch exceptions which are subclasses of Exception
 *
 * <p>RuntimeException: an exception of this type represents a programming error and typically(thông
 * thường) we should not throw and catch runtime exceptions. NullPointerException is very well-know
 * runtime exception in JAVA
 *
 * <p>So far we have Error, Exception and RuntimeException represent 3 different kinds of errors and
 * exceptions in JDK. Under them, there are a lot of sub classes and their sub classes. For example,
 * the IOException represents a general I/O error, and its subclass FileNotFoundException is a more
 * specific exception that indicates a file cannot be located on disk
 *
 * <p>Here’s a list of common error classes defined by JDK (most of them are under java.lang
 * package): AssertionError AWTError (java.awt) IOError (java.io) LinkageError
 * ExceptionInInitializerError NoClassDefFoundError UnsatisfiedLinkError VerifyError ThreadDeath
 * VirtualMachineError InternalError OutOfMemoryError StackOverflowError UnknownError
 *
 * <p>These exceptions are categorized as checked exceptions and they are grouped by package. The
 * following is a list of common checked exceptions defined in the java.lang package:
 * ReflectiveOperationException ClassNotFoundException InstantiationException IllegalAccessException
 * InvocationTargetException NoSuchFieldException NoSuchMethodException CloneNotSupportedException
 * InterruptedException
 *
 * <p>These exceptions are categorized as unchecked exceptions and they are grouped by package. The
 * following is a list of common unchecked exceptions in the java.lang package: ArithmeticException
 * IndexOutOfBoundsException ArrayIndexOutOfBoundsException StringIndexOutOfBoundsException
 * ArrayStoreException ClassCastException EnumConstantNotPresentException IllegalArgumentException
 * IllegalThreadStateException NumberFormatException IllegalMonitorStateException
 * IllegalStateException NegativeArraySizeException NullPointerException SecurityException
 * TypeNotPresentException UnsupportedOperationException
 */
public class Hierarchy {
  public static void main(String[] args) {}
}
