package com.softserve.itacademy.stage5.ex2;

import java.util.Arrays;

public class Plant {
    private String name;
    private Color color;
    private Type type;

    public Plant(final String type, final String color, final String name) throws ColorException, TypeException
    {
        boolean isTypeExist = false;
        boolean isColorExist = false;

        for (Type t : Arrays.asList(Type.values())) {
            if (type != null && t.toString().toUpperCase().equals(type.toUpperCase())) isTypeExist = true;
        }

        for (Color c : Arrays.asList(Color.values())) {
            if (color != null && c.toString().toUpperCase().equals(color.toUpperCase())) isColorExist = true;
        }

        try
        {
            this.type = Type.valueOf(type.toUpperCase());
            this.color = Color.valueOf(color.toUpperCase());
            this.name = name;
        }
        catch(IllegalArgumentException e) {
            if (!isTypeExist) throw new TypeException(String.format("Invalid value %s for field type", type));
            if (!isColorExist) throw new ColorException(String.format("Invalid value %s for field color", color));
        }

    }

    static Plant tryCreatePlant(String type, String color, final String name) {

        Plant plant = null;
        try
        {
            plant = new Plant(type, color, name);
        }
        catch(TypeException e)
        {
            type = Type.ORDINARY.toString();
            plant = tryCreatePlant(type, color, name);
        }
        catch(ColorException e)
        {
            color = Color.RED.toString();
            plant = tryCreatePlant(type, color, name);
        }

        return plant;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString()
    {
        return "{type: " + type + ", color: " + color + ", name: " + name + "}";
    }
}
