package com.example.springboot.domain.posts;

import java.util.List;

public interface AcademyRepositoryCustom {
    List<Academy> findByName(String name);
}
