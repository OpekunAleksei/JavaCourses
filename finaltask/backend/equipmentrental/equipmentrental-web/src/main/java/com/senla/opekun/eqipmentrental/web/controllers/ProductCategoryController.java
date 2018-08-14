package com.senla.opekun.eqipmentrental.web.controllers;

import com.senla.opekun.eqipmentrental.api.service.IProductCategoryService;
import com.senla.opekun.eqipmentrental.api.utils.IResponseBuilder;
import com.senla.opekun.eqipmentrental.model.ProductCategory;
import com.senla.opekun.eqipmentrental.web.dto.product.ProductCategoryDto;
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

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Controller
@RequestMapping("/category")
public class ProductCategoryController {

    @Autowired
    private DozerBeanMapper mapper;
    @Autowired
    private IProductCategoryService productCategoryService;
    @Autowired
    private IResponseBuilder responseBuilder;

    @RequestMapping(path = "/create", method = RequestMethod.PUT)
    public @ResponseBody Map<String, Object> create(@RequestBody ProductCategoryDto category) {
	ProductCategory requestProductCategory = mapper.map(category, ProductCategory.class);
	ProductCategory persistentCategory = this.productCategoryService.creteProductCategory(requestProductCategory);
	ProductCategoryDto responseProductCategory = mapper.map(persistentCategory, ProductCategoryDto.class);
	return responseBuilder.createResponse(Boolean.TRUE, null, responseProductCategory);
    }

    @RequestMapping(path = "/categorys", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> getCategorys() {
	List<ProductCategoryDto> responseCategorys = new ArrayList<ProductCategoryDto>();
	this.productCategoryService.getProductCategories().forEach((category) -> {
	    responseCategorys.add(mapper.map(category, ProductCategoryDto.class));
	});
	return responseBuilder.createResponse(Boolean.TRUE, null, responseCategorys);
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> update(@RequestBody ProductCategoryDto category) {
	ProductCategory requestProductCategory = mapper.map(category, ProductCategory.class);
	ProductCategory updateCategory = this.productCategoryService.updateProductCategory(requestProductCategory);
	ProductCategoryDto responseProductCategory = mapper.map(updateCategory, ProductCategoryDto.class);
	return responseBuilder.createResponse(Boolean.TRUE, null, responseProductCategory);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Map<String, Object> delete(@PathVariable(value = "id") Long id) {
	this.productCategoryService.deleteProductCategory(id);
	return responseBuilder.createResponse(Boolean.TRUE, null, null);
    }
}
