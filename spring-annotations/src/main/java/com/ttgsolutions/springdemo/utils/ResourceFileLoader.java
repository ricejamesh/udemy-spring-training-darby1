package com.ttgsolutions.springdemo.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ResourceFileLoader {

    public static String[] getResource(String rsc) {
        ArrayList<String> myList = new ArrayList<String>();

        try {
            Class cls = ResourceFileLoader.class;

            // returns the ClassLoader object associated with this Class
            ClassLoader cLoader = cls.getClassLoader();

            // input stream
            InputStream i = cLoader.getResourceAsStream(rsc);
            BufferedReader r = new BufferedReader(new InputStreamReader(i));

            // reads each line
            String l;
            while((l = r.readLine()) != null) {
                myList.add(l);
            }
            i.close();
        } catch(Exception e) {
            System.out.println(e);
        }
        return myList.toArray(new String[0]);
    }
}
