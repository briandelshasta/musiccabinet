package com.github.hakko.musiccabinet.ws.musicbrainz;

import static com.github.hakko.musiccabinet.domain.model.library.WebserviceInvocation.Calltype.MB_RELEASE_GROUPS;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.github.hakko.musiccabinet.domain.model.library.WebserviceInvocation;
import com.github.hakko.musiccabinet.domain.model.music.Artist;
import com.github.hakko.musiccabinet.exception.ApplicationException;

/*
 * Executes a request to fetch MusicBrainz releases for an artist, i.e:
 * http://www.musicbrainz.org/ws/2/release-group/?artist=5b11f4ce-a62d-471e-81fc-a69a8278c7da&type=album
 */
public class ReleaseGroupsClient extends AbstractMusicBrainzClient {

	protected static final String PATH = "/ws/2/release-group/";
	
	protected static final String ARTIST = "artist";
	
	protected static final String TYPE = "type";
	protected static final String ALBUM = "album";
	
	public String get(String artistName, String mbid) throws ApplicationException {
		WebserviceInvocation invocation = new WebserviceInvocation(
				MB_RELEASE_GROUPS, new Artist(artistName));
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair(ARTIST, mbid));
		params.add(new BasicNameValuePair(TYPE, ALBUM));
		return executeWSRequest(invocation, PATH, params);
	}
	
}