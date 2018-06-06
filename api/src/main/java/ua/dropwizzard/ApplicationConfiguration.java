package ua.dropwizzard;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Component
public class ApplicationConfiguration extends Configuration {

    @NotNull
    private String datasourceUrl;
    @NotNull
    private String datasourceUserName;
    @NotNull
    private String datasourcePassword;
    @NotNull
    private String datasourceDriver;

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
