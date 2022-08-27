package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileReader {

    public Profile getDataFromFile(File file) {
        int b;

        Map<String, String> map = new HashMap<>();
        StringBuilder builder = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                builder.append(line + "\n");
            }

            String[] words = builder.toString().split("\n");
            for (String w : words) {
                System.out.println(w);
            }

            for (String w : words) {
                String[] keyValue = w.split(": ");
                map.put(keyValue[0], keyValue[1].trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Profile profile = new Profile();
        profile.setName(map.get("Name"));
        profile.setAge(Integer.parseInt(map.get("Age")));
        profile.setEmail(map.get("Email"));
        profile.setPhone(Long.parseLong(map.get("Phone")));

        return profile;
    }
}
