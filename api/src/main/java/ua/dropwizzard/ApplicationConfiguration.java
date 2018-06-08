package ua.dropwizzard;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.constraints.NotNull;

public class ApplicationConfiguration extends Configuration {

    @NotNull
    private String datasourceUrl;
    @NotNull
    private String datasourceUserName;
    @NotNull
    private String datasourcePassword;
    @NotNull
    private String datasourceDriver;

    private String springKafkaBootstrapServers;

    private String appTopicFoo;

    @JsonProperty
    public String getSpringKafkaBootstrapServers() {
        return springKafkaBootstrapServers;
    }

    @JsonProperty
    public void setSpringKafkaBootstrapServers(String springKafkaBootstrapServers) {
        this.springKafkaBootstrapServers = springKafkaBootstrapServers;
    }

    @JsonProperty
    public String getAppTopicFoo() {
        return appTopicFoo;
    }

    @JsonProperty
    public void setAppTopicFoo(String appTopicFoo) {
        this.appTopicFoo = appTopicFoo;
    }

    @JsonProperty
    public String getDatasourceUrl() {
        return datasourceUrl;
    }

    @JsonProperty
    public void setDatasourceUrl(String datasourceUrl) {
        this.datasourceUrl = datasourceUrl;
    }

    @JsonProperty
    public String getDatasourceUserName() {
        return datasourceUserName;
    }

    @JsonProperty
    public void setDatasourceUserName(String datasourceUserName) {
        this.datasourceUserName = datasourceUserName;
    }

    @JsonProperty
    public String getDatasourcePassword() {
        return datasourcePassword;
    }

    @JsonProperty
    public void setDatasourcePassword(String datasourcePassword) {
        this.datasourcePassword = datasourcePassword;
    }

    @JsonProperty
    public String getDatasourceDriver() {
        return datasourceDriver;
    }

    @JsonProperty
    public void setDatasourceDriver(String datasourceDriver) {
        this.datasourceDriver = datasourceDriver;
    }
}
