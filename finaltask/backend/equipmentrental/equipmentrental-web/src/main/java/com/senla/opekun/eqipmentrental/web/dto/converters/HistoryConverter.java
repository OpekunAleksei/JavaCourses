package com.senla.opekun.eqipmentrental.web.dto.converters;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import org.dozer.DozerConverter;
import org.dozer.Mapper;
import org.dozer.MapperAware;

import com.senla.opekun.eqipmentrental.model.History;
import com.senla.opekun.eqipmentrental.model.Product;
import com.senla.opekun.eqipmentrental.model.User;
import com.senla.opekun.eqipmentrental.web.exceptionhandler.GlobalExceptionHandler;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
public class HistoryConverter extends DozerConverter<Map, History> implements MapperAware {

    private final static Logger logger = Logger.getLogger(GlobalExceptionHandler.class);
    private static final String PRODUCT = "product";
    private static final String USER = "user";
    private static final String HISTORY = "history";
    private final static String RETURN_DATE = "returnDate";
    private final static String DATE_OF_RECEIVING = "dateOfReceiving";
    private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    private Mapper mapper;

    public HistoryConverter() {
	super(Map.class, History.class);
    }

    @Override
    public History convertTo(Map a, History b) {
	try {
	    Product product = mapper.map(a.get(PRODUCT), Product.class);
	    User user = mapper.map(a.get(USER), User.class);
	    LinkedHashMap c = (LinkedHashMap) a.get(HISTORY);
	    b = new History();
	    b.setReturnDate(format.parse((String) c.get(RETURN_DATE)));
	    b.setDateOfReceiving(format.parse((String) c.get(DATE_OF_RECEIVING)));
	    b.setProduct(product);
	    b.setUser(user);
	} catch (ParseException ex) {
	    logger.error(new Date() + " " + ex.getMessage());
	}
	return b;
    }

    @Override
    public Map convertFrom(History b, Map a) {
	return null;
    }

    @Override
    public void setMapper(Mapper mapper) {
	this.mapper = mapper;
    }

}
