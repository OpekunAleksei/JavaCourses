/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.managers;

import com.senla.ui.menu.MenuItem;
import com.senla.ui.menu.Menu;
import com.senla.ui.action.rooms.GetSortEmptyRoomByPrice;
import com.senla.ui.action.rooms.GetSortEmptyRoomByCapacity;
import com.senla.ui.action.rooms.GetSortEmptyRoomByNumberOfStars;
import com.senla.ui.action.guest.AddService;
import com.senla.ui.action.rooms.ChangeRoomPrice;
import com.senla.ui.action.rooms.ChangeRoomStatus;
import com.senla.ui.action.service.ChangeServicePrice;
import com.senla.ui.action.guest.CreateGuest;
import com.senla.ui.action.rooms.CreateRoom;
import com.senla.ui.action.service.CreateService;
import com.senla.ui.action.guest.EvictedFromRoom;
import com.senla.ui.action.rooms.GetDetailsOfRoom;
import com.senla.ui.action.guest.GetGuestPriceForAccommodation;
import com.senla.ui.action.rooms.GetLeftThreeGuestOfRoom;
import com.senla.ui.action.rooms.GetListOfRoomsAvailableByDate;
import com.senla.ui.action.rooms.GetNumberEmptyRoom;
import com.senla.ui.action.guest.GetNumberGuestInHotel;
import com.senla.ui.action.guest.GetSortGuestByDateOfDeparture;
import com.senla.ui.action.guest.GetSortGuestByName;
import com.senla.ui.action.rooms.GetSortRoomByCapacity;
import com.senla.ui.action.rooms.GetSortRoomByNumberOfStars;
import com.senla.ui.action.rooms.GetSortRoomByPrice;
import com.senla.ui.action.guest.GetSortServicesOfGuestByPrice;
import com.senla.ui.action.guest.GetSortServisecOfGuestByCategory;
import com.senla.ui.action.Exit;
import com.senla.ui.action.exports.ExportGuests;
import com.senla.ui.action.exports.ExportHistory;
import com.senla.ui.action.exports.ExportRooms;
import com.senla.ui.action.exports.ExportServices;
import com.senla.ui.action.guest.SettleInRoom;
import com.senla.ui.action.imports.ImportGuests;
import com.senla.ui.action.imports.ImportHistory;
import com.senla.ui.action.imports.ImportRooms;
import com.senla.ui.action.imports.ImportServices;
import com.senla.ui.action.rooms.ChangeCapacity;
import com.senla.ui.action.rooms.ChangeNumberOfStars;
import com.senla.ui.action.rooms.CopyRoom;
import java.util.ArrayList;

public final class Builder {

    private Menu mainMenu;
    private Menu guestMenu;
    private Menu roomMenu;
    private Menu serviceMenu;
    private Menu rootMenu;
    private Menu importMenu;
    private Menu exportMenu;
    private Menu changeMenu;

    public Builder() {
        changeMenu = new Menu();
        mainMenu = new Menu();
        importMenu = new Menu();
        exportMenu = new Menu();
        guestMenu = new Menu();
        roomMenu = new Menu();
        serviceMenu = new Menu();
        this.rootMenu = new Menu();
    }

    public void buildMainMenu() {

        ArrayList<MenuItem> importMenuItems = new ArrayList();
        importMenu.setName(" Import menu");
        importMenuItems.add(new MenuItem(" Import guests ", new ImportGuests(), importMenu));
        importMenuItems.add(new MenuItem(" Import rooms ", new ImportRooms(), importMenu));
        importMenuItems.add(new MenuItem(" Import History ", new ImportHistory(), importMenu));
        importMenuItems.add(new MenuItem(" Import services ", new ImportServices(), importMenu));
        importMenuItems.add(new MenuItem(" Back to main menu", null, mainMenu));
        importMenu.setMenuItem(importMenuItems);
        ArrayList<MenuItem> exportMenuItems = new ArrayList();
        exportMenu.setName(" Export menu");
        exportMenuItems.add(new MenuItem(" Export guests ", new ExportGuests(), exportMenu));
        exportMenuItems.add(new MenuItem(" Export rooms ", new ExportRooms(), exportMenu));
        exportMenuItems.add(new MenuItem(" Export history ", new ExportHistory(), exportMenu));
        exportMenuItems.add(new MenuItem(" Export services ", new ExportServices(), exportMenu));
        exportMenuItems.add(new MenuItem(" Back to main menu ", null, mainMenu));
        exportMenu.setMenuItem(exportMenuItems);

        ArrayList<MenuItem> roomMenuItems = new ArrayList();
        roomMenu.setName(" Room menu");
        roomMenuItems.add(new MenuItem(" Create room", new CreateRoom(), roomMenu));
        roomMenuItems.add(new MenuItem(" Change room price ", new ChangeRoomPrice(), roomMenu));
        roomMenuItems.add(new MenuItem(" Get list of rooms available by date ", new GetListOfRoomsAvailableByDate(), roomMenu));
        roomMenuItems.add(new MenuItem(" Change room status ", new ChangeRoomStatus(), roomMenu));
        roomMenuItems.add(new MenuItem(" Copy room", new CopyRoom(), changeMenu));
        roomMenuItems.add(new MenuItem(" Get number empty room in hotel", new GetNumberEmptyRoom(), roomMenu));
        roomMenuItems.add(new MenuItem(" Get details of room", new GetDetailsOfRoom(), roomMenu));
        roomMenuItems.add(new MenuItem(" Get list left guest of this room", new GetLeftThreeGuestOfRoom(), roomMenu));
        roomMenuItems.add(new MenuItem(" Get sort rooms by capacity", new GetSortRoomByCapacity(), roomMenu));
        roomMenuItems.add(new MenuItem(" Get sort rooms by price", new GetSortRoomByPrice(), roomMenu));
        roomMenuItems.add(new MenuItem(" Get sort rooms by number of stars", new GetSortRoomByNumberOfStars(), roomMenu));
        roomMenuItems.add(new MenuItem(" Get sort empty rooms by capacity", new GetSortEmptyRoomByCapacity(), roomMenu));
        roomMenuItems.add(new MenuItem(" Get sort empty rooms by price", new GetSortEmptyRoomByPrice(), roomMenu));
        roomMenuItems.add(new MenuItem(" Get sort empty rooms by number of stars", new GetSortEmptyRoomByNumberOfStars(), roomMenu));
        roomMenuItems.add(new MenuItem(" Back to main menu ", null, mainMenu));
        roomMenu.setMenuItem(roomMenuItems);
        ArrayList<MenuItem> changeMenuItems = new ArrayList();
        changeMenu.setName(" Change menu");
        changeMenuItems.add(new MenuItem(" Change status ", new ChangeRoomStatus(), changeMenu));
        changeMenuItems.add(new MenuItem(" Change price ", new ChangeRoomPrice(), changeMenu));
        changeMenuItems.add(new MenuItem(" Change number of stars ", new ChangeNumberOfStars(), changeMenu));
        changeMenuItems.add(new MenuItem(" Change capacity", new ChangeCapacity(), changeMenu));
        changeMenuItems.add(new MenuItem(" Back to room menu", null, roomMenu));
        changeMenu.setMenuItem(changeMenuItems);
        ArrayList<MenuItem> serviceMenuItems = new ArrayList();
        serviceMenu.setName(" Service menu");
        serviceMenuItems.add(new MenuItem(" Create service", new CreateService(), serviceMenu));
        serviceMenuItems.add(new MenuItem(" Change service price", new ChangeServicePrice(), serviceMenu));
        serviceMenuItems.add(new MenuItem(" Back to main menu", null, mainMenu));
        serviceMenu.setMenuItem(serviceMenuItems);

        ArrayList<MenuItem> guestMenuItems = new ArrayList();
        guestMenu.setName(" Guest Menu");
        guestMenuItems.add(new MenuItem(" Create guest", new CreateGuest(), guestMenu));
        guestMenuItems.add(new MenuItem(" Settle in room", new SettleInRoom(), guestMenu));
        guestMenuItems.add(new MenuItem(" Get price for accommodation", new GetGuestPriceForAccommodation(), guestMenu));
        guestMenuItems.add(new MenuItem(" Add Service", new AddService(), guestMenu));
        guestMenuItems.add(new MenuItem(" Evicted from room", new EvictedFromRoom(), guestMenu));
        guestMenuItems.add(new MenuItem(" Get sort services of guest by category", new GetSortServisecOfGuestByCategory(), guestMenu));
        guestMenuItems.add(new MenuItem(" Get sort services of guest by price", new GetSortServicesOfGuestByPrice(), guestMenu));
        guestMenuItems.add(new MenuItem(" Get number guest in hotel", new GetNumberGuestInHotel(), guestMenu));
        guestMenuItems.add(new MenuItem(" Get sort guests by name", new GetSortGuestByName(), guestMenu));
        guestMenuItems.add(new MenuItem(" Get sort guests by date of departure", new GetSortGuestByDateOfDeparture(), guestMenu));
        guestMenuItems.add(new MenuItem("Back to main menu", null, mainMenu));
        guestMenu.setMenuItem(guestMenuItems);
        ArrayList<MenuItem> mainMenuItems = new ArrayList();
        mainMenu.setName(" Main menu");
        mainMenuItems.add(new MenuItem(" Guest ", null, guestMenu));
        mainMenuItems.add(new MenuItem(" Room ", null, roomMenu));
        mainMenuItems.add(new MenuItem(" Service ", null, serviceMenu));
        mainMenuItems.add(new MenuItem(" Import ", null, importMenu));
        mainMenuItems.add(new MenuItem(" Export ", null, exportMenu));
        mainMenuItems.add(new MenuItem(" Exit ", new Exit(), null));
        mainMenu.setMenuItem(mainMenuItems);

        this.rootMenu = mainMenu;
    }

    public void setRootMenu(Menu rootMenu) {
        this.rootMenu = rootMenu;
    }

    public Menu getRootMenu() {
        return rootMenu;
    }

}
