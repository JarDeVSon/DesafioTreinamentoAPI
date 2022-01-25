package posts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Objects;

@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostsLombok {


    private String title;
    private String body;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostsLombok that = (PostsLombok) o;
        return title.equals(that.title) && body.equals(that.body);
    }


}
