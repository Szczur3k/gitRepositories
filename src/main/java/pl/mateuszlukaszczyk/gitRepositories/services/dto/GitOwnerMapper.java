package pl.mateuszlukaszczyk.gitRepositories.services.dto;

import org.json.JSONObject;
import pl.mateuszlukaszczyk.gitRepositories.models.GitOwner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GitOwnerMapper {

    public GitOwner map(String jsonResponse) {
        JSONObject jsonObject = new JSONObject(jsonResponse);
        parseCreatedAtToNormalDate(jsonObject);
        return GitOwner.builder()
                .fullName(jsonObject.getString("full_name"))
                .description(jsonObject.getString("description"))
                .cloneUrl(jsonObject.getString("clone_url"))
                //                .stars( tu wpisz metoda aby zapisywalo lista stargazersow )
                .createdAt(parseCreatedAtToNormalDate(jsonObject))
                .build();
    }

    private Date parseCreatedAtToNormalDate(JSONObject jsonObject) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = inputFormat.parse(jsonObject.getString("created_at"));
            String s = outputFormat.format(date);
            date = outputFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}

