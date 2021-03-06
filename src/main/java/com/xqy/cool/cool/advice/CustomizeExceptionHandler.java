package com.xqy.cool.cool.advice;

import com.alibaba.fastjson.JSON;
import com.xqy.cool.cool.dto.ResultDTO;
import com.xqy.cool.cool.exception.CustomizeErrorCode;
import com.xqy.cool.cool.exception.CustomizeException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by codedrinker on 2019/5/28.
 */
@ControllerAdvice
public class CustomizeExceptionHandler {

//    @ExceptionHandler(Exception.class)
//    ModelAndView handle(Throwable e, Model model, HttpServletRequest request, HttpServletResponse response) {
//        String contentType = request.getContentType();
//        if ("application/json".equals(contentType)) {
//            ResultDTO resultDTO;
//            // 返回 JSON
//            if (e instanceof CustomizeException) {
//                resultDTO = ResultDTO.errorOf((CustomizeException) e);
//            } else {
//                log.error("handle error", e);
//                resultDTO = ResultDTO.errorOf(CustomizeErrorCode.SYS_ERROR);
//            }
//            try {
//                response.setContentType("application/json");
//                response.setStatus(200);
//                response.setCharacterEncoding("utf-8");
//                PrintWriter writer = response.getWriter();
//                writer.write(JSON.toJSONString(resultDTO));
//                writer.close();
//            } catch (IOException ioe) {
//            }
//            return null;
//        } else {
//            // 错误页面跳转
//            if (e instanceof CustomizeException) {
//                model.addAttribute("message", e.getMessage());
//            } else {
//                log.error("handle error", e);
//                model.addAttribute("message", CustomizeErrorCode.SYS_ERROR.getMessage());
//            }
//            return new ModelAndView("error");
//        }
//    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    ModelAndView handle(HttpServletRequest request, Throwable ex, Model model, HttpServletResponse response){
        String contentType = request.getContentType();
        ResultDTO resultDTO = null;


        if ("application/json".equals(contentType)){
            //返回JSON
            if (ex instanceof CustomizeException){
                resultDTO = ResultDTO.errorOf((CustomizeException) ex);
            }else {
                resultDTO = ResultDTO.errorOf(CustomizeErrorCode.SYS_ERROR);
            }

            try {
                response.setContentType("application/json");
                response.setStatus(200);
                response.setCharacterEncoding("utf-8");
                PrintWriter writer = response.getWriter();
                writer.write(JSON.toJSONString(resultDTO));
                writer.close();
            } catch (IOException e) {
            }

            return null;
        }else {
            //错误页面跳转
            if (ex instanceof CustomizeException){
                model.addAttribute("message", ex.getMessage());
            }else {
                model.addAttribute("message", CustomizeErrorCode.SYS_ERROR.getMessage());
            }
        }


        return new ModelAndView("error");
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null){
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}
