package com.citi.shanghai.training.dataAnalyst.controller;

import com.citi.shanghai.training.dataAnalyst.model.Symbols;
import com.citi.shanghai.training.dataAnalyst.service.SymbolsService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
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
@RequestMapping(value = "/symbols")
public class SymbolController {
    private static Logger logger = Logger.getLogger(SymbolController.class);
    @Resource
    private SymbolsService service;

    @RequestMapping(value = "/allSymbols",method = RequestMethod.GET)
    public @ResponseBody List<Symbols> allSymbols(HttpServletRequest request){
        List<Symbols> symbols = service.getAllSymbols();
        logger.debug(symbols);
        return symbols;
    }


}
