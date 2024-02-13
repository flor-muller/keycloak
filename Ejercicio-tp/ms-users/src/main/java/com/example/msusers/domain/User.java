package com.example.msusers.domain;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class User {
    private String id;
    private String username;
    private String email;
    private String name;
    private List<Bill> bills;

}
