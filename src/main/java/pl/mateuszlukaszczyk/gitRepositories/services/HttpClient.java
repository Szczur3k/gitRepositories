package pl.mateuszlukaszczyk.gitRepositories.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.mateuszlukaszczyk.gitRepositories.models.GitOwner;
import pl.mateuszlukaszczyk.gitRepositories.services.dto.GitOwnerMapper;

@Component
public class HttpClient {
    public static final String HTTPS_API_GITHUB_COM_USERS = "https://api.github.com/users/";
    public static final String HTTPS_API_GITHUB_COM_REPOS = "https://api.github.com/repos/";
    RestTemplate restTemplate = new RestTemplate();
    GitOwnerMapper gitOwnerMapper = new GitOwnerMapper();

    public GitOwner getResponseFromOwner(String owner) {
        String restTemplate = getRestTemplate(HTTPS_API_GITHUB_COM_USERS, "{owner}", owner);
        return gitOwnerMapper.map(restTemplate);
    }

    public GitOwner getResponseFromOwnerChoosenRepo(String owner, String repositoryName) {
        String restTemplateResponse = getRestTemplate(HTTPS_API_GITHUB_COM_REPOS, "{owner}/{repositoryName}", owner, repositoryName);
        GitOwnerMapper gitOwnerMapper = new GitOwnerMapper();
        return gitOwnerMapper.map(restTemplateResponse);
    }

    public GitOwner getResponseFromOwnerAllRepositories(String owner) {
        String restTemplateResponse = getRestTemplate(HTTPS_API_GITHUB_COM_USERS, "{owner}/repos", owner);
        GitOwner objectReader = null;
        return objectReader;
    }

    private String getRestTemplate(String finalUrl, String s, Object... objects) {
        return restTemplate.getForObject(finalUrl + s,
                String.class,
                objects);
    }
}