package com.citi.shanghai.training.dataAnalyst.controller;

import com.citi.shanghai.training.dataAnalyst.model.User;
import com.citi.shanghai.training.dataAnalyst.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    @RequestMapping(value="/test",method=RequestMethod.GET)
    public String test(HttpServletRequest request, Model model){
        int userId = Integer.parseInt(request.getParameter("id"));
        logger.debug("userID:" + userId);
        User user = userService.getUserById(userId);
        logger.debug(user.toString());
        model.addAttribute("user", user);
        return "index";
    }
    @RequestMapping(value = "/mapping/companys",method = RequestMethod.GET)
    public @ResponseBody String companyMapping(HttpServletRequest request, Model model){

        return "";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> Register(@RequestBody User user, HttpServletRequest request){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        try{
            user  = userService.register(user.getUsername(),user.getPassword());
            if(user == null) {
                throw  new RuntimeException("Register failed due to some unknow issue");
            }
            map.put("result", user);
        }catch (Exception e){
//            request.setAttribute("message",e.getMessage());
            map.put("error",e.getMessage());
        }
        return map;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> Login(@RequestBody User user ,HttpServletRequest request){
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        try {
            user = userService.login(user.getUsername(),user.getPassword());
            if(user == null){
                throw  new RuntimeException("Incorrect name or password");
            }
            map.put("result", user);
        }catch (Exception e){
            map.put("error", e.getMessage());
        }
        return map;
    }
}
