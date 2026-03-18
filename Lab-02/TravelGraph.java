package Lab_02;

import java.util.*;

public class TravelGraph {

    private final Map<City, List<City>> graph = new HashMap<>();

    public void addCity(City city) {
        graph.putIfAbsent(city, new ArrayList<>());
    }

    public void addConnection(City from, City to) {
        if (!graph.containsKey(from) || !graph.containsKey(to)) {
            throw new IllegalArgumentException("City not found in graph");
        }
        graph.get(from).add(to);
    }

    // DFS using Stack
    public List<City> findPath(City start, City destination) {

        if (start == null || destination == null) {
            throw new IllegalArgumentException("Null cities not allowed");
        }

        if (!graph.containsKey(start) || !graph.containsKey(destination)) {
            throw new IllegalArgumentException("City not in graph");
        }

        Stack<City> stack = new Stack<>();
        Set<City> visited = new HashSet<>();
        Map<City, City> parent = new HashMap<>();

        stack.push(start);
        visited.add(start);

        while (!stack.isEmpty()) {
            City current = stack.pop();

            if (current.equals(destination)) {
                return buildPath(parent, start, destination);
            }

            for (City neighbor : graph.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parent.put(neighbor, current);
                    stack.push(neighbor);
                }
            }
        }

        return new ArrayList<>();
    }

    private List<City> buildPath(Map<City, City> parent, City start, City dest) {
        List<City> path = new ArrayList<>();

        for (City at = dest; at != null; at = parent.get(at)) {
            path.add(at);
        }

        Collections.reverse(path);
        return path;
    }

    // BONUS: BFS
    public List<City> findPathBFS(City start, City destination) {

        Queue<City> queue = new LinkedList<>();
        Set<City> visited = new HashSet<>();
        Map<City, City> parent = new HashMap<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            City current = queue.poll();

            if (current.equals(destination)) {
                return buildPath(parent, start, destination);
            }

            for (City neighbor : graph.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parent.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        return new ArrayList<>();
    }
}