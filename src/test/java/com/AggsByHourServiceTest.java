package com;

import com.citi.shanghai.training.dataAnalyst.dao.AggsByHourMapper;
import com.citi.shanghai.training.dataAnalyst.entity.Price;
import com.citi.shanghai.training.dataAnalyst.entity.StockPrices;
import com.citi.shanghai.training.dataAnalyst.model.AggsByHour;
import com.citi.shanghai.training.dataAnalyst.service.AggsByHourService;
import com.citi.shanghai.training.dataAnalyst.service.impl.AggsByHourServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.inject.Inject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by Administrator on 8/16/2018.
 */

@RunWith(MockitoJUnitRunner.class)
public class AggsByHourServiceTest {
    @InjectMocks
    AggsByHourService service = new AggsByHourServiceImpl();

    @Mock
    AggsByHourMapper mapper;

    @Test
    public void getPrices() throws Exception {

        Integer symbolId = 1;
        String symbol = "a";
        List<StockPrices> prices = new ArrayList<>();
        StockPrices sp = new StockPrices();
        List<Price> prices1 = new ArrayList<>();
        Price price = new Price();
        price.setDate("2016-01-04 09:00:00");
        price.setOpen(110.0);
        price.setHigh(120.0);
        price.setVolume(new BigDecimal("250.00000"));
        price.setLow(100.0);
        price.setClose(115.0);
        price.setIncreasePercentage(0.2);
        prices1.add(price);
        sp.setPrices(prices1);
        sp.setSymbol(symbol);
        prices.add(sp);

        List<String> symbols = new ArrayList<>();
        symbols.add(symbol);

        Map<Integer,String> map = new HashMap<>();
        map.put(symbolId,symbol);
        List<Integer> symbolsId = new ArrayList<>();
        symbolsId.add(symbolId);


        List<AggsByHour> abhs = new ArrayList<>();
        AggsByHour abh = new AggsByHour();

        abh.setOpen(110.0);
        abh.setHigh(120.0);
        abh.setVolume(new BigDecimal("250.00000"));
        abh.setLow(100.0);
        abh.setClose(115.0);
        abh.setIncreasePercentage(0.2);
        abh.setDate(20160104);
        abh.setTime(9);
        abh.setSymbolid(symbolId);
        abhs.add(abh);
        when(mapper.selectRecordsByDateAndSymbols(anyInt(),anyInt(),anyListOf(Integer.class))).thenReturn(abhs);

        List<StockPrices> sp2 = service.getPrices(1,2,symbols,map);
        assertEquals(prices,sp2);
        verify(mapper,times(1)).selectRecordsByDateAndSymbols(1,2,symbolsId);
    }
}