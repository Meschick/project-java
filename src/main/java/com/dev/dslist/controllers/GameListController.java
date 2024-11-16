package com.dev.dslist.controllers;

import com.dev.dslist.dto.GameListDto;
import com.dev.dslist.repositories.GameListRepository;
import com.dev.dslist.services.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;


    @GetMapping
    public List<GameListDto> findAll(){
        var gamesList = gameListService.findAll();
        return gamesList;
    }
}
