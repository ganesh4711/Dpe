package com.imaginnovate.dpe.controllers;

import com.imaginnovate.dpe.data.misc.APIResponse;
import com.imaginnovate.dpe.data.requests.ShipperRateRequest;
import com.imaginnovate.dpe.data.responses.ShipperRateConfigurationResponse;
import com.imaginnovate.dpe.services.ShipperRateConfigurationService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.stream.Collectors;

@ApplicationScoped
@Path("/api/ruleset/{ruleSetId}/shipperrate")
public class ShipperRateConfigurationController {

    @Inject
    ShipperRateConfigurationService shipperRateConfigurationService;
    @POST
    @Path("/configuration")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addConfiguration(@PathParam("ruleSetId") long ruleSetId, ShipperRateRequest shipperRateRequest){
     return shipperRateConfigurationService.addConfiguration(ruleSetId,shipperRateRequest);
    }
    @GET
    @Path("/configuration")
    public  Response getConfiguration(@PathParam("ruleSetId") long ruleSetId)  {
        try {
            var  shipperRateConfigurations = shipperRateConfigurationService.getConfiguration(ruleSetId);
            var data = shipperRateConfigurations.stream().map(config -> new ShipperRateConfigurationResponse(config)).collect(Collectors.toList());
            return APIResponse.success("",data);
        } catch (Exception e) {
            e.printStackTrace();
            return APIResponse.error("Configuration failed,please update again");
        }

    }
    @DELETE
    @Path("/configuration/{configurationId}")
    public Response deleteConfiguration(@PathParam("ruleSetId") long ruleSetId,@PathParam("configurationId") long configurationId){
        return shipperRateConfigurationService.deleteConfiguration(ruleSetId,configurationId);
    }
    @PUT
    @Path("/configuration/{configurationId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateConfiguration(@PathParam("ruleSetId") long ruleSetId,@PathParam ("configurationId") long configurationId, ShipperRateRequest shipperRateRequest){
        return shipperRateConfigurationService.updateConfiguration(ruleSetId,configurationId,shipperRateRequest);
    }
}
