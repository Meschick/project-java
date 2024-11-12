package com.dev.dslist.services;

import com.dev.dslist.dto.GameMinDto;
import com.dev.dslist.entities.Game;
import com.dev.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDto> findAll(){
          List<Game> games = gameRepository.findAll(); // Lista de games
          List<GameMinDto> gamesDto = games.stream().map( g -> new GameMinDto(g)).toList(); // transforma a lista de games para uma lista de GamesDto.
          return gamesDto;
    }
}
