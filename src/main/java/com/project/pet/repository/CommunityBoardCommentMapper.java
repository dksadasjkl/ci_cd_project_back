package com.project.pet.repository;

import com.project.pet.entity.communityBoard.CommunityBoardComment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommunityBoardCommentMapper {

    // 커뮤니티 게시판 추가(Post)
    public int  saveCommunityBoardComment(CommunityBoardComment communityBoardComment);

    // 커뮤니티 게시판 해당 게시판(BoardId)에 달린 댓글 전체 조회.
    public List <CommunityBoardComment> getCommunityBoardAllCommentsByBoardId(int communityBoardId);

    // 커뮤니티 게시판 단건 조회(Get)
    public List <CommunityBoardComment> getCommunityBoardCommentByUserId(int userId);

    // 커뮤니티 게시판 단건 삭제(Delete)
    public int deleteCommunityBoardComment(int communityBoardCommentId);

    // 커뮤니티 게시판 다건 삭제(Delete)
    public int deleteCommunityBoardComments(List<Integer> commentIds);

    // 커뮤니티 게시판 단건 수정(Put)
    public int updateCommunityBoardComment(CommunityBoardComment communityBoardComment);
}
