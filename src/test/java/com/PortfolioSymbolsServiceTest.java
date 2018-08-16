package com;

import com.citi.shanghai.training.dataAnalyst.dao.PortfolioSymbolsMapper;
import com.citi.shanghai.training.dataAnalyst.model.PortfolioSymbols;
import com.citi.shanghai.training.dataAnalyst.service.PortfolioSymbolsService;
import com.citi.shanghai.training.dataAnalyst.service.impl.PortfolioSymbolsServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by Administrator on 8/16/2018.
 */
@RunWith(MockitoJUnitRunner.class)

public class PortfolioSymbolsServiceTest {

    @InjectMocks
    PortfolioSymbolsService service = new PortfolioSymbolsServiceImpl();

    @Mock
    PortfolioSymbolsMapper mapper;

    @Test
    public void addPortfolioSymbol() throws Exception {
        PortfolioSymbols portfolioSymbols = mock(PortfolioSymbols.class);
        portfolioSymbols.setSymbolid(1);
        portfolioSymbols.setPortfolioid(1);

        when(mapper.addPortfolioSymbol(portfolioSymbols)).thenReturn(1);

        assertEquals(1,service.addPortfolioSymbol(portfolioSymbols));
        verify(mapper,times(1)).addPortfolioSymbol(portfolioSymbols);
    }

    @Test
    public void deletePortfolioSymbol() throws Exception {

        PortfolioSymbols portfolioSymbols = mock(PortfolioSymbols.class);
        portfolioSymbols.setPortfolioid(1);
        portfolioSymbols.setSymbolid(1);
        when(mapper.deletePortfolioSymbol(portfolioSymbols)).thenReturn(1);

        assertEquals(1,service.deletePortfolioSymbol(portfolioSymbols));

        verify(mapper,times(1)).deletePortfolioSymbol(portfolioSymbols);
    }

}