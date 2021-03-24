package pl.mateuszlukaszczyk.gitRepositories.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
public class GitOwner {

    String fullName;
    String description;
    String cloneUrl;
    Stargazers stars;
    Date createdAt;

}
