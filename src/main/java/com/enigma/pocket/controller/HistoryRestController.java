package com.enigma.pocket.controller;

import com.enigma.pocket.dto.HistorySearchDto;
import com.enigma.pocket.entity.HistoryProduct;
import com.enigma.pocket.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
public class HistoryRestController {

    @Autowired
    HistoryService historyService;
    @GetMapping("/history/{id}")
    public HistoryProduct getHistoryById(@PathVariable(name = "id") String id){
        return historyService.findHistoryById(id);
    }
    @GetMapping("/histories")
    public Page<HistoryProduct> getAllHistories(@RequestBody HistorySearchDto historySearchDto,
                                        @RequestParam(name = "page", defaultValue = "0") Integer page,
                                        @RequestParam(name = "size", defaultValue = "5") Integer size
    ){
        Pageable pageable = PageRequest.of(page, size);
        return historyService.findHistories(historySearchDto, pageable);
    }


    @PostMapping("/history/create")
    public void createNewHistory(@RequestBody HistoryProduct historyProduct){
        historyService.createHistory(historyProduct);
    }
    @PutMapping("/updateHistory")
    public void updateProduct(@RequestBody HistoryProduct historyProduct){
        historyService.updateHistory(historyProduct);
    }

    @DeleteMapping("/deleteHistory/{id}")
    public void deleteProduct(@PathVariable String id){
        historyService.removeHistory(id);
    }
}
