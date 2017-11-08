package com.senla.hotel.comparators;

import com.senla.hotel.entity.Room;
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
    private Comparator<Room> busyComparator = (Room room, Room room1) -> {
        int busy = 0;
        if (room != null) {
            busy = room.getBusy().compareTo(room1.getBusy());
        }
        return busy;

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

    public Comparator<Room> getBusyComparator() {
        return busyComparator;
    }

    public Comparator<Room> getCapacityComparator() {
        return capacityComparator;
    }

    public Comparator<Room> getNumberStarsComparator() {
        return numberStarsComparator;
    }
}
