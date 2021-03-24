package pl.mateuszlukaszczyk.gitRepositories.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import pl.mateuszlukaszczyk.gitRepositories.models.GitOwner;

@Service
@ComponentScan
public class GitService {

    @Autowired
    HttpClient httpClient;

    public GitOwner getAllRepositoriesFromOwner(String owner) {
        return httpClient.getResponseFromOwnerAllRepositories(owner);
    }

    public GitOwner getDataFromOwner(String owner) throws JsonProcessingException {
        return httpClient.getResponseFromOwner(owner);
    }

    public GitOwner getSingleRepositoryFromOwner(String owner, String repositoryName) {
        return httpClient.getResponseFromOwnerChoosenRepo(owner, repositoryName);
    }
}
