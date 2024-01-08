package com.refactor.rebuild.handler;

import com.refactor.rebuild.entity.BaseUnit;
import com.refactor.rebuild.vo.RentalVo;

public class NewReleaseMovieHandler extends BaseUnit implements BaseHandler {
    static {
        extraDayBase = 3;

        eranPoint = 1;
    }

    @Override
    public double getTotalAmount(RentalVo.RentalInfo rentalInfo) {
        return rentalInfo.getRentDay() * extraDayBase;
    }

    @Override
    public int getFrequentPoints(RentalVo.RentalInfo rentalInfo) {
        int frequentPoint = eranPoint;
        if (rentalInfo.getRentDay() > 1){
            frequentPoint++;
        }
        return frequentPoint;
    }
}
