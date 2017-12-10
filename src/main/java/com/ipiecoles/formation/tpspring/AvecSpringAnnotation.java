package com.ipiecoles.formation.tpspring;

import com.ipiecoles.formation.tpspring.service.RecommandationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class AvecSpringAnnotation {

    @Autowired
    private RecommandationService recommandationService1;

    public static void main(String... args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.ipiecoles.formation.tpspring");
        AvecSpringAnnotation bean = applicationContext.getBean(AvecSpringAnnotation.class);
        System.out.println(bean.recommandationService1.getRecommandation(1L));
    }

}
