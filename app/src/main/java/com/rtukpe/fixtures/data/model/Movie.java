package com.rtukpe.fixtures.data.model;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class Movie {

    @SerializedName("_id")
    private String _id;
    private String src;
    private String isbn;
    private String type;
    private Double price;
    private String title;
    private String sample;
    private String language;

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

    public static final class Builder {
        private String _id;
        private String src;
        private String isbn;
        private String type;
        private Double price;
        private String title;
        private String sample;
        private String language;

        public Builder(String id) {
            this._id = id;
        }

        public Movie build() {
            Movie movie = new Movie();

            movie.src = src;
            movie._id = _id;
            movie.type = type;
            movie.isbn = isbn;
            movie.price = price;
            movie.title = title;
            movie.sample = sample;
            movie.language = language;

            return movie;
        }

        public Movie.Builder id(@NonNull String id) {
            this._id = id;
            return this;
        }

        public Movie.Builder language(@NonNull String language) {
            this.language = language;
            return this;
        }

        public Movie.Builder sample(@NonNull String sample) {
            this.sample = sample;
            return this;
        }

        public Movie.Builder title(@NonNull String title) {
            this.title = title;
            return this;
        }

        public Movie.Builder price(@NonNull Double price) {
            this.price = price;
            return this;
        }

        public Movie.Builder type(@NonNull String type) {
            this.type = type;
            return this;
        }

        public Movie.Builder src(@NonNull String src) {
            this.src = src;
            return this;
        }

        public Movie.Builder isbn(@NonNull String isbn) {
            this.isbn = isbn;
            return this;
        }
    }
}
