package com.ipiecoles.formation.tpspring;

import com.ipiecoles.formation.tpspring.model.Film;
import com.ipiecoles.formation.tpspring.service.RecommandationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class AvecSpringAnnotation {

    @Autowired
    @Qualifier("RecommandationServiceTriche")
    private RecommandationService recommandationService;

    public static void main(String... args) {
        {
            AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.ipiecoles.formation.tpspring");
            RecommandationService recommandationService = applicationContext.getBean("RecommandationServiceTriche", RecommandationService.class);
            Film recommandation = recommandationService.getRecommandation(1L);
            System.out.println(recommandation);
            applicationContext.close();
        }
        {
            AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.ipiecoles.formation.tpspring");
            AvecSpringAnnotation avecSpringAnnotation = applicationContext.getBean(AvecSpringAnnotation.class);
            Film recommandation = avecSpringAnnotation.recommandationService.getRecommandation(1L);
            System.out.println(recommandation);
            applicationContext.close();
        }

    }
}
