package com.stackroute.bookmarkservice.service;

import com.stackroute.bookmarkservice.model.CovidBookmark;
import com.stackroute.bookmarkservice.repository.CovidBookmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookmarkService {

    @Autowired
    CovidBookmarkRepository covidBookmarkRepository;

    public CovidBookmark saveBookmark(CovidBookmark covidBookmark, int userId) {
        covidBookmark.setUserId(userId);
        return covidBookmarkRepository.save(covidBookmark);
    }

    @Cacheable(cacheNames="covidCache", key="#userId")
    public List<CovidBookmark> getCovidBookmark(int userId) {
        return covidBookmarkRepository.findAllByUserId(userId);
    }

    public Boolean deleteCovidBookmark(int id) {
        covidBookmarkRepository.deleteById(id);
        return true;
    }
}
