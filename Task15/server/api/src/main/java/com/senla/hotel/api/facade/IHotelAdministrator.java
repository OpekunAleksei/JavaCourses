/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.api.facade;

import com.senla.hotel.entity.Client;
import java.util.List;

public interface IHotelAdministrator {

    public Client getClient(String login, String password) ;

    public void signOut(Client client);

    public void signIn(Client client, String token);

    public void registerUser(String login, String password);

    public Long getGuestPriceForAccommodation(Integer guestId, Integer numberRoom);

    public void changeNumberOfStars(Integer numberOfRoom, Integer numberOfStars);

    public void changeCapacity(Integer numberOfRoom, Integer capacity);

    public void createRoom(Integer number, Integer price, Integer capacity, Integer numberOfStars, String status);

    public void copyRoom(Integer numberOfRoom, Integer newNumber);

    public void createGuest(String name, String arrivalDate, String dateOfDeparture);

    public void importRooms();

    public void exportRooms();

    public void importServices();

    public void exportServices();

    public void importGuests();

    public void exportGuests();

    public Integer getGuestIdByNumberOnList(Integer number);

    public Integer getRoomNumberByNumberOnList(Integer number);

    public Integer getServiceIdByNumberOnList(Integer number);

    public void createService(Integer price, String category);

    public void changeRoomPrice(Integer numberOfRoom, Integer price);

    public void changeServicePrice(Integer serviceId, Integer price);

    public List getListOfRoomsAvailableByDate(String date);

    public void changeRoomStatus(Integer numberOfRoom, String status);

    public void addServiceToGuest(Integer serviceId, Integer guestId, Integer numberRoom);

    public void settleInRoom(Integer guestId, Integer numberOfRoom);

    public void evictedFromRoom(Integer guestId, Integer numberOfRoom);

    public Integer getNumberGuestInHotel();

    public Integer getNumberEmptyRoomInHotel();

    public List getListOfServices();

    public List getListLeftGuestThisRoom(Integer numberOfRoom);

    public List getDetailsOfRoom(Integer numberOfRoom);

    public List getListServiceOfGuest(Integer guestId, Integer numberRoom, String name);

    public List getListGuest(String name);

    public List getListOfRooms(String name, Boolean busy);

    public void auditData(Client user, String data);
}
