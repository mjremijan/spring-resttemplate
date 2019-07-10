package org.thoth.resttemplate.web.client;

import java.net.InetSocketAddress;
import java.net.Proxy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
@Configuration
public class RestTemplateConfiguration {

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
}
