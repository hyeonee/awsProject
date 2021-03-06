package com.example.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AcademyReposityrSupportTest {

    @Autowired
    private AcademyRepository academyRepository;

    @Autowired
    private AcademyReposityrSupport academyReposityrSupport;

    @After
    public void tearDown() throws Exception {
        academyRepository.deleteAllInBatch();
    }

    @Test
    public void querydsl_기본확인() {
        //given
        String name = "gh";
        String address = "gh@gmail.com";
        academyRepository.save(new Academy(name, address));

        //when
        List<Academy> result = academyReposityrSupport.findByName(name);

        //then
        assertThat(result.size(), is(1));
        assertThat(result.get(0).getAddress(), is(address));

    }

    @Test
    public void querydsl_기본확인2() {
        //given
        String name = "gh";
        String address = "gh@gmail.com";
        academyRepository.save(new Academy(name, address));

        //when
        List<Academy> result = academyRepository.findByName(name);

        //then
        assertThat(result.size(), is(1));
        assertThat(result.get(0).getAddress(), is(address));

    }
}
