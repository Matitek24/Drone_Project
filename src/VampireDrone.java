public class VampireDrone
extends Drone{

    private final String construcktor = "Bram Stoker";
    private boolean isDoneBat;

    public VampireDrone(String droneName, double droneWeight, double enginePower, double batteryLevel, boolean isDoneBat) {
        super(droneName, droneWeight, enginePower, batteryLevel);
        this.isDoneBat = isDoneBat;
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
            System.out.println("Przekształcenie powiodło się");
        }
    }

    @Override
    public String toString() {
        return  super.toString() + " - Vampire Drone " + "Construckotor " +  construcktor;
    }

}
