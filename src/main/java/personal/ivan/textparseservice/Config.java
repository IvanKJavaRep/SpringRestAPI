package personal.ivan.textparseservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("demo")
public class Config {
    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    private int port;

    @Override
    public String toString() {
        return "{" + this.getPort() + "}";
    }
}