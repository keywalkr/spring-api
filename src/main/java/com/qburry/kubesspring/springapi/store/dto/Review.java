package com.qburry.kubesspring.springapi.store.dto;

import com.qburry.kubesspring.springapi.user.dto.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    private Long id;
    private Integer rating;
    private String comment;
    private Product product;
    private User user;
}
