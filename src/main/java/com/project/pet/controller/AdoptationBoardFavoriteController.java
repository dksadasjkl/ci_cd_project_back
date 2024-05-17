package com.project.pet.controller;


import com.project.pet.dto.adoptation.request.DeleteAdoptationBoardLikeReqDto;
import com.project.pet.dto.adoptation.request.GetAdoptationFavoriteReqDto;
import com.project.pet.dto.adoptation.request.PostAdoptationBoardFavoriteReqDto;
import com.project.pet.service.AdoptationBoardFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/adoptation")
public class AdoptationBoardFavoriteController {

    @Autowired
    private AdoptationBoardFavoriteService adoptationBoardFavoriteService;

    //해당 userId로 좋아요 취소
    @DeleteMapping("/favorite")
    public ResponseEntity<?> deleteAdoptationBoardFavorite(@RequestParam int adoptationBoardId, @RequestParam int userId) {
        Map<String, Integer> params = new HashMap<>();
        params.put("adoptationBoardId", adoptationBoardId);
        params.put("userId", userId);
        System.out.println(params);
        adoptationBoardFavoriteService.deleteAdoptationBoardFavorite(params);
        return ResponseEntity.ok(null);
    }


    //해당 userId로 게시물에 좋아요 등록
    @PostMapping("/favorite")
    public ResponseEntity<?> saveAdoptationBoardFavorite(@RequestBody PostAdoptationBoardFavoriteReqDto postAdoptationBoardFavoriteReqDto) {
        adoptationBoardFavoriteService.saveAdoptationBoardFavorite(postAdoptationBoardFavoriteReqDto);
        return ResponseEntity.created(null).body(true);
    }

    @GetMapping("/favorite/board")
    public ResponseEntity<?> getAdoptationBoardFavoriteByBoardId (@RequestParam int adoptationBoardId) {
        return ResponseEntity.ok(adoptationBoardFavoriteService.getAdoptationBoardFavorite(adoptationBoardId));
    }

    @GetMapping("/favorite/{boardId}")
    public ResponseEntity<?> getFindUserByBoardId (@PathVariable int boardId) {
        return ResponseEntity.ok(adoptationBoardFavoriteService.findMyUserIdByBoardId(boardId));
    }

}
