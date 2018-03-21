/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.api.facade;

import com.senla.hotel.entity.Client;

public interface IHotelAdministrator {

    public Client getClient(String login, String password);

    public void signOut(Client client, String information);

    public void signIn(String login, String password, String token, String information);

    public void registerUser(String login, String password, String information);

    public String getGuestPriceForAccommodation(Integer guestId, Integer numberRoom, String information);

    public void changeNumberOfStars(Integer numberOfRoom, Integer numberOfStars, String information);

    public void changeCapacity(Integer numberOfRoom, Integer capacity, String information);

    public void createRoom(Integer number, Integer price, Integer capacity, Integer numberOfStars, String status, String information);

    public void copyRoom(Integer numberOfRoom, Integer newNumber, String information);

    public void createGuest(String name, String arrivalDate, String dateOfDeparture, String information);

    public void importRooms(String information);

    public void exportRooms(String information);

    public void importServices(String information);

    public void exportServices(String information);

    public void importGuests(String information);

    public void exportGuests(String information);

    public Integer getGuestIdByNumberOnList(Integer number);

    public Integer getRoomNumberByNumberOnList(Integer number);

    public Integer getServiceIdByNumberOnList(Integer number);

    public void createService(Integer price, String category, String information);

    public void changeRoomPrice(Integer numberOfRoom, Integer price, String information);

    public void changeServicePrice(Integer serviceId, Integer price, String information);

    public String getListOfRoomsAvailableByDate(String date, String information);

    public void changeRoomStatus(Integer numberOfRoom, String status, String information);

    public void addServiceToGuest(Integer serviceId, Integer guestId, Integer numberRoom, String information);

    public void settleInRoom(Integer guestId, Integer numberOfRoom, String information);

    public void evictedFromRoom(Integer guestId, Integer numberOfRoom, String information);

    public String getNumberGuestInHotel(String information);

    public String getNumberEmptyRoomInHotel(String information);

    public String getListOfServices(String information);

    public String getListLeftGuestThisRoom(Integer numberOfRoom, String information);

    public String getDetailsOfRoom(Integer numberOfRoom, String information);

    public String getListServiceOfGuest(Integer guestId, Integer numberRoom, String name, String information);

    public String getListGuest(String name, String information);

    public String getListOfRooms(String name, Boolean busy, String information);
}
