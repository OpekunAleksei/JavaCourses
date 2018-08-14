package com.senla.opekun.eqipmentrental.web.controllers;

import com.senla.opekun.eqipmentrental.api.service.IHistoryService;
import com.senla.opekun.eqipmentrental.api.utils.IResponseBuilder;
import com.senla.opekun.eqipmentrental.model.History;
import com.senla.opekun.eqipmentrental.model.Product;
import com.senla.opekun.eqipmentrental.model.User;
import com.senla.opekun.eqipmentrental.web.dto.history.HistoryDto;
import com.senla.opekun.eqipmentrental.web.dto.product.ProductDto;
import com.senla.opekun.eqipmentrental.web.dto.user.UserDto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Controller
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    private IHistoryService historyService;
    @Autowired
    private IResponseBuilder responseBuilder;
    @Autowired
    private DozerBeanMapper dozerMapper;

    @RequestMapping(path = "/rentProduct", method = RequestMethod.PUT)
    public @ResponseBody Map<String, Object> rentProduct(@RequestBody HashMap<String, Object> request) {

	History history = dozerMapper.map(request, History.class);
	historyService.rentProduct(history);
	return responseBuilder.createResponse(Boolean.TRUE, null, null);
    }

    @RequestMapping(path = "/returnProduct", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> returnProduct(@RequestBody ProductDto productDto) {
	Product product = dozerMapper.map(productDto, Product.class);
	History persistentHistory = historyService.returnProduct(product);
	BigDecimal price = this.historyService.getProductRentPrice(persistentHistory);
	return responseBuilder.createResponse(Boolean.TRUE, null, price);
    }

    @RequestMapping(path = "/productHistorys", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> productHistorys(@RequestBody ProductDto productDto) {

	Product product = dozerMapper.map(productDto, Product.class);
	List<HistoryDto> historys = new ArrayList<HistoryDto>();
	historyService.getHistorysOfProduct(product).forEach((history) -> {
	    historys.add(dozerMapper.map(history, HistoryDto.class));
	});
	return responseBuilder.createResponse(Boolean.TRUE, null, historys);
    }

    @RequestMapping(path = "/returnProductDate", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> getReturnDateOfProduct(@RequestBody ProductDto productDto) {

	Product product = dozerMapper.map(productDto, Product.class);
	Date returnDate = historyService.getReturnDateOfProduct(product);
	return responseBuilder.createResponse(Boolean.TRUE, null, returnDate);
    }

    @RequestMapping(path = "/userProducts", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> getUserProducts(@RequestBody UserDto userDto) {
	User user = dozerMapper.map(userDto, User.class);
	List<ProductDto> products = new ArrayList<ProductDto>();
	historyService.getProductsOfUser(user).forEach((product) -> {
	    products.add(dozerMapper.map(product, ProductDto.class));
	});
	return responseBuilder.createResponse(Boolean.TRUE, null, products);
    }
}
