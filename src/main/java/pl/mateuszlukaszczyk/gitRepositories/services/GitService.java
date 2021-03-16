package pl.mateuszlukaszczyk.gitRepositories.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import pl.mateuszlukaszczyk.gitRepositories.WebClient.HttpClient;
import pl.mateuszlukaszczyk.gitRepositories.models.GitRepository;
import pl.mateuszlukaszczyk.gitRepositories.models.GitResponse;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GitService {

    @Autowired
    final HttpClient httpClient;

    public List<GitRepository> getResponseFromOwnerRepoFromHttpClient(String owner) {
        return JsonParser.parseResponseToGitRepositoryFromArray(httpClient.getResponseFromOwnerAllRepositories(owner));
    }

    public GitResponse getGitResponseInEntity(String owner) {
        return JsonParser.parseResponseToGitResponse(httpClient.getResponseFromOwner(owner));
    }

    public GitRepository getResponseFromOwnerChoosenRepositoryFromHttpClient(String owner, String repositoryName) {
        return JsonParser.parseResponseToGitRepoitory(httpClient.getResponseFromOwnerChoosenRepo(owner, repositoryName));
    }
}
