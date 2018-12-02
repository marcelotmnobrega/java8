package com.pluralsight.generics;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class PersonLoader {

    private final RandomAccessFile file;

    public PersonLoader(final File file) throws FileNotFoundException {
        this.file = new RandomAccessFile(file, "rw");
    }

    public Person load() throws ClassNotFoundException {

        try
        {
            String clazzName = this.file.readUTF();
            String name = this.file.readUTF();
            int age = this.file.readInt();

            final Class<?> personClass = Class.forName(clazzName);
            final Constructor<?> constructor = personClass.getConstructor(String.class, int.class);
            return (Person) constructor.newInstance(name, age);
        }
        catch(IOException e)
        {
            return null;
        }
        catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
