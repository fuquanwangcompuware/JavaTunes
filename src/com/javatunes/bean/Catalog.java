/*
 * Java Tunes Catalog interface
 * 
 * Provides methods for Music Item information:
 * 	- find by music item id
 * 	- find by music title and artist
 * 	- find first twenty items used for index page
 */

package com.javatunes.bean;

import java.util.Collection;

public interface Catalog {

   public MusicItem findById(Long id);
   public Collection<MusicItem> findByKeyword(String keyword);
   public Collection<MusicItem> findFirstTwenty();
}