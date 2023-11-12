package com.imaginnovate.dpe.data.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DATMetaData {


    public Double companies;

    public Double reports;

    public  Double duration;

//    public String escalationAreaType;

    public String originEscalationAreaType;

    public String destinationEscalationAreaType;

}
