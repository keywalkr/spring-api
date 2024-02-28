package com.qburry.kubesspring.springapi.store.dto;

import com.qburry.kubesspring.springapi.user.dto.User;
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
