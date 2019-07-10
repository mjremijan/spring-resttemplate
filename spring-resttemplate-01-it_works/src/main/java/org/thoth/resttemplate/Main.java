package org.thoth.resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
@SpringBootApplication
public class Main implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Autowired
    protected RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Override
    public void run(String... args) throws Exception {
        
        System.out.printf("Welcome to RestTemplate 01 it works!%n%n");
        
//        System.out.printf("Setting Java system proxy configuration ...%n");
//        System.setProperty("http.proxyHost", "localhost");
//        System.setProperty("http.proxyPort", "80");

        System.out.printf("RestTemplate=\"%s\"%n", restTemplate);

        String urlStr = "http://jsonplaceholder.typicode.com/todos/2";
        System.out.printf("urlStr=\"%s\"%n", urlStr);

        System.out.printf("Calling ...%n");
        String obj
            = restTemplate.getForObject(urlStr, String.class);

        System.out.printf("Obj:%n%s%n", obj);

        System.out.printf("DONE!%n");
    }
}
