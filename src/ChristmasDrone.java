public class ChristmasDrone
extends Drone{
    private Gift gift;

    public ChristmasDrone(String droneName, double droneWeight, double enginePower, double batteryLevel, Gift gift) {
        super(droneName, droneWeight, enginePower, batteryLevel);
        this.gift = gift;
    }

    public void deliverGift(){
        if(gift == null || !gift.getIsReadyToBeDelivered() || getDroneWeight() + gift.getGiftWeight() > getEnginePower() ){
            System.out.println("Nie mozna dostarczyc prezentu");
        }
        else{
            System.out.println("Dostarczono prezent " + gift);
            gift = null;
        }
    }

    @Override
    public String toString() {
        return  super.toString() + " - Christmas Drone" ;
    }

}
