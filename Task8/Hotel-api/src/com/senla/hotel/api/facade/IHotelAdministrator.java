/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.api.facade;

import com.senla.hotel.enums.RoomStatus;

public interface IHotelAdministrator {

    public String getGuestPriceForAccommodation(Integer guestId, Integer numberRoom);

    public void changeNumberOfStars(Integer numberOfRoom, Integer numberOfStars);

    public void changeCapacity(Integer numberOfRoom, Integer capacity);

    public void writeData();

    public void createRoom(Integer number, Integer price, Integer capacity, Integer numberOfStars, Integer id, RoomStatus status);

    public void copyRoom(Integer numberOfRoom, Integer newId, Integer newNumber);

    public void createGuest(String name, String arrivalDate, String dateOfDeparture, Integer id);

    public void importRooms();

    public void exportRooms();

    public void importServices();

    public void exportServices();

    public void importGuests();

    public void exportGuests();

    public Integer getGuestIdByNumberOnList(Integer number);

    public Integer getRoomNumberByNumberOnList(Integer number);

    public Integer getServiceIdByNumberOnList(Integer number);

    public void createService(Integer price, String category, Integer id);

    public void changeRoomPrice(Integer numberOfRoom, Integer price);

    public void changeServicePrice(Integer serviceId, Integer price);

    public String getListOfRoomsAvailableByDate(String date);

    public void changeRoomStatus(Integer numberOfRoom, RoomStatus status);

    public void addServiceToGuest(Integer serviceId, Integer guestId, Integer numberRoom);

    public void settleInRoom(Integer guestId, Integer numberOfRoom);

    public void evictedFromRoom(Integer guestId, Integer numberOfRoom);

    public String getNumberGuestInHotel();

    public String getNumberEmptyRoomInHotel();

    public String getListOfServices();

    public String getListLeftGuestThisRoom(Integer numberOfRoom);

    public String getDetailsOfRoom(Integer numberOfRoom);

    public String getSortRoomsByCapacity();

    public String getSortRoomsByPrice();

    public String getSortRoomsByNumberOfStars();

    public String getSortEmptyRoomsByCapacity();

    public String getSortEmptyRoomsByPrice();

    public String getSortEmptyRoomsByNumberOfStars();

    public String getSortGuestByDateOfDeparture();

    public String getSortListServiceGuestByPrice(Integer guestId, Integer numberRoom);

    public String getSortListServiceGuestByCategory(Integer guestId, Integer numberRoom);

    public String getSortGuestByName();

    public Boolean getRoomAbility();
}
