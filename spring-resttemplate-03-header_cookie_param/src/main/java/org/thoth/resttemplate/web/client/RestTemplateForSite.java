package org.thoth.resttemplate.web.client;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
@Component
public class RestTemplateForSite {

    @Value("${my.site.rest.url}")
    protected String url;
    
    @Value("${my.site.rest.cookie.name}")
    protected String cookieName;
    
    @Value("${my.site.rest.cookie.value}")
    protected String cookieValue;
    
    @Value("${my.site.rest.param.name}")
    protected String paramName;
    
    @Value("${my.site.rest.param.valueFormat}")
    protected String paramValueFormat;

    @Autowired
    protected RestTemplate restTemplate;

    protected HttpEntity<HttpHeaders> httpEntity;

    @PostConstruct
    protected void postConstruct() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("User-Agent", String.format("Java/%s", System.getProperty("java.version")));
        //System.out.printf("Cookie value=\"%s\"%n", cookieValue);
        httpHeaders.add("Cookie", String.format("%s=%s",cookieName, cookieValue));
        httpEntity = new HttpEntity<>(httpHeaders);
        
        System.out.printf("URL: %s%n", url);
    }
    
    public String exchange(int book, int chapter) {
        
        String paramValue = String.format(paramValueFormat, book, chapter, 0, 999);
        //System.out.printf("Param value=\"%s\"%n", paramValue);
        UriComponentsBuilder builder
            = UriComponentsBuilder
                .fromHttpUrl(url)
                .queryParam(paramName, paramValue);
            ;
         
        HttpEntity<String> response = restTemplate.exchange(
            builder.toUriString(),
            HttpMethod.GET,
            httpEntity,
            String.class);

        return response.getBody();
    }
    
    

}
