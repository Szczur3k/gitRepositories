package pl.mateuszlukaszczyk.gitRepositories.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import pl.mateuszlukaszczyk.gitRepositories.models.GitRepository;
import pl.mateuszlukaszczyk.gitRepositories.models.GitResponse;

@Service
@ComponentScan
public class GitService {

    @Autowired
    HttpClient httpClient;

    public GitRepository getResponseFromOwnerRepoFromHttpClient(String owner) {
        return JsonParser.parseResponseToGitRepositoryFromArray(httpClient.getResponseFromOwnerAllRepositories(owner));
    }

    public GitResponse getGitResponseInEntity(String owner) {
        return JsonParser.parseResponseToGitResponse(httpClient.getResponseFromOwner(owner));
    }

    public GitRepository getResponseFromOwnerChoosenRepositoryFromHttpClient(String owner, String repositoryName) {
        return JsonParser.parseResponseToGitRepoitory(httpClient.getResponseFromOwnerChoosenRepo(owner, repositoryName));
    }
}
