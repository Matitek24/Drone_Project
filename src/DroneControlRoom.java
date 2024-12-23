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
        allDrones[allDrones.length-1] = drone;
    }

    public void sortAllDrones(){
        for(int i=0; i<allDrones.length-1; i++){
            if(allDrones[i].getDroneWeight() > allDrones[i+1].getDroneWeight()){

                Drone temp = allDrones[i];
                allDrones[i] = allDrones[i+1];
                allDrones[i+1] = temp;
            }
        }
    }

    public void findMostPowerfulDrones() throws DroneException {
        if (allDrones == null || allDrones.length == 0) {
           throw new DroneException("Nie znaleziona dronów");
        }
        Drone mostPowerful = findMostPowerful2(0, allDrones[0]);
        System.out.println("Najpotężniejszy dron: " + mostPowerful);
    }

    public Drone findMostPowerful2 (int index, Drone currentMax) {
        if (index == allDrones.length) {
            return currentMax;
        }

        if (allDrones[index].getEnginePower() > currentMax.getEnginePower()) {
            currentMax = allDrones[index];
        }
        return findMostPowerful2(++index, currentMax);
    }

}
