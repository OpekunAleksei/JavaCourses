/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.grsy.ftf.lesson4task1.comparator;

import by.grsy.ftf.lesson4task1.entity.Room;
import java.util.Comparator;

public class RoomComparator {

    private Comparator<Room> priceComparator = new Comparator<Room>() {
        @Override
        public int compare(Room room, Room room1) {
            int price = 0;
            if (room != null) {
                price = room.getPrice().compareTo(room1.getPrice());
            }
            return price;
        }
    };
    private Comparator<Room> capacityComparator = (Room room, Room room1) -> {
        int capacity = 0;
        if (room != null) {
            capacity = room.getCapacity().compareTo(room1.getCapacity());
        }
        return capacity;

    };

    private Comparator<Room> numberStarsComparator = new Comparator<Room>() {
        @Override
        public int compare(Room room, Room room1) {
            int numberStars = 0;
            if (room != null) {
                numberStars = room.getNumberOfStars().compareTo(room1.getNumberOfStars());
            }
            return numberStars;

        }
    };

    public Comparator<Room> getPriceComparator() {
        return priceComparator;
    }

    public Comparator<Room> getCapacityComparator() {
        return capacityComparator;
    }
    public Comparator<Room> getNumberStarsComparator() {
        return numberStarsComparator;
    }
}
