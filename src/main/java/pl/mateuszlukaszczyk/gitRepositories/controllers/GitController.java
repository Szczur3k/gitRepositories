package pl.mateuszlukaszczyk.gitRepositories.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.mateuszlukaszczyk.gitRepositories.models.GitRepository;
import pl.mateuszlukaszczyk.gitRepositories.models.GitResponse;
import pl.mateuszlukaszczyk.gitRepositories.services.GitService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GitController {

    GitService gitService;
    ArrayList<String> list = new ArrayList<>();

    public GitController(GitService gitService) {
        this.gitService = gitService;
        list.add("Wybierz jedną z opcji ");
        list.add("Pokaż odpowiedź od użytkownika Defunkt - " + "/repositories/defunkt");
        list.add("Pokaż repozytorium 'ace' użytkownika Defunkt - " + "/repositories/defunkt/ace");
    }

    @GetMapping("/")
    public Object[] firstView() {
        return list.toArray();
    }

    @GetMapping("/repositories/{owner}")
    public GitResponse getApiGit(@PathVariable(value = "owner") String owner) {
        return gitService.getDataFromOwner(owner);
    }

    @GetMapping("/repositories/{owner}/repos")
    public List<GitRepository> getAllRepositoriesFromOwner(@PathVariable(value = "owner") String owner) {
        return gitService.getAllRepositoriesFromOwner(owner);
    }

    @GetMapping("/repositories/{owner}/{repository-name}")
    public GitRepository getChoosenRepositoryFromOwner(@PathVariable(value = "owner") String owner, @PathVariable(value = "repository-name") String repositoryName) {
        return gitService.getSingleRepositoryFromOwner(owner, repositoryName);
    }
}