package com.citi.shanghai.training.dataAnalyst.service.impl;

import com.citi.shanghai.training.dataAnalyst.dao.AggsByHourMapper;
import com.citi.shanghai.training.dataAnalyst.entity.Price;
import com.citi.shanghai.training.dataAnalyst.entity.StockPrices;
import com.citi.shanghai.training.dataAnalyst.model.AggsByHour;
import com.citi.shanghai.training.dataAnalyst.service.AggsByHourService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 8/14/2018.
 */
@Service("aggsByHourServiceImpl")
public class AggsByHourServiceImpl implements AggsByHourService{

    @Resource
    private AggsByHourMapper mapper;

    @Override
    public List<StockPrices> getPrices(int fromDate, int toDate, List<String> symbols,Map<Integer,String> symbolMapper) {
        List<StockPrices> prices = new ArrayList<>();
        List<Integer> symbolsId = new ArrayList<>();
        Map<String,Integer> idMapper = new HashMap<>();
        symbolMapper.entrySet().forEach(singalMapping -> {
            idMapper.put(singalMapping.getValue(),singalMapping.getKey());
        });
        symbols.forEach(symbol -> {
         symbolsId.add(idMapper.get(symbol));
        });
        List<AggsByHour> aggs= mapper.selectRecordsByDateAndSymbols(fromDate,toDate,symbolsId);
        Map<Integer,StockPrices> priceAggBySymbol = new HashMap<>();
        aggs.forEach(agg -> {
            StockPrices sp;
            if(priceAggBySymbol.containsKey(agg.getSymbolid()))
                sp = priceAggBySymbol.get(agg.getSymbolid());
            else {
                sp = new StockPrices();
                sp.setPrices(new ArrayList<Price>());
            }
            sp.setSymbol(symbolMapper.get(agg.getSymbolid()));
            Price price  = new Price();
            price.setOpen(agg.getOpen());
            price.setClose(agg.getClose());
            price.setDate(agg.getDate()/10000 + "-" +String.format("%2s",(agg.getDate() % 10000) / 100).replace(' ','0') + "-" + String.format("%2s",agg.getDate() % 100).replace(' ','0')+ " " + String.format("%2s",agg.getTime()).replace(' ','0')+ ":00:00");
            price.setHigh(agg.getHigh());
            price.setLow(agg.getLow());
            price.setVolume(agg.getVolume());
            price.setIncreasePercentage(agg.getIncreasePercentage());
            sp.getPrices().add(price);
            priceAggBySymbol.put(agg.getSymbolid(),sp);
        });
        return new ArrayList<StockPrices>(priceAggBySymbol.values());
    }
}
