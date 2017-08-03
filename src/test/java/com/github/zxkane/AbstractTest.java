package com.github.zxkane;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class AbstractTest {

    public static File getResource(String name) {
        ClassLoader classLoader = AbstractTest.class.getClassLoader();
        File file = new File(classLoader.getResource(name).getFile());
        return file;
    }

    public static InputStream getResourceInput(String path) throws IOException {
        ClassLoader classLoader = AbstractTest.class.getClassLoader();
        return classLoader.getResource(path).openStream();
    }

}
