package com.example.external_api_com_2.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Gender {
    int count;
    String gender;
    String name;
    double probability;
}
