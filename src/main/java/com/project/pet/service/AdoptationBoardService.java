package com.project.pet.service;

import com.project.pet.dto.adoptation.request.*;
import com.project.pet.dto.adoptation.response.*;
import com.project.pet.entity.adoptationBoard.AdoptationBoard;
import com.project.pet.repository.AdoptationBoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdoptationBoardService {

    @Autowired
    private AdoptationBoardMapper adoptationBoardMapper;

    //게시판 작성
    public void postAdoptationBoard(PostAdoptationBoardReqDto postAdoptationBoardReqDto) {
        adoptationBoardMapper.postAdoptationBoard(postAdoptationBoardReqDto.toEntity());
    }

    public List<GetTop3AdoptationBoardsResDto> getTop3AdoptationBoards() {
        List<AdoptationBoard> list = adoptationBoardMapper.getTop3AdoptationBoards();
        return list.stream().map(AdoptationBoard::toGetTop3AdoptationBoardsResDto).collect(Collectors.toList());
    }

    // 전체 분양 게시판 수 조회
    public GetAdoptationBoardCountRespDto getAdoptationBoardCount(GetAdoptationBoardCountReqDto getAdoptationBoardCountReqDto) {
        int adoptionBoardCount = adoptationBoardMapper.getAdoptationBoardCount(
                getAdoptationBoardCountReqDto.getBoardAnimalCategoryId(),
                getAdoptationBoardCountReqDto.getAdoptationBoardTitle()
        );
        int maxPageNumber = (int) Math.ceil(((double) adoptionBoardCount / getAdoptationBoardCountReqDto.getCount()));
        return GetAdoptationBoardCountRespDto.builder()
                .maxPageNumber(maxPageNumber)
                .totalCount(adoptionBoardCount)
                .build();
    }


    // 강아지 분양 게시판 수 조회
    public GetAdoptationBoardDogCountRespDto getAdoptationBoardDogCount(GetAdoptationBoardDogCountReqDto getAdoptationBoardDogCountReqDto) {
        int adoptionBoardCount = adoptationBoardMapper.getAdoptationBoardDogCount();
        int maxPageNumber = (int) Math.ceil(((double) adoptionBoardCount / getAdoptationBoardDogCountReqDto.getCount()));
        return GetAdoptationBoardDogCountRespDto.builder()
                .maxPageNumberDog(maxPageNumber)
                .totalCountDog(adoptionBoardCount)
                .build();
    }

    public GetAdoptationBoardCatCountRespDto getAdoptationBoardCatCount(GetAdoptationBoardCatCountReqDto getAdoptationBoardCatCountReqDto) {
        int adoptionBoardCount = adoptationBoardMapper.getAdoptationBoardCatCount();
        int maxPageNumber = (int) Math.ceil(((double) adoptionBoardCount / getAdoptationBoardCatCountReqDto.getCount()));
        return GetAdoptationBoardCatCountRespDto.builder()
                .maxPageNumberCat(maxPageNumber)
                .totalCountCat(adoptionBoardCount)
                .build();
    }

    //마이페이지 게시판 수 조회
    public GetAdoptationBoardUserCountRespDto getAdoptationBoardUserCount(GetAdoptationBoardUserCountReqDto getAdoptationBoardUserCountReqDto) {
        int adoptionBoardCount = adoptationBoardMapper.getAdoptationBoardUserCount(getAdoptationBoardUserCountReqDto.getUserId());
        int maxPageNumber = (int) Math.ceil(((double) adoptionBoardCount / getAdoptationBoardUserCountReqDto.getCount()));
        return GetAdoptationBoardUserCountRespDto.builder()
                .maxPageNumber(maxPageNumber)
                .totalCount(adoptionBoardCount)
                .build();
    }

    //전체 게시판 조회(다건)
    public List<GetAdoptationBoardRespDto> getAdoptationBoards(GetAdoptationBoardsRequestDto getAdoptationBoardsRequestDto) {
        int startIndex = (getAdoptationBoardsRequestDto.getPage() - 1) * getAdoptationBoardsRequestDto.getCount();
        List<AdoptationBoard> list = adoptationBoardMapper.getAdoptationBoards(
                startIndex,
                getAdoptationBoardsRequestDto.getCount(),
                getAdoptationBoardsRequestDto.getBoardAnimalCategoryId(),
                getAdoptationBoardsRequestDto.getAdoptationBoardTitle()
        );

        return list.stream().map(AdoptationBoard::toGetAdoptationBoardRespDto).collect(Collectors.toList());
    }

    public List<GetAdoptationBoardRespDto> getAdoptationBoardByUserId(int userId) {
        List<AdoptationBoard> adoptationBoards = adoptationBoardMapper.getAdoptationBoardByUserId(userId);
        return adoptationBoards.stream().map(AdoptationBoard::toGetAdoptationBoardRespDto).collect(Collectors.toList());
    }

    //해당 userId로 좋아요 한 게시물 조회
    public List<GetLikedAdoptationBoardByUserIdRespDto> getLikedAdoptationBoards(int userId) {
        List <AdoptationBoard> adoptationBoards = adoptationBoardMapper.getLikedAdoptationBoardByUserId(userId);
        return adoptationBoards.stream().map(AdoptationBoard::toGetLikedAdoptationBoardByUserIdRespDto).collect(Collectors.toList());
    }

    public List<GetAdoptationBoardRespDto> getAdoptationBoardsDog() {
        List <AdoptationBoard> adoptationBoards = adoptationBoardMapper.getAdoptationBoardsDog();
        return adoptationBoards.stream().map(AdoptationBoard::toGetAdoptationBoardRespDto).collect(Collectors.toList());
    }

    public List<GetAdoptationBoardRespDto> getAdoptationBoardsCat() {
        List <AdoptationBoard> adoptationBoards = adoptationBoardMapper.getAdoptationBoardsCat();
        return adoptationBoards.stream().map(AdoptationBoard::toGetAdoptationBoardRespDto).collect(Collectors.toList());
    }

    //id를 사용하여 해당 게시판 조회(단건)
    public GetAdoptationBoardRespDto getAdoptationBoardByBoardId(int boardId) {
        adoptationBoardMapper.setAdoptationBoardViewCountUp(boardId);
        AdoptationBoard adoptationBoard = adoptationBoardMapper.getAdoptationBoardByBoardId(boardId);
        return adoptationBoard.toGetAdoptationBoardRespDto();
    }

    //해당 게시판 단건 삭제
    public void deleteAdoptationBoardByBoardId(int boardId) {
        adoptationBoardMapper.deleteAdoptationBoardByBoardId(boardId);
    }

    //게시판 다건 삭제
    public void deleteAdoptationBoards (List<Integer> boardIds) {
        try {
            for (int boardId : boardIds) {
                deleteAdoptationBoardByBoardId(boardId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //해당 게시판 수정
    public void updateAdoptationBoard (UpdateAdoptationBoardReqDto updateAdoptationBoardReqDto) {
            adoptationBoardMapper.updateAdoptationBoard(updateAdoptationBoardReqDto.toEntity());
    }

    public void getAdoptationBoardMyPage (GetAdoptationBoardMyPageReqDto getAdoptationBoardMyPageReqDto) {
        int startIndex = (getAdoptationBoardMyPageReqDto.getPage() - 1) * getAdoptationBoardMyPageReqDto.getCount();
        List<AdoptationBoard> list = adoptationBoardMapper.getAdoptationBoardMyPage(
                startIndex,
                getAdoptationBoardMyPageReqDto.getCount(),
                getAdoptationBoardMyPageReqDto.getUserId()
        );
    }

}


