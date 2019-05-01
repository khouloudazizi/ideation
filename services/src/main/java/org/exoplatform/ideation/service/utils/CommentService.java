package org.exoplatform.ideation.service.utils;

import org.exoplatform.commons.api.persistence.ExoTransactional;
import org.exoplatform.commons.utils.CommonsUtils;
import org.exoplatform.ideation.dao.CommentImpDAO;
import org.exoplatform.ideation.dto.CommentDTO;
import org.exoplatform.ideation.entities.CommentEntity;
import org.exoplatform.ideation.service.Mapper.CommentMapper;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;

public class CommentService {
    private           CommentImpDAO commentdao;
 /*   /**
     *
     * @param commentdao;
     */
   /* public CommentService(CommentImpDAO commentdao) {

        this.commentdao = commentdao;
    }

    public void setCommentdao(CommentImpDAO commentdao) {
        this.commentdao = commentdao;
    }

    public List<CommentEntity> getComment(Long id){
        return commentdao.getComment(id);
    }*/
 private              CommentImpDAO commentDao;
 private              CommentMapper commentMapper;
 private static final Log           LOG = ExoLogger.getExoLogger(CommentEntity.class);

    public CommentService(CommentImpDAO commentDao,CommentMapper commentMapper) {
        this.commentDao=  CommonsUtils.getService(CommentImpDAO.class);
        this.commentMapper=  CommonsUtils.getService(CommentMapper.class);
    }

    @ExoTransactional
    public CommentDTO addComment (CommentDTO commentDTO) {

        CommentEntity commententity = null;

        try {

            commententity = commentDao.create(commentMapper.commentDTOToComment(commentDTO));

        } catch (Exception e) {
            LOG.error("Error to create badge with title {}", commentDTO.getCommentText() , e);
        }

        return commentMapper.CommentToCommentDTO(commententity);
    }



}
