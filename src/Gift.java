public class Gift {
    private String nameOfContent;
    private int giftWeight;
    private boolean isReadyToBeDelivered;

    public Gift(String nameOfContent, int giftWeight, boolean isReadyToBeDelivered) {
        this.nameOfContent = nameOfContent;
        this.giftWeight = giftWeight;
        this.isReadyToBeDelivered = isReadyToBeDelivered;
    }

    public void prepare(){
        isReadyToBeDelivered = true;
    }
    public void unpack(){
        isReadyToBeDelivered = false;
        System.out.println("Brawo odpakowany prezent: " + nameOfContent);
    }

    @Override
    public String toString() {
        return "Gift( " + nameOfContent +  " || " + giftWeight + ")";
    }
}
