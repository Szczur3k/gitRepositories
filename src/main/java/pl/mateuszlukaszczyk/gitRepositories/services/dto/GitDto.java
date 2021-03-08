package pl.mateuszlukaszczyk.gitRepositories.services.dto;

import java.net.HttpURLConnection;
import java.time.LocalDate;
import java.util.UUID;

public class GitDto {

    String login;
    UUID id;
    HttpURLConnection userURLGitHub;
    HttpURLConnection userURLRepo;
    LocalDate createdAt;
    LocalDate updatedAt;

}
