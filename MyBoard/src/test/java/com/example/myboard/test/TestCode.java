package com.example.myboard.test;

import com.example.myboard.entity.Test;
import com.example.myboard.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class TestCode {
    @Autowired
    private TestRepository testRepository;

    @org.junit.jupiter.api.Test
    public void findByTest(){
        // given
        Test test = new Test();
        test.setTest(1);

        // when
        Test saved = testRepository.save(test);

        // then
        assertThat(saved.getTest()).isGreaterThan(0); // ID가 생성되었는지 확인
    }
}
