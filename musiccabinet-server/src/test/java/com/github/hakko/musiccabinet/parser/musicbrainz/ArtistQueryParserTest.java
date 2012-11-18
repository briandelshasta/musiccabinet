package com.github.hakko.musiccabinet.parser.musicbrainz;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

import com.github.hakko.musiccabinet.domain.model.music.MBArtist;
import com.github.hakko.musiccabinet.exception.ApplicationException;
import com.github.hakko.musiccabinet.util.ResourceUtil;

public class ArtistQueryParserTest {
	
	private static final String ARTIST_QUERY_FILE = 
		"musicbrainz/xml/artistQuery.xml";

	// constant values below are copied from file above
	
	private static final String MBID = "d347406f-839d-4423-9a28-188939282afa";
	private static final String NAME = "Cult of Luna";
	private static final String COUNTRY_CODE = "SE";
	private static final short START_YEAR = 1998;
	private static final boolean ACTIVE = true;
	
	@Test
	public void resourceFileCorrectlyParsed() throws ApplicationException {
		ArtistQueryParser parser = new ArtistQueryParserImpl(
				new ResourceUtil(ARTIST_QUERY_FILE).getInputStream());
		
		MBArtist artist = parser.getArtist();
		
		assertEquals(MBID, artist.getMbid());
		assertEquals(NAME, artist.getName());
		assertEquals(COUNTRY_CODE, artist.getCountryCode());
		assertEquals(START_YEAR, artist.getStartYear());
		assertEquals(ACTIVE, artist.isActive());
	}

}