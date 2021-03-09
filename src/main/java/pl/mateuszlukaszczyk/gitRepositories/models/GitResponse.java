package pl.mateuszlukaszczyk.gitRepositories.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Builder
@Getter
@Setter
@NoArgsConstructor
@Component
public class GitResponse {

    String login;
    Integer id;
    String userURLGitHub;
    String userURLRepo;
    String createdAt;
    String updatedAt;

    public GitResponse(String login, Integer id, String userURLGitHub, String userURLRepo, String createdAt, String updatedAt) {
        this.login = login;
        this.id = id;
        this.userURLGitHub = userURLGitHub;
        this.userURLRepo = userURLRepo;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}