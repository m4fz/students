package com.students.DTO;

import lombok.*;

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
