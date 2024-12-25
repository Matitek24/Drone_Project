public class ExplorationDrone
extends Drone{

    private double range;
    private int pointCheck;
    public Map[] points;
    public String[][] checkPoints;

    public ExplorationDrone(String droneName, double droneWeight, double enginePower, double batteryLevel, double range, Map[] pointMap) {
        super(droneName, droneWeight, enginePower, batteryLevel);
        this.range = range;
        this.pointCheck = 0;
        this.points = pointMap;
        this.checkPoints = new String[points.length][2];
    }

    public void explore(int index, double distance){
        String name = points[index].getNamePoint();

        if(getBatteryLevel() < distance && range < distance){
            System.out.println(name + " Nie moze lecieć" );
        }
        else{
            setBatteryLevel(getBatteryLevel() - distance);
            String data = collectData(index);
            addPoint(name, data);
            System.out.println("Super zdobyłeś punkt " + name);

        }

    }
    public void addPoint(String name, String data){
        checkPoints[pointCheck][0] = name;
        checkPoints[pointCheck][1] = data;
        pointCheck++;
    }

    public String collectData(int index){
        String data = "Nie udało się pobrać danych";
        if(!points[index].isDangerous()){
            data = points[index].getDataInPoint();
        }
            points[index].markSafe();
           return data;
    }
    public void fastPowerCharge(){
        System.out.println("Bateria jest na poziomie " + getBatteryLevel() + " Odpalono szybkie ładowanie");
        setBatteryLevel(getBatteryLevel() + 10);
    }

    public void UndiscoveredPoints(int index) {
      if(index >= points.length){
          return;
      }

      boolean isDiscovered = false;

      for(int i = 0; i < pointCheck; i++){
          if(checkPoints[i][0] != null && checkPoints[i][0].equals(points[index].getNamePoint())){
              isDiscovered = true;
              break;
          }
      }

      if(!isDiscovered){
          System.out.println("Nieodkryty punkt to jeszcze " + points[index].getNamePoint());
      }

      UndiscoveredPoints(index + 1);

    }

    @Override
    public String toString() {
        String result = super.toString() + "\nZdobył punkty ";
        for (int i = 0; i < checkPoints.length; i++) {
            for (int j = 0; j < checkPoints[i].length; j++) {
                if(checkPoints[i][j] != null){
                    result += checkPoints[i][j] + "\n";
                }
            }
        }
        return result;
    }

}
