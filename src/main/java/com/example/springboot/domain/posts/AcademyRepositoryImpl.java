package com.example.springboot.domain.posts;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.springboot.domain.posts.QAcademy.academy;

@RequiredArgsConstructor
public class AcademyRepositoryImpl implements AcademyRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<Academy> findByName(String name) {
        return jpaQueryFactory.selectFrom(academy)
                .where(academy.name.eq(name))
                .fetch();
    }
}
