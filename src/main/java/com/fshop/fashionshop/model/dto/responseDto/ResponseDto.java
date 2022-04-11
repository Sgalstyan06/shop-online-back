package com.fshop.fashionshop.model.dto.responseDto;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

@ToString
@RequiredArgsConstructor
public class ResponseDto {
    private HttpStatus httpStatus;
    private String message;
    private Map<String, String> info;

    public ResponseDto(String message){
        this.message=message;
        this.httpStatus=HttpStatus.OK;
        this.info=new HashMap<>();
    }

    public ResponseDto(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.info=new HashMap<>();
    }

    public HttpStatus getHttpStatus() {

        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {

        this.httpStatus = httpStatus;
    }

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {

        this.message = message;
    }

    public Map<String, String> getInfo() {

        return info;
    }

    public void addInfo(String key,String value){

        info.put(key, value);
    }


}
