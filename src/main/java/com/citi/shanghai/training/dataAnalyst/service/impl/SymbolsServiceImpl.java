package com.citi.shanghai.training.dataAnalyst.service.impl;

import com.citi.shanghai.training.dataAnalyst.dao.SymbolsMapper;
import com.citi.shanghai.training.dataAnalyst.model.Symbols;
import com.citi.shanghai.training.dataAnalyst.service.SymbolsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 8/13/2018.
 */
@Service("symbolService")
public class SymbolsServiceImpl implements SymbolsService {

    @Resource
    private SymbolsMapper mapper;

    public List<Symbols> getAllSymbols() {
        List<Symbols> symbols;
        if((symbols=this.mapper.getAllSymbols()) != null){
            return symbols;
        }
        symbols = new ArrayList<Symbols>();
        return  symbols;
    }
}
