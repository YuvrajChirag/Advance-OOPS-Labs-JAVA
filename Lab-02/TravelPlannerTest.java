package Lab_02;

import java.util.List;

public class TravelPlannerTest {

    public static void main(String[] args) {

        City ny = new City("New York", "USA", "EST");
        City london = new City("London", "UK", "GMT");
        City paris = new City("Paris", "France", "CET");
        City tokyo = new City("Tokyo", "Japan", "JST");
        City singapore = new City("Singapore", "Singapore", "SGT");
        City dubai = new City("Dubai", "UAE", "GST");
        City delhi = new City("Delhi", "India", "IST");
        City sydney = new City("Sydney", "Australia", "AEST");

        TravelGraph graph = new TravelGraph();

        // Add cities
        graph.addCity(ny);
        graph.addCity(london);
        graph.addCity(paris);
        graph.addCity(tokyo);
        graph.addCity(singapore);
        graph.addCity(dubai);
        graph.addCity(delhi);
        graph.addCity(sydney);

        // Add connections
        graph.addConnection(ny, london);
        graph.addConnection(london, paris);
        graph.addConnection(ny, tokyo);
        graph.addConnection(tokyo, singapore);
        graph.addConnection(singapore, dubai);
        graph.addConnection(paris, delhi);
        graph.addConnection(delhi, dubai);

        // DFS
        List<City> dfsPath = graph.findPath(ny, dubai);

        System.out.println("DFS Route:");
        for (City c : dfsPath) {
            System.out.print(c.getName() + " -> ");
        }

        // BFS
        System.out.println("\n\nBFS Route:");
        List<City> bfsPath = graph.findPathBFS(ny, dubai);

        for (City c : bfsPath) {
            System.out.print(c.getName() + " -> ");
        }
    }
}