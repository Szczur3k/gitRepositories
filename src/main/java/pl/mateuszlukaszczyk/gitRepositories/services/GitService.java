package pl.mateuszlukaszczyk.gitRepositories.services;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.mateuszlukaszczyk.gitRepositories.models.GitResponse;

@Service
@ComponentScan
public class GitService {

    HttpClient httpClient;

    public String getHttpClientResponseFromOwnerRepository(String owner, String repositoryName) {
        return httpClient.getResponseFromOwnerRepository(owner, repositoryName);
    }

    public ResponseEntity<GitResponse> getGitResponseInEntity(String owner) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(JsonParser.parse(httpClient.getResponseFromOwner(owner)));
    }
}
