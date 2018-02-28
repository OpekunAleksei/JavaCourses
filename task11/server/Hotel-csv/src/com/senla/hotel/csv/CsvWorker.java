/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.csv;

import com.senla.hotel.annotation.enums.PropertyType;
import com.senla.hotel.annotations.CsvEntity;
import com.senla.hotel.annotations.CsvProperty;
import com.senla.hotel.entity.Entity;
import com.senla.hotel.enums.RoomStatus;
import com.senla.hotel.utils.DateConverter;
import com.senla.hotel.utils.DataParser;
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

public class CsvWorker {

    private String csvGuestData;
    private final String path;
    private String fileName;
    private String valuesSeparator;
    private final Map<Integer, Object> entityList;
    private final Map<Integer, String> entityName;
    private final Transfer transfer;
    private final DateConverter dateConverter;
    private final DataParser textWorker;
    private String simpleName;

    public CsvWorker(String path) {

        this.textWorker = new DataParser();
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

    public List importData(Class<? extends Entity> entityClass) throws IOException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ParseException {

        List entityes = new ArrayList();
        CsvEntity entityAnnotation = (CsvEntity) entityClass.getAnnotation(CsvEntity.class);
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
            Entity importEntity = (Entity) entityClass.newInstance();
            Field[] entityFields = entityClass.getDeclaredFields();
            for (Field entityField : entityFields) {
                CsvProperty fieldProperty = (CsvProperty) entityField.getAnnotation(CsvProperty.class);
                entityField.setAccessible(true);
                if (fieldProperty != null && fieldProperty.propertyType() == PropertyType.SimpleProperty) {
                    if (entityField.getName() == null ? (this.entityName.get(fieldProperty.colomnNumber())) == null : entityField.getName().equals(this.entityName.get(fieldProperty.colomnNumber()))) {
                        if (entityField.getType() == Date.class) {
                            entityField.set(importEntity, dateConverter.parseDate((String) entityList.get(fieldProperty.colomnNumber())));
                        } else if (entityField.getType() == Integer.class) {
                            entityField.set(importEntity, Integer.parseInt(entityList.get(fieldProperty.colomnNumber()).toString()));
                        } else if (entityField.getType() == String.class) {
                            entityField.set(importEntity, entityList.get(fieldProperty.colomnNumber()));
                        } else if (entityField.getType() == RoomStatus.class) {
                            if (RoomStatus.valueOf((String) entityList.get(fieldProperty.colomnNumber())) == RoomStatus.repaired) {
                                entityField.set(importEntity, RoomStatus.repaired);
                            } else {
                                entityField.set(importEntity, RoomStatus.serviced);
                            }
                        }
                    }
                }
            }
            entityes.add(importEntity);
        }
        return entityes;
    }
}
