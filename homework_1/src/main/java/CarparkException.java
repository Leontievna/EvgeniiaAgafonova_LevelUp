/**
 * CarparkException - класс описывает исключение.
 *
 * @version 1.00 09 Dec 2020
 * @author Агафонова Евгения
 */

public class CarparkException extends Exception {
    private int detail;

    public CarparkException(int detail, String message) {
        super(message);
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "CarparkException{"
                + "detail = " + detail
                + ", message = " + getMessage()
                + "} ";
    }
}
