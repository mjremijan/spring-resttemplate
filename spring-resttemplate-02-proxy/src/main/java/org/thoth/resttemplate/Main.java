package org.thoth.resttemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
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
    public RestTemplate restTemplate(
          @Value("${my.proxy.host}") String proxyHost
        , @Value("${my.proxy.port}") Integer proxyPort
    ) {
        System.out.printf("restTemplate proxy = \"%s\"%n", proxyHost);
        System.out.printf("restTemplate port = %d%n", proxyPort);
        
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setProxy(
            new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort))
        );

        return new RestTemplate(requestFactory);
    }

    @Override
    public void run(String... args) throws Exception {
        
        System.out.printf("Welcome to RestTemplate 02 proxy!%n%n");

        String urlStr = "http://jsonplaceholder.typicode.com/todos/2";
        System.out.printf("Calling ...\"%s\"%n", urlStr);
        String obj
            = restTemplate.getForObject(urlStr, String.class);
        System.out.printf("Obj:%n%s%n", obj);

        System.out.printf("%nDONE!%n");
    }
}
