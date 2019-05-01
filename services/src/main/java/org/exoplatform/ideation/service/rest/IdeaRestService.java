package org.exoplatform.ideation.service.rest;
import org.exoplatform.commons.utils.CommonsUtils;
import org.exoplatform.ideation.dto.IdeaDTO;
import org.exoplatform.ideation.entities.IdeaEntity;
import org.exoplatform.ideation.service.utils.IdeaService;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;
import org.exoplatform.services.rest.resource.ResourceContainer;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.SimpleDateFormat;
import java.util.List;

@Path("/idea")
@Produces(MediaType.APPLICATION_JSON)

public class IdeaRestService implements ResourceContainer {
  private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
  private static Log              LOG       = ExoLogger.getLogger(IdeaRestService.class);
  @Inject
  IdeaService ideaService;
  public IdeaRestService() {
    ideaService= CommonsUtils.getService(IdeaService.class);
  }

  @GET
  @Path("/getdrafted/{DRAFET}")
  public Response getDraftIdeas(@PathParam("DRAFET") IdeaEntity.Status draft) {

    try {
      List<IdeaDTO> draftIdea = ideaService.getIdeaDraft(draft);

      return Response.ok(draftIdea, MediaType.APPLICATION_JSON).build();

    } catch (Exception e) {

      LOG.error("Error listing all Idea ", e);

      return Response.serverError()
                     .entity("Error listing all Idea")
                     .build();
    }
  }
    @GET
    @Path("/getarchived/{ARCHIVED}")
    public Response getArchivedIdeas(@PathParam("ARCHIVED") IdeaEntity.Status archived) {


      try {
        List<IdeaDTO> draftIdea = ideaService.getIdeaArchived(archived);

        return Response.ok(draftIdea, MediaType.APPLICATION_JSON).build();

      } catch (Exception e) {

        LOG.error("Error listing all Idea ", e);

        return Response.serverError()
                       .entity("Error listing all Idea")
                       .build();
      }



  }
  @POST
  @Path("addIdea")
  public  Response addIdea(IdeaDTO ideaDTO){
    try{
      ideaDTO=ideaService.addIdea(ideaDTO);
      return Response.ok().entity(ideaDTO).build();
    }catch (Exception e) {
      return Response.serverError()
                     .entity("Error adding new idea")
                     .build();
    }
  }


  @DELETE
  @Path("/delete/{id}")
  public  Response deltetidea(@PathParam("id") Long id ) {
    try {

        ideaService.deleteIdea(id);

      return Response.ok().build();
    } catch (Exception e) {
      return Response.serverError()
                     .entity("Error delete idea")
                     .build();

  }


}

  @PUT
  @Path("/update")
  public Response updateIdea(IdeaDTO ideaDTO) {
 try {

       ideaService.updateIdea(ideaDTO);

        return Response.ok().build();

      } catch (Exception e) {

        LOG.error("Error updating idea {} by {} ", e);

        return Response.serverError().build();

      }




  }




/*

    private static Log log = ExoLogger.getLogger(IdeaRestService.class);

    @Inject
    IdeaService ideaService;
/*
    @GET
    @Path("/list")
    public Response getIdeas(){

        List<IdeaEntity> ideas =ideaService.getAllIdea();
        JSONArray jsonArray=new JSONArray();
        try {
            for(IdeaEntity idea :  ideas){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id_ideas", idea.getId());
                jsonObject.put("titre", idea.getTitle());
                jsonObject.put("description", idea.getDescription());
                jsonObject.put("status",idea.getStatus());
                jsonObject.put("user", idea.getUSER());
                jsonObject.put("time", idea.getCreatedTime());
                jsonArray.add(jsonObject);

            }
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An internal error has occurred When trying to import Ideas list")
                    .build();
        }
        return Response.ok(jsonArray.toString(), MediaType.APPLICATION_JSON).build();
    }
*/
/*@GET
@Path("/json")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public List<IdeaEntity> getjson(){
    return ideaService.getAllIdea();
}
@POST
@Path("/addidea")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

    public IdeaEntity creatIdee(IdeaEntity idee){
    IdeaEntity idea=new IdeaEntity();
    idea.setTitle(idee.getTitle());
    idea.setDescription(idee.getDescription());
    idea.setCreatedTime(idee.getCreatedTime());
    idea.setUser(idee.getUser());
    idea.setStatus(idee.getStatus());
    return ideaService.AddIdea(idea);
}

@DELETE
@Path("/delete/{id}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
     public String deltetidea(@PathParam("id") Long id){

        return ideaService.deleteIdea(id);
}

/*@GET
@Path("/getuser/{user}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
    public List<IdeaEntity> getideabyuser(@PathParam("user") String user){
    return ideaService.getIdeaByUser(user);
}*/

   /*@GET
    @Path("/getpubsh/{PUBLISHED}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<IdeaEntity> getideaPublished(@PathParam("PUBLISHED") IdeaEntity.Status PUBLISHED){
        return ideaService.getIdeaPublished(PUBLISHED);
    }
    @GET
    @Path("/getdrafted/{DRAFET}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<IdeaEntity> getideaDRAFET(@PathParam("DRAFET") IdeaEntity.Status DRAFET){
        return ideaService.getIdeaDRAFET(DRAFET);
    }
    @GET
    @Path("/getarchived/{ARCHIVED}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<IdeaEntity> getideaARCHIVED(@PathParam("ARCHIVED") IdeaEntity.Status ARCHIVED){
        return ideaService.getIdeaARCHIVED(ARCHIVED);
    }
*/

}
