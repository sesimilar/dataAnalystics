package com.citi.shanghai.training.dataAnalyst.service;

import com.citi.shanghai.training.dataAnalyst.entity.StockPrices;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 8/14/2018.
 */
public interface AggsByHourService {
    List<StockPrices> getPrices(int fromDate, int toDate, List<String> symbols,Map<Integer,String> symbolMapper);
}
