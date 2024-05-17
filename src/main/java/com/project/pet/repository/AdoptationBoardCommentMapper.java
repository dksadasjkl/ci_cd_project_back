package com.project.pet.repository;


import com.project.pet.dto.adoptation.request.PostAdoptationBoardCommentReqDto;
import com.project.pet.dto.adoptation.request.UpdateAdoptionBoardCommentReqDto;
import com.project.pet.dto.adoptation.response.GetAdoptationBoardCommentRespDto;
import com.project.pet.entity.adoptationBoard.AdoptationBoardComment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdoptationBoardCommentMapper {

    public int saveAdoptationBoardComment(AdoptationBoardComment adoptationBoardComment);

    public List<AdoptationBoardComment> getAdoptationBoardCommentByBoardId(int boardId);

    public AdoptationBoardComment getAdoptationBoardCommentByCommentId(int commentId);

    public void deleteAdoptationBoardByCommentId(int commentId);

    public void updateAdoptationBoardByCommentId(AdoptationBoardComment adoptationBoardComment);
}

