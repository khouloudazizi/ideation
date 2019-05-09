package org.exoplatform.ideation.service.utils;

import org.exoplatform.commons.api.persistence.ExoTransactional;
import org.exoplatform.commons.utils.CommonsUtils;
import org.exoplatform.ideation.dao.FavoriteImpDAO;
import org.exoplatform.ideation.dto.CowokerDTO;
import org.exoplatform.ideation.dto.FavoritDTO;

import org.exoplatform.ideation.dto.OrderIdeaDTO;
import org.exoplatform.ideation.entities.CoworkerEntity;
import org.exoplatform.ideation.entities.FavoriteEntity;

import org.exoplatform.ideation.entities.IdeaEntity;
import org.exoplatform.ideation.service.Mapper.FavoritMapper;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;

import java.util.ArrayList;
import java.util.List;

public class FavService {
  private static final Log LOG = ExoLogger.getExoLogger(FavoriteEntity.class);

  private FavoritMapper favoritMapper;

  private FavoriteImpDAO favoriteImpDAO;

  public FavService(FavoritMapper favoritMapper, FavoriteImpDAO favoriteImpDAO) {
    this.favoritMapper = CommonsUtils.getService(FavoritMapper.class);
    this.favoriteImpDAO = CommonsUtils.getService(FavoriteImpDAO.class);
  }

  public List<FavoritDTO> getAllFavByUser(String user) {
    try {
      List<FavoriteEntity> favoriteEntities = favoriteImpDAO.getFav(user);
      if (favoriteEntities != null) {
        return favoritMapper.FavsToFavDTOs(favoriteEntities);
      }
    } catch (Exception e) {
      LOG.error("Error to find fav by idea", e.getMessage());

    }
    return null;

  }

  public List<FavoritDTO> getallbyidANDuser(String user, Long id) {
    try {
      List<FavoriteEntity> favs = favoriteImpDAO.getFavByUserAndId(user, id);
      if (favs != null) {
        return favoritMapper.FavsToFavDTOs(favs);
      }
    } catch (Exception e) {
      LOG.error("Error to find fav by idea", e.getMessage());

    }
    return null;
  }

  @ExoTransactional
  public FavoritDTO addFav(FavoritDTO favoritDTO) {
    FavoriteEntity favoriteEntity = null;
    try {
      favoriteEntity = favoriteImpDAO.create(favoritMapper.FavdtoTofav(favoritDTO));
    } catch (Exception e) {
      LOG.error("Error to create badge with title {}", favoritDTO.getUser(), e);
    }

    return favoritMapper.FavToFavDTO(favoriteEntity);
  }

  public List<FavoritDTO> getallbyid(Long id) {
    try {
      List<FavoriteEntity> favs = favoriteImpDAO.getFavById(id);
      if (favs != null) {
        return favoritMapper.FavsToFavDTOs(favs);
      }
    } catch (Exception e) {
      LOG.error("Error to find fav by idea", e.getMessage());

    }
    return null;
  }

  public List<OrderIdeaDTO> getAllOrderByFav() {
    try {
      //--- load all Rules
      List<OrderIdeaDTO> list1=new ArrayList<OrderIdeaDTO>();
      List<FavoriteEntity> favorits =  favoriteImpDAO.getAllOrderByFav();
      int i=0;
      while(i<favorits.size()){
        OrderIdeaDTO orderideadto=new OrderIdeaDTO();
        orderideadto.setId(favorits.get(i).getIdea().getId());
        orderideadto.setTitle(favorits.get(i).getIdea().getTitle());
        orderideadto.setUser(favorits.get(i).getIdea().getUser());
        orderideadto.setNb(favoriteImpDAO.getnumberOffav(favorits.get(i).getIdea().getId()));
        list1.add(orderideadto);
        i++;

      }
      return list1 ;


    } catch (Exception e) {
      LOG.error("Error to find Idea Ordered", e.getMessage());
    }

    return null;
  }



}
