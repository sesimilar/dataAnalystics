package com.citi.shanghai.training.dataAnalyst.service.impl;

import com.citi.shanghai.training.dataAnalyst.dao.AggsByDayMapper;
import com.citi.shanghai.training.dataAnalyst.entity.EnhancePriceToFront;
import com.citi.shanghai.training.dataAnalyst.entity.PriceToFront;
import com.citi.shanghai.training.dataAnalyst.model.AggsByDay;
import com.citi.shanghai.training.dataAnalyst.service.PriceByDayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("priceByDay")
public class PriceByDayServiceImpl implements PriceByDayService {
    @Resource
    private AggsByDayMapper mapper;
    @Override
    public EnhancePriceToFront getPrice(int fromDate, int toDate, List<String> symbols) {
        NumberFormat format = NumberFormat.getInstance();
        format.setMaximumFractionDigits(6);
        EnhancePriceToFront enhancePriceToFronts = new EnhancePriceToFront();
        enhancePriceToFronts.setResult(new ArrayList<>());
        Map<String,List<AggsByDay>> priceInSymbol = new HashMap<>();
        List<PriceToFront> priceToFronts = enhancePriceToFronts.getResult();
        try {

            List<AggsByDay> priceInDay = mapper.getAllPriceByDay(fromDate,toDate,symbols);
            priceInDay.forEach(price->{
                if(priceInSymbol.containsKey(price.getSymbol())){
                    priceInSymbol.get(price.getSymbol()).add(price);
                }else {
                    priceInSymbol.put(price.getSymbol(), new ArrayList<>());
                    priceInSymbol.get(price.getSymbol()).add(price);
                }
            });
            for(Map.Entry<String,List<AggsByDay>> entry: priceInSymbol.entrySet()){
                PriceToFront priceToFront = new PriceToFront();
                priceToFront.setSymbol(entry.getKey());
                String[][] displayPrices = new String[entry.getValue().size()][];
                for (int i = 0; i < entry.getValue().size(); i++) {
                    displayPrices[i] = new String[7];
                    AggsByDay aggsByDay = entry.getValue().get(i);
                    int date =aggsByDay.getDate();
                    displayPrices[i][0] = date/10000 + "-" +String.format("%2s",(date % 10000) / 100).replace(' ','0') + "-" + String.format("%2s",date % 100).replace(' ','0');
                    displayPrices[i][1] = String.valueOf(aggsByDay.getOpen());
                    displayPrices[i][2] = String.valueOf(aggsByDay.getClose());
                    displayPrices[i][3] = String.valueOf(aggsByDay.getHigh());
                    displayPrices[i][4] = String.valueOf(aggsByDay.getLow());
                    displayPrices[i][5] = String.valueOf(aggsByDay.getVolume());
                    displayPrices[i][6] = String.valueOf(format.format(aggsByDay.getIncreasePercentage()));
                }
                priceToFront.setData(displayPrices);
                priceToFronts.add(priceToFront);
            }

        }catch (Exception e){
            enhancePriceToFronts.setErr(e.getMessage());
        }finally {
            enhancePriceToFronts.setResult(priceToFronts);
        }
    return enhancePriceToFronts;
    }
}
