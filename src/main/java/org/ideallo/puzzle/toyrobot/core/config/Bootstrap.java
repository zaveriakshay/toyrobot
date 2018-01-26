package org.ideallo.puzzle.toyrobot.core.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

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
