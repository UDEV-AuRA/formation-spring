package com.ipiecoles.formation.tpspring.service;

import com.ipiecoles.formation.tpspring.model.Film;

public interface RecommandationService {

    Film getRecommandation(Long idUser);

}
