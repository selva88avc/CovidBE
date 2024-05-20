package com.stackroute.bookmarkservice.controller;

import com.stackroute.bookmarkservice.model.CovidBookmark;
import com.stackroute.bookmarkservice.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookmark")
public class BookmarkServiceController {
    @Autowired
    BookmarkService bookmarkService;

    @PostMapping("/save")
    public ResponseEntity<CovidBookmark> saveProduct(@RequestBody CovidBookmark covidBookmark, @RequestHeader Integer id){
        CovidBookmark savedCovidBookmark=bookmarkService.saveBookmark(covidBookmark,id);
        return new ResponseEntity<>(savedCovidBookmark, HttpStatus.OK);
    }
    @GetMapping("/view")
    public ResponseEntity<List<CovidBookmark>> getBookmarks(@RequestHeader int id){
        List<CovidBookmark> bookmarks = bookmarkService.getCovidBookmark(id);
        return new ResponseEntity<>(bookmarks, HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteBookmark(@RequestParam int id){
        bookmarkService.deleteCovidBookmark(id);
        return new ResponseEntity<>("Succeefully Deleted", HttpStatus.OK);
    }
}