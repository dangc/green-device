package com.nuri.green.device.exception;

import com.google.gson.Gson;
import com.nuri.green.constants.ErrorCode;
import com.nuri.green.constants.ResultCode;
import com.nuri.green.api.response.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
public class AbstractBaseResource {

    // TODO - ERROR 코드 변경

    @ExceptionHandler(AbstractBaseException.class)
    public String abstractBaseException(HttpServletRequest req, HttpServletResponse res, final AbstractBaseException exception) {

        log.error("AbstractBaseException : " + exception.getMessage());
        res.setStatus(exception.getHttpStatus().value());
        ResponseMessage response = new ResponseMessage(ResultCode.N, ErrorCode.E0002, exception.getMessage());
        Gson gson = new Gson();
        return gson.toJson(response);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value=HttpStatus.BAD_REQUEST)
    public String illegalArgumentException(HttpServletRequest req, final IllegalArgumentException exception){
        ResponseMessage response = new ResponseMessage(ResultCode.N, ErrorCode.E0002, ErrorCode.E0002.getMsg());
        return new Gson().toJson(response);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(value=HttpStatus.BAD_REQUEST)
    public String HttpMessageNotReadableException(HttpServletRequest req, final HttpMessageNotReadableException exception){
        log.info(exception.toString());
        ResponseMessage response = new ResponseMessage(ResultCode.N, ErrorCode.E0002, HttpStatus.BAD_REQUEST.toString());
        return new Gson().toJson(response);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
    public String exception(HttpServletRequest req, final Exception exception) {
        log.info(exception.toString());
        ResponseMessage response = new ResponseMessage(ResultCode.N, ErrorCode.E0002, ErrorCode.E0002.getMsg());
        return new Gson().toJson(response);
    }
}