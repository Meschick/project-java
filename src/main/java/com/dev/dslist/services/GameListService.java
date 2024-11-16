package com.dev.dslist.services;

import com.dev.dslist.dto.GameListDto;
import com.dev.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional
    public List<GameListDto> findAll(){
        var gamesList = gameListRepository.findAll();
        var gamesListDto = gamesList.stream().map(l -> new GameListDto(l)).toList();
        return gamesListDto;
    }

}
