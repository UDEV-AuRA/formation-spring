package com.ipiecoles.formation.tpspring.controller;

import com.ipiecoles.formation.tpspring.model.Film;
import com.ipiecoles.formation.tpspring.service.RecommandationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccueilController {

    @Autowired
    private RecommandationService recommandationService;

    @GetMapping("/accueil")
    public ModelAndView index() {
        Film film = recommandationService.getRecommandation(1L);
        ModelAndView mv = new ModelAndView("accueil");
        mv.addObject(film);
        return mv;
    }
}
