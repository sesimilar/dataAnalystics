package com.citi.shanghai.training.dataAnalyst.controller;

import com.citi.shanghai.training.dataAnalyst.model.PortfolioSymbols;
import com.citi.shanghai.training.dataAnalyst.service.PortfolioSymbolsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/portfolioSymbols")
public class PortfolioSymbolsController {
    @Resource
    private PortfolioSymbolsService service;

    @RequestMapping(value = "/addPortfolioSymbols",method = RequestMethod.POST)
    public String addPortfolioSymbol(@RequestBody PortfolioSymbols ps, HttpServletRequest request){
//        @PathVariable Integer portfolioid, @PathVariable Integer symbolid,
//        PortfolioSymbols portfolioSymbols = new PortfolioSymbols();
//        portfolioSymbols.setPortfolioid(ps.getPortfolioid());
//        portfolioSymbols.setSymbolid(ps.getSymbolid());
        try{
            int rows = service.addPortfolioSymbol(ps);
            if(rows == 0) {
                throw  new RuntimeException("add symbol failed.");
            }
        }catch (Exception e){
            request.setAttribute("message",e.getMessage());
            return "forward:/error";
        }
        return "forward:/success";
    }
    @RequestMapping(value = "/delPortfolioSymbols",method = RequestMethod.POST)
    public String deletePortfolioSymbol(@RequestBody PortfolioSymbols ps, HttpServletRequest request){
//        @PathVariable Integer portfolioid,@PathVariable Integer symbolid,
//        PortfolioSymbols portfolioSymbols = new PortfolioSymbols();
//        portfolioSymbols.setPortfolioid(portfolioid);
//        portfolioSymbols.setSymbolid(symbolid);
        try{
            int rows =  service.deletePortfolioSymbol(ps);
            if(rows == 0) {
                throw  new RuntimeException("delete symbol failed.");
            }
        }catch (Exception e){
            request.setAttribute("message",e.getMessage());
            return "forward:/error";
        }
        return "forward:/success";
    }
}
