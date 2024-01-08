package com.refactor.rebuild.factory;

import com.refactor.rebuild.entity.Movie;
import com.refactor.rebuild.handler.BaseHandler;
import com.refactor.rebuild.handler.ChildrenMovieHandler;
import com.refactor.rebuild.handler.NewReleaseMovieHandler;
import com.refactor.rebuild.handler.RegularMovieHandler;

import java.lang.reflect.Modifier;

public class MovieFactory {
    public static BaseHandler getHandler(int priceCode) {
        if (priceCode == 0) {
            return new RegularMovieHandler();
        } else if (priceCode == 1) {
            return new NewReleaseMovieHandler();
        } else if (priceCode == 2) {
            return new ChildrenMovieHandler();
        } else {
            throw new IllegalArgumentException("price code " + priceCode + "not config");
        }
    }

    public static BaseHandler getHandlerReflect(Movie movie) {
        String handlerName = movie.getHandlerName();
        BaseHandler instance = null;
        try {
            Class<?> clazz = Class.forName(handlerName);
            if (clazz.isInterface() || Modifier.isAbstract(clazz.getModifiers())) {
                System.out.println("interface or abstract class can not be instantiation");
                return null;
            }
            instance = (BaseHandler) clazz.newInstance();
        } catch (ClassNotFoundException e) {
            System.out.println("Does not exists handler " + handlerName);
        } catch (InstantiationException e) {
            System.out.println("Instantiation handler " + handlerName + "failed");
        } catch (IllegalAccessException e) {
            System.out.println("Handler " + handlerName + "access failed");
        }
        return instance;
    }
}
