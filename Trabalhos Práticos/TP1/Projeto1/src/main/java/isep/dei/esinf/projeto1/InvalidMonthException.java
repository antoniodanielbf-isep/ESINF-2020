package isep.dei.esinf.projeto1;

/**
 * A exception to be launched when the app tries to build/modify a instance of
 * Date to represent a day which month is invalid.
 *
 * @author 1190402_1191045
 */
public class InvalidMonthException extends Exception {

    /**
     * Builds a InvalidMonthException with the message "Invalid Month!".
     */
    public InvalidMonthException() {
        super("Invalid Month!");
    }

    /**
     * Builds a InvalidMonthException with the received message.
     *
     * @param message the message received by the exception
     */
    public InvalidMonthException(String message) {
        super(message);
    }
}
