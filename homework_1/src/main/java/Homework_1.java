import vehicles.Bus;
import vehicles.Taxi;
import vehicles.Vehicle;

import java.util.ArrayList;

public class Homework_1 {
    public static void main(String[] args) {
        Carpark carpark = new Carpark();
        carpark.addBus(49, 480, Vehicle.FuelTypes.DIESEL, "OO123M",25000000,25);
        carpark.addBus(25, 250, Vehicle.FuelTypes.DIESEL, "TT336E",8200000,20);
        carpark.addBus(18, 150, Vehicle.FuelTypes.PETROL_92, "BB963M",4000000,18);
        carpark.addBus(18, 200, Vehicle.FuelTypes.PETROL_92, "OX612X",5150000,19);

        Bus doubleBus = carpark.addBus(80, 500, Vehicle.FuelTypes.DIESEL, "OO123M",28000000,28);
        doubleBus.setFloorNumbers(2);
        doubleBus.setHasToilet(true);

        carpark.addTaxis(4,1.2, Vehicle.FuelTypes.PETROL_95,"CO857X",1150000,10);
        carpark.addTaxis(6,2.2, Vehicle.FuelTypes.PETROL_92,"TT657X",3150000,14);
        carpark.addTaxis(4,1.6, Vehicle.FuelTypes.PETROL_92,"MB311C",2150000,12);
        carpark.addTaxis(3,1.4, Vehicle.FuelTypes.PETROL_98,"OO999X",4550000,12);
        Taxi cargoTaxi = carpark.addTaxis(2,2.4, Vehicle.FuelTypes.DIESEL,"CC695X",4550000,16);
        cargoTaxi.setCarType(Taxi.CarTypes.PICKUP);
        Taxi luxTaxi = carpark.addTaxis(20,2.0, Vehicle.FuelTypes.PETROL_95,"EE898C",8550000,16);
        luxTaxi.setCarType(Taxi.CarTypes.LIMOUSINE);

        System.out.println("Carpark prise is " + String.format("%.2f", carpark.parkPrise()) + " RUR");
        carpark.printVehiclesFuelConsumption();

        ArrayList<Bus> buses = carpark.getBusesByPassengers(18, 49);

        for(Bus bus: buses) {
            System.out.println("The numberplate of the bus is " + bus.getNumberplate() +
                    " has " + bus.getPassengerNumber() + " passengers" );
        }
    }



}
