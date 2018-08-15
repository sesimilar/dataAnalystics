package com.citi.shanghai.training.dataAnalyst.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 8/15/2018.
 */
@Controller
public class SuccessController {

    @RequestMapping(value = "/success",method = RequestMethod.POST)
    public @ResponseBody String returnError(){
        return "success";
    }
}
