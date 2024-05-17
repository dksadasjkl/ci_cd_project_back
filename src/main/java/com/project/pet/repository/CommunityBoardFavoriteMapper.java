package com.project.pet.repository;

import com.project.pet.entity.communityBoard.CommunityBoard;
import com.project.pet.entity.communityBoard.CommunityBoardFavorite;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommunityBoardFavoriteMapper {

    public int saveBoardFavorite(CommunityBoardFavorite communityBoardFavorite);

    public CommunityBoard getBoardFavoritesCount(int getCommunityBoardId);

    public boolean existsByUserIdAndBoardId(CommunityBoardFavorite communityBoardFavorite);

    public int deleteCommunityBoardFavorite(int userId, int communityBoardId);
}
