package vehicles;

/**
 * Bus - описывает автобусы парка общественного транспорта.
 *
 * @version 1.00 28 Nov 2020
 * @author Агафонова Евгения
 */
public class Bus extends Vehicle {

    private int floorNumbers;
    private boolean hasToilet;
    private boolean checkTaker;

    public Bus(int passengerNumber, double fuelTankVolume, FuelTypes fuelTypes, String numberplate, double prise, int fuelConsumption) {
        super(passengerNumber, fuelTankVolume, fuelTypes, numberplate, prise, fuelConsumption);

        floorNumbers = 1;
        hasToilet = false;
        checkTaker = true;
        setVehicleType("Bus");
    }

    public int getFloorNumbers() {
        return floorNumbers;
    }

    public boolean isHasToilet() {
        return hasToilet;
    }

    public boolean isCheckTaker() {
        return checkTaker;
    }

    public void setFloorNumbers(int floorNumbers) {
        this.floorNumbers = floorNumbers;
    }

    public void setHasToilet(boolean hasToilet) {
        this.hasToilet = hasToilet;
    }

    public void setCheckTaker(boolean checkTaker) {
        this.checkTaker = checkTaker;
    }
}
