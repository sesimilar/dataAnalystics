package com;

import com.citi.shanghai.training.dataAnalyst.dao.PortfolioMapper;
import com.citi.shanghai.training.dataAnalyst.entity.PortfolioAllSymbols;
import com.citi.shanghai.training.dataAnalyst.model.Portfolio;
import com.citi.shanghai.training.dataAnalyst.service.PortfoliosService;
import com.citi.shanghai.training.dataAnalyst.service.impl.PortfolioServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

/**
 * Created by Administrator on 8/16/2018.
 */

@RunWith(MockitoJUnitRunner.class)

public class PortfoliosServiceTest {

    @InjectMocks
    PortfoliosService service = new PortfolioServiceImpl();

    @Mock
    PortfolioMapper mapper;

    @Test
    public void getPortfolioByUserId() throws Exception {
        List<PortfolioAllSymbols> portfolios = mock(List.class);

        when(mapper.selectPortfolioByUserId(anyInt())).thenReturn(portfolios);

        assertEquals(portfolios,service.getPortfolioByUserId(1));

        when(mapper.selectPortfolioByUserId(anyInt())).thenReturn(null);
        assertEquals(new ArrayList<PortfolioAllSymbols>(),service.getPortfolioByUserId(1));

        verify(mapper,times(2)).selectPortfolioByUserId(1);
    }

    @Test
    public void addPortfolio() throws Exception {
        Portfolio portfolio = mock(Portfolio.class);

        when(mapper.addPortfolio(any(Portfolio.class))).thenReturn(1);
        assertEquals(1,service.addPortfolio(portfolio));

        verify(mapper,times(1)).addPortfolio(portfolio);
    }

    @Test
    public void deletePortfolio() throws Exception {
        Portfolio portfolio = mock(Portfolio.class);

        when(mapper.deletePortfolio(anyInt())).thenReturn(1);
        assertEquals(1,service.deletePortfolio(1));

        verify(mapper,times(1)).deletePortfolio(1);

    }

}