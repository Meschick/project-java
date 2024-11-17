package com.dev.dslist.services;

import com.dev.dslist.dto.GameListDto;
import com.dev.dslist.repositories.GameListRepository;
import com.dev.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    GameRepository gameRepository;

    @Transactional
    public List<GameListDto> findAll(){
        var gamesList = gameListRepository.findAll();
        var gamesListDto = gamesList.stream().map(l -> new GameListDto(l)).toList();
        return gamesListDto;
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){

        // retorna games de uma lista específica
        var games = gameRepository.searchByList(listId);
        // remove um objeto especifico
        var obj = games.remove(sourceIndex);
        // adiciona esse obj em uma nova position
        games.add(destinationIndex, obj);


        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for(int i = min; i<=max; i++){

            gameListRepository.updateBelongingPosition(listId, games.get(i).getId(), i );
            // atribui uma nova position para o obj

        }



    }

}
