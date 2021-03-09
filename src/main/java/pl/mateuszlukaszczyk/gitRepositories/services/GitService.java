package pl.mateuszlukaszczyk.gitRepositories.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import pl.mateuszlukaszczyk.gitRepositories.models.GitResponse;

@Service
@ComponentScan
public class GitService {

    @Autowired
    HttpClient httpClient;

    public String getHttpClientResponseFromOwnerRepository(String owner) {
        return httpClient.getResponseFromOwnerRepository(owner);
    }

    public GitResponse getGitResponseInEntity(String owner) {
        return JsonParser.parseResponseToGitResponse(httpClient.getResponseFromOwner(owner));
    }

    public GitResponse getApiDefunkt() {
        return JsonParser.parseResponseToGitResponse(httpClient.getDefunkt());
    }
}
