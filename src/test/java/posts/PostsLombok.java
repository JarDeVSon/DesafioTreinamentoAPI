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



}
