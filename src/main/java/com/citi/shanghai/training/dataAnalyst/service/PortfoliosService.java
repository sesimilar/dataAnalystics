package com.citi.shanghai.training.dataAnalyst.service;

import com.citi.shanghai.training.dataAnalyst.model.Portfolio;

import java.util.List;

/**
 * Created by Administrator on 8/13/2018.
 */
public interface PortfoliosService {
    List<Portfolio> getPortfolioByUserId(int userId);
}
