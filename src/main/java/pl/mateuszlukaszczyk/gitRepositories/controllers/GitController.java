package pl.mateuszlukaszczyk.gitRepositories.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.mateuszlukaszczyk.gitRepositories.models.GitRepository;
import pl.mateuszlukaszczyk.gitRepositories.models.GitResponse;
import pl.mateuszlukaszczyk.gitRepositories.services.GitService;

import java.util.List;

@RestController
public class GitController {

    GitService gitService;

    public GitController(GitService gitService) {
        this.gitService = gitService;
    }

    @GetMapping("/")
    public String firstView() {
        return "Now I will start to writing an application";
    }

    @GetMapping("/repositories/{owner}")
    public GitResponse getApiGit(@PathVariable(value = "owner") String owner) {
        return gitService.getGitResponseInEntity(owner);
    }

    @GetMapping("/repositories/{owner}/repos")
    public List<GitRepository> getAllRepositoriesFromOwner(@PathVariable(value = "owner") String owner) {
        return gitService.getResponseFromOwnerRepoFromHttpClient(owner);
    }

    @GetMapping("/repositories/{owner}/{repository-name}")
    public GitRepository getChoosenRepositoryFromOwner(@PathVariable(value = "owner") String owner, @PathVariable(value = "repository-name") String repositoryName) {
        return gitService.getResponseFromOwnerChoosenRepositoryFromHttpClient(owner, repositoryName);
    }
}

/* GET/repositories/{owner}/{repository-name}

{
    "fullName:"...",
    "description:"...",
    "cloneUrl:"...",
    "stars:0,
    "createdAt:"..."
}


 */