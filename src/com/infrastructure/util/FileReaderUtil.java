package com.infrastructure.util;

import com.infrastructure.ProjectConfig;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReaderUtil {
    public FileReaderUtil() {
    }

    public static String getTextFromResourceFile(String fileName) {
        String filePath = Paths.get(ProjectConfig.getResourceDir() + File.separator + fileName).toString();
        String res = "";

        try {
            res = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException var4) {
            var4.printStackTrace();
        }

        return res.replaceAll("\\p{C}", "");
    }
}
