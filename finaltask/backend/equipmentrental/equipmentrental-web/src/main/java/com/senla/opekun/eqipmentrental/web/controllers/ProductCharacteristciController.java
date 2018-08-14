package com.senla.opekun.eqipmentrental.web.controllers;

import java.util.HashMap;
import java.util.Map;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.senla.opekun.eqipmentrental.api.service.IProductCharactersticService;
import com.senla.opekun.eqipmentrental.api.utils.IResponseBuilder;
import com.senla.opekun.eqipmentrental.model.Product;
import com.senla.opekun.eqipmentrental.model.ProductCharacteristic;
import com.senla.opekun.eqipmentrental.web.dto.product.ProductCharacteristicDto;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Controller
@RequestMapping("/productCharacteristic")
public class ProductCharacteristciController {

    private static final String PRODUCT = "product";
    private static final String PRODUCT_CHARACTERISTIC = "productCharacteristic";
    @Autowired
    private DozerBeanMapper mapper;
    @Autowired
    private IProductCharactersticService productCharactersticService;
    @Autowired
    private IResponseBuilder responseBuilder;

    @RequestMapping(path = "/create", method = RequestMethod.PUT)
    public @ResponseBody Map<String, Object> create(@RequestBody HashMap<String, Object> request) {

	Product product = mapper.map(request.get(PRODUCT), Product.class);
	ProductCharacteristic characteristic = mapper.map(request.get(PRODUCT_CHARACTERISTIC),
		ProductCharacteristic.class);
	ProductCharacteristic persistentProductCharacteristic = this.productCharactersticService
		.addProductCharacteristicToProduct(characteristic, product);
	ProductCharacteristicDto responseProductCharacteristic = mapper.map(persistentProductCharacteristic,
		ProductCharacteristicDto.class);
	return responseBuilder.createResponse(Boolean.TRUE, null, responseProductCharacteristic);
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> update(@RequestBody ProductCharacteristicDto characteristic) {
	ProductCharacteristic requestProductCharacteristic = mapper.map(characteristic, ProductCharacteristic.class);
	ProductCharacteristic updateCharacteristic = this.productCharactersticService
		.updateProductCharacteristic(requestProductCharacteristic);
	ProductCharacteristicDto responseProductCharacteristic = mapper.map(updateCharacteristic,
		ProductCharacteristicDto.class);
	return responseBuilder.createResponse(Boolean.TRUE, null, responseProductCharacteristic);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Map<String, Object> delete(@PathVariable(value = "id") Long id) {
	this.productCharactersticService.deleteProductCharacteristic(id);
	return responseBuilder.createResponse(Boolean.TRUE, null, null);
    }
}
