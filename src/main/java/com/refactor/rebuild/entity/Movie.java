package com.refactor.rebuild.entity;

public enum Movie {

    REGULARE("regular movie", 0, "com.refactor.rebuild.handler.RegularMovieHandler"),
    NEWRELEASE("new movie", 1, "com.refactor.rebuild.handler.NewReleaseMovieHandler"),
    CHILDREN("children movie", 2, "com.refactor.rebuild.handler.ChildrenMovieHandler");

    private String _title;

    private int _priceCode;

    private String _handlerName;

    Movie(String title, int priceCode, String handlerName) {
        this._title = title;
        this._priceCode = priceCode;
        this._handlerName = handlerName;
    }

    public String getTitle() {
        return _title;
    }

    public int getPriceCode() {
        return _priceCode;
    }

    public String getHandlerName() {
        return _handlerName;
    }

    public static Movie getByValue(int priceCode) {
        for (Movie movie:values()) {
            if (movie.getPriceCode() == priceCode) {
                return movie;
            }
        }
        throw new IllegalArgumentException("Invalid price code: " + priceCode);
    }
}
