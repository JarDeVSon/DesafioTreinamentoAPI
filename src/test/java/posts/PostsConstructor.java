package posts;

import com.google.gson.Gson;
import org.json.JSONObject;

import java.util.Objects;

public class PostsConstructor {

    private String title;
    private String body;

    public PostsConstructor(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostsConstructor that = (PostsConstructor) o;
        return Objects.equals(title, that.title) && Objects.equals(body, that.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, body);
    }

    public JSONObject getJson() {
        return new JSONObject(new Gson().toJson(this));
    }
}
