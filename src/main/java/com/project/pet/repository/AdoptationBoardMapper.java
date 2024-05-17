package com.project.pet.repository;


import com.project.pet.dto.adoptation.request.GetAdoptationBoardByUserIdReqDto;
import com.project.pet.entity.adoptationBoard.AdoptationBoard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdoptationBoardMapper {

    //게시글 작성
    public int postAdoptationBoard(AdoptationBoard adoptationBoard);

    public List<AdoptationBoard> getTop3AdoptationBoards();

    //전체 게시글 조회
    public List<AdoptationBoard> getAdoptationBoards(
            @Param("startIndex") int startIndex,
            @Param("count") int count,
            @Param("boardAnimalCategoryId") int boardAnimalCategoryId,
            @Param("adoptationBoardTitle") String adoptationBoardTitle
    );

    public List<AdoptationBoard> getAdoptationBoardByUserId(int userId);

    public int getAdoptationBoardCount(
            @Param("boardAnimalCategoryId") int boardAnimalCategoryId,
            @Param("adoptationBoardTitle") String adoptationBoardTitle
    );

    public int getAdoptationBoardDogCount();

    public int getAdoptationBoardCatCount();

    public int getAdoptationBoardUserCount(int userId);


    //개 카테고리인 게시글 목록 조회
    public List<AdoptationBoard> getAdoptationBoardsDog();


    //고양이 카테고리인 게시글 목록 조회
    public List<AdoptationBoard> getAdoptationBoardsCat();

    //해당 유저id가 좋아요를 누른 게시글 리스트 조회
    public List<AdoptationBoard> getLikedAdoptationBoardByUserId(int userId);


    public int setAdoptationBoardViewCountUp(int boardId);

    //해당 게시글 단건 조회
    public AdoptationBoard getAdoptationBoardByBoardId(int boardId);


    //해당 게시글 단건 삭제
    public void deleteAdoptationBoardByBoardId(int boardId);

    //해당 게시글 수정
    public int updateAdoptationBoard(AdoptationBoard adoptationBoard);

    public List<AdoptationBoard> getAdoptationBoardMyPage(
            @Param("startIndex") int startIndex,
            @Param("count") int count,
            @Param("userId") int userId
    );

}
