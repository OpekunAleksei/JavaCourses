package com.senla.hotel.comparators;

import com.senla.hotel.entity.Guest;
import java.util.Comparator;

public class GuestComparator {

    private Comparator<Guest> nameComparator = new Comparator<Guest>() {
        @Override
        public int compare(Guest guest, Guest guest1) {
            int name = 0;
            if (guest != null) {
                name = guest.getName().compareTo(guest1.getName());
            }
            return name;
        }
    };

    private Comparator<Guest> dateComparator = new Comparator<Guest>() {
        @Override
        public int compare(Guest guest, Guest guest1) {
            int date = 0;
            if (guest != null) {
                date = guest.getDateOfDeparture().compareTo(guest1.getDateOfDeparture());
            }
            return date;
        }
    };

    public Comparator<Guest> getNameComparator() {
        return nameComparator;
    }

    public Comparator<Guest> getDateComparator() {
        return dateComparator;
    }
}
