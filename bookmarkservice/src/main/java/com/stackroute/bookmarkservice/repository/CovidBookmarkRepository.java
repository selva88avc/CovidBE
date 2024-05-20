package com.stackroute.bookmarkservice.repository;

import com.stackroute.bookmarkservice.model.CovidBookmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CovidBookmarkRepository extends JpaRepository<CovidBookmark,Integer> {
    List<CovidBookmark> findAllByUserId(int userId);
}
