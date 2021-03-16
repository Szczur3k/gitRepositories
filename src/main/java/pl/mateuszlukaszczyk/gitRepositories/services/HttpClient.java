package pl.mateuszlukaszczyk.gitRepositories.services;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URL;

@Component
public class HttpClient {
    public static final String HTTPS_API_GITHUB_COM_USERS = "https://api.github.com/users/";
    public static final String HTTPS_API_GITHUB_COM_REPOS = "https://api.github.com/repos/";
    RestTemplate restTemplate = new RestTemplate();
    URL url = null;

    public String getResponseFromOwnerAllRepositories(String owner) {
        return restTemplate
                .getForObject(HTTPS_API_GITHUB_COM_USERS + "{owner}/repos",
                        String.class,
                        owner);
    }

    public String getResponseFromOwner(String owner) {
        return restTemplate.getForObject(HTTPS_API_GITHUB_COM_USERS + "{owner}",
                String.class,
                owner);
    }

    public String getResponseFromOwnerChoosenRepo(String owner, String repositoryName) {
        return restTemplate.getForObject(HTTPS_API_GITHUB_COM_REPOS + "{owner}/{repositoryName}",
                String.class,
                owner,
                repositoryName);
    }
}