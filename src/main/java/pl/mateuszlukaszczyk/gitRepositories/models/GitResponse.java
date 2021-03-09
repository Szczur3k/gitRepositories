package pl.mateuszlukaszczyk.gitRepositories.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class GitResponse {

    String login;
    Integer id;
    String userURLGitHub;
    String userURLRepo;
    String createdAt;
    String updatedAt;
}