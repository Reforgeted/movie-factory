package com.refactor.rebuild;

import com.refactor.rebuild.entity.Movie;
import com.refactor.rebuild.factory.MovieFactory;
import com.refactor.rebuild.handler.BaseHandler;
import com.refactor.rebuild.vo.RentalVo;

import java.util.Vector;

public class Customer {
    public String statement(RentalVo rentalVo) {
        if (rentalVo == null || rentalVo.getRentals() == null) {
            return "";
        }

        Vector<RentalVo.RentalInfo> rentals = rentalVo.getRentals();
        double total = 0D;
        int frequentRenterPoints = 0;

        String result = "Rental Record for " + rentalVo.getName() + "\n";
        String table = "";
        for (RentalVo.RentalInfo rentalInfo : rentals) {
            if (rentalInfo.getRentDay() == 0){
                continue;
            }

            Movie movie = Movie.getByValue(rentalInfo.getMovieCode());
            BaseHandler handler = MovieFactory.getHandler(rentalInfo.getMovieCode());
            // BaseHandler handler = MovieFactory.getHandlerReflect(movie);
            double curAmount = handler.getTotalAmount(rentalInfo);
            frequentRenterPoints += handler.getFrequentPoints(rentalInfo);
            result += "\t" + movie.getTitle() + "\t" + curAmount + "\n";
            table += "<tr>\n" + "<td>" + movie.getTitle() + "</td>\n" + "<td>" + curAmount + "</td>\n" + "<tr>\n";
            total += curAmount;
        }

        result += "Amount owed is " + total + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points";
        return result;
    }

    public static String buildHtml(String name, String tables, double totalAmount, int frequentPoints) {
        String html = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n" +
                "<p>Rental Record for " + name + "</p>\n" +
                "<table>\n" +
                "<thead>\n" +
                "<tr>\n" +
                "<th>Movie title</th>\n" +
                "<th>Price</th>\n" +
                "</tr>\n" +
                "</thead>\n" +
                "<tbody>\n" +
                tables +
                "</tbody>\n" +
                "</table>\n" +
                "<p>Amount owed is " + totalAmount + "</p>\n" +
                "<p>You earned " + frequentPoints + " frequent renter points</p>\n" +
                "</body>\n" +
                "</html>";
        return html;
    }
}
