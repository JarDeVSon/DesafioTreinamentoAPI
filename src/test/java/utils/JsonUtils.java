package utils;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonUtils {

    public JSONObject parseJSONFILE(String json) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get("src/test/resources/jsons/"+json+".json")));
        return new JSONObject(content);
    }
}
