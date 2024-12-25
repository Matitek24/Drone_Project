public class Map {
    private String namePoint;
    private String dataInPoint;
    private boolean isDangerous;

    public Map(String namePoint, String dataInPoint, boolean isDangerous) {
        this.namePoint = namePoint;
        this.dataInPoint = dataInPoint;
        this.isDangerous = isDangerous;
    }

    public String getNamePoint() {
        return namePoint;
    }

    public String getDataInPoint() {
        return dataInPoint;
    }

    public boolean isDangerous() {
        return isDangerous;
    }

    public void markSafe() {
        isDangerous = false;
        System.out.println(namePoint + " został oznaczony jako bezpieczny.");
    }

    @Override
    public String toString() {
        return "Nazwa punktu " + namePoint + " DANE: " + dataInPoint + " Czy punkt jest groźny " + isDangerous;
    }
}
