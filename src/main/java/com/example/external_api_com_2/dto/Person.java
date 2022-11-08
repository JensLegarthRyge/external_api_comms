package com.example.external_api_com_2.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@NoArgsConstructor
public class Person {
    public String name;
    public String gender;
    public double genderProbability;
    public int age;
    public int ageCount;
    public String country;
    public double countryProbability;

    public void setGenderProbability(double probability){
        genderProbability = probability*100;
    }

    public void setCountryProbability(double probability){
        countryProbability = probability*100;
    }
}
