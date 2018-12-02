package com.pluralsight.generics;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.File;

public class PersonStorageTest {

    private Partner donDraper = new Partner("Don Draper", 89);
    private Partner bertCooper = new Partner("Bert Cooper", 100);
    private Employee peggyOlson = new Employee("Peggy Olson", 65);

    private File file;
    private PersonSaver saver;
    private PersonLoader loader;

    @Before
    public void setUp() throws Exception
    {
        file = File.createTempFile("tmp", "people");
        saver = new PersonSaver(file);
        loader = new PersonLoader(file);
    }

    @After
    public void tearDown()
    {
        if (this.file.exists())
            this.file.delete();
    }

    @Test
    public void savesAndLoadsPerson() throws Exception
    {
        Person person = new Person("Bob", 20);
        saver.save(person);

        assertEquals(person, loader.load());
    }
}
