package pl.mateuszlukaszczyk.gitRepositories.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.mateuszlukaszczyk.gitRepositories.models.GitResponse;
import pl.mateuszlukaszczyk.gitRepositories.services.GitService;

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

    @GetMapping("/repositories/{owner}/repos")
    public String getApiGit(@PathVariable(value = "owner") String owner){
        return gitService.getHttpClientResponseFromOwnerRepository(owner);
    }

    @GetMapping("/repositories/{owner}/")
    public GitResponse getApiGitResponse(@PathVariable(value = "owner") String owner) {
        return gitService.getGitResponseInEntity(owner);

    }

    @GetMapping("/repositories")
    public GitResponse getApiFromOwnerDefunkt() {
        return gitService.getApiDefunkt();

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