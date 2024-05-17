package com.project.pet.controller;


import com.project.pet.dto.adoptation.request.PostAdoptationBoardCommentReqDto;
import com.project.pet.dto.adoptation.request.UpdateAdoptionBoardCommentReqDto;
import com.project.pet.entity.adoptationBoard.AdoptationBoardComment;
import com.project.pet.service.AdoptationBoardCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adoptation")
public class AdoptationBoardCommentController {

    @Autowired
    private AdoptationBoardCommentService adoptationBoardCommentService;


    //게시판 댓글 작성
    @PostMapping("/comment")
    public ResponseEntity<?> saveAdoptationBoardComment(@RequestBody PostAdoptationBoardCommentReqDto postAdoptationBoardCommentReqDto) {
        adoptationBoardCommentService.saveAdoptationBoardComment(postAdoptationBoardCommentReqDto);
        return ResponseEntity.created(null).body("댓글 작성 완료");
    }

    //boardId로 해당 게시판 댓글 다건 조회
    @GetMapping("/comments/{boardId}")
    public ResponseEntity<?> getAdoptationBoardComment(@PathVariable int boardId) {
        return ResponseEntity.ok(adoptationBoardCommentService.getAdoptationBoardCommentByBoardId(boardId));
    }

    //commentId로 해당 게시판 댓글 단건 조회
    @GetMapping("/comment/{commentId}")
    public ResponseEntity<?> getAdoptationVBoardCommentByCommentId(@PathVariable int commentId) {
        return ResponseEntity.ok(adoptationBoardCommentService.getAdoptationBoardCommentByCommentId(commentId));
    }



    //게시판 댓글 단건 삭제
    @DeleteMapping("/comment/{commentId}")
    public ResponseEntity<?> DeleteAdoptationBoardCommentByCommentId(@PathVariable int commentId){
            adoptationBoardCommentService.deleteAdoptationBoardCommentByCommentId(commentId);
            return ResponseEntity.ok().body("삭제 완료");
    }

    //게시판 댓글 다건 삭제
    @DeleteMapping("/comment")
    public ResponseEntity<?> DeleteAdoptationBoardComments(@RequestParam("commentsId") List<Integer> comments) {
        adoptationBoardCommentService.deleteAdoptationBoardComments(comments);
        return ResponseEntity.ok("삭제 완료");
    }

    //게시판 댓글 단건 수정
    @PutMapping("/comment")
    public ResponseEntity<?> DeleteAdoptationBoardCommentByCommentId(@RequestBody UpdateAdoptionBoardCommentReqDto updateAdoptionBoardCommentReqDto) {
        adoptationBoardCommentService.updateAdoptationBoardCommentByCommentId(updateAdoptionBoardCommentReqDto);
        return ResponseEntity.ok(true);
    }


}
