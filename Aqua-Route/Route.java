public class Route {

    private String area;
    private int tankerId;
    private String priority;
    private int litresSupplied;

    public Route(String area, int tankerId,
                 String priority, int litresSupplied) {

        this.area = area;
        this.tankerId = tankerId;
        this.priority = priority;
        this.litresSupplied = litresSupplied;
    }

    public String getArea() {
        return area;
    }

    public int getTankerId() {
        return tankerId;
    }

    public String getPriority() {
        return priority;
    }

    public int getLitresSupplied() {
        return litresSupplied;
    }

    public void displayRoute() {
        System.out.println(
            "Area: " + area +
            " | Tanker: " + tankerId +
            " | Priority: " + priority +
            " | Supplied: " + litresSupplied + " litres"
        );
    }
}