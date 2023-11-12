package com.imaginnovate.dpe.data.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GenericResponse {

    private  String message;
    private  Object data;
}
