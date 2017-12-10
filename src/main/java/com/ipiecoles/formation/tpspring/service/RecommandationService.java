package com.ipiecoles.formation.tpspring.service;

import com.ipiecoles.formation.tpspring.model.Film;
import com.ipiecoles.formation.tpspring.model.User;
import com.ipiecoles.formation.tpspring.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RecommandationService {

	private FilmService filmService;
	private UserRepository userRepository;

	public RecommandationService(FilmService filmService, UserRepository userRepository) {
		this.filmService = filmService;
		this.userRepository = userRepository;
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("RecommandationServiceImpl PostConstruct");
	}

	public Film getRecommandation(Long idUser) {
		User user = userRepository.findById(idUser);
		for (Film film : user.getFilmsAVoir()) {
			return film;
		}
		List<Film> nouveautes = filmService.findNouveautesParType(user.getType());
		for (Film film : nouveautes ) {
			if(!user.getDejaVus().contains(film)) {
				return film;
			}
		}
		return null;
	}

}
