/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.server.utils;

import com.senla.hotel.api.facade.IHotelAdministrator;
import com.senla.hotel.enums.RoomStatus;
import com.senla.hotel.facade.HotelAdministrator;

public class DataParser {

    private final IHotelAdministrator hotelAdministrator;

    public DataParser(IHotelAdministrator hotelAdministrator) {
        this.hotelAdministrator = hotelAdministrator;

    }

    private String[] parseData = null;

    public String setInputData(String data) {
        if (data != null) {
            String[] arr = data.split("/");
            switch (arr[0]) {
                case "ExportGuests":
                    hotelAdministrator.exportGuests();
                    return "";
                case "ExportServices":
                    hotelAdministrator.exportServices();
                    return "";
                case "ExportRooms":
                    hotelAdministrator.exportServices();
                    return "";
                case "AddService":
                    parseData = arr[1].split(";");
                    hotelAdministrator.addServiceToGuest(getServiceId(parseInt(parseData[0])), getGuestId(parseInt(parseData[1])), getRoomNumber(parseInt(parseData[2])));
                    return "";
                case "CreateGuest":
                    parseData = arr[1].split(";");
                    hotelAdministrator.createGuest(parseData[0], parseData[1], parseData[2], parseInt(parseData[3]));
                    return "";
                case "EvictedFromRoom":
                    parseData = arr[1].split(";");
                    hotelAdministrator.evictedFromRoom(getGuestId(parseInt(parseData[0])), getRoomNumber(parseInt(parseData[1])));
                    return "";
                case "GetGuestPriceForAccommodation":
                    parseData = arr[1].split(";");
                    return hotelAdministrator.getGuestPriceForAccommodation(getGuestId(parseInt(parseData[0])), getRoomNumber(parseInt(parseData[1])));
                case "GetNumberGuestInHotel":
                    parseData = arr[1].split(";");
                    return hotelAdministrator.getNumberGuestInHotel();
                case "GetSortGuestByDateOfDeparture":
                    return hotelAdministrator.getSortGuestByDateOfDeparture();
                case "GetSortGuestByName":
                    return hotelAdministrator.getSortGuestByName();
                case "GetSortServicesOfGuestByPrice":
                    parseData = arr[1].split(";");
                    return hotelAdministrator.getSortListServiceGuestByPrice(getGuestId(parseInt(parseData[0])), getRoomNumber(parseInt(parseData[1])));
                case "GetSortServisecOfGuestByCategory":
                    parseData = arr[1].split(";");
                    return hotelAdministrator.getSortListServiceGuestByCategory(getGuestId(parseInt(parseData[0])), getRoomNumber(parseInt(parseData[1])));
                case "SettleInRoom":
                    parseData = arr[1].split(";");
                    hotelAdministrator.settleInRoom(getGuestId(parseInt(parseData[0])), getRoomNumber(parseInt(parseData[1])));
                    return "";
                case "ImportGuests":
                    hotelAdministrator.importGuests();
                    return "";
                case "ImportRooms":
                    hotelAdministrator.importRooms();
                    return "";
                case "ImportServices":
                    hotelAdministrator.importServices();
                    return "";
                case "Exit":
                    hotelAdministrator.writeData();
                    return "";
                case "RoomAbility":
                    return hotelAdministrator.getRoomAbility().toString();
                case "ChangeCapacity":
                    parseData = arr[1].split(";");
                    hotelAdministrator.changeCapacity(parseInt(parseData[0]), parseInt(parseData[1]));
                    return "";
                case "ChangeNumberOfStars":
                    parseData = arr[1].split(";");
                    hotelAdministrator.changeNumberOfStars(parseInt(parseData[0]), parseInt(parseData[1]));
                    return "";
                case "ChangeRoomPrice":
                    parseData = arr[1].split(";");
                    hotelAdministrator.changeRoomPrice(parseInt(parseData[0]), parseInt(parseData[1]));
                    return "";
                case "ChangeRoomStatus":
                    parseData = arr[1].split(";");
                    hotelAdministrator.changeRoomStatus(parseInt(parseData[0]), parseStatus(parseData[1]));
                    return "";
                case "CopyRoom":
                    parseData = arr[1].split(";");
                    hotelAdministrator.copyRoom(getRoomNumber(parseInt(parseData[0])), parseInt(parseData[1]), parseInt(parseData[2]));
                    return "";
                case "CreateRoom":
                    parseData = arr[1].split(";");
                    hotelAdministrator.createRoom(parseInt(parseData[0]), parseInt(parseData[1]), parseInt(parseData[2]), parseInt(parseData[3]), parseInt(parseData[4]), parseStatus(parseData[4]));
                    return "";
                case "GetDetailsOfRoom":
                    return hotelAdministrator.getDetailsOfRoom(getRoomNumber(parseInt(arr[1])));
                case "GetLeftThreeGuestOfRoom":
                    return HotelAdministrator.getInstance().getListLeftGuestThisRoom(getRoomNumber(parseInt(arr[1])));
                case "GetListOfRoomsAvailableByDate":
                    return hotelAdministrator.getListOfRoomsAvailableByDate(arr[1]);
                case "GetNumberEmptyRoom":
                    return hotelAdministrator.getNumberEmptyRoomInHotel();
                case "GetSortEmptyRoomByCapacity":
                    return hotelAdministrator.getSortEmptyRoomsByCapacity();
                case "GetSortEmptyRoomByNumberOfStars":
                    return hotelAdministrator.getSortEmptyRoomsByNumberOfStars();
                case "GetSortEmptyRoomByPrice":
                    return hotelAdministrator.getSortEmptyRoomsByPrice();
                case "GetSortRoomByCapacity":
                    return hotelAdministrator.getSortRoomsByCapacity();
                case "GetSortRoomByNumberOfStars":
                    return hotelAdministrator.getSortRoomsByNumberOfStars();
                case "GetSortRoomByPrice":
                    return hotelAdministrator.getSortRoomsByPrice();
                case "ChangeServicePrice":
                    parseData = arr[1].split(";");
                    hotelAdministrator.changeServicePrice(getServiceId(parseInt(parseData[0])), parseInt(parseData[1]));
                    return "";
                case "CreateService":
                    parseData = arr[1].split(";");
                    hotelAdministrator.createService(parseInt(parseData[0]), parseData[1], parseInt(parseData[2]));
                    return "";
                case "GetListOfServices":
                    return hotelAdministrator.getListOfServices();
            }
        }
        return "";
    }

    private RoomStatus parseStatus(String data) {
        if ("repaired".equals(data)) {
            return RoomStatus.repaired;
        } else {
            return RoomStatus.serviced;
        }
    }

    private Integer parseInt(String data) {
        return Integer.parseInt(data);
    }

    private Integer getGuestId(Integer number) {
        return hotelAdministrator.getGuestIdByNumberOnList(number);
    }

    private Integer getRoomNumber(Integer number) {
        return hotelAdministrator.getRoomNumberByNumberOnList(number);
    }

    private Integer getServiceId(Integer number) {
        return hotelAdministrator.getServiceIdByNumberOnList(number);
    }
}
