public class RacingDrone
extends Drone{
    private String racingTeam;
    private int positionInRanking;

    // Tutaj ciekawą rzeczą jest przeciązenie kostrukotra jest to przydatne do elastycznosci danych ktore moze podac uzytkownik.
    public RacingDrone(String droneName, double droneWeight, double enginePower, double batteryLevel ,String racingTeam, int positionInRacing) {
        super(droneName, droneWeight, enginePower, batteryLevel);
        this.racingTeam = racingTeam;
        this.positionInRanking = positionInRacing;
    }
    public RacingDrone(String droneName, double droneWeight, double enginePower, double batteryLevel ,String racingTeam) {
        super(droneName, droneWeight, enginePower, batteryLevel);
        this.racingTeam = racingTeam;
    }

    public Drone race(Drone[] racers){
        Drone drone = racers[0];
        for(Drone dr: racers){
            if(dr.getEnginePower() > drone.getEnginePower()){
                drone = dr;
            }
        }
        return drone;
    }
    @Override
    public void revEngine() throws DroneException {
       super.revEngine();
        System.out.println("ZOOOOOOOOOM");
    }

    public RacingDrone[] sortByPosition(RacingDrone[] racingDrone) {
        for (int i = 0; i < racingDrone.length - 1; i++) {
            for (int j = 0; j < racingDrone.length - i - 1; j++) {
                if (racingDrone[j].positionInRanking > racingDrone[j + 1].positionInRanking ||
                        (racingDrone[j].positionInRanking == racingDrone[j + 1].positionInRanking &&
                                racingDrone[j].getEnginePower() < racingDrone[j + 1].getEnginePower())) {

                    RacingDrone temp = racingDrone[j];
                    racingDrone[j] = racingDrone[j + 1];
                    racingDrone[j + 1] = temp;
                }
            }
        }
        return racingDrone;
    }

    @Override
    public String toString(){
        return super.toString() + ", Team " + racingTeam +
                ", Pozycja w rankingu " + positionInRanking + " - Drone Wyscigowy";
    }

}
