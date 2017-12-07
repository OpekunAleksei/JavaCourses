/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senla.hotel.annotations;

import com.senla.hotel.annotation.enums.PropertyType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface CsvProperty {
    PropertyType propertyType() default PropertyType.CompositeProperty;
    int colomnNumber() default 0;
    String keyField() default "id";
}
