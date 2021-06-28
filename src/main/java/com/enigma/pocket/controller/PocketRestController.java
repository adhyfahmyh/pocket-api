package com.enigma.pocket.controller;

import com.enigma.pocket.entity.Customer;
import com.enigma.pocket.entity.Pocket;
import com.enigma.pocket.service.PocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PocketRestController {
    @Autowired
    PocketService pocketService;

    @GetMapping("/pocket/{id}")
    public Pocket getPocketById(@PathVariable(name = "id") String id){
        return pocketService.findPocketById(id);
    }

    @GetMapping("/pockets")
    public List<Pocket> getAllPockets(){return pocketService.findPockets();}

    @PostMapping("/pocket")
    public void createNewPocket(@RequestBody Pocket pocket){
        pocketService.createPocket(pocket);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/pocket")
    public Pocket updatePocket(
            @RequestBody Pocket pocket) {
        return pocketService.updatePocket(pocket);
    }

    @DeleteMapping("/pocket/{id}")
    public void DeletePocket(
            @PathVariable(name = "id") String id
    ){
        pocketService.removePocket(id);
    }

}
