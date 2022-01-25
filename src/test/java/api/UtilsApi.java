package api;

import io.restassured.response.Response;
import org.json.JSONObject;
import utils.LogUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class UtilsApi extends LogUtils {

    protected Response response;
    protected JSONObject body;
    protected String uri;
    protected Map<String, String> headers = new HashMap<>();
    protected Map<String, String> params = new HashMap<>();
    protected String token;

    public void log(String verbo){
        super.logInfo("*** Dados enviados na Request ***");
        super.logInfo(verbo + " " + uri);
        super.logInfo("Body \n" + body);
        super.logInfo("Headers: " + headers);
        super.logInfo("Params : " + params);

        super.logInfo("*** Dados recebidos como Response ***");
        super.logInfo("Status code: " + response.statusCode());
        super.logInfo("Payload recebido: \n" + response.asPrettyString());
        super.logInfo("Tempo de resposta em ms: " + response.timeIn(TimeUnit.MILLISECONDS));
    }
}
