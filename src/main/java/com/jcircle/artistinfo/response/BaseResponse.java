package com.jcircle.artistinfo.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class BaseResponse {

    private List<String> userMessages;
    private List<String> errorMessages;

}
