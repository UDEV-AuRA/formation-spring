package com.ipiecoles.formation.tpspring;

import com.ipiecoles.formation.tpspring.model.Film;
import com.ipiecoles.formation.tpspring.model.Type;
import com.ipiecoles.formation.tpspring.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class JavaConfiguration {

    @Bean
    public User defaultUser(){
        User john = new User();
        john.setId(1L);
        john.setLogin("john");
        john.setType(Type.SF);
        return john;
    }

    @Bean
    public List<Film> films() {
        List<Film> films = new ArrayList<>();

        Film justiceLeague = new Film();
        justiceLeague.setTitre("Justice League");
        justiceLeague.setType(Type.SF);
        films.add(justiceLeague);

        Film epouseMoi = new Film();
        epouseMoi.setTitre("Epouse-moi mon pote");
        epouseMoi.setType(Type.HUMOUR);
        films.add(epouseMoi);
        return films;

    }
}
