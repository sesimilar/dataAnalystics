package com.citi.shanghai.training.dataAnalyst.controller;

import com.citi.shanghai.training.dataAnalyst.entity.EnhancePriceToFront;
import com.citi.shanghai.training.dataAnalyst.entity.Price;
import com.citi.shanghai.training.dataAnalyst.entity.PriceToFront;
import com.citi.shanghai.training.dataAnalyst.entity.StockPrices;
import com.citi.shanghai.training.dataAnalyst.service.AggsByHourService;
import com.citi.shanghai.training.dataAnalyst.service.SymbolsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by Administrator on 8/14/2018.
 */
@Controller
@RequestMapping("/price")
public class PriceController {

    @Resource
    private AggsByHourService service;
    @Resource
    private SymbolsService symbolsService;

    @RequestMapping(value = "/byHour",method = RequestMethod.GET)
    public @ResponseBody EnhancePriceToFront getPriceByHour(HttpServletRequest request){
        EnhancePriceToFront ept = new EnhancePriceToFront();
        List<PriceToFront> priceToFronts  = new ArrayList<>();
        try {
        int fromDate = Integer.parseInt(request.getParameter("from_date"));
        int toDate = Integer.parseInt(request.getParameter("to_date"));
        String symbolString = request.getParameter("symbol");
        Map<Integer,String> symbolMapper = new HashMap<>();
        symbolsService.getAllSymbols().forEach(symbols -> {
            symbolMapper.put(symbols.getSymbolid(),symbols.getSymbol());
        });
        List<String> symbols = Arrays.asList(symbolString.split("\\|"));
        List<StockPrices> prices = service.getPrices(fromDate,toDate,symbols,symbolMapper);
        prices.forEach(price -> {
            PriceToFront ptf = new PriceToFront();
            ptf.setSymbol(price.getSymbol());
            ptf.setData(new String[price.getPrices().size()][]);
            String[][] data = ptf.getData();
            for (int i = 0; i < price.getPrices().size(); i++) {
                data[i] = new String[6];
                data[i][0] = price.getPrices().get(i).getDate();
                data[i][1] = String.valueOf(price.getPrices().get(i).getOpen());
                data[i][2] = String.valueOf(price.getPrices().get(i).getClose());
                data[i][3] = String.valueOf(price.getPrices().get(i).getHigh());
                data[i][4] = String.valueOf(price.getPrices().get(i).getLow());
                data[i][5] = String.valueOf(price.getPrices().get(i).getVolume());
            }
            ptf.setData(data);
            priceToFronts.add(ptf);
        });
        }catch (Exception e){
            ept.setErr(e.getMessage());
        }finally {
            ept.setResult(priceToFronts);
        }
        return ept;
    }
}
