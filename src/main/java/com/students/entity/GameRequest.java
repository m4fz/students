package com.students.entity;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class GameRequest {
    private String gameName;
    private Integer rating;
    private Integer price;
}
