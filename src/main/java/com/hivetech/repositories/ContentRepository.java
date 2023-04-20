package com.hivetech.repositories;


import com.hivetech.entities.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {

//    List<Content> findBy(String title);
}
