package com.jcircle.artistinfo.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ArtistRequest {

    private List<String> artistIdList = null;
    private String artistFirstName = null;
    private String artistLastName = null;

}
