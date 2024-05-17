package com.project.pet.service;

import com.project.pet.dto.communityboard.request.CommunityBoardFavoriteRequestDto;
import com.project.pet.dto.communityboard.request.DeleteCommunityBoardLikeReqDto;
import com.project.pet.dto.communityboard.request.GetCommunityBoardLikeReqDto;
import com.project.pet.dto.communityboard.response.GetCommunityBoardFavoriteResponseDto;
import com.project.pet.dto.communityboard.response.GetCommunityBoardResponseDto;
import com.project.pet.entity.communityBoard.CommunityBoard;
import com.project.pet.entity.communityBoard.CommunityBoardFavorite;
import com.project.pet.entity.user.PrincipalUser;
import com.project.pet.repository.CommunityBoardFavoriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommunityBoardFavoriteService {

    @Autowired
    private CommunityBoardFavoriteMapper communityBoardFavoriteMapper;


    // 게시물 좋아요 증가 등록(Post)
    public void saveBoardFavorite (CommunityBoardFavoriteRequestDto communityBoardFavoriteRequestDto) {
        communityBoardFavoriteMapper.saveBoardFavorite(communityBoardFavoriteRequestDto.toEntity());
    }

    public GetCommunityBoardFavoriteResponseDto getBoardFavoritesCount (GetCommunityBoardLikeReqDto getCommunityBoardLikeReqDto) {
        return communityBoardFavoriteMapper.getBoardFavoritesCount(getCommunityBoardLikeReqDto.getCommunityBoardId()).toGetCommunityBoardFavoriteResponseDto();
    }

    public boolean getUserBoardLikeStatus(GetCommunityBoardLikeReqDto getCommunityBoardLikeReqDto) {
        return  communityBoardFavoriteMapper.existsByUserIdAndBoardId(getCommunityBoardLikeReqDto.toEntity());
    }


    // 게시물 좋아요 감소 (Delete)
    public void deleteCommunityBoardFavoriteByBoardId(DeleteCommunityBoardLikeReqDto deleteCommunityBoardLikeReqDto) {
        communityBoardFavoriteMapper.deleteCommunityBoardFavorite(deleteCommunityBoardLikeReqDto.getUserId(), deleteCommunityBoardLikeReqDto.getCommunityBoardId());
    }

}
