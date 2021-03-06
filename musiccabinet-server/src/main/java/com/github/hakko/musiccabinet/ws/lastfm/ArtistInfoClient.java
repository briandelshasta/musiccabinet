package com.github.hakko.musiccabinet.ws.lastfm;

import static com.github.hakko.musiccabinet.domain.model.library.WebserviceInvocation.Calltype.ARTIST_GET_INFO;

import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.github.hakko.musiccabinet.domain.model.library.WebserviceInvocation;
import com.github.hakko.musiccabinet.domain.model.music.Artist;
import com.github.hakko.musiccabinet.exception.ApplicationException;

public class ArtistInfoClient extends AbstractWSGetClient {

	public static final String METHOD = "artist.getinfo";
	
	public WSResponse getArtistInfo(Artist artist) throws ApplicationException {
		WebserviceInvocation webserviceInvocation = 
			new WebserviceInvocation(ARTIST_GET_INFO, artist);

		List<NameValuePair> params = getDefaultParameterList();
		params.add(new BasicNameValuePair(PARAM_METHOD, METHOD));
		params.add(new BasicNameValuePair(PARAM_ARTIST, artist.getName()));
		
		return executeWSRequest(webserviceInvocation, params);
	}
	
}