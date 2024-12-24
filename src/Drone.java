public class Drone {
    private final String uniqueId;
    private String droneName;
    private double droneWeight;
    private double enginePower;
    private double batteryLevel;
    private int counter;

    public Drone(String droneName, double droneWeight, double enginePower, double batteryLevel) {
        this.uniqueId = "Drone " + counter++;
        this.droneName = droneName;
        this.droneWeight = droneWeight;
        this.enginePower = enginePower;
        this.batteryLevel = batteryLevel;
    }

    public boolean checkFlyParameter(){
        boolean check = false;
        if(enginePower > batteryLevel && enginePower > droneWeight){
            check = true;
        }
        return check;
    }

    public void fly(double distance){
        if(batteryLevel > distance){
            batteryLevel -= distance;
        }
        else{
            System.out.println(droneName + "Nie mozemy lecieć bo nie mamy wystarczającą ilość baterii");
        }
    }
    public void revEngine() throws DroneWeightException{
        if (droneWeight == 0) {
            throw new DroneWeightException("Waga drona nie moze być równa 0");
        }

        int limit = (int) (enginePower / droneWeight);

        for (int i = 0; i < limit; i++) {
            System.out.print("Vroom ");
        }
        System.out.println();
    }


    @Override
    public String toString() {
        return "Drone{ " +
                "uniqueId='" + uniqueId + '\'' +
                ", name='" + droneName + '\'' +
                ", weight=" + droneWeight +
                ", enginePower=" + enginePower +
                ", batteryLevel=" + batteryLevel +
                '}';
    }

    // Gettery

    public double getEnginePower() {
        return enginePower;
    }
    public double getBatteryLevel(){
        return batteryLevel;
    }
    public double getDroneWeight() {
        return droneWeight;
    }

    // Settery

    public void setBatteryLevel(double batteryLevel) {
        this.batteryLevel = batteryLevel;
    }
    public void setDroneWeight(double droneWeight) {
        this.droneWeight = droneWeight;
    }
}
