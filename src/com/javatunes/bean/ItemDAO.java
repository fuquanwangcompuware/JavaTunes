/*
 * Data Access Object interface for music items, provides:
 * 	- get single item by id
 * 	- get all the items
 * 	- search by keyword (title & artist)
 */

package com.javatunes.bean;

import java.util.Collection;

public interface ItemDAO {
  public MusicItem get(Long id);
  public Collection<MusicItem> getAll();
  public Collection<MusicItem> searchByArtistTitle(String keyword);
}
