package com.example.springboot.domain.posts;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.springboot.domain.posts.QAcademy.academy;

@Repository
public class AcademyReposityrSupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    public AcademyReposityrSupport(JPAQueryFactory jpaQueryFactory) {
        super(Academy.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public List<Academy> findByName(String name) {
        return jpaQueryFactory.selectFrom(academy)
                .where(academy.name.eq(name))
                .fetch();
    }

}
