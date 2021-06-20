package isep.dei.esinf.projeto1;

/**
 * A exception to be launched when the app tries to build/modify a instance of
 * Date to represent a invalid day.
 *
 * @author 1190402_1191045
 */
public class InvalidDayException extends Exception {

    /**
     * Builds a InvalidDayException with the message "Invalid Day!".
     */
    public InvalidDayException() {
        super("Invalid Day!");
    }

    /**
     * Builds a InvalidDayException with the received message.
     *
     * @param message the message received by the exception
     */
    public InvalidDayException(String message) {
        super(message);
    }
}
