package vehicles;

/**
 * Taxi - описывает легковые автомобили парка общественного транспорта.
 *
 * @version 1.00 28 Nov 2020
 * @author Агафонова Евгения
 */
public class Taxi extends Vehicle {

    public enum CarTypes {
        SEDAN,
        HATCHBACK,
        MINIVAN,
        UNIVERSAL,
        PICKUP,
        CABRIOLET,
        LIMOUSINE
    }

    private boolean hasSeatHeating;
    private CarTypes carType;

    public Taxi(int passengerNumber, double fuelTankVolume, FuelTypes fuelTypes, String numberplate, double prise, int fuelConsumption) {
        super(passengerNumber, fuelTankVolume, fuelTypes, numberplate, prise, fuelConsumption);
        carType = CarTypes.SEDAN;
        boolean hasSeatHeating = false;
        setVehicleType("Taxi");
    }

    public boolean isHasSeatHeating() {
        return hasSeatHeating;
    }

    public CarTypes getCarType() {
        return carType;
    }

    public void setHasSeatHeating(boolean hasSeatHeating) {
        this.hasSeatHeating = hasSeatHeating;
    }

    public void setCarType(CarTypes carType) {
        this.carType = carType;
    }
}

