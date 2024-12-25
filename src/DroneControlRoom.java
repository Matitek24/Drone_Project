public class DroneControlRoom {
    private Drone[] allDrones;
    private double windPowerOutside;

    public DroneControlRoom(Drone[] allDrones) {
        this.allDrones = allDrones;
    }
    public void countDronesThatCanFly(){
        int count = 0;
        for(Drone drone: allDrones){
            if(drone.getEnginePower() > drone.getDroneWeight() && drone.getBatteryLevel() > 0){
                count++;
            }
        }
        System.out.println(count);
    }

    public void chargeAllDrones(){
        for(Drone drone: allDrones){
            drone.setBatteryLevel(drone.getBatteryLevel()+20);
        }
    }
    public void addNewDrone(Drone drone){

        for (int i = 0; i < allDrones.length; i++) {
            if (allDrones[i] == null) {
                allDrones[i] = drone;
                return;
            }
        }

        Drone[] newDrones = new Drone[allDrones.length + 1];
        for (int i = 0; i < allDrones.length; i++) {
            newDrones[i] = allDrones[i];
        }
        newDrones[allDrones.length] = drone;
        allDrones = newDrones;
    }

    public void sortAllDrones(){
        for (int i = 0; i < allDrones.length - 1; i++) {
            for (int j = 0; j < allDrones.length - i - 1; j++) {
                if (allDrones[j].getDroneWeight() > allDrones[j + 1].getDroneWeight()) {
                    Drone temp = allDrones[j];
                    allDrones[j] = allDrones[j + 1];
                    allDrones[j + 1] = temp;
                }
            }
        }
    }

    public Drone findMostPowerfulDrones() throws DroneException {
        if (allDrones == null || allDrones.length == 0) {
            throw new DroneException("Nie znaleziono dronów");
        }
        return findMostPowerfulDrones(0, allDrones[0]);
    }

    public Drone findMostPowerfulDrones (int index, Drone currentMax) {
        if (index == allDrones.length) {
            return currentMax;
        }

        if (allDrones[index].getEnginePower() > currentMax.getEnginePower()) {
            currentMax = allDrones[index];
        }
        return findMostPowerfulDrones(++index, currentMax);
    }

    @Override
    public String toString() {
        String result = "";
        for (Drone drone: allDrones) {
            result += "\n" + drone;
        }
        return result;
    }
}
