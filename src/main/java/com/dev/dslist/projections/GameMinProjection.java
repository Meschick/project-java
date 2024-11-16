package com.dev.dslist.projections;

public interface GameMinProjection {

    Long getId();
    String getTitle();
    Integer getYear();
    String getImgUrl();
    String getShortDescription();
    Integer getPosition();
}
// Terá métodos get para cada dado que a minha consulta está retornando..