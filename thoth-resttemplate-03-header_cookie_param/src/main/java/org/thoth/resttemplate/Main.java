package org.thoth.resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.thoth.resttemplate.chapter.ChapterRepository;
import org.thoth.resttemplate.web.client.RestTemplateConfiguration;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
@SpringBootApplication
@Import({RestTemplateConfiguration.class})
public class Main implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    
    @Autowired
    protected ChapterRepository chapterRepository;

    @Override
    public void run(String... args) throws Exception {
        
        System.out.printf("Welcome to RestTemplate 03 header, cookie, param!%n%n");

        System.out.printf("Chapter(1,1) JSON:%n%s%n", chapterRepository.getChapter(1, 1));
        
        System.out.printf("%nDONE!%n");
    }
}
