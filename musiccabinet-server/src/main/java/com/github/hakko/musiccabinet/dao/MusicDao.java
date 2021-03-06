package com.github.hakko.musiccabinet.dao;

import com.github.hakko.musiccabinet.domain.model.music.Album;
import com.github.hakko.musiccabinet.domain.model.music.Artist;
import com.github.hakko.musiccabinet.domain.model.music.Track;

public interface MusicDao {

	int getArtistId(String artistName);
	int getArtistId(Artist artist);
	int getAlbumId(String artistName, String albumName);
	int getAlbumId(Album album);
	int getTrackId(String artistName, String trackName);
	int getTrackId(Track track);

}