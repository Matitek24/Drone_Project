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

    }
}

