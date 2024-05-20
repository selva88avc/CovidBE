package com.stackroute.bookmarkservice.model;

import java.util.ArrayList;
import java.util.Collection;

public class CovidBookmarkList extends ArrayList<CovidBookmark> {
        public CovidBookmarkList(final Collection<? extends CovidBookmark> c) {
            super(c);
        }
    }