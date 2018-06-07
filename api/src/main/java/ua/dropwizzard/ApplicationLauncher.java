package ua.dropwizzard;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.spring.config.PersistenceContext;

import javax.ws.rs.Path;

public class ApplicationLauncher extends Application<ApplicationConfiguration> {

    public static void main(String[] args) throws Exception {
        new ApplicationLauncher().run(args);
    }

    @Override
    public void initialize(Bootstrap<ApplicationConfiguration> bootstrap) {

    }

    @Override
    public void run(ApplicationConfiguration applicationConfiguration, Environment environment) throws Exception {
        AnnotationConfigApplicationContext parent = new AnnotationConfigApplicationContext();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        parent.refresh();
        parent.getBeanFactory().registerSingleton("configuration", applicationConfiguration);
        parent.registerShutdownHook();
        parent.start();

        context.setParent(parent);
        context.register(PersistenceContext.class);
        context.refresh();
        context.registerShutdownHook();
        context.start();

        context.getBeansWithAnnotation(Path.class).forEach((s, o1) -> {
            environment.jersey().register(o1);
        });
    }
}
