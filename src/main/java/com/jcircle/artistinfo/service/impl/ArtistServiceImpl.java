package com.jcircle.artistinfo.service.impl;

import com.jcircle.artistinfo.model.Artist;
import com.jcircle.artistinfo.model.ArtistDetail;
import com.jcircle.artistinfo.request.ArtistRequest;
import com.jcircle.artistinfo.service.IArtistService;
import com.jcircle.artistinfo.utils.CommonUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "artistService")
public class ArtistServiceImpl implements IArtistService {


    @Override
    public List<Artist> getArtistInfo(ArtistRequest request) {
        List<Artist> artistList = this.populateArtist();
        List<Artist> updatesList = new ArrayList<Artist>(artistList.size());


            artistList.stream().forEach(artistObj -> {
                //Checking the first name
                if (CommonUtils.isNotEmpty(request.getArtistFirstName()) && request.getArtistFirstName().equalsIgnoreCase(artistObj.getArtistFirstName())) {
                    updatesList.add(artistObj);
                }
                //Checking the last name
                if (CommonUtils.isNotEmpty(request.getArtistLastName()) && request.getArtistLastName().equalsIgnoreCase(artistObj.getArtistLastName())) {
                    updatesList.add(artistObj);
                }

                //Check the artist id in the given list
                if (CommonUtils.isNotEmpty(request.getArtistIdList())) {
                    if (request.getArtistIdList().contains(artistObj.getArtistId())) {
                        updatesList.add(artistObj);
                    }
                }
            });


        return updatesList;
    }

    public List<Artist> populateArtist() {

        List<Artist> artistList = new ArrayList<Artist>();
        Artist artistObj = new Artist();
        ArtistDetail artistDetail = new ArtistDetail();
        artistObj.setArtistFirstName("Keenu");
        artistObj.setArtistLastName("Reeves");
        artistObj.setArtistField("Actor");
        artistObj.setArtistId("100");
        artistDetail.setAge(40);
        artistDetail.setMaritalStatus("S");
        artistDetail.setTotalNumberofMovies(50);
        artistObj.setArtistDetail(artistDetail);
        artistList.add(artistObj);
        //Record 2
        artistDetail = new ArtistDetail();
        artistObj = new Artist();
        artistObj.setArtistFirstName("Rajini");
        artistObj.setArtistLastName("Kanth");
        artistObj.setArtistField("Actor");
        artistObj.setArtistId("101");
        artistDetail.setAge(68);
        artistDetail.setMaritalStatus("M");
        artistDetail.setTotalNumberofMovies(120);
        artistObj.setArtistDetail(artistDetail);
        artistList.add(artistObj);

        return  artistList;

    }
}
