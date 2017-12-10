package com.ipiecoles.formation.tpspring;

import com.ipiecoles.formation.tpspring.model.Film;
import com.ipiecoles.formation.tpspring.repository.FilmRepository;
import com.ipiecoles.formation.tpspring.repository.UserRepository;
import com.ipiecoles.formation.tpspring.service.FilmService;
import com.ipiecoles.formation.tpspring.service.RecommandationService;

public class SansSpring {
	public static void main(String... args) {
		FilmRepository filmRepository = new FilmRepository();
		UserRepository userRepository = new UserRepository();

		FilmService filmService = new FilmService();
		filmService.setFilmRepository(filmRepository);
		RecommandationService recommandationService = new RecommandationService();
		recommandationService.setFilmService(filmService);
		recommandationService.setUserRepository(userRepository);

		Film recommandation = recommandationService.getRecommandation(1L);
		System.out.println(recommandation);
	}
}
