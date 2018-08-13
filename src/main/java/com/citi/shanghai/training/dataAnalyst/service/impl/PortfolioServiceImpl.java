package com.citi.shanghai.training.dataAnalyst.service.impl;

import com.citi.shanghai.training.dataAnalyst.dao.PortfolioMapper;
import com.citi.shanghai.training.dataAnalyst.model.Portfolio;
import com.citi.shanghai.training.dataAnalyst.service.PortfoliosService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 8/13/2018.
 */
@Service("portfolio")
public class PortfolioServiceImpl implements PortfoliosService {
    private static Logger logger = Logger.getLogger(PortfolioServiceImpl.class);
    @Resource
    private PortfolioMapper mapper;
    @Override
    public List<Portfolio> getPortfolioByUserId(int userId) {
        List<Portfolio> portfolios;
//        if((portfolios=mapper.selectPortfolioByUserId(userId))!= null){
//            return portfolios;
//        }
        logger.info("Get portfolios by userId has exception: result list is null");
        portfolios = new ArrayList<>();
        return portfolios;
    }
}
