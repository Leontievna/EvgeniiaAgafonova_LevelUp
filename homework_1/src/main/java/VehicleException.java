 /**
 * VehicleException - класс описывает исключение.
 *
 * @version 1.00 09 Dec 2020
 * @author Агафонова Евгения
 */

public class VehicleException extends CarparkException {
    private String detail;

    public VehicleException(String detail, String message) {
        super(0, message);
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "VehicleException{"
                + "detail = " + detail
                + ", message = " + getMessage()
                + "} ";
    }
}