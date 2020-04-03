package com.jcircle.artistinfo.service;

import com.jcircle.artistinfo.model.Artist;
import com.jcircle.artistinfo.request.ArtistRequest;

import java.util.List;

public interface IArtistService {


    List<Artist> getArtistInfo(ArtistRequest artistRequest);

}
