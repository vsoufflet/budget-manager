package project.budget.utils;

import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class ResourceUtils {

    public static String getContent(Resource resource) throws IOException {
        try (BufferedReader reader = new BufferedReader((new InputStreamReader(resource.getInputStream())))) {
            String body = reader.lines().collect(Collectors.joining("\n"));
            return body;
        }
    }
}
