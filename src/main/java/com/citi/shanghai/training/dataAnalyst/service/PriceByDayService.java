package com.citi.shanghai.training.dataAnalyst.service;

import com.citi.shanghai.training.dataAnalyst.entity.EnhancePriceToFront;

import java.util.List;
import java.util.Map;

public interface PriceByDayService {
    EnhancePriceToFront getPrice(int fromDate, int toDate, List<String> symbols);
}
