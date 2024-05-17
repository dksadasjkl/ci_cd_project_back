package com.project.pet.repository;

import com.project.pet.dto.adoptation.request.DeleteAdoptationBoardLikeReqDto;
import com.project.pet.dto.adoptation.request.GetAdoptationBoardFavoriteCountReqDto;
import com.project.pet.dto.adoptation.request.GetAdoptationFavoriteReqDto;
import com.project.pet.dto.adoptation.request.PostAdoptationBoardFavoriteReqDto;
import com.project.pet.entity.adoptationBoard.AdoptationBoardFavorite;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdoptationBoardFavoriteMapper {
    public int saveAdoptationBoardFavorite(AdoptationBoardFavorite adoptationBoardFavorite);
    public int deleteAdoptationBoardFavorite(Map<String, Integer> params);
    public int getAdoptationBoardFavorite(int boardId);
    public List<Integer> getAdoptationBoardFavorites(int boardId);
    public List<AdoptationBoardFavorite> findMyUserIdByBoardId(int boardId);
}
