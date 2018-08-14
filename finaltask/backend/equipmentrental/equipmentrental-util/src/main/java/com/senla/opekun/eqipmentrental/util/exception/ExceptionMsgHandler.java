package com.senla.opekun.eqipmentrental.util.exception;

import com.senla.opekun.eqipmentrental.api.utils.IErrMsgHandler;
import java.util.Properties;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class ExceptionMsgHandler implements IErrMsgHandler {

    @Resource(name = "errConfiguration")
    private Properties errConfiguration;

    @Override
    public String getErrCodeByException(String name) {
        return this.errConfiguration.getProperty(name);

    }

}
