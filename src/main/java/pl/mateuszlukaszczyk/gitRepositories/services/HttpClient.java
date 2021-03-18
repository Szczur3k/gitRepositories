package pl.mateuszlukaszczyk.gitRepositories.services;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.mateuszlukaszczyk.gitRepositories.models.GitRepository;

@Component
public class HttpClient {
    public static final String HTTPS_API_GITHUB_COM_USERS = "https://api.github.com/users/";
    public static final String HTTPS_API_GITHUB_COM_REPOS = "https://api.github.com/repos/";
    RestTemplate restTemplate = new RestTemplate();

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

    public GitRepository getResponseFromOwnerChoosenRepo(String owner, String repositoryName) {
        GitRepository gitSingleRepositoryFromOwner = restTemplate.getForObject(HTTPS_API_GITHUB_COM_REPOS + "{owner}/{repositoryName}",
                GitRepository.class,
                owner,
                repositoryName);
        return GitRepository.builder()
                .fullName(gitSingleRepositoryFromOwner.getFullName())
                .description(gitSingleRepositoryFromOwner.getDescription())
                .cloneUrl(gitSingleRepositoryFromOwner.getCloneUrl())
                .createdAt(gitSingleRepositoryFromOwner.getCreatedAt())
                .stars(gitSingleRepositoryFromOwner.getStars())
                .build();
    }
}