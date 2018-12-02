package com.pluralsight.generics;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class PersonSaver {

    private final RandomAccessFile file;

    public PersonSaver(final File file) throws FileNotFoundException {
        this.file = new RandomAccessFile(file, "rw");
    }

    public void save(Person person) throws IOException
    {
        this.file.writeUTF(person.getClass().getName());
        this.file.writeUTF(person.getName());
        this.file.writeInt(person.getAge());
    }
}
