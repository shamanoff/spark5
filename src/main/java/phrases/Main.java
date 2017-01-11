package phrases;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import phrases.config.RootConfig;


public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RootConfig.class);


    }
}

