package com.dev.dslist.dto;


import com.dev.dslist.entities.Game;
import com.dev.dslist.projections.GameMinProjection;

public class GameMinDto {

    // A classe dto não será uma entidade no banco, com isso, não será mapeada.
    // Se torna uma classe independente.



    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;


    public GameMinDto(){}

    public GameMinDto(Game entity){
       id = entity.getId();
       title = entity.getTitle();
       year = entity.getYear();
       imgUrl = entity.getImgUrl();
       shortDescription = entity.getShortDescription();
    }

    public GameMinDto(GameMinProjection projection){
        id = projection.getId();
        title = projection.getTitle();
        year = projection.getYear();
        imgUrl = projection.getImgUrl();
        shortDescription = projection.getShortDescription();

    }
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}
