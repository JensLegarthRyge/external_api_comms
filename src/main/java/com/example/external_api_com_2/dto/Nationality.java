package com.example.external_api_com_2.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class Nationality {
    public ArrayList<Country> country;
    public String name;
}
