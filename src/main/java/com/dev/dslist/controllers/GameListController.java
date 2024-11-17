package com.dev.dslist.controllers;

import com.dev.dslist.dto.GameListDto;
import com.dev.dslist.dto.GameMinDto;
import com.dev.dslist.dto.ReplacementDto;
import com.dev.dslist.repositories.GameRepository;
import com.dev.dslist.services.GameListService;
import com.dev.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;


    @GetMapping
    public List<GameListDto> findAll(){
        var gamesList = gameListService.findAll();
        return gamesList;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDto>  findByList( @PathVariable Long listId){
        var games = gameService.finfByList(listId);
        return games;
    }

   @PostMapping(value = "/{listId}/replacement")
    public void move( @PathVariable Long listId, @RequestBody ReplacementDto body){
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());

   }
}
