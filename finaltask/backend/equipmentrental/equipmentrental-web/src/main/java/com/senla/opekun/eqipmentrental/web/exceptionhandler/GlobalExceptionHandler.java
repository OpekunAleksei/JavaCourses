package com.senla.opekun.eqipmentrental.web.exceptionhandler;

import com.senla.opekun.eqipmentrental.api.utils.IErrMsgHandler;
import com.senla.opekun.eqipmentrental.api.utils.IResponseBuilder;
import com.senla.opekun.eqipmentrental.exceptions.LoginExist;
import com.senla.opekun.eqipmentrental.exceptions.SignInException;

import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Алексей Опекун
 * @version 1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private final static String SIGN_IN_EXCEPTION = "SignInException";
    private final static String CREATE_DATA_EXCEPTION = "DataIntegrityViolationException";
    private final static String LOGIN_EXIST_EXCEPTION = "LoginExist";
    private final static String UNKNOW_EXCEPTION = "UnknownException";
    private final static Logger logger = Logger.getLogger(GlobalExceptionHandler.class);
    @Autowired
    private IResponseBuilder responseBuilder;
    @Autowired
    private IErrMsgHandler exceptionMsgHandler;

    @ExceptionHandler(value = SignInException.class)
    public @ResponseBody
    Map<String, Object> wrongLoginOrPassword(Exception ex) {
        String errCode = exceptionMsgHandler.getErrCodeByException(SIGN_IN_EXCEPTION);
        return responseBuilder.createResponse(Boolean.FALSE, errCode, null);
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public @ResponseBody
    Map<String, Object> dataExist(Exception ex) {
        String errCode = exceptionMsgHandler.getErrCodeByException(CREATE_DATA_EXCEPTION);
        return responseBuilder.createResponse(Boolean.FALSE, errCode, null);
    }

    @ExceptionHandler(value = LoginExist.class)
    public @ResponseBody
    Map<String, Object> LoginExist(Exception ex) {
        String errCode = exceptionMsgHandler.getErrCodeByException(LOGIN_EXIST_EXCEPTION);
        return responseBuilder.createResponse(Boolean.FALSE, errCode, null);
    }

    @ExceptionHandler(value = Exception.class)
    public @ResponseBody
    Map<String, Object> unknownException(Exception ex) {
        logger.error(new Date() + " " + ex.getMessage());
        String errCode = exceptionMsgHandler.getErrCodeByException(UNKNOW_EXCEPTION);
        return responseBuilder.createResponse(Boolean.FALSE, errCode, null);
    }
}
