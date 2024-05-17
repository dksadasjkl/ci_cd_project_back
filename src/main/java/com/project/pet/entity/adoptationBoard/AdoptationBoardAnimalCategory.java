package com.project.pet.entity.adoptationBoard;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AdoptationBoardAnimalCategory {

    private int boardAnimalCategoryId;
    private String boardAnimalCategoryName;
    private String boardAnimalCategoryNameKor;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

}
