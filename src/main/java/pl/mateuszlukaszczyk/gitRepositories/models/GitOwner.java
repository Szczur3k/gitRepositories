package pl.mateuszlukaszczyk.gitRepositories.models;

import lombok.*;

import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
public class GitOwner {

    String fullName;
    String description;
    String cloneUrl;
    int stars;
    Date createdAt;

}
