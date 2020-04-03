package com.jcircle.artistinfo.response;

import com.jcircle.artistinfo.model.Artist;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Setter
@Getter
public class ArtistResponse extends BaseResponse {

    private List<Artist> artistList;

}
