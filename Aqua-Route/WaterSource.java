public class WaterSource {

    private int sourceId;
    private String sourceName;
    private int capacity;

    public WaterSource(int sourceId, String sourceName,
                       int capacity) {
        this.sourceId = sourceId;
        this.sourceName = sourceName;
        this.capacity = capacity;
    }

    public int getSourceId() {
        return sourceId;
    }

    public String getSourceName() {
        return sourceName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void displaySource() {
        System.out.println(
            "Tanker ID: " + sourceId +
            " | Name: " + sourceName +
            " | Capacity: " + capacity + " litres"
        );
    }
}