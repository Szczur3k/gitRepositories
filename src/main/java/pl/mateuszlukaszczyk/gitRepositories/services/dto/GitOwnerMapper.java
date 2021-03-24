package pl.mateuszlukaszczyk.gitRepositories.services.dto;

import com.google.gson.stream.JsonReader;
import org.json.JSONArray;
import org.json.JSONObject;
import pl.mateuszlukaszczyk.gitRepositories.models.GitOwner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class GitOwnerMapper {

    List<Object> listStargazers = new ArrayList<>();

    public GitOwner map(String jsonResponseRepo, String jsonResponseStargazers) {
        JSONObject jsonObject = new JSONObject(jsonResponseRepo);
        parseCreatedAtToNormalDate(jsonObject);

        JSONArray jsonArray = new JSONArray(jsonResponseStargazers);
        for (Object object : jsonArray) {
            listStargazers.add(object);
        }

        return GitOwner.builder()
                .fullName(jsonObject.getString("full_name"))
                .description(jsonObject.getString("description"))
                .cloneUrl(jsonObject.getString("clone_url"))
                .stars(listStargazers.size())
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

