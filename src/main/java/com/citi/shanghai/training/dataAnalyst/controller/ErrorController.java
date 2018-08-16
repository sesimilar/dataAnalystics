package com.citi.shanghai.training.dataAnalyst.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Administrator on 8/15/2018.
 */
@Controller
public class ErrorController {

    @RequestMapping(value = "/error",method = RequestMethod.POST)
    public @ResponseBody
    Map returnError(HttpServletRequest request){
        Map<String,String> map = new LinkedHashMap<String,String>();
        map.put("status","error");
        map.put("errorMessage",request.getAttribute("message").toString());
        return map;
    }
}
