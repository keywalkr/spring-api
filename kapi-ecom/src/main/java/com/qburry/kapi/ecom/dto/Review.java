package com.qburry.kapi.ecom.dto;

import com.qburry.kapi.user.dto.User;
import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    private Long id;
    private Integer rating;
    private String comment;
    private Product product;
    private User user;
}
