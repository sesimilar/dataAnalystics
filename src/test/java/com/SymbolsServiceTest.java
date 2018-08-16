package com;

import com.citi.shanghai.training.dataAnalyst.dao.SymbolsMapper;
import com.citi.shanghai.training.dataAnalyst.model.Symbols;
import com.citi.shanghai.training.dataAnalyst.service.SymbolsService;
import com.citi.shanghai.training.dataAnalyst.service.impl.SymbolsServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by Administrator on 8/16/2018.
 */
@RunWith(MockitoJUnitRunner.class)

public class SymbolsServiceTest {
    @InjectMocks
    SymbolsService service = new SymbolsServiceImpl();

    @Mock
    SymbolsMapper mapper;

    @Test
    public void getAllSymbolsTest() throws Exception{


        List<Symbols> symbols = new ArrayList<>();
        symbols.add(new Symbols(1,"a","d"));
        when(mapper.getAllSymbols()).thenReturn(symbols);
        assertEquals(symbols,service.getAllSymbols());
        verify(mapper,times(1)).getAllSymbols();

    }

}