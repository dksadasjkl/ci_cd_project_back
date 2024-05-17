package com.project.pet.controller;


import com.project.pet.dto.communityboard.request.*;
import com.project.pet.service.CommunityBoardCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/community")
public class CommunityBoardCommentController {

    @Autowired
    private CommunityBoardCommentService communityBoardCommentService;


    // 커뮤니티 게시판 댓글 작성(단건) - 상세페이지 게시물에서 사용(Post)
    @PostMapping("/comment")
    public ResponseEntity<?> saveCommunityBoardComment(@RequestBody CommunityBoardCommentRequestDto communityBoardCommentRequestDto) {
        communityBoardCommentService.saveCommunityComments(communityBoardCommentRequestDto);
        return  ResponseEntity.ok().body(true);

    }

    // 커뮤니티 게시판 댓글 조회(다건) - 게시판 상세 페이지(boardId)를 통해 게시판에 단 댓글을 조회.
    @GetMapping("/comments")
    public  ResponseEntity<?> getCommunityBoardAllCommentsByBoardId(GetCommunityBoardCommentByBoardIdReqDto getCommunityBoardCommentByBoardIdReqDto) {
        return  ResponseEntity.ok(communityBoardCommentService.getCommunityBoardAllCommentsByBoardId(getCommunityBoardCommentByBoardIdReqDto));
    }

    // 커뮤니티 게시판 댓글 조회(단건) - 마이 페이지에서 내가 쓴 댓글을 조회 및 상세 페이지에도 사용.
    @GetMapping("/user/comment")
    public ResponseEntity<?> getCommunityBoardCommentByUserId(GetCommunityBoardCommentByUserIdReqDto getCommunityBoardCommentByUserIdReqDto) {
        return ResponseEntity.ok(communityBoardCommentService.getCommunityBoardCommentByUserId(getCommunityBoardCommentByUserIdReqDto));
    }


    // 커뮤니티 게시판 댓글 단건 삭제(Delete) - 상세페이지 게시물에서 사용
    @DeleteMapping("/delete/comment/{communityBoardCommentId}")
    public ResponseEntity<?> deleteCommunityBoardComment(DeleteCommunityBoardCommentRequestDto deleteCommunityBoardCommentRequestDto) {
        communityBoardCommentService.deleteCommunityBoardCommentId(deleteCommunityBoardCommentRequestDto);
        return  ResponseEntity.ok(true);
    }

    // 커뮤니티 게시판 댓글 다건 삭제(Delete) -  마이페이지 내가 작성한 댓글에서 사용
//    @DeleteMapping("/delete/comments")
//    public ResponseEntity<?> deleteCommunityBoardComment(@RequestBody DeleteCommunityBoardCommentRequestDto deleteCommunityBoardCommentRequestDto) {
//        communityBoardCommentService.deleteCommunityBoardComment(deleteCommunityBoardCommentRequestDto);
//        return ResponseEntity.ok(true);
//
//    }

    // 커뮤니티 게시판 댓글 단건 수정(Put) -
    @PutMapping("/update/comment")
    public ResponseEntity<?> updateCommunityBoardComment(@RequestBody UpdateCommunityBoardCommentRequestDto updateCommunityBoardCommentRequestDto) {
        communityBoardCommentService.updateCommunityBoardCommentId(updateCommunityBoardCommentRequestDto);
        return ResponseEntity.ok().body(true);
    }
}

