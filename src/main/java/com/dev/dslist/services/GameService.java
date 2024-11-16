package com.dev.dslist.services;

import com.dev.dslist.dto.GameDto;
import com.dev.dslist.dto.GameMinDto;
import com.dev.dslist.entities.Game;
import com.dev.dslist.entities.GameList;
import com.dev.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDto> findAll(){
          var games = gameRepository.findAll(); // Lista de games
          var gamesDto = games.stream().map( g -> new GameMinDto(g)).toList(); // transforma a lista de games para uma lista de GamesDto.
          return gamesDto;
    }

    @Transactional(readOnly = true)
    public GameDto findById(Long id){
        var game = gameRepository.findById(id).get();
        var gameDto = new GameDto(game); // transforma o game em game dto
        return gameDto;
    }
}
