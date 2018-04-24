package com.rtukpe.fixtures.data.repository.mock;

import com.rtukpe.fixtures.data.model.Movie;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Observable;

public class MockHelper implements MockerInterface {

    @Inject
    MockHelper() {
    }

    @Override
    public Observable<ArrayList<Movie>> getMovies() {
        ArrayList<Movie> movies = new ArrayList<>();
        Movie.Builder builder = new Movie.Builder("1");


        builder
                .id("1")
                .type("epub")
                .src("https://github.com/FolioReader/FolioReader-Android/blob/master/sample/src/main/assets/TheSilverChair.epub")
                .isbn("978-1123-561")
                .language("en")
                .price(2000d)
                .title("A good book")
                .sample("A good book is a story of how book an be a great book")
        ;
        movies.add(builder.build());

        builder
                .id("2")
                .type("epub")
                .src("https://github.com/FolioReader/FolioReader-Android/blob/master/sample/src/main/assets/TheSilverChair.epub")
                .isbn("978-1123-561")
                .language("en")
                .price(2000d)
                .title("The Dark Tower")
                .sample("The famed gunslinger must stop the man in the suit to save the world.")
        ;
        movies.add(builder.build());


        builder
                .id("3")
                .type("audio")
                .src("https://github.com/FolioReader/FolioReader-Android/blob/master/sample/src/main/assets/TheSilverChair.epub")
                .isbn("978-1123-561")
                .language("en")
                .price(2000d)
                .title("Ravenclaw")
                .sample("A deep dive into the mind of Neville Longbottom")
        ;
        movies.add(builder.build());

        builder
                .id("4")
                .type("audio")
                .src("https://github.com/FolioReader/FolioReader-Android/blob/master/sample/src/main/assets/TheSilverChair.epub")
                .isbn("978-1123-561")
                .language("en")
                .price(2000d)
                .title("Children of Blood and Bone")
                .sample("Atanda leaves his home to find the lost necklace of Orunmila")
        ;
        movies.add(builder.build());

        builder
                .id("1")
                .type("epub")
                .src("https://github.com/FolioReader/FolioReader-Android/blob/master/sample/src/main/assets/TheSilverChair.epub")
                .isbn("978-1123-561")
                .language("en")
                .price(2000d)
                .title("A good book")
                .sample("A good book is a story of how book an be a great book")
        ;
        movies.add(builder.build());

        builder
                .id("2")
                .type("epub")
                .src("https://github.com/FolioReader/FolioReader-Android/blob/master/sample/src/main/assets/TheSilverChair.epub")
                .isbn("978-1123-561")
                .language("en")
                .price(2000d)
                .title("The Dark Tower")
                .sample("The famed gunslinger must stop the man in the suit to save the world.")
        ;
        movies.add(builder.build());


        builder
                .id("3")
                .type("audio")
                .src("https://github.com/FolioReader/FolioReader-Android/blob/master/sample/src/main/assets/TheSilverChair.epub")
                .isbn("978-1123-561")
                .language("en")
                .price(2000d)
                .title("Ravenclaw")
                .sample("A deep dive into the mind of Neville Longbottom")
        ;
        movies.add(builder.build());

        builder
                .id("4")
                .type("audio")
                .src("https://github.com/FolioReader/FolioReader-Android/blob/master/sample/src/main/assets/TheSilverChair.epub")
                .isbn("978-1123-561")
                .language("en")
                .price(2000d)
                .title("Children of Blood and Bone")
                .sample("Atanda leaves his home to find the lost necklace of Orunmila")
        ;
        movies.add(builder.build());

        builder
                .id("1")
                .type("epub")
                .src("https://github.com/FolioReader/FolioReader-Android/blob/master/sample/src/main/assets/TheSilverChair.epub")
                .isbn("978-1123-561")
                .language("en")
                .price(2000d)
                .title("A good book")
                .sample("A good book is a story of how book an be a great book")
        ;
        movies.add(builder.build());

        builder
                .id("2")
                .type("epub")
                .src("https://github.com/FolioReader/FolioReader-Android/blob/master/sample/src/main/assets/TheSilverChair.epub")
                .isbn("978-1123-561")
                .language("en")
                .price(2000d)
                .title("The Dark Tower")
                .sample("The famed gunslinger must stop the man in the suit to save the world.")
        ;
        movies.add(builder.build());


        builder
                .id("3")
                .type("audio")
                .src("https://github.com/FolioReader/FolioReader-Android/blob/master/sample/src/main/assets/TheSilverChair.epub")
                .isbn("978-1123-561")
                .language("en")
                .price(2000d)
                .title("Ravenclaw")
                .sample("A deep dive into the mind of Neville Longbottom")
        ;
        movies.add(builder.build());

        builder
                .id("4")
                .type("audio")
                .src("https://github.com/FolioReader/FolioReader-Android/blob/master/sample/src/main/assets/TheSilverChair.epub")
                .isbn("978-1123-561")
                .language("en")
                .price(2000d)
                .title("Children of Blood and Bone")
                .sample("Atanda leaves his home to find the lost necklace of Orunmila")
        ;
        movies.add(builder.build());

        return Observable.just(movies);
    }
}
