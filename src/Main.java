public class Main {
    public static void main(String[] args) {
    Drone firstDrone = new Drone("Krzyś",
            34,
            13.2,
            33.2);
        System.out.println(firstDrone.checkFlyParameter() ? "Gotowy do lotu": "Nie mozna lecieć");


    Drone[] droneArray = {
            new Drone("Robert", 33, 34.2,333.2),
            new Drone("Alan", 12, 321.2,313.2),
            new Drone("Maja", 7, 24.2,233.2),
            new Drone("Krzysztof", 345, 111.2,933.2)
    };

    RacingDrone racingDrone = new RacingDrone(
            "Ala",
            20.2,
            42.3,
            431,
            "Robertosy",
            1);

        Drone fastestDrone = racingDrone.race(droneArray);
        System.out.println("Najszybszy dron: " + fastestDrone);

        try{
            racingDrone.revEngine();
        }
        catch(Exception e){
            System.out.println(e);
        }

        System.out.println("=========================");

        // Tworzymy punkty eksploracji
        Map[] points = {
                new Map("PointA", "Znaleziono minerały", false),
                new Map("PointB", "Obszar niebezpieczny", true),
                new Map("PointC", "Potencjalne surowce", false),
                new Map("PointD", "Nowe odkrycia", false)
        };

        // Tworzymy drona eksploracyjnego
        ExplorationDrone drone2 = new ExplorationDrone("ExplorerX", 10.0, 25.0, 50.0, 30.0, points);

        // Eksploracja niektórych punktów
        System.out.println("\nEksploracja punktów:");
        drone2.explore(0, 10.0); // Punkt A
        drone2.explore(3, 20.0); // Punkt D
        drone2.explore(1, 15.0); // Punkt B (niebezpieczny, nie będzie danych)

        // Wyświetlenie nieodkrytych punktów za pomocą metody rekurencyjnej
        System.out.println("\nNieodkryte punkty:");
        drone2.printUndiscoveredPoints(0);

        // Naładowanie baterii drona
        System.out.println("\nŁadowanie baterii:");
        drone2.fastPowerCharge();

        // Wyświetlenie stanu drona po eksploracji
        System.out.println("\nStan drona po eksploracji:");
        System.out.println(drone2);
    }
}

