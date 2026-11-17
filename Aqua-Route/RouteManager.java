import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class RouteManager {

    // Inner class to store water requests
    private static class WaterRequest {

        int requestId;
        String area;
        int litres;
        int remainingLitres;
        String priority;

        WaterRequest(int requestId, String area,
                     int litres, String priority) {

            this.requestId = requestId;
            this.area = area;
            this.litres = litres;
            this.remainingLitres = litres;
            this.priority = priority;
        }
    }

    private ArrayList<WaterRequest> requests;
    private ArrayList<WaterSource> sources;
    private ArrayList<Route> routes;

    private int requestCounter = 1;
    private int sourceCounter = 1;

    public RouteManager() {

        requests = new ArrayList<>();
        sources = new ArrayList<>();
        routes = new ArrayList<>();
    }

    // Register water request
    public void addRequest(String area, int litres,
                           String priority) {

        WaterRequest request = new WaterRequest(
            requestCounter++, area, litres, priority
        );

        requests.add(request);

        System.out.println("Water request registered successfully!");
    }

    // Register tanker
    public void addWaterSource(String name, int capacity) {

        WaterSource source = new WaterSource(
            sourceCounter++, name, capacity
        );

        sources.add(source);

        System.out.println("Water tanker registered successfully!");
    }

    // Display all requests
    public void displayRequests() {

        System.out.println("\n--- WATER REQUESTS ---");

        boolean found = false;

        for (WaterRequest request : requests) {

            if (request.remainingLitres > 0) {

                System.out.println(
                    "Request ID: " + request.requestId +
                    " | Area: " + request.area +
                    " | Required: " + request.litres +
                    " litres" +
                    " | Remaining: " + request.remainingLitres +
                    " litres" +
                    " | Priority: " + request.priority
                );

                found = true;
            }
        }

        if (!found) {
            System.out.println("No pending requests.");
        }
    }

    // Display available tankers
    public void displaySources() {

        System.out.println("\n--- AVAILABLE TANKERS ---");

        if (sources.isEmpty()) {
            System.out.println("No tankers registered.");
            return;
        }

        for (WaterSource source : sources) {
            source.displaySource();
        }
    }

    // Priority ranking
    private int getPriority(String priority) {

        switch (priority.toLowerCase()) {

            case "hospital":
                return 1;

            case "school":
                return 2;

            case "residential":
                return 3;

            default:
                return 4;
        }
    }

    // Schedule water supply
    public void scheduleRoutes() {

        if (requests.isEmpty()) {
            System.out.println("No water requests available.");
            return;
        }

        if (sources.isEmpty()) {
            System.out.println("No tankers available.");
            return;
        }

        // Sort requests according to priority
        requests.sort(
            Comparator.comparingInt(
                r -> getPriority(r.priority)
            )
        );

        System.out.println("\n--- WATER SUPPLY SCHEDULE ---");

        boolean supplied = false;

        for (WaterSource source : sources) {

            int available = source.getCapacity();

            System.out.println(
                "\nTanker: " + source.getSourceName()
            );

            for (WaterRequest request : requests) {

                if (available <= 0) {
                    break;
                }

                if (request.remainingLitres <= 0) {
                    continue;
                }

                int amount = Math.min(
                    available,
                    request.remainingLitres
                );

                request.remainingLitres -= amount;
                available -= amount;

                Route route = new Route(
                    request.area,
                    source.getSourceId(),
                    request.priority,
                    amount
                );

                routes.add(route);

                route.displayRoute();

                supplied = true;
            }
        }

        if (!supplied) {
            System.out.println("No pending requests to serve.");
        }

        System.out.println("\nScheduling completed.");
        System.out.println(
            "Unserved water requests will be carried forward."
        );
    }

    // Generate area-wise report
    public void generateReport() {

        if (routes.isEmpty()) {
            System.out.println("No water supply records available.");
            return;
        }

        Map<String, Integer> report = new TreeMap<>();

        for (Route route : routes) {

            report.put(
                route.getArea(),
                report.getOrDefault(route.getArea(), 0)
                + route.getLitresSupplied()
            );
        }

        System.out.println("\n--- AREA-WISE WATER SUPPLY REPORT ---");

        for (Map.Entry<String, Integer> entry :
             report.entrySet()) {

            System.out.println(
                "Area: " + entry.getKey() +
                " | Water supplied: " +
                entry.getValue() + " litres"
            );
        }
    }
}