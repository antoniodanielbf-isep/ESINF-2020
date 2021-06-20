package graphexamples;

import graph.AdjacencyMatrixGraph;
import graph.GraphAlgorithms;

import java.util.LinkedList;
import java.util.Objects;

/**
 * A class to represent a labyrinth map with rooms, doors and exits
 * Methods discover the nearest exit and the path to it
 * Stores a graph of private Room vertex and Door edges
 *
 * @author DEI-ESINF
 */
public class LabyrinthCheater {

    AdjacencyMatrixGraph<Room, Door> map;

    public LabyrinthCheater() {
        map = new AdjacencyMatrixGraph<Room, Door>();
    }

    /**
     * Inserts a new room in the map
     *
     * @param name
     * @return false if city exists in the map
     */
    public boolean insertRoom(String name, boolean hasExit) {
        Room room = new Room(name, hasExit);
        return map.insertVertex(room);
    }

    /**
     * Inserts a new door in the map
     * fails if room does not exist or door already exists
     *
     * @param from room
     * @param to   room
     * @return false if a room does not exist or door already exists between rooms
     */
    public boolean insertDoor(String from, String to) {
        return map.insertEdge(new Room(from), new Room(to), new Door());
    }

    /**
     * Returns a list of rooms which are reachable from one room
     *
     * @param room
     * @return list of room names or null if room does not exist
     */
    public Iterable<String> roomsInReach(String room, boolean hasExit) {
        LinkedList<Room> reachableRooms = GraphAlgorithms.BFS(map, new Room(room));
        LinkedList<String> reachableRoomsString = new LinkedList<>();
        for (Room r : reachableRooms) {
            reachableRoomsString.add(r.getName());
        }
        return reachableRoomsString;
    }

    /**
     * Returns the nearest room with an exit
     *
     * @param room from room
     * @return room name or null if from room does not exist or there is no reachable exit
     */
    public String nearestExit(String room) {
        if (!map.checkVertex(new Room(room))) return null;

        LinkedList<Room> roomsInReach = GraphAlgorithms.BFS(map, new Room(room, false));
        for (Room r : roomsInReach) {
            if (r.hasExit) return r.getName();
        }
        return null;
    }


    private class Room {
        private String name;
        private boolean hasExit;

        public Room(String name, boolean hasExit) {
            this.name = name;
            this.hasExit = hasExit;
        }

        public Room(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isHasExit() {
            return hasExit;
        }

        public void setHasExit(boolean hasExit) {
            this.hasExit = hasExit;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Room room = (Room) o;
            return Objects.equals(name, room.name);
        }
    }

    private class Door {
    }


}
