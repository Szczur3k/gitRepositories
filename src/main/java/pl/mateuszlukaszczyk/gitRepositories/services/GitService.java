package pl.mateuszlukaszczyk.gitRepositories.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import pl.mateuszlukaszczyk.gitRepositories.models.GitRepository;
import pl.mateuszlukaszczyk.gitRepositories.models.GitResponse;

import java.util.List;

@Service
@ComponentScan
public class GitService {

    @Autowired
    HttpClient httpClient;

    public List<GitRepository> getAllRepositoriesFromOwner(String owner) {
        return JsonParser.parseResponseToGitRepositoryFromArray(httpClient.getResponseFromOwnerAllRepositories(owner));
    }

    public GitResponse getDataFromOwner(String owner) {
        return JsonParser.parseResponseToGitResponse(httpClient.getResponseFromOwner(owner));
    }

    public GitRepository getSingleRepositoryFromOwner(String owner, String repositoryName) {
        return httpClient.getResponseFromOwnerChoosenRepo(owner, repositoryName);
//        return JsonParser.parseResponseToGitRepoitory(httpClient.getResponseFromOwnerChoosenRepo(owner, repositoryName));
    }
}
