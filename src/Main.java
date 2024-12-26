public class Main {
    public static void main(String[] args) {


        // INICIALIZE FIRST DRONE AND ARRAY

    Drone firstDrone = new Drone("Krzyś",
            34,
            13.2,
            33.2);

    Drone[] droneArray = {
            new Drone("Robert", 33, 34.2,333.2),
            new Drone("Alan", 12, 321.2,313.2),
            new Drone("Maja", 7, 24.2,233.2),
            new Drone("Krzysztof", 345, 111.2,933)
    };
    droneArray[3].fly(12.3);

        DroneControlRoom FirstRoom = new DroneControlRoom(droneArray);
        FirstRoom.addNewDrone(firstDrone);
// ---------------------------------------------------- CHRISTMAS DRONE
        printSectionHeader("CHRISMTAS DRONE");

        ChristmasDrone SantaDrone = new ChristmasDrone(
                "Santa Drone",
                142.3,
                212,
                60,
                new Gift("Miś",
                        22,
                        true)
        );
        System.out.println(firstDrone.checkFlyParameter() ? "Gotowy do lotu": "Nie mozna lecieć");
        SantaDrone.setBatteryLevel(515.5);
        FirstRoom.addNewDrone(SantaDrone);

        SantaDrone.deliverGift();
        SantaDrone.fly(52.3);

        // ---------------------------------------------------- RACING DRON
        printSectionHeader( "RACING DRONE");

        RacingDrone[] racingDrones = {
                new RacingDrone("Olek", 18.5, 150.0, 410, "Speedster", 2),
                new RacingDrone("Maja", 22.0, 135.5, 450, "Thunderbird", 7),
                new RacingDrone("Kuba", 19.8, 170.0, 321, "Lightning", 4)
        };
        RacingDrone racingDrone = new RacingDrone("Ala", 20.2, 42.3, 431, "Szefy");

        for (RacingDrone rd : racingDrones) {
            FirstRoom.addNewDrone(rd);
        }

        Drone fastestDrone = racingDrones[0];
       for (int i = 0; i < racingDrones.length; i++) {
           fastestDrone = racingDrones[i].race(racingDrones);
       }
        System.out.println( "Najszybszy dron: " + fastestDrone);

        try{
            racingDrone.revEngine();
        }
        catch(DroneException e){
            System.out.println(e);
        }

        RacingDrone[] ranking = racingDrone.sortByPosition(racingDrones);
                for(Drone d : ranking){
                    System.out.println(d);
                }
        racingDrones[1].fly(333.3);
        // ---------------------------------------------------- VAMPIRE DRONE
        printSectionHeader( "VAMPIRE DRONE");
                VampireDrone vampireDrone = new VampireDrone("BadBat", 34,312.3,300, false);
                vampireDrone.drainEnergy(firstDrone);
                vampireDrone.turnIntoBatDrone();
                FirstRoom.addNewDrone(vampireDrone);
        // ---------------------------------------------------- EXPLORATION DRONE
        printSectionHeader( "EXPLORATION DRONE");

        Map[] points = {
                new Map("PointA", "Znaleziono minerały", false),
                new Map("PointB", "Obszar niebezpieczny", true),
                new Map("PointC", "Potencjalne surowce", false),
                new Map("PointD", "Nowe odkrycia", false),
                new Map("PointE", "Zloze Diamentów", false)
        };

        ExplorationDrone expDrone = new ExplorationDrone(
                "ExplorerX",
                10.0,
                25.0,
                100.0,
                30.0,
                points);
        FirstRoom.addNewDrone(expDrone);
        ExplorationDrone expDroneBoss = new ExplorationDrone(
                "BossExplore",
                120.0,
                334.0,
                230.0,
                points);
        FirstRoom.addNewDrone(expDroneBoss);
        expDrone.fly(31);
        expDroneBoss.fly(76.7);
        System.out.println("\nEksploracja punktów:");
        expDrone.explore(0, 10.0); // Punkt A
        expDrone.explore(3, 20.0); // Punkt D
        expDrone.explore(1, 15.0); // Punkt B
        expDrone.explore(4, 100.0); // Punkt E

        System.out.println("\nNieodkryte punkty:");
        expDrone.UndiscoveredPoints(0);

        System.out.println("\nŁadowanie baterii:");
        expDrone.fastPowerCharge();

        System.out.println("\nStan drona po eksploracji:");
        System.out.println(expDrone.presentCheckPoints());


    // ---------------------------------------------------- DRONE BASE
        System.out.print("\u001B[31m |>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>| \n");
        System.out.print("\t\t\t Baza Dronów");
        FirstRoom.sortAllDrones();
        System.out.print(FirstRoom + "\n\n");
        try{
            System.out.println("Najmocniejszy Dron " + FirstRoom.findMostPowerfulDrones());
        } catch (DroneException ex) {
            System.out.println(ex);
        }
        System.out.print("Drony gotowe do lotów: ");
        System.out.println(FirstRoom.countDronesThatCanFly());;
        FirstRoom.chargeAllDrones();
        System.out.print("\u001B[31m |>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>|  \u001B[0m \n");
    }

    public static void printSectionHeader(String sectionName) {
        System.out.print("\u001B[31m |>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>| \n");
        System.out.println("\t\t\t " + sectionName);
        System.out.print(" |>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>=>|  \u001B[0m \n");
    }
}

