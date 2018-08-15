package com.citi.shanghai.training.dataAnalyst.service;

import com.citi.shanghai.training.dataAnalyst.entity.PortfolioAllSymbols;
import com.citi.shanghai.training.dataAnalyst.model.Portfolio;

import java.util.List;

/**
 * Created by Administrator on 8/13/2018.
 */
public interface PortfoliosService {
    List<PortfolioAllSymbols> getPortfolioByUserId(int userId);

    int addPortfolio(Portfolio record);
    int deletePortfolio(int portfolioID);

}
