package vehicles;

/**
 * BusException - класс описывает исключение.
 *
 * @version 1.00 09 Dec 2020
 * @author Агафонова Евгения
 */
public class BusException extends Exception {
    private int detail;

    public BusException(int detail, String message) {
        super(message);
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "BusException{"
                + "detail = " + detail
                + ", message = " + getMessage()
                + "} ";
    }
}