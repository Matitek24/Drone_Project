public class Drone {
    public final String uniqueId;
    public String droneName;
    public double droneWeight;
    public double enginePower;
    public double batteryLevel;
    public static int counter;

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
    public void revEngine(){
        if (droneWeight == 0) {
            throw new IllegalArgumentException("Waga drona nie moze być równa 0");
        }

        int limit = (int) (enginePower / droneWeight);

        for (int i = 0; i < limit; i++) {
            System.out.print("Vroom ");
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "Drone{" +
                "uniqueId='" + uniqueId + '\'' +
                ", name='" + droneName + '\'' +
                ", weight=" + droneWeight +
                ", enginePower=" + enginePower +
                ", batteryLevel=" + batteryLevel +
                '}';
    }
}
