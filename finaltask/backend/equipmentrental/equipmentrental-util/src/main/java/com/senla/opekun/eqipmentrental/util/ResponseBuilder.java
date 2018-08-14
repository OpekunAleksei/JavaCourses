package com.senla.opekun.eqipmentrental.util;

import com.senla.opekun.eqipmentrental.api.utils.IResponseBuilder;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@Component
public class ResponseBuilder implements IResponseBuilder {

    private final Map<String, Object> response = new HashMap<String, Object>();
    private static final String IS_SUCCESS = "isSuccess";
    private static final String ERROR_MSG = "erorMsg";
    private static final String DATA = "data";

    @Override
    public Map<String, Object> createResponse(Boolean success, String errCode, Object data) {
        this.response.clear();
        this.response.put(IS_SUCCESS, success);
        this.response.put(ERROR_MSG, errCode);
        this.response.put(DATA, data);
        return this.response;
    }

}
