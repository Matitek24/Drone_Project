public class Drone {
    private static int counter = 1;
    private final String uniqueId;
    private String droneName;
    private double droneWeight;
    private double enginePower;
    private double batteryLevel;

    public Drone(String droneName, double droneWeight, double enginePower, double batteryLevel) {
        this.uniqueId = "Drone" + counter++;
        this.droneName = droneName;
        this.droneWeight = droneWeight;
        this.enginePower = enginePower;
        this.batteryLevel = batteryLevel;
    }

    public boolean checkFlyParameter(){
        return enginePower > batteryLevel && enginePower > droneWeight;
    }

    public void fly(double distance){
        if (distance <= 0) {
            System.out.println("Dystans musi być większy niż 0");
            return;
        }
        if(batteryLevel > distance){
            batteryLevel -= distance;
            System.out.println("Udalo sie polecieć ");
        }
        else{
            System.out.println(droneName + " Nie mozemy lecieć bo nie mamy wystarczającą ilość baterii");
        }
    }
    public void revEngine() throws DroneException {
        if (droneWeight == 0) {
            throw new DroneException("Waga drona nie moze być równa 0");
        }
        if (enginePower <= 0) {
            throw new DroneException("Moc silnika musi być większa od 0");
        }

        int limit = (int) (enginePower / droneWeight);

        for (int i = 0; i < limit; i++) {
            System.out.print("Vroom ");
        }
        System.out.println();
    }


    @Override
    public String toString() {
        return "\u001B[36m Drone{ " + " \u001B[0m" +
                "\u001B[32m uniqueId='" + uniqueId + '\'' +
                ", name='" + droneName + '\'' +
                ", weight=" + droneWeight +
                ", enginePower=" + enginePower +
                ", batteryLevel=" + batteryLevel + " \u001B[0m" + "\u001B[36m } \u001B[0m";
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
