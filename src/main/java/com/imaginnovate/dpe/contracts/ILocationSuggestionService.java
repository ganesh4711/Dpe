package com.imaginnovate.dpe.contracts;

import com.imaginnovate.dpe.data.response.GenericResponse;
import jakarta.ws.rs.core.Response;


public interface ILocationSuggestionService {
    Response getLocationSuggestion(String search, Integer pageSize, Integer pageNo);
}
