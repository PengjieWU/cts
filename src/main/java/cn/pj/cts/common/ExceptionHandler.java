package cn.pj.cts.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:Pengjie WU
 * @Description:TODO
 * @Date: Create in 0:19 2019/1/24
 * @Modify By:
 **/
@ControllerAdvice
@Slf4j
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(ErrorsException.class)
    @ResponseBody
    public Response handleStudentException(HttpServletRequest request, ErrorsException ex) {
        Response response;
        log.error("ErrorsException code:{},msg:{}",ex.getResponse().getCode(),ex.getResponse().getMsg());
        response = new Response(ex.getResponse().getCode(),ex.getResponse().getMsg());
        return response;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @ResponseBody
    public Response handleException(HttpServletRequest request, Exception ex) {
        Response response;
        log.error("exception error:{}",ex);
        response = new Response(ErrorCodeAndMsg.Network_error.getCode(),
                ErrorCodeAndMsg.Network_error.getMsg());
        return response;
    }
}