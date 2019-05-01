package org.exoplatform.ideation.service.rest;

import org.exoplatform.ideation.entities.CommentEntity;
import org.exoplatform.ideation.service.utils.CommentService;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.exoplatform.services.rest.resource.ResourceContainer;

import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/comment")
@Produces(MediaType.APPLICATION_JSON)
public class CommentRestService implements ResourceContainer {

    private static Log log = ExoLogger.getLogger(CommentEntity.class);

    @Inject
    CommentService commentservice;


  /*  @GET
    @Path("/getcomment/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<CommentEntity> getComment(@PathParam("id") Long id){
        return commentservice.getComment(id);
    }*/

 /*   @POST
    @Path('save')
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)

    public CommentDTO save(CommentDTO comment){

    }*/

}
