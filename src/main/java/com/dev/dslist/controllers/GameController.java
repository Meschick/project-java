package com.dev.dslist.controllers;

import com.dev.dslist.dto.GameDto;
import com.dev.dslist.dto.GameMinDto;
import com.dev.dslist.entities.Game;
import com.dev.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinDto> findAll(){
        List<GameMinDto> games = gameService.findAll();
        return games;
    }

    @GetMapping(value = "/{id}")
    public GameDto findById(@PathVariable Long id){
        var gameDto = gameService.findById(id);
        return gameDto;
    }
}
