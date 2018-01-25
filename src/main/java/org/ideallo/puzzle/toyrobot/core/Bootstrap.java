package org.ideallo.puzzle.toyrobot.core;

import org.ideallo.puzzle.toyrobot.core.object.Robot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author akshay.zaveri
 * This class will initialize/boostrap our spring boot application.
 */

@SpringBootApplication
@ComponentScan(basePackages = "org.ideallo.*")
public class Bootstrap  {

    /**
     * Host the Servlet Container here.
     * server.port configured under resources/application.properties file.
     * @param args
     */
    public static void main(String [] args){

        /**
         * Initializing the Spring Application.
         */
        SpringApplication.run(Bootstrap.class,args);
    }
}
