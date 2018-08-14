package com.senla.opekun.eqipmentrental.web.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.senla.opekun.eqipmentrental.api.service.IManufacturerService;
import com.senla.opekun.eqipmentrental.api.utils.IResponseBuilder;
import com.senla.opekun.eqipmentrental.model.Manufacturer;
import com.senla.opekun.eqipmentrental.model.User;
import com.senla.opekun.eqipmentrental.web.dto.product.ManufacturerDto;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Controller
@RequestMapping("/manufacturer")

public class ManufacturerController {

    @Autowired
    private DozerBeanMapper mapper;
    @Autowired
    private IManufacturerService manufacturerService;
    @Autowired
    private IResponseBuilder responseBuilder;

    @RequestMapping(path = "/create", method = RequestMethod.PUT)
    public @ResponseBody Map<String, Object> create(@RequestBody ManufacturerDto manufacturer) {
	Manufacturer requestManufacturer = mapper.map(manufacturer, Manufacturer.class);
	Manufacturer createManufacturer = this.manufacturerService.createManufacturer(requestManufacturer);
	ManufacturerDto responseManufacturer = mapper.map(createManufacturer, ManufacturerDto.class);
	return responseBuilder.createResponse(Boolean.TRUE, null, responseManufacturer);
    }

    @RequestMapping(path = "/manufacturers", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> getManufacturers() {

	List<ManufacturerDto> manufacturers = new ArrayList<ManufacturerDto>();
	for (Manufacturer manufacturer : this.manufacturerService.getManufacturers()) {
	    manufacturers.add(mapper.map(manufacturer, ManufacturerDto.class));
	}
	return responseBuilder.createResponse(Boolean.TRUE, null, manufacturers);
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> update(@RequestBody ManufacturerDto manufacturer) {
	Manufacturer requestManufacturer = mapper.map(manufacturer, Manufacturer.class);
	Manufacturer updateManufacturer = this.manufacturerService.updateManufacturer(requestManufacturer);
	ManufacturerDto responseManufacturer = mapper.map(updateManufacturer, ManufacturerDto.class);

	return responseBuilder.createResponse(Boolean.TRUE, null, responseManufacturer);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Map<String, Object> delete(@PathVariable(value = "id") Long id, @ModelAttribute User user) {
	this.manufacturerService.deleteManufacturer(id);
	return responseBuilder.createResponse(Boolean.TRUE, null, null);
    }
}
