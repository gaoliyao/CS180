package com.github;

/**
 * DropFromCourseException
 *
 * Exception thrown for invalid drop operations involving the Course class.
 *
 * @author You
 *
 * @version date of completion
 *
 */

public class DropFromCourseException extends Exception {
    /**
     * Constructs a DropFromCourseException with the default message.
     */
    public DropFromCourseException() {
        //TODO: Call the superclass's constructor with a default message
        super();
    }

    /**
     * Constructs a DropFromCourseException with the provided message.
     *
     * @param message Message to be provided to the user in case of exception
     */
    public DropFromCourseException(String message) {
        //TODO: Call the superclass's constructor with a the message parameter
        super("DropFromCourseException");
    }
}
