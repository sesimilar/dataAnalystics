package com.citi.shanghai.training.dataAnalyst.controller;

import com.citi.shanghai.training.dataAnalyst.entity.EnhancePriceToFront;
import com.citi.shanghai.training.dataAnalyst.entity.Price;
import com.citi.shanghai.training.dataAnalyst.entity.PriceToFront;
import com.citi.shanghai.training.dataAnalyst.entity.StockPrices;
import com.citi.shanghai.training.dataAnalyst.service.AggsByHourService;
import com.citi.shanghai.training.dataAnalyst.service.PriceByDayService;
import com.citi.shanghai.training.dataAnalyst.service.SymbolsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.NumberFormat;
import java.util.*;

/**
 * Created by Administrator on 8/14/2018.
 */
@Controller
@RequestMapping("/api")
public class PriceController {

    @Resource
    private AggsByHourService service;

    @Resource
    private PriceByDayService serviceByDay;

    @Resource
    private SymbolsService symbolsService;

    @RequestMapping(value = "/price",method = RequestMethod.GET)
    public @ResponseBody EnhancePriceToFront getPrice(HttpServletRequest request){
        String interval = request.getParameter("interval");
        EnhancePriceToFront enhancePriceToFront = null;
        switch (interval){
            case "1h":
                enhancePriceToFront = getPriceByHour(request);
                break;
            case "1d":
                enhancePriceToFront = getPriceByDay(request);
                break;
            case "1m":
                // 1 min to do
                break;
            case "1M":
                //1 month to do
                break;
            default:
                break;
        }
        return enhancePriceToFront;
    }

    private EnhancePriceToFront getPriceByHour(HttpServletRequest request){
        NumberFormat format = NumberFormat.getInstance();
        format.setMaximumFractionDigits(6);
        EnhancePriceToFront ept = new EnhancePriceToFront();
        List<PriceToFront> priceToFronts  = new ArrayList<>();
        try {
        int fromDate = Integer.parseInt(request.getParameter("from_date").replace("-",""));
        int toDate = Integer.parseInt(request.getParameter("to_date").replace("-",""));
        String symbolString = request.getParameter("symbol");
        Map<Integer,String> symbolMapper = new HashMap<>();
        symbolsService.getAllSymbols().forEach(symbols -> {
            symbolMapper.put(symbols.getSymbolid(),symbols.getSymbol());
        });
        List<String> symbols = Arrays.asList(symbolString.split(","));
        List<StockPrices> prices = service.getPrices(fromDate,toDate,symbols,symbolMapper);
        prices.forEach(price -> {
            PriceToFront ptf = new PriceToFront();
            ptf.setSymbol(price.getSymbol());
            ptf.setData(new String[price.getPrices().size()][]);
            String[][] data = ptf.getData();
            for (int i = 0; i < price.getPrices().size(); i++) {
                data[i] = new String[7];
                data[i][0] = price.getPrices().get(i).getDate();
                data[i][1] = String.valueOf(price.getPrices().get(i).getOpen());
                data[i][2] = String.valueOf(price.getPrices().get(i).getClose());
                data[i][3] = String.valueOf(price.getPrices().get(i).getHigh());
                data[i][4] = String.valueOf(price.getPrices().get(i).getLow());
                data[i][5] = String.valueOf(price.getPrices().get(i).getVolume());
                data[i][6] = String.valueOf(format.format(price.getPrices().get(i).getIncreasePercentage()));
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
    private EnhancePriceToFront getPriceByDay(HttpServletRequest request){
        int fromDate = Integer.parseInt(request.getParameter("from_date").replace("-",""));
        int toDate = Integer.parseInt(request.getParameter("to_date").replace("-",""));
        String symbolString = request.getParameter("symbol");
        return serviceByDay.getPrice(fromDate,toDate,Arrays.asList(symbolString.split(",")));
    }

}
