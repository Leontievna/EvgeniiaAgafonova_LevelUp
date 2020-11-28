import vehicles.Bus;
import vehicles.Taxi;
import vehicles.Vehicle;

import java.util.ArrayList;
import java.util.Collections;

public class Carpark {
    private ArrayList<Vehicle> allVehicles;
    private ArrayList<Taxi> taxis;
    private ArrayList<Bus> buses;

    public Carpark(){
        allVehicles = new ArrayList<Vehicle>();
        taxis = new ArrayList<Taxi>();
        buses = new ArrayList<Bus>();
    }

    public Bus addBus(int passengerNumber, double fuelTankVolume, Vehicle.FuelTypes fuelTypes, String numberplate, double prise, int fuelConsumption){
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
            if (minPassengersNum <= bus.getPassengerNumber() &&
                    bus.getPassengerNumber() <= maxPassengersNum){
                result.add(bus);
            }
        }

        return result;
    }




}
