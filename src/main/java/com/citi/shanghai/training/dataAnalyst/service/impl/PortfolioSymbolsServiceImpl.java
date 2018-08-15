package com.citi.shanghai.training.dataAnalyst.service.impl;

import com.citi.shanghai.training.dataAnalyst.dao.PortfolioSymbolsMapper;
import com.citi.shanghai.training.dataAnalyst.dao.SymbolsMapper;
import com.citi.shanghai.training.dataAnalyst.model.PortfolioSymbols;
import com.citi.shanghai.training.dataAnalyst.service.PortfolioSymbolsService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("portfolioSymbolsService")
public class PortfolioSymbolsServiceImpl implements PortfolioSymbolsService {
    private static Logger logger = Logger.getLogger(PortfolioSymbolsServiceImpl.class);
    @Resource
    private PortfolioSymbolsMapper mapper;

    @Override
    public int addPortfolioSymbol(PortfolioSymbols portfolioSymbols) {

       return mapper.addPortfolioSymbol(portfolioSymbols);

    }

    @Override
    public int deletePortfolioSymbol(PortfolioSymbols portfolioSymbols) {
        return mapper.deletePortfolioSymbol(portfolioSymbols);
    }

}




