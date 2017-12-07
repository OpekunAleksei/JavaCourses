/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.reflection;

import com.senla.hotel.annotation.enums.PropertyType;
import com.senla.hotel.annotations.CsvEntity;
import com.senla.hotel.annotations.CsvProperty;
import com.senla.hotel.entity.Guest;
import com.senla.hotel.entity.Room;
import com.senla.hotel.entity.Service;
import com.senla.hotel.enums.RoomStatus;
import com.senla.hotel.utils.DateConverter;
import com.senla.hotel.utils.TextWorker;
import com.senla.hotel.utils.Transfer;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

public class Reflection {

    private String csvGuestData;
    private final String path;
    private String fileName;
    private String valuesSeparator;
    private final Map<Integer, Object> entityList;
    private final Map<Integer, String> entityName;
    private final Transfer transfer;
    private final DateConverter dateConverter;
    private final TextWorker textWorker;
    private String simpleName;

    public Reflection(String path) {

        this.textWorker = new TextWorker();
        this.path = path;
        this.entityList = new HashMap();
        this.entityName = new HashMap();
        this.transfer = new Transfer();
        this.dateConverter = new DateConverter();
    }

    public void exportData(List list) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, IOException {
        for (Object entity : list) {
            Class entityClass = entity.getClass();
            this.simpleName = entityClass.getSimpleName();
            CsvEntity entityAnnotation = (CsvEntity) entityClass.getAnnotation(CsvEntity.class);
            this.fileName = entityAnnotation.fileName();
            this.valuesSeparator = entityAnnotation.valuesSeparator();
            Field[] entityFields = entityClass.getDeclaredFields();
            for (Field field : entityFields) {
                CsvProperty fieldProperty = (CsvProperty) field.getAnnotation(CsvProperty.class);
                field.setAccessible(true);
                if (fieldProperty != null && fieldProperty.propertyType() == PropertyType.SimpleProperty) {
                    if (field.getType() == Date.class) {
                        entityName.put(fieldProperty.colomnNumber(), field.getName());
                        entityList.put(fieldProperty.colomnNumber(), dateConverter.parseDate((Date) field.get(entity)));
                    } else {
                        entityName.put(fieldProperty.colomnNumber(), field.getName());
                        entityList.put(fieldProperty.colomnNumber(), field.get(entity));
                    }
                } else if (fieldProperty != null && fieldProperty.propertyType() == PropertyType.CompositeProperty) {
                    List compositePropertyList = (List) field.get(entity);
                    StringBuilder stringBuilder = new StringBuilder();
                    for (Object CList : compositePropertyList) {
                        Class compositePropertyClass = CList.getClass();
                        Field guestCompositeField = compositePropertyClass.getDeclaredField(fieldProperty.keyField());
                        if (guestCompositeField != null) {
                            guestCompositeField.setAccessible(true);
                            stringBuilder.append(guestCompositeField.get(fieldProperty));
                            stringBuilder.append(".");
                        }
                    }
                    entityName.put(fieldProperty.colomnNumber(), field.getName());
                    this.entityList.put(fieldProperty.colomnNumber(), stringBuilder.toString());
                }
            }
            csvGuestData = textWorker.createEntityList(entityList, valuesSeparator, csvGuestData);
            transfer.export(this.path + this.fileName, csvGuestData, this.simpleName, textWorker.createFirstLine(entityName, valuesSeparator));
        }
    }

    public List<Guest> importGuest() throws IOException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ParseException {
        Class guestClass = Guest.class;
        List<Guest> importGuests = new ArrayList();
        CsvEntity entityAnnotation = (CsvEntity) guestClass.getAnnotation(CsvEntity.class);
        this.fileName = path + entityAnnotation.fileName();
        this.valuesSeparator = entityAnnotation.valuesSeparator();
        List<String> csvData = transfer.importData(this.fileName);
        String[] arr = csvData.get(0).split(this.valuesSeparator);
        for (int i = 0; i < arr.length; i++) {
            this.entityName.put(i, arr[i]);
        }
        for (int i = 1; i < csvData.size(); i++) {

            String[] splitLine = csvData.get(i).split(this.valuesSeparator);
            for (int j = 0; j < splitLine.length; j++) {
                this.entityList.put(j, splitLine[j]);
            }
            Guest importGuest = (Guest) guestClass.newInstance();
            Field[] entityFields = guestClass.getDeclaredFields();
            for (Field entityField : entityFields) {
                CsvProperty fieldProperty = (CsvProperty) entityField.getAnnotation(CsvProperty.class);
                entityField.setAccessible(true);
                if (fieldProperty != null && fieldProperty.propertyType() == PropertyType.SimpleProperty) {
                    if (entityField.getName() == null ? (this.entityName.get(fieldProperty.colomnNumber())) == null : entityField.getName().equals(this.entityName.get(fieldProperty.colomnNumber()))) {
                        if (entityField.getType() == Date.class) {
                            entityField.set(importGuest, dateConverter.parseDate((String) entityList.get(fieldProperty.colomnNumber())));
                        } else if (entityField.getType() == Integer.class) {
                            entityField.set(importGuest, Integer.parseInt(entityList.get(fieldProperty.colomnNumber()).toString()));
                        } else if (entityField.getType() == String.class) {
                            entityField.set(importGuest, entityList.get(fieldProperty.colomnNumber()));
                        }
                    }
                }
            }
            importGuests.add(importGuest);
        }
        return importGuests;
    }

    public List<Room> importRoom() throws IOException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ParseException {
        Class roomClass = Room.class;
        List<Room> importRooms = new ArrayList();
        CsvEntity entityAnnotation = (CsvEntity) roomClass.getAnnotation(CsvEntity.class);
        this.fileName = path + entityAnnotation.fileName();
        this.valuesSeparator = entityAnnotation.valuesSeparator();
        List<String> csvData = transfer.importData(this.fileName);
        String[] arr = csvData.get(0).split(this.valuesSeparator);
        for (int i = 0; i < arr.length; i++) {
            this.entityName.put(i, arr[i]);
        }
        for (int i = 1; i < csvData.size(); i++) {

            String[] splitLine = csvData.get(i).split(this.valuesSeparator);
            for (int j = 0; j < splitLine.length; j++) {

                this.entityList.put(j, splitLine[j]);
            }
            Room importRoom = (Room) roomClass.newInstance();
            Field[] entityFields = roomClass.getDeclaredFields();
            for (Field entityField : entityFields) {
                CsvProperty fieldProperty = (CsvProperty) entityField.getAnnotation(CsvProperty.class);
                entityField.setAccessible(true);
                if (fieldProperty != null && fieldProperty.propertyType() == PropertyType.SimpleProperty) {
                    if (entityField.getName() == null ? (this.entityName.get(fieldProperty.colomnNumber())) == null : entityField.getName().equals(this.entityName.get(fieldProperty.colomnNumber()))) {
                        if (entityField.getType() == Integer.class) {
                            entityField.set(importRoom, Integer.parseInt(entityList.get(fieldProperty.colomnNumber()).toString()));
                        } else if (entityField.getType() == String.class) {
                            entityField.set(importRoom, entityList.get(fieldProperty.colomnNumber()));
                        } else if (entityField.getType() == RoomStatus.class) {
                            if (RoomStatus.valueOf((String) entityList.get(fieldProperty.colomnNumber())) == RoomStatus.repaired) {
                                entityField.set(importRoom, RoomStatus.repaired);
                            } else {
                                entityField.set(importRoom, RoomStatus.serviced);
                            }
                        }
                    }
                }
            }
            importRooms.add(importRoom);

        }
        return importRooms;
    }

    public List<Service> importService() throws IOException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ParseException {
        Class ServiceClass = Service.class;
        List<Service> importServices = new ArrayList();
        CsvEntity entityAnnotation = (CsvEntity) ServiceClass.getAnnotation(CsvEntity.class);
        this.valuesSeparator = entityAnnotation.valuesSeparator();
        this.fileName = path + entityAnnotation.fileName();
        List<String> csvData = transfer.importData(this.fileName);
        String[] arr = csvData.get(0).split(this.valuesSeparator);
        for (int i = 0; i < arr.length; i++) {
            this.entityName.put(i, arr[i]);
        }
        for (int i = 1; i < csvData.size(); i++) {

            String[] splitLine = csvData.get(i).split(this.valuesSeparator);
            for (int j = 0; j < splitLine.length; j++) {
                this.entityList.put(j, splitLine[j]);
            }
            Service importService = (Service) ServiceClass.newInstance();
            Field[] entityFields = ServiceClass.getDeclaredFields();
            for (Field entityField : entityFields) {
                CsvProperty fieldProperty = (CsvProperty) entityField.getAnnotation(CsvProperty.class);
                entityField.setAccessible(true);
                if (fieldProperty != null && fieldProperty.propertyType() == PropertyType.SimpleProperty) {
                    if (entityField.getName() == null ? (this.entityName.get(fieldProperty.colomnNumber())) == null : entityField.getName().equals(this.entityName.get(fieldProperty.colomnNumber()))) {
                        if (entityField.getType() == Integer.class) {
                            entityField.set(importService, Integer.parseInt(entityList.get(fieldProperty.colomnNumber()).toString()));
                        } else if (entityField.getType() == String.class) {
                            entityField.set(importService, entityList.get(fieldProperty.colomnNumber()));
                        }
                    }
                }
            }
            importServices.add(importService);
        }
        return importServices;
    }
}
