package org.thoth.resttemplate.chapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.thoth.resttemplate.web.client.RestTemplateForSite;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
@Repository
public class ChapterRepository {

    @Autowired
    protected RestTemplateForSite rest;
    
    public String getChapter(int book, int chapter) {
        return rest.exchange(book, chapter);
    }
}
