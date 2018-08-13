package com.citi.shanghai.training.dataAnalyst.controller;

import com.citi.shanghai.training.dataAnalyst.entity.UserAllPortfolio;
import com.citi.shanghai.training.dataAnalyst.model.Portfolio;
import com.citi.shanghai.training.dataAnalyst.service.PortfoliosService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 8/13/2018.
 */
@Controller
@RequestMapping("/portfolio")
public class PortfolioController {

    @Resource
    private PortfoliosService service;

    @RequestMapping(value = "/all/{id}",method = RequestMethod.GET)
    public @ResponseBody UserAllPortfolio getUserAllPortfolio(@PathVariable String id, HttpServletRequest request){
        int userId = Integer.parseInt(id);
        List<Portfolio> portfolios = service.getPortfolioByUserId(userId);


        return null;
    }

}
