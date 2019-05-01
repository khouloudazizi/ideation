package org.exoplatform.ideation.service.utils;

import org.exoplatform.ideation.dao.RatingImpDAO;
import org.exoplatform.ideation.entities.RatingEntity;

import java.util.List;

public class RatingService {
    private RatingImpDAO ratingdao;
    /**
     *
     * @param ratingdao;
     */

    public RatingService(RatingImpDAO ratingdao) {
        this.ratingdao = ratingdao;
    }

    public void setRatingdao(RatingImpDAO ratingdao) {
        this.ratingdao = ratingdao;
    }

    public List<RatingEntity> getStatusIdIdea(Long id){
        return ratingdao.getStatusById(id);

    }

}
