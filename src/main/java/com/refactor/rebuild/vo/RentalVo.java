package com.refactor.rebuild.vo;

import java.util.Vector;

public class RentalVo {
    private String name;

    private Vector<RentalInfo> rentals;

    public String getName() {
        return name;
    }

    public Vector<RentalInfo> getRentals() {
        return rentals;
    }

    public class RentalInfo {
        private int movieCode;

        private int rentDay;

        public int getRentDay() {
            return rentDay;
        }

        public int getMovieCode() {
            return movieCode;
        }
    }
}
