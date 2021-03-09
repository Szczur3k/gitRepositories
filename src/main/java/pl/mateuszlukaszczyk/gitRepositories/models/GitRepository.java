package pl.mateuszlukaszczyk.gitRepositories.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GitRepository {

    String fullName;
    String description;
    String cloneUrl;
    Integer stars;
    String createdAt;

}