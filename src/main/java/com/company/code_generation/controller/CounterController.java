package com.company.code_generation.controller;

import com.company.code_generation.model.CounterDto;
import com.company.code_generation.service.CounterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/counter")
public class CounterController {

    private final CounterService counterService;

    @GetMapping
    public CounterDto getCode() {
        return counterService.getCode();
    }
}
