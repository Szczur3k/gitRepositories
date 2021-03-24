package pl.mateuszlukaszczyk.gitRepositories.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class Stargazers {
    List<Stargazers> stargazers;
    int id;
    String type;
}
