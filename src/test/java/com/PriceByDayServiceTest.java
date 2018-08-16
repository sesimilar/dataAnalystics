package com;

import com.citi.shanghai.training.dataAnalyst.dao.AggsByDayMapper;
import com.citi.shanghai.training.dataAnalyst.entity.EnhancePriceToFront;
import com.citi.shanghai.training.dataAnalyst.entity.Price;
import com.citi.shanghai.training.dataAnalyst.entity.PriceToFront;
import com.citi.shanghai.training.dataAnalyst.entity.StockPrices;
import com.citi.shanghai.training.dataAnalyst.model.AggsByDay;
import com.citi.shanghai.training.dataAnalyst.model.AggsByHour;
import com.citi.shanghai.training.dataAnalyst.service.PriceByDayService;
import com.citi.shanghai.training.dataAnalyst.service.impl.PriceByDayServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.when;

/**
 * Created by Administrator on 8/16/2018.
 */
@RunWith(MockitoJUnitRunner.class)
public class PriceByDayServiceTest {

    @InjectMocks
    PriceByDayService service = new PriceByDayServiceImpl();

    @Mock
    AggsByDayMapper mapper;

    @Test
    public void getPrice() throws Exception {
        Integer symbolId = 1;
        String symbol = "a";
//        List<StockPrices> prices = new ArrayList<>();
//        StockPrices sp = new StockPrices();
//        List<Price> prices1 = new ArrayList<>();
//        Price price = new Price();
//        price.setDate("2016-01-04 09:00:00");
//        price.setOpen(110.0);
//        price.setHigh(120.0);
//        price.setVolume(new BigDecimal("250.00000"));
//        price.setLow(100.0);
//        price.setClose(115.0);
//        price.setIncreasePercentage(0.2);
//        prices1.add(price);
//        sp.setPrices(prices1);
//        sp.setSymbol(symbol);
//        prices.add(sp);

        List<PriceToFront> ptfs = new ArrayList<>();
        PriceToFront ptf = new PriceToFront();
        ptf.setSymbol(symbol);
        String[][] priceStrings = new String[1][];
        priceStrings[0] = new String[7];
        priceStrings[0][0] = "2016-01-04";
        priceStrings[0][1] = "110.0";
        priceStrings[0][2] = "115.0";
        priceStrings[0][3] = "120.0";
        priceStrings[0][4] = "100.0";
        priceStrings[0][5] = "250.00000";
        priceStrings[0][6] = "0.2";
        ptf.setData(priceStrings);
        ptfs.add(ptf);
        EnhancePriceToFront eptfExpect = new EnhancePriceToFront();
        eptfExpect.setResult(ptfs);

        List<String> symbols = new ArrayList<>();
        symbols.add(symbol);

        Map<Integer,String> map = new HashMap<>();
        map.put(symbolId,symbol);
        List<Integer> symbolsId = new ArrayList<>();
        symbolsId.add(symbolId);


        List<AggsByDay> abds = new ArrayList<>();
        AggsByDay abd = new AggsByDay();

        abd.setOpen(110.0);
        abd.setHigh(120.0);
        abd.setSymbol(symbol);
        abd.setVolume(new BigDecimal("250.00000"));
        abd.setLow(100.0);
        abd.setClose(115.0);
        abd.setIncreasePercentage(0.2);
        abd.setDate(20160104);
        abd.setSymbolid(symbolId);
        abds.add(abd);

        when(mapper.getAllPriceByDay(anyInt(),anyInt(),anyListOf(String.class))).thenReturn(abds);

        EnhancePriceToFront eptf = service.getPrice(2,2,symbols);


        assertEquals(eptfExpect,eptf);
    }

}