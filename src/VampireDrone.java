public class VampireDrone
extends Drone{

    private final String construcktor = "Bram Stoker";
    private boolean isDoneBat = false;

    public VampireDrone(String droneName, double droneWeight, double enginePower, double batteryLevel) {
        super(droneName, droneWeight, enginePower, batteryLevel);
    }

    public void drainEnergy(Drone drone) {
        if (!isDoneBat) {
            double halfBattery = drone.getBatteryLevel() / 2;
            drone.setBatteryLevel(drone.getBatteryLevel() - halfBattery);
            setBatteryLevel(getBatteryLevel() + halfBattery);
            System.out.println("Poziom baterii drona: " + getBatteryLevel());
        } else {
            System.out.println("Nie można wyssać energii");
        }
    }

    public void turnIntoBatDrone(){
        if(!isDoneBat){
            isDoneBat = true;
            setBatteryLevel(getBatteryLevel() / 2);
            setDroneWeight(getDroneWeight() / 2);
            System.out.println("Przekształcony w bat Drone");
        }
    }

}
