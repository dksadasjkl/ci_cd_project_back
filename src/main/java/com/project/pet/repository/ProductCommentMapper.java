package com.project.pet.repository;

import com.project.pet.entity.product.ProductComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductCommentMapper {
    public int saveProductComment(ProductComment productComment);
    public List<ProductComment> getProductCommentsByUserId(int userId);
    public List<ProductComment> getAllProductCommentsByProductId(int productId);
    public int deleteProductComment(int productCommentId);
    public List<ProductComment> findProductComments (
            @Param("startIndex") int startIndex,
            @Param("count") int count,
            int productId
    );
    public int getAllProductCommentCount(int productId);
    public int updateProductComment(ProductComment productComment);

}
