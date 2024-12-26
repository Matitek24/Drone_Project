# Drone for Every Occasion

## Overview
This project features a modular drone system implemented in Java, with various types of drones tailored for specific scenarios. The main classes include core functionality and extensions for specialized drones.

## Classes and Functionality

### `Drone`
- **Fields**: `uniqueId`, `name`, `weight`, `enginePower`, `batteryLevel`
- **Methods**:
  - `checkFlyParameters()`: Returns true if the drone can fly based on its parameters.
  - `fly(distance)`: Simulates a flight and reduces `batteryLevel`.
  - `revEngine()`: Prints "Vroom" based on engine power.

### `RacingDrone`
- **Fields**: `racingTeam`, `positionInRanking`
- **Methods**:
  - `race(Drone[] racers)`: Finds the drone with the highest `enginePower`.
  - `revEngine()`: Adds "ZOOOOOM" to the engine rev output.
  - `sortByPosition(RacingDrone[])`: Sorts drones by ranking and `enginePower`.

### `VampireDrone`
- **Fields**: `construcktor`, `isDoneBat`
- **Methods**:
  - `drainEnergy(Drone)`: Transfers energy from another drone.
  - `turnIntoBatDrone()`: Halves battery and weight, marking it as a bat drone.

### `ChristmasDrone`
- **Fields**: `Gift gift`
- **Methods**:
  - `deliverGift()`: Delivers a gift if conditions are met.

### `Gift`
- **Fields**: `nameOfContent`, `weight`, `isReadyToBeDelivered`
- **Methods**:
  - `prepare()`: Marks the gift as ready.
  - `unpack()`: Displays contents and marks as not ready.

### `DroneControlRoom`
- **Fields**: `Drone[] allDrones`, `windPowerOutside`
- **Methods**:
  - `countDronesThatCanFly()`: Counts drones ready to fly.
  - `chargeAllDrones()`: Adds battery to all drones.
  - `addNewDrone(Drone)`: Dynamically expands the array to add a new drone.
  - `sortAllDrones()`: Sorts drones by weight.
  - `findMostPowerful()`: Recursively finds the most powerful drone.

### `ExplorationDrone`
- **Fields**: `range`, `pointCheck`, `points`, `checkPoints`
- **Methods**:
  - `explore(int index, double distance)`: Simulates exploration of a map point.
  - `collectData(int index)`: Gathers data from points.
  - `UndiscoveredPoints(int index)`: Recursively lists undiscovered points.
  - `presentCheckPoints()`: Displays visited checkpoints.

