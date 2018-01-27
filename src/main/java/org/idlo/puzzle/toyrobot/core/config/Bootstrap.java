package org.idlo.puzzle.toyrobot.core.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

/**
 * @author akshay.zaveri
 * This class will initialize/boostrap our spring boot application.
 */

@SpringBootApplication
@ComponentScan(basePackages = "org.idlo.*")
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

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.getDefault()); // Set default Locale as US
        return slr;
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasenames("i18n/messages"); // name of the resource bundle
        source.setUseCodeAsDefaultMessage(true);
        return source;
    }
}
