package com.project.pet.repository;

import com.project.pet.entity.product.ProductCommentRating;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductCommentRatingMapper {
    public int savaProductCommentRating(ProductCommentRating productCommentRating);
    public int updateProductCommentRating(ProductCommentRating productCommentRating);
}
