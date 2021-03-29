package com.softserve.itacademy.stage9.ex3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;

public class TestSuitHandler {
    public static void run(Class<?> clazz)
    {
        try
        {
            if (!clazz.isAnnotationPresent(TestSuite.class)) {
                throw new AnnotationNotFoundException("Class " + clazz.getSimpleName() + " isn't annotated");
            }
            List<String> methods = Arrays.asList(clazz.getDeclaredMethods()).stream()
                                                                    .filter(x -> x.getParameterCount() == 0)
                                                                    .filter(x -> Modifier.isPublic(x.getModifiers()))
                                                                    .filter(x -> !Modifier.isStatic(x.getModifiers()))
                                                                    .map(x -> x.getName())
                                                                    .collect(Collectors.toList());
            for (String arg : Arrays.asList(clazz.getAnnotation(TestSuite.class).value())) {
                if (!methods.contains(arg)) {
                    System.out.println(String.format("Method with name %s doesn't exists or not public in class %s",
                                                     arg, clazz.getSimpleName()));
                }
                else {
                    System.out.println(String.format("\t -- Method %s.%s started --", clazz.getSimpleName(), arg));
                    clazz.getMethod(arg).invoke(clazz.getDeclaredConstructor().newInstance());
                    System.out.println(String.format("\t -- Method %s.%s finished --", clazz.getSimpleName(), arg));
                }
            }
        }
        catch(AnnotationNotFoundException e) {
            System.out.println(e.getMessage());
        }
        catch(NoSuchMethodException e)
        {
            e.printStackTrace();
        }
        catch(IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch(InstantiationException e)
        {
            e.printStackTrace();
        }
        catch(InvocationTargetException e)
        {
            e.printStackTrace();
        }
    }
}

class AnnotationNotFoundException extends Throwable {
    public AnnotationNotFoundException(final String message)
    {
        super(message);
    }
}
