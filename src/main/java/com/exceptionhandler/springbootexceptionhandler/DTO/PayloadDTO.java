package com.exceptionhandler.springbootexceptionhandler.DTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashMap;

@Data
@EqualsAndHashCode(callSuper=false)
public class PayloadDTO extends HashMap<String,Object>  {

    public static PayloadDTO getErrorPayload(String message){
        PayloadDTO errorPayload=new PayloadDTO();
        errorPayload.put("Error",message);
        return  errorPayload;
    }

    public  static  PayloadDTO getPayload(String name,String message){
        PayloadDTO payloadDTO=new PayloadDTO();
        payloadDTO.put(name,message);
        return  payloadDTO;
    }
}