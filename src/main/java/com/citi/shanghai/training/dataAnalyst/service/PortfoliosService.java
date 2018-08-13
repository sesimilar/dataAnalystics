package com.citi.shanghai.training.dataAnalyst.service;

import com.citi.shanghai.training.dataAnalyst.entity.PortfolioAllSymbols;

import java.util.List;

/**
 * Created by Administrator on 8/13/2018.
 */
public interface PortfoliosService {
    List<PortfolioAllSymbols> getPortfolioByUserId(int userId);
}
