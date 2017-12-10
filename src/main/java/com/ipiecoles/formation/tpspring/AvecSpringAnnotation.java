package com.ipiecoles.formation.tpspring;

import com.ipiecoles.formation.tpspring.model.Film;
import com.ipiecoles.formation.tpspring.service.RecommandationService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AvecSpringAnnotation {
    public static void main(String... args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.ipiecoles.formation.tpspring");
        RecommandationService recommandationService = applicationContext.getBean(RecommandationService.class);
        Film recommandation = recommandationService.getRecommandation(1L);
        System.out.println(recommandation);
        applicationContext.close();
    }
}
