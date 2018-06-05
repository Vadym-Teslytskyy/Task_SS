package dropwizzard;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import resource.ClientTestResource;

public class ApplicationLauncher extends Application<ApplicationConfiguration> {

    public static void main(String[] args) throws Exception {
        new ApplicationLauncher().run(args);
    }

    @Override
    public void initialize(Bootstrap<ApplicationConfiguration> bootstrap) {

    }

    @Override
    public void run(ApplicationConfiguration applicationConfiguration, Environment environment) throws Exception {
        final ClientTestResource resource = new ClientTestResource();
        environment.jersey().register(resource);
    }
}
