/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.api.facade;

public interface IHotelAdministrator {

    public String getGuestPriceForAccommodation(String guestId, String numberRoom);

    public void changeNumberOfStars(String numberOfRoom, String numberOfStars);

    public void changeCapacity(String numberOfRoom, String capacity);

  

    public void createRoom(String number, String price, String capacity, String numberOfStars, String status);

    public void copyRoom(String numberOfRoom, String newNumber);

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

    public void createService(String price, String category);

    public void changeRoomPrice(String numberOfRoom, String price);

    public void changeServicePrice(String serviceId, String price);

    public String getListOfRoomsAvailableByDate(String date);

    public void changeRoomStatus(String numberOfRoom, String status);

    public void addServiceToGuest(String serviceId, String guestId, String numberRoom);

    public void settleInRoom(String guestId, String numberOfRoom);

    public void evictedFromRoom(String guestId, String numberOfRoom);

    public String getNumberGuestInHotel();

    public String getNumberEmptyRoomInHotel();

    public String getListOfServices();

    public String getListLeftGuestThisRoom(String numberOfRoom);

    public String getDetailsOfRoom(String numberOfRoom);

    public String getSortRoomsByCapacity();

    public String getSortRoomsByPrice();

    public String getSortRoomsByNumberOfStars();

    public String getSortEmptyRoomsByCapacity();

    public String getSortEmptyRoomsByPrice();

    public String getSortEmptyRoomsByNumberOfStars();

    public String getSortGuestByDateOfDeparture();

    public String getSortListServiceGuestByPrice(String guestId, String numberRoom);

    public String getSortListServiceGuestByCategory(String guestId, String numberRoom);

    public String getSortGuestByName();

    public String getRoomAbility();
}
