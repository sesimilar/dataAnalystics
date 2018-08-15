package com.citi.shanghai.training.dataAnalyst.service;

import com.citi.shanghai.training.dataAnalyst.model.PortfolioSymbols;

public interface PortfolioSymbolsService {
    int addPortfolioSymbol(PortfolioSymbols portfolioSymbols);
    int  deletePortfolioSymbol(PortfolioSymbols portfolioSymbols);
}
