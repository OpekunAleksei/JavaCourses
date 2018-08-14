package com.senla.opekun.eqipmentrental.web.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.senla.opekun.eqipmentrental.api.service.ICharacteristicService;
import com.senla.opekun.eqipmentrental.api.utils.IResponseBuilder;
import com.senla.opekun.eqipmentrental.model.Characteristic;
import com.senla.opekun.eqipmentrental.web.dto.product.CharacteristicDto;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Controller
@RequestMapping("/characteristic")
public class CharacteristicController {

    @Autowired
    private DozerBeanMapper mapper;
    @Autowired
    private ICharacteristicService characteristicService;
    @Autowired
    private IResponseBuilder responseBuilder;

    @RequestMapping(path = "/create", method = RequestMethod.PUT)
    public @ResponseBody Map<String, Object> create(@RequestBody CharacteristicDto characteristic) {
	Characteristic requestCharacteristic = mapper.map(characteristic, Characteristic.class);
	Characteristic persistentCharacteristic = this.characteristicService
		.createCharacteristic(requestCharacteristic);
	CharacteristicDto responseCharacteristic = mapper.map(persistentCharacteristic, CharacteristicDto.class);
	return responseBuilder.createResponse(Boolean.TRUE, null, responseCharacteristic);
    }

    @RequestMapping(path = "/characteristics", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> getCharacteristics() {
	List<CharacteristicDto> responseCharacteristics = new ArrayList<CharacteristicDto>();
	this.characteristicService.getCharacteristics().forEach((characteristics) -> {
	    responseCharacteristics.add(mapper.map(characteristics, CharacteristicDto.class));
	});
	return responseBuilder.createResponse(Boolean.TRUE, null, responseCharacteristics);
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> update(@RequestBody CharacteristicDto characteristic) {
	Characteristic requestCharacteristic = mapper.map(characteristic, Characteristic.class);
	Characteristic updateCharacteristic = this.characteristicService.updateCharacteristic(requestCharacteristic);
	CharacteristicDto responseCharacteristic = mapper.map(updateCharacteristic, CharacteristicDto.class);
	return responseBuilder.createResponse(Boolean.TRUE, null, responseCharacteristic);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Map<String, Object> deleteManufacturer(@PathVariable(value = "id") Long id) {
	this.characteristicService.deleteCharacteristic(id);
	return responseBuilder.createResponse(Boolean.TRUE, null, null);
    }
}
