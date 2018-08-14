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

import com.senla.opekun.eqipmentrental.api.service.IProductService;
import com.senla.opekun.eqipmentrental.api.utils.IResponseBuilder;
import com.senla.opekun.eqipmentrental.model.Manufacturer;
import com.senla.opekun.eqipmentrental.model.Product;
import com.senla.opekun.eqipmentrental.model.ProductCategory;
import com.senla.opekun.eqipmentrental.web.dto.product.ManufacturerDto;
import com.senla.opekun.eqipmentrental.web.dto.product.ProducDtoWithCharacteistics;
import com.senla.opekun.eqipmentrental.web.dto.product.ProductCategoryDto;
import com.senla.opekun.eqipmentrental.web.dto.product.ProductDto;
import com.senla.opekun.eqipmentrental.web.dto.product.RequestProductDto;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private DozerBeanMapper mapper;
    @Autowired
    private IProductService productService;
    @Autowired
    private IResponseBuilder responseBuilder;

    @RequestMapping(path = "/create", method = RequestMethod.PUT)
    public @ResponseBody Map<String, Object> create(@RequestBody RequestProductDto product) {
	Product reqestProduct = mapper.map(product, Product.class);
	Product persistentProduct = this.productService.createProduct(reqestProduct);
	ProductDto responseProduct = mapper.map(persistentProduct, ProductDto.class);
	return responseBuilder.createResponse(Boolean.TRUE, null, responseProduct);
    }

    @RequestMapping(path = "/products", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> getProducts() {
	List<ProductDto> products = new ArrayList<ProductDto>();
	this.productService.getProducts().forEach((product) -> {
	    products.add(mapper.map(product, ProductDto.class));
	});
	return responseBuilder.createResponse(Boolean.TRUE, null, products);
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> update(@RequestBody RequestProductDto product) {
	Product requestProduct = mapper.map(product, Product.class);
	Product updateProduct = this.productService.updateProduct(requestProduct);
	ProductDto responseProduct = mapper.map(updateProduct, ProductDto.class);
	return responseBuilder.createResponse(Boolean.TRUE, null, responseProduct);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> getProductWithCharacteristics(@PathVariable(value = "id") Long id) {

	Product productWithCharacteristics = this.productService.getProductWithCharacteristics(id);
	ProducDtoWithCharacteistics responseProduct = mapper.map(productWithCharacteristics,
		ProducDtoWithCharacteistics.class);
	return responseBuilder.createResponse(Boolean.TRUE, null, responseProduct);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Map<String, Object> delete(@PathVariable(value = "id") Long id) {
	this.productService.deleteProduct(id);
	return responseBuilder.createResponse(Boolean.TRUE, null, null);
    }

    @RequestMapping(path = "/manufacturer", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> getProductManufacturer(@RequestBody ProductDto product) {
	Product requestProduct = mapper.map(product, Product.class);
	Manufacturer productManufacturer = this.productService.getManufacturerOfProduct(requestProduct);
	ManufacturerDto responseManufacturer = mapper.map(productManufacturer, ManufacturerDto.class);
	return responseBuilder.createResponse(Boolean.TRUE, null, responseManufacturer);
    }

    @RequestMapping(path = "/productsByCategory", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> getProductsByCategory(@RequestBody ProductCategoryDto category) {
	List<ProductDto> products = new ArrayList<ProductDto>();
	this.productService.getProductsByCategory(mapper.map(category, ProductCategory.class)).forEach((product) -> {
	    products.add(mapper.map(product, ProductDto.class));
	});
	return responseBuilder.createResponse(Boolean.TRUE, null, products);
    }

    @RequestMapping(path = "/productTitle", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> checkProductTitle(@RequestBody String title) throws Exception {
	this.productService.getProductByTitle(title);
	return responseBuilder.createResponse(Boolean.TRUE, null, null);
    }
}
