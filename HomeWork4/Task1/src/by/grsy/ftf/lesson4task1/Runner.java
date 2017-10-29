/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.grsy.ftf.lesson4task1;

import by.grsy.ftf.lesson4task1.entity.Guest;
import by.grsy.ftf.lesson4task1.facade.HotelAdministrator;
import by.grsy.ftf.lesson4task1.entity.Room;
import by.grsy.ftf.lesson4task1.entity.Service;
import by.grsy.ftf.lesson4task1.printer.Printer;
import com.danco.training.TextFileWorker;
import java.text.ParseException;


public class Runner {

    public static void main(String[] args) throws ParseException {
        Printer printer = new Printer();
        TextFileWorker textFileWorkerGuest;
        TextFileWorker textFileWorkerRoom;
        TextFileWorker textFileWorkerService;
        textFileWorkerService = new TextFileWorker("D:\\serviceFile.txt");
        textFileWorkerGuest = new TextFileWorker("D:\\guestFile.txt");
        textFileWorkerRoom = new TextFileWorker("D:\\roomFile.txt");
        String lineService[];
        String lineGuest[];
        String lineRoom[];
        lineService = textFileWorkerService.readFromFile();
        lineGuest = textFileWorkerGuest.readFromFile();
        lineRoom = textFileWorkerRoom.readFromFile();
        HotelAdministrator hotelAdministrator = new HotelAdministrator();
        Room room1 = new Room(lineRoom[0]);
        Room room2 = new Room(lineRoom[1]);
        Room room3 = new Room(lineRoom[2]);
        Guest guest = new Guest(lineGuest[0]);
        Guest guest1 = new Guest(lineGuest[1]);
        Guest guest3 = new Guest(lineGuest[2]);
        Guest guest2 = new Guest(lineGuest[3]);
        Guest guest4 = new Guest(lineGuest[4]);
        Guest guest5 = new Guest(lineGuest[5]);
        Service service1 = new Service(lineService[0]);
        Service service = new Service(lineService[1]);
        Service service2 = new Service(lineService[2]);
        hotelAdministrator.createRoom(room1);
        hotelAdministrator.createRoom(room2);
        hotelAdministrator.createRoom(room3);
        hotelAdministrator.createGuest(guest);
        hotelAdministrator.createGuest(guest1);
        hotelAdministrator.createGuest(guest2);
        hotelAdministrator.createGuest(guest3);
        hotelAdministrator.createGuest(guest4);
        hotelAdministrator.createGuest(guest5);
        hotelAdministrator.createService(service);
        hotelAdministrator.createService(service1);
        hotelAdministrator.createService(service2);

        hotelAdministrator.settleInRoom(guest, room1);
        hotelAdministrator.settleInRoom(guest1, room3);
        hotelAdministrator.settleInRoom(guest2, room2);
        hotelAdministrator.settleInRoom(guest3, room2);
        hotelAdministrator.settleInRoom(guest5, room2);
        printer.print(hotelAdministrator.getNumberEmptyRoomInHotel());
        hotelAdministrator.evictedFromRoom(guest);
        printer.print(hotelAdministrator.getNumberEmptyRoomInHotel());
        printer.print(hotelAdministrator.getDetailsOfRoom(room1));
        printer.print(hotelAdministrator.getGuestPriceForAccommodation(room3));
        printer.print(hotelAdministrator.getListLeftThreeGuestThisRoom(room1));
        hotelAdministrator.evictedFromRoom(guest3);
        hotelAdministrator.evictedFromRoom(guest2);
        hotelAdministrator.evictedFromRoom(guest5);
        printer.print(hotelAdministrator.getListLeftThreeGuestThisRoom(room2));
        hotelAdministrator.changeRoomPrice(room3, 100);
        hotelAdministrator.evictedFromRoom(guest);

    }

}
