package org.exoplatform.ideation.service.Mapper;

import org.exoplatform.ideation.dto.CommentDTO;
import org.exoplatform.ideation.entities.CommentEntity;
import org.exoplatform.ideation.entities.IdeaEntity;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CommentMapper {
  private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

  public CommentMapper() {
  }
  public CommentDTO CommentToCommentDTO(CommentEntity comment){
    return new CommentDTO(comment);
  }
  public List<CommentDTO> CommentsTOCommentDTO(List<CommentEntity> Comment){
    return Comment.stream()
               .filter(Objects::nonNull)
               .map(this::CommentToCommentDTO)
               .collect(Collectors.toList());

  }
  public CommentEntity commentDTOToComment(CommentDTO commentDTO){
    try {
      if(commentDTO==null){
        return null;
      }else{
        CommentEntity comment=new CommentEntity();
        comment.setCommentText(commentDTO.getCommentText());
       comment.setUSER(commentDTO.getUser());
        if (commentDTO.getCreatedTime() != null) {
          comment.setCreatedTime(formatter.parse(commentDTO.getCreatedTime()));
        }

        IdeaEntity idea=this.IdeaFromLongId(commentDTO.getId_ideac());
        comment.setIdea(idea);
        return comment;

      }

    }catch(Exception pe){
      pe.printStackTrace();
    }
    return null;
  }
  public IdeaEntity IdeaFromLongId(Long idIdea) {
    IdeaEntity idea=new IdeaEntity();
    idea.setId(idIdea);
    return idea;
  }

}
