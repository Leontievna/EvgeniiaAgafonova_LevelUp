package vehicles;

/**
 * Vehicle - содержит характеристики автомобилей парка общественного транспорта.
 *
 * @version 1.00 28 Nov 2020
 * @author Агафонова Евгения
 */
public class Vehicle implements Comparable{

    public enum FuelTypes {
        PETROL_92,
        PETROL_95,
        PETROL_98,
        PETROL_100,
        DIESEL
    }

    private int passengerNumber;
    private double fuelTankVolume;
    private FuelTypes fuelTypes;
    private String numberplate;
    private double prise;
    private int fuelConsumption;
    private String vehicleType;

    public Vehicle(int passengerNumber, double fuelTankVolume, FuelTypes fuelTypes, String numberplate, double prise, int fuelConsumption) {
        this.passengerNumber = passengerNumber;
        this.fuelTankVolume = fuelTankVolume;
        this.fuelTypes = fuelTypes;
        this.numberplate = numberplate;
        this.prise = prise;
        this.fuelConsumption = fuelConsumption;
    }

    public void setPassengerNumber(int passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    public void setFuelTankVolume(double fuelTankVolume) {
        this.fuelTankVolume = fuelTankVolume;
    }

    public void setFuelTypes(FuelTypes fuelTypes) {
        this.fuelTypes = fuelTypes;
    }

    public void setNumberplate(String numberplate) {
        this.numberplate = numberplate;
    }

    public void setPrise(double prise) {
        this.prise = prise;
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public double getFuelTankVolume() {
        return fuelTankVolume;
    }

    public FuelTypes getFuelTypes() {
        return fuelTypes;
    }

    public String getNumberplate() {
        return numberplate;
    }

    public double getPrise() {
        return prise;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    @Override
    public int compareTo(Object obj) {
        Vehicle vehicle = (Vehicle)obj;
        if(this.getFuelConsumption() < vehicle.getFuelConsumption()) {
            return -1;
        } else if(this.getFuelConsumption() > vehicle.getFuelConsumption()) {
            return 1;
        }
        return 0;
    }
}
