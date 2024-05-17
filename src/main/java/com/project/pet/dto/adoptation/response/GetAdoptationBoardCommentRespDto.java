package com.project.pet.dto.adoptation.response;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class GetAdoptationBoardCommentRespDto {
    private int adoptationBoardId;
    private int adoptationBoardCommentId;
    private int userId;
    private String username;
    private String userNickname;
    private String adoptationBoardCommentContent;
    private LocalDate createDate;
    private LocalDate updateDate;

}
