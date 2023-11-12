package com.imaginnovate.dpe.controllers;

import com.imaginnovate.dpe.data.misc.APIResponse;
import com.imaginnovate.dpe.data.requests.BaseRequest;
import com.imaginnovate.dpe.data.requests.GlobalBaseRateCreateDTO;
import com.imaginnovate.dpe.services.BaseRateConstrainService;
import com.imaginnovate.dpe.services.PrimaryBaseRateAdjustmentService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
@Path("api/rule-set/{ruleSetId}/rule")
public class PrimaryConfigurationController {

    @Inject
    private BaseRateConstrainService baseRateConstrainService;

    @Inject
    private PrimaryBaseRateAdjustmentService primaryBaseRateAdjustmentService;

    @GET
    @Path("/primary-base-rate-adjustment")
    public Response getPrimaryBaseRateAdjustment(@PathParam("ruleSetId") Long ruleSetId) {
        try {
            var persistedBaseRateConfig = primaryBaseRateAdjustmentService.getPrimaryBaseRateConfiguration(ruleSetId);
            return Response.ok(APIResponse.success("", persistedBaseRateConfig)).build();
        } catch (Exception e) {

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(APIResponse.error("Configuration failed, please update again"))
                    .build();
        }
    }

    //checked
    @POST
    @Path("/primary-base-rate-adjustment/configuration")
    public Response AddConfiguration(@PathParam("ruleSetId") long ruleSetId, GlobalBaseRateCreateDTO globalBaseRateCreateDTO) {
            try {
                var persistedBaseRateConfig = primaryBaseRateAdjustmentService.addConfiguration(ruleSetId, globalBaseRateCreateDTO);

                if (globalBaseRateCreateDTO.getId() == null) {
                    return Response.ok(APIResponse.success("Configuration created successfully", persistedBaseRateConfig)).build();
                }

                return Response.ok(APIResponse.success("Configuration updated successfully", persistedBaseRateConfig)).build();
            } catch (Exception e) {
                e.printStackTrace();
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(APIResponse.error("Configuration failed, please update again"))
                        .build();
            }
    }
    //checked
    @DELETE
    @Path("/primary-base-rate-adjustment/configuration/{configurationId}")
    public Response deleteConfiguration(@PathParam("ruleSetId") long ruleSetId, @PathParam("configurationId") long primaryRateConfigurationId) {
        try {
            var baseRateConfig = primaryBaseRateAdjustmentService.deletePrimaryBaseRateConfiguration(ruleSetId, primaryRateConfigurationId);
            return Response.status(Response.Status.NO_CONTENT).entity(APIResponse.success("Configuration deleted successfully", null)).build();
        } catch (Exception e) {

           return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(APIResponse.error("Configuration failed, please update again"))
                    .build();
        }
    }
    //checked
    @GET
    @Path("/base-rate-constrain")
    public Response getBaseRateConstrain(@PathParam("ruleSetId") Long ruleSetId){
        try {
            var persistedBaseRateConfig = baseRateConstrainService.getBaseRateConstrain(ruleSetId);
            return Response.ok(APIResponse.success("",persistedBaseRateConfig)).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(APIResponse.error("Configuration failed, please update again"))
                    .build();
        }
    }

    //checked
    @DELETE
    @Path("/base-rate-constrain/configuration/{configurationId}")
    public Response deleteBaseRateConstrain(@PathParam("ruleSetId") long ruleSetId, @PathParam("configurationId") long primaryRateConfigurationId){
        try {
            var deleteBaseRateConstrain = baseRateConstrainService.deleteBaseRateConfiguration(ruleSetId, primaryRateConfigurationId);
            return Response.status(Response.Status.NO_CONTENT).entity(APIResponse.success("Configuration deleted successfully", null)).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(APIResponse.error("Configuration failed, please update again"))
                    .build();
        }
    }

    //checked

    @POST
    @Path("/base-rate-constrain/configuration")
    public Response addConfiguration(@PathParam("ruleSetId") long ruleSetId,BaseRequest baseRequest){
        try {
            var persistedBaseRateConfig = baseRateConstrainService.addConfiguration(ruleSetId, baseRequest);
            if(baseRequest.getId()== null){
                return Response.status(Response.Status.CREATED).entity(APIResponse.success("Configuration created successfully",persistedBaseRateConfig)).build();
            }
            return APIResponse.success("Configuration updated successfully",persistedBaseRateConfig);
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(APIResponse.error("Configuration failed, please update again"))
                    .build();
        }
    }

}
