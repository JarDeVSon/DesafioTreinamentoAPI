package api;

import java.util.HashMap;
import java.util.Map;

public class HeadersApi {

    Map<String, String> headers = new HashMap<>();

    public Map<String, String> jsonPlaceHolderHeaders(){

        headers.put("Content-Type", "application/json");

        return headers;
    }
}
