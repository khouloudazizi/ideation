package org.exoplatform.ideation.service.rest;

import org.exoplatform.ideation.entities.RatingEntity;
import org.exoplatform.ideation.service.utils.RatingService;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.exoplatform.services.rest.resource.ResourceContainer;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/rating")
@Produces(MediaType.APPLICATION_JSON)
public class RatingRestService implements ResourceContainer {
    private static Log log = ExoLogger.getLogger(RatingService.class);
    @Inject
    RatingService ratingservice;

    @GET
    @Path("/getstatus/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<RatingEntity> getcommante(@PathParam("id") Long id){
        return ratingservice.getStatusIdIdea(id);
    }
}
