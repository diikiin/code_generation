package com.company.code_generation.service.impl;

import com.company.code_generation.entity.Counter;
import com.company.code_generation.repository.CounterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CounterServiceImplTest {
    @Mock
    CounterRepository counterRepository;
    @InjectMocks
    CounterServiceImpl counterServiceImpl;

    @Test
    void getCode_a0a9() {
        // given
        when(counterRepository.findTopByOrderByIdDesc()).thenReturn(new Counter("a0a9"));

        // when
        String result = counterServiceImpl.getCode();

        // then
        Assertions.assertEquals("a0b0", result);
    }

    @Test
    void getCode_a0z9() {
        // given
        when(counterRepository.findTopByOrderByIdDesc()).thenReturn(new Counter("a0z9"));

        // when
        String result = counterServiceImpl.getCode();

        // then
        Assertions.assertEquals("a1a0", result);
    }

    @Test
    void getCode_a9z9() {
        // given
        when(counterRepository.findTopByOrderByIdDesc()).thenReturn(new Counter("a9z9"));

        // when
        String result = counterServiceImpl.getCode();

        // then
        Assertions.assertEquals("b0a0", result);
    }

    @Test
    void getCode_z9z9() {
        // given
        when(counterRepository.findTopByOrderByIdDesc()).thenReturn(new Counter("z9z9"));

        // when
        String result = counterServiceImpl.getCode();

        // then
        Assertions.assertEquals("a0a0a0", result);
    }
}
