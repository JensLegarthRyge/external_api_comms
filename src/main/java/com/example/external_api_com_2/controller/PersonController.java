package com.example.external_api_com_2.controller;

import com.example.external_api_com_2.dto.Age;
import com.example.external_api_com_2.dto.Gender;
import com.example.external_api_com_2.dto.Nationality;
import com.example.external_api_com_2.dto.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class PersonController {

    @RequestMapping("/person-info")
    public Person getDetails(@RequestParam String name){
        WebClient client = WebClient.create();

        Mono<Age> age = client.get()
                .uri("https://api.agify.io?name="+name)
                .retrieve()
                .bodyToMono(Age.class);
        Mono<Gender> gender = client.get()
                .uri("https://api.genderize.io?name="+name)
                .retrieve()
                .bodyToMono(Gender.class);
        Mono<Nationality> nationality = client.get()
                .uri("https://api.nationalize.io?name="+name)
                .retrieve()
                .bodyToMono(Nationality.class);

        var res = Mono.zip(age, gender, nationality).map(t -> {
            Person p = new Person();
            p.setAge(t.getT1().getAge());
            p.setAgeCount(t.getT1().getCount());

            p.setGender(t.getT2().getGender());
            p.setGenderProbability(t.getT2().getProbability());

            p.setCountry(t.getT3().getCountry().get(0).getCountry_id());
            p.setCountryProbability(t.getT3().getCountry().get(0).getProbability());

            p.setName(name);
            return p;
        });
        return res.block();
    }
}
