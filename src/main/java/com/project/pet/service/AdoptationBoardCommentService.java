package com.project.pet.service;


import com.project.pet.dto.adoptation.request.PostAdoptationBoardCommentReqDto;
import com.project.pet.dto.adoptation.request.UpdateAdoptionBoardCommentReqDto;
import com.project.pet.dto.adoptation.response.GetAdoptationBoardCommentRespDto;
import com.project.pet.entity.adoptationBoard.AdoptationBoardComment;
import com.project.pet.entity.user.PrincipalUser;
import com.project.pet.repository.AdoptationBoardCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdoptationBoardCommentService {

    @Autowired
    private AdoptationBoardCommentMapper adoptationBoardCommentMapper;

    //댓글 작성
    public void saveAdoptationBoardComment (PostAdoptationBoardCommentReqDto postAdoptationBoardCommentReqDto) {

        adoptationBoardCommentMapper.saveAdoptationBoardComment(postAdoptationBoardCommentReqDto.toEntity());
    }

    //댓글 다건 조회
    public List<GetAdoptationBoardCommentRespDto> getAdoptationBoardCommentByBoardId(int boardId) {
        List<AdoptationBoardComment> adoptationBoardComments = adoptationBoardCommentMapper.getAdoptationBoardCommentByBoardId(boardId);
        return adoptationBoardComments.stream().map(AdoptationBoardComment::toGetAdoptationBoardCommentRespDto).collect(Collectors.toList());
    }

    public GetAdoptationBoardCommentRespDto getAdoptationBoardCommentByCommentId(int commentId) {
        AdoptationBoardComment adoptationBoardComment = adoptationBoardCommentMapper.getAdoptationBoardCommentByCommentId(commentId);
        return adoptationBoardComment.toGetAdoptationBoardCommentRespDto();
    }

    //댓글 단건 삭제
    public void deleteAdoptationBoardCommentByCommentId(int commentId) {
        adoptationBoardCommentMapper.deleteAdoptationBoardByCommentId(commentId);
    }


    //댓글 다건 삭제
    public void deleteAdoptationBoardComments(List<Integer> comments) {
        for(int commentId : comments) {
            adoptationBoardCommentMapper.deleteAdoptationBoardByCommentId(commentId);
        }
    }

    //댓글 단건 수정
    public void updateAdoptationBoardCommentByCommentId(UpdateAdoptionBoardCommentReqDto updateAdoptionBoardCommentReqDto) {
        adoptationBoardCommentMapper.updateAdoptationBoardByCommentId(updateAdoptionBoardCommentReqDto.toEntity());
    }

}
