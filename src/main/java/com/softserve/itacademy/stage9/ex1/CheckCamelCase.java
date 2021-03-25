package com.softserve.itacademy.stage9.ex1;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CheckCamelCase {
    public static final String CAMELCASE_PATTERN = "([a-z][a-z0-9]+[A-Z]?)+";

    public static boolean checkAndPrint(Class clazz) {
        List<Method> methods =
        Arrays.stream(clazz.getMethods())
                .filter(x -> x.isAnnotationPresent(CamelCase.class))
                .filter(x -> !x.getName().matches(CAMELCASE_PATTERN))
                .collect(Collectors.toList());
        methods.forEach(x -> System.out.println("method " + clazz.getSimpleName() + "." +
                                                        x.getName() + " doesn't satisfy camelCase naming convention"));
        return methods.size() == 0;
    }
}
