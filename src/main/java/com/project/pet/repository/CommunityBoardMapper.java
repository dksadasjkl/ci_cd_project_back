package com.project.pet.repository;

import com.project.pet.entity.communityBoard.CommunityBoard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommunityBoardMapper {

    // 게시판 작성(Post)
    public int postCommunityBoard(CommunityBoard communityBoard);


    public List<CommunityBoard> getTop3Boards();
    // 게시판 조회 다건(Get)
    public List<CommunityBoard> GetCommunityBoards();

    //게시판 해당BoardId로 조회 단건(Get)
    public CommunityBoard getCommunityBoardBoardId(int communityBoardAdminId);

    // 게시판에 좋아요한 userId조회
    public List<CommunityBoard> getFavoriteCommunityBoardsByUserId(int userId);

    public int setBoardViewCountUp(int communityBoardId);

    public List<CommunityBoard> getCommunityBoardsDog();

    public List<CommunityBoard> getCommunityBoardCat();

    public List<CommunityBoard> getMyBoardByUserId(int userId);

    // 전체 게시판 페이지
    public List<CommunityBoard> getBoardPageCount(
            @Param("startIndex") int startIndex,
            @Param("count") int count,
            @Param("boardAnimalCategoryId") int boardAnimalCategoryId,
            @Param("searchText") String searchText
    );

    public int getBoardCount(
            @Param("searchText") String searchText,
            @Param("boardAnimalCategoryId") int boardAnimalCategoryId
    );



    public int getDogBoardPageCount();

    public int getCatBoardPageCount();

    public int getMyBoardPageCount();


    // 게시판 해당BoardId로 단건 삭제(Delete)
    public void deleteCommunityBoardByBoardId(int communityBoardId);

    //게시판 다건 삭제(Delete)
    public int deleteCommunityBoards(List<Integer> boardIds);

    // 게시판 해당BoardId로 단건 수정(Put)
    public int updateCommunityBoard(CommunityBoard communityBoard);

}












