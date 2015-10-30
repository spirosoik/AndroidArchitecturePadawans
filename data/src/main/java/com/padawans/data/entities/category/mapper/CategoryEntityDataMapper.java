package com.padawans.data.entities.category.mapper;

import com.padawans.data.net.common.response.Category;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Spiros I. Oikonomakis on 10/29/15.
 */
@Singleton public class CategoryEntityDataMapper {

  @Inject public CategoryEntityDataMapper() {
  }

  public com.padawans.data.entities.category.CategoryEntity transform(Category category) {
    com.padawans.data.entities.category.CategoryEntity categoryEntity = null;
    if (category != null) {
      categoryEntity = new com.padawans.data.entities.category.CategoryEntity();
      categoryEntity.setId(category.id);
      categoryEntity.setName(category.name);
      categoryEntity.setPrefixImageUrl(category.icon.prefix);
      categoryEntity.setSuffixImage(category.icon.suffix);
    }
    return categoryEntity;
  }

  public List<com.padawans.data.entities.category.CategoryEntity> transform(Collection<Category> categoryCollection) {
    List<com.padawans.data.entities.category.CategoryEntity> placeEntityList = new ArrayList<>();
    com.padawans.data.entities.category.CategoryEntity place = null;
    for (Category venue : categoryCollection) {
      place = transform(venue);
      if (place != null) {
        placeEntityList.add(place);
      }
    }
    return placeEntityList;
  }
}
