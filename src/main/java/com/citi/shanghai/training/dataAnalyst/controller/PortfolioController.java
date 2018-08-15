package com.citi.shanghai.training.dataAnalyst.controller;

import com.citi.shanghai.training.dataAnalyst.entity.PortfolioAllSymbols;
import com.citi.shanghai.training.dataAnalyst.model.Portfolio;
import com.citi.shanghai.training.dataAnalyst.service.PortfoliosService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 8/13/2018.
 */
@Controller
@RequestMapping("/portfolio")
public class PortfolioController {

    @Resource
    private PortfoliosService service;

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public @ResponseBody List<PortfolioAllSymbols> getUserAllPortfolio(HttpServletRequest request){
        List<PortfolioAllSymbols> portfolios = service.getPortfolioByUserId(Integer.parseInt(request.getParameter("id")));
        return portfolios;
    }

    //no need to write to interface document
    @RequestMapping(value = "/postAll",method = RequestMethod.POST)
    public @ResponseBody List<PortfolioAllSymbols> postUserAllPortfolio(HttpServletRequest request){
        List<PortfolioAllSymbols> portfolios = service.getPortfolioByUserId((Integer) request.getAttribute("id"));
        return portfolios;
    }

    @RequestMapping(value = "/addPortfolio",method = RequestMethod.POST)
    public String addPortfolio(@RequestBody Portfolio portfolio,HttpServletRequest request){
        try {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            portfolio.setCreatedate(sdf.format(date));
            int rows = service.addPortfolio(portfolio);
            if(rows == 0){
                throw  new RuntimeException("add portfolio failed.");
            }
        }catch (Exception e){
            request.setAttribute("message",e.getMessage());
            return "forward:/error";
        }
        request.setAttribute("id",portfolio.getUserid());
        return "forward:/portfolio/postAll";
    }



    @RequestMapping(value = "/deletePortfolio",method = RequestMethod.POST)
    public String deletePortfolio(@RequestBody Portfolio portfolio,HttpServletRequest request){
        try {
            int rows = service.deletePortfolio(portfolio.getPortfolioid());
            if(rows == 0){
                throw  new RuntimeException("delete portfolio failed.");
            }
        }catch (Exception e){
            request.setAttribute("message",e.getMessage());
            return "forward:/error";
        }
        request.setAttribute("id",portfolio.getUserid());
        return "forward:/portfolio/postAll";
    }

}
