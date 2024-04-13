package com.students.DTO;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@ToString
@AllArgsConstructor
//making a DTO object
public class GameRequest {
    private String gameName;
    private Integer rating;
    private Integer price;
}
