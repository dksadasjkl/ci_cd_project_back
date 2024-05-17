package com.project.pet.service;
import com.project.pet.dto.communityboard.request.*;
import com.project.pet.dto.communityboard.response.*;
import com.project.pet.entity.communityBoard.CommunityBoard;
import com.project.pet.repository.CommunityBoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommunityBoardService {

    @Autowired
    private CommunityBoardMapper communityBoardMapper;

    public List<GetTop3BoardsResponseDto> getTop3Boards() {
        List<CommunityBoard> list = communityBoardMapper.getTop3Boards();
        return list.stream().map(CommunityBoard::toGetTop3BoardsResDto).collect(Collectors.toList());
    }

    // 게시물 추가 (post)
    public void  PostCommunityBoardRequestDto (PostCommunityBoardRequestDto postCommunityBoardRequestDto) {
        communityBoardMapper.postCommunityBoard(postCommunityBoardRequestDto.toEntity());
    }

    // 게시물 다건 조회 (Get)
    public List<GetCommunityBoardResponseDto> getCommunityBoards () {
        List<CommunityBoard> communityBoards = communityBoardMapper.GetCommunityBoards();
        return communityBoards.stream().map(CommunityBoard::toGetCommunityBoardResponseDto).collect(Collectors.toList());
    }

    // 게시물 해당BoardId로 단건 조회 (Get)
    public GetCommunityBoardResponseDto getCommunityBoardByBoardId(GetCommunityBoardRequestDto getCommunityBoardRequestDto) {
        communityBoardMapper.setBoardViewCountUp(getCommunityBoardRequestDto.getCommunityBoardId());
        CommunityBoard communityBoard = communityBoardMapper.getCommunityBoardBoardId(getCommunityBoardRequestDto.getCommunityBoardId());
        return communityBoard.toGetCommunityBoardResponseDto();
    }




    public List<GetCommunityBoardResponseDto> getMyWriteBoardByUserId(int userId)  {
        List <CommunityBoard> communityBoards = communityBoardMapper.getMyBoardByUserId(userId);
        return communityBoards.stream().map(CommunityBoard::toGetCommunityBoardResponseDto).collect(Collectors.toList());
    }

    // 페이지 조회
    public List<GetCommunityBoardResponseDto> getBoardPageCount(GetCommunityBoardPageCountReqDto getCommunityBoardPageCountReqDto) {
        int startIndex = (getCommunityBoardPageCountReqDto.getPage() - 1) * getCommunityBoardPageCountReqDto.getCount();

        List<CommunityBoard>  communityBoardList = communityBoardMapper.getBoardPageCount(
                startIndex,
                getCommunityBoardPageCountReqDto.getCount(),
                getCommunityBoardPageCountReqDto.getBoardAnimalCategoryId(),
                getCommunityBoardPageCountReqDto.getSearchText());
        return communityBoardList.stream().map(CommunityBoard::toGetCommunityBoardResponseDto).collect(Collectors.toList());
    }

    // 페이지 카운트
    public GetCommunityBoardPageCountResponseDto  getBoardCount(GetCommunityBoardPageCountReqDto getCommunityBoardPageCountReqDto) {
        int boardCount = communityBoardMapper.getBoardCount(
                getCommunityBoardPageCountReqDto.getSearchText(),
                getCommunityBoardPageCountReqDto.getBoardAnimalCategoryId()
        );
        int maxPageNumber = (int) Math.ceil(((double) boardCount) / getCommunityBoardPageCountReqDto.getCount());

        return GetCommunityBoardPageCountResponseDto.builder()
                .totalCount(boardCount)
                .maxPageNumber(maxPageNumber)
                .build();
    }


    public GetCommunityBoardDogCountResDto getDogBoardPageCount(GetCommunityBoardDogCountReqDto getCommunityBoardDogCountReqDto) {
        int dogBoardCount = communityBoardMapper.getDogBoardPageCount();
        int dogPageMaxNumber = (int) Math.ceil(((double) dogBoardCount / getCommunityBoardDogCountReqDto.getCount()));

        return GetCommunityBoardDogCountResDto.builder()
                .dogPageMaxNumber(dogPageMaxNumber)
                .totalCount(dogBoardCount)
                .build();
    }

    public GetCommunityBoardCatCountResDto getCatBoardPageCount(GetCommunityBoardCatCountReqDto getCommunityBoardCatCountReqDto) {
        int catBoardCount = communityBoardMapper.getCatBoardPageCount();
        int catPageMaxNumber = (int) Math.ceil(((double) catBoardCount / getCommunityBoardCatCountReqDto.getCount()));

        return GetCommunityBoardCatCountResDto.builder()
                .catPageMaxNumber(catPageMaxNumber)
                .totalCount(catBoardCount)
                .build();
    }

    public  GetCommunityBoardMyPageCountResDto getMyBoardPageCount(GetCommunityBoardMyPageCountReqDto getCommunityBoardMyPageCountReqDto) {
        int myPageBoardCount = communityBoardMapper.getMyBoardPageCount();
        int myPageMaxNumber = (int) Math.ceil(((double) myPageBoardCount / getCommunityBoardMyPageCountReqDto.getCount()));

        return GetCommunityBoardMyPageCountResDto.builder()
                .myPageMaxNumber(myPageMaxNumber)
                .totalCount(myPageBoardCount)
                .build();
    }


    public List<GetCommunityBoardLikedByUserIdResDto> getFavoriteCommunityBoards(int userId) {
        List <CommunityBoard> communityBoards = communityBoardMapper.getFavoriteCommunityBoardsByUserId(userId);
        return communityBoards.stream().map(CommunityBoard::toGetCommunityBoardLikedByUserIdResDto).collect(Collectors.toList());
    }

    public List<GetCommunityBoardResponseDto> getCommunityBoardsDog() {
        List <CommunityBoard> communityBoards = communityBoardMapper.getCommunityBoardsDog();
        return communityBoards.stream().map(CommunityBoard::toGetCommunityBoardResponseDto).collect(Collectors.toList());
    }

    public List<GetCommunityBoardResponseDto> getCommunityBoardCat() {
        List <CommunityBoard> communityBoards = communityBoardMapper.getCommunityBoardCat();
        return  communityBoards.stream().map(CommunityBoard::toGetCommunityBoardResponseDto).collect(Collectors.toList());
    }

    // 게시물 해당BoardId로 단건 삭제 (Delete)
    public void deleteCommunityBoardByBoardId(int communityBoardId) {
        communityBoardMapper.deleteCommunityBoardByBoardId(communityBoardId);
    }

    // 게시물 다건 삭제 (Delete)
    public void deleteCommunityBoardsByBoardId(List<Integer> boardIds) {
        communityBoardMapper.deleteCommunityBoards(boardIds);
    }

    // 게시물 해당BoardId로 단건 수정 (Put)
    public void updateCommunityBoard (UpdateCommunityBoardRequestDto updateCommunityBoardRequestDto) {
        communityBoardMapper.updateCommunityBoard(updateCommunityBoardRequestDto.toEntity());
    }

}








