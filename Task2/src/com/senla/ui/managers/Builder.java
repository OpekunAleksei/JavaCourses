/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.ui.managers;

import com.senla.ui.menu.MenuItem;
import com.senla.ui.menu.Menu;
import com.senla.ui.api.IAction;
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
import com.senla.ui.action.Exit;
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
import com.senla.ui.action.OpenMenuService;
import com.senla.ui.action.OpenMenuRoom;
import com.senla.ui.action.OpenMenuGuest;
import com.senla.ui.action.OpenMenuExit;
import com.senla.ui.action.guest.SettleInRoom;
import java.util.ArrayList;

public class Builder {

    private Menu mainMenu = new Menu();
    private Menu guestMenu = new Menu();
    private Menu roomMenu = new Menu();
    private Menu serviceMenu = new Menu();
    private Menu rootMenu;
    private IAction a = null;

    public void buildMainMenu() {
        ArrayList<MenuItem> mainMenuItems = new ArrayList();
        mainMenu.setName("Main menu");
        mainMenuItems.add(new MenuItem(" Guest ", new OpenMenuGuest(), guestMenu));
        mainMenuItems.add(new MenuItem(" Room ", new OpenMenuRoom(), roomMenu));
        mainMenuItems.add(new MenuItem(" Service ", new OpenMenuService(), serviceMenu));
        mainMenuItems.add(new MenuItem(" Exit ", new OpenMenuExit(), null));
        mainMenu.setMenuItem(mainMenuItems);
        rootMenu = mainMenu;
    }

    public void buildRoomMenu() {

        ArrayList<MenuItem> mainMenuItems = new ArrayList();
        roomMenu.setName("Room menu");
        mainMenuItems.add(new MenuItem(" Create room", new CreateRoom(), roomMenu));
        mainMenuItems.add(new MenuItem(" Change room price ", new ChangeRoomPrice(), roomMenu));
        mainMenuItems.add(new MenuItem(" Get list of rooms available by date ", new GetListOfRoomsAvailableByDate(), roomMenu));
        mainMenuItems.add(new MenuItem(" Change room status ", new ChangeRoomStatus(), roomMenu));
        mainMenuItems.add(new MenuItem(" Get number empty room in hotel", new GetNumberEmptyRoom(), roomMenu));
        mainMenuItems.add(new MenuItem(" Get details of room", new GetDetailsOfRoom(), roomMenu));
        mainMenuItems.add(new MenuItem(" Get list left three guest of this room", new GetLeftThreeGuestOfRoom(), roomMenu));
        mainMenuItems.add(new MenuItem(" Get sort rooms by capacity", new GetSortRoomByCapacity(), roomMenu));
        mainMenuItems.add(new MenuItem(" Get sort rooms by price", new GetSortRoomByPrice(), roomMenu));
        mainMenuItems.add(new MenuItem(" Get sort rooms by number of stars", new GetSortRoomByNumberOfStars(), roomMenu));
        mainMenuItems.add(new MenuItem(" Get sort empty rooms by capacity",new GetSortEmptyRoomByCapacity(), roomMenu));
        mainMenuItems.add(new MenuItem(" Get sort empty rooms by price", new GetSortEmptyRoomByPrice(), roomMenu));
        mainMenuItems.add(new MenuItem(" Get sort empty rooms by number of stars", new GetSortEmptyRoomByNumberOfStars(), roomMenu));
        mainMenuItems.add(new MenuItem(" Exit ", new OpenMenuExit(), null));
        roomMenu.setMenuItem(mainMenuItems);
        rootMenu = roomMenu;
    }

    public void buildServiceMenu() {
        ArrayList<MenuItem> serviceMenuItems = new ArrayList();
        serviceMenu.setName("Service menu");
        serviceMenuItems.add(new MenuItem(" Create service", new CreateService(), serviceMenu));
        serviceMenuItems.add(new MenuItem("Change service price", new ChangeServicePrice(), serviceMenu));
        serviceMenuItems.add(new MenuItem("Exit",  new Exit(), serviceMenu));
        serviceMenu.setMenuItem(serviceMenuItems);
        rootMenu = serviceMenu;
    }

    public void buildGuestMenu() {

        ArrayList<MenuItem> guestMenuItems = new ArrayList();
        guestMenu.setName(" Guest Menu");
        guestMenuItems.add(new MenuItem(" Create guest", new CreateGuest(), guestMenu));
        guestMenuItems.add(new MenuItem(" Settle in room", new SettleInRoom(), guestMenu));
        guestMenuItems.add(new MenuItem("Get price for accommodation", new GetGuestPriceForAccommodation(), guestMenu));
        guestMenuItems.add(new MenuItem("Add Service", new AddService(), guestMenu));
        guestMenuItems.add(new MenuItem(" Evicted from room", new EvictedFromRoom(), guestMenu));
        guestMenuItems.add(new MenuItem(" Get sort services of guest by category", new GetSortServisecOfGuestByCategory(), guestMenu));
        guestMenuItems.add(new MenuItem(" Get sort services of guest by price", new GetSortServicesOfGuestByPrice(), guestMenu));
        guestMenuItems.add(new MenuItem(" Get number guest in hotel", new GetNumberGuestInHotel(), guestMenu));
        guestMenuItems.add(new MenuItem(" Get sort guests by name", new GetSortGuestByName(), guestMenu));
        guestMenuItems.add(new MenuItem(" Get sort guests by date of departure", new GetSortGuestByDateOfDeparture(), guestMenu));
        guestMenuItems.add(new MenuItem("Exit", new Exit(), null));
        guestMenu.setMenuItem(guestMenuItems);
        rootMenu = guestMenu;
    }

    public void setRootMenu(Menu rootMenu) {
        this.rootMenu = rootMenu;
    }

    public Menu getRootMenu() {
        return rootMenu;
    }

    public Builder() {
        rootMenu = new Menu();
    }

}
