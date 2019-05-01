package org.exoplatform.ideation.dao;

import org.exoplatform.commons.persistence.impl.GenericDAOJPAImpl;
import org.exoplatform.ideation.entities.RatingEntity;

import javax.persistence.TypedQuery;
import java.util.List;

public class RatingImpDAO extends GenericDAOJPAImpl<RatingEntity,Long> {

    public List<RatingEntity> getStatusById(Long id){
        TypedQuery<RatingEntity> query = getEntityManager().createNamedQuery("Rating.getStatusByIdIdea",RatingEntity.class);
        query.setParameter("id",id);
        return query.getResultList();



    }
}
