package com.jcircle.artistinfo.controller;

import com.jcircle.artistinfo.model.Artist;
import com.jcircle.artistinfo.request.ArtistRequest;
import com.jcircle.artistinfo.response.ArtistResponse;
import com.jcircle.artistinfo.response.BaseResponse;
import com.jcircle.artistinfo.service.IArtistService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ArtistController {

    @Autowired
    IArtistService artistService;

    @CrossOrigin
    @PostMapping(value = "/v1/artist/info")
    @ApiOperation(value = "Get Movie Information",
        notes = "Choose the appropriate request parameters.")
    public ResponseEntity<BaseResponse> getMovieInfo(@ApiParam(value = " {\n"
        + "  \"artistFirstName\": \"Rajini\",\n"
        + "  \"artistLastName\": \"Kanth\",\n"
        + "  \"artistIdList\": \"[100]\"\n"
        + "}")@RequestBody ArtistRequest artistRequest) {

        System.out.println(artistRequest.getArtistFirstName());


        ResponseEntity<BaseResponse> responseEntityObj = null;

        List<Artist> artistList = artistService.getArtistInfo(artistRequest);

        ArtistResponse artistResponse = new ArtistResponse();
        artistResponse.setArtistList(artistList);
        responseEntityObj = new ResponseEntity(artistResponse, HttpStatus.OK);

        return responseEntityObj;
    }

}
