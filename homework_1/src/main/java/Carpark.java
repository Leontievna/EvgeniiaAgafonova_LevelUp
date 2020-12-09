import vehicles.Bus;
import vehicles.Taxi;
import vehicles.Vehicle;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Carpark - выполняет добавление объектов в автопарк, поиск и их отображение по заданным параметрам.
 *
 * @version 1.1 09 Dec 2020
 * @author Агафонова Евгения
 */
public class Carpark {

    private ArrayList<Vehicle> allVehicles;
    private ArrayList<Taxi> taxis;
    private ArrayList<Bus> buses;

    public Carpark() {
        allVehicles = new ArrayList<Vehicle>();
        taxis = new ArrayList<Taxi>();
        buses = new ArrayList<Bus>();
    }

    public Bus addBus(int passengerNumber, double fuelTankVolume, Vehicle.FuelTypes fuelTypes,
                      String numberplate, double prise, int fuelConsumption) throws CarparkException {

        if (passengerNumber < 1 )
            throw new CarparkException(passengerNumber, "The number of passengers can't be less then 1");

        Bus bus = new Bus(passengerNumber, fuelTankVolume, fuelTypes, numberplate, prise, fuelConsumption);
        buses.add(bus);
        allVehicles.add(bus);
        return bus;
    }

    public Taxi addTaxis(int passengerNumber, double fuelTankVolume, Vehicle.FuelTypes fuelTypes, String numberplate, double prise, int fuelConsumption){
        Taxi taxi = new Taxi(passengerNumber, fuelTankVolume, fuelTypes, numberplate, prise, fuelConsumption);
        taxis.add(taxi);
        allVehicles.add(taxi);
        return taxi;
    }

    public double parkPrise() {
        double result = 0;

        for (Vehicle vehicle: allVehicles) {
             result += vehicle.getPrise();
        }
        return result;
    }

    public void printVehiclesFuelConsumption(){
        Collections.sort(allVehicles);

        for(int i = 0; i < allVehicles.size(); i++)
        {
            Vehicle vehicle = allVehicles.get(i);
            String text = Integer.toString(i + 1) + " " +
                    vehicle.getVehicleType() + " " +
                    vehicle.getFuelConsumption() + " " +
                    vehicle.getNumberplate();
            System.out.println(text);
        }
    }

    public ArrayList<Bus> getBusesByPassengers(int minPassengersNum, int maxPassengersNum){
        ArrayList<Bus> result = new ArrayList<Bus>();

        for (Bus bus: buses) {
            if ((minPassengersNum <= bus.getPassengerNumber()) &&
                    (bus.getPassengerNumber() <= maxPassengersNum)){
                result.add(bus);
            }
        }
        return result;
    }

    public Vehicle getVehicle(String numberplate) throws VehicleException {
        Vehicle result = null;
        for (Vehicle vehicle: allVehicles) {
            if (vehicle.getNumberplate() == numberplate) {
                result = vehicle;
                break;
            }
        }
        if (result == null) {
            throw new VehicleException(numberplate, "This vehicle doesn't exist in the carpark");
        }
        return result;
    }

}
