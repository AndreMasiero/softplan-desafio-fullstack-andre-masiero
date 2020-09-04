package br.com.softplan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;

@Configuration
public class ProdConfig {

    @Autowired
    private DataBase dbService;

    @Bean
    public boolean instantiateDatabase() throws ParseException {
        dbService.instantiateDatabase();
        return true;
    }

}
