package io.learn.backend.bestpractices.service;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.learn.backend.bestpractices.bean.Covid;
import io.learn.backend.bestpractices.repository.CovidDataRepository;

@Service
public class CovidService {

    @Autowired
    private CovidDataRepository repo;

    @Autowired
    private RestTemplate rt;

    public String insertCovidData(String url) {

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
        String dateStr = sdf.format(date);
        if(repo.countByRecordInsertedDate(dateStr) > 0) return "records already inserted";
        JSONObject json;
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        // System.out.println(url);
        String result = rt.exchange(url, HttpMethod.GET, entity, String.class).getBody();
        json = new JSONObject(result);
        JSONArray arr = json.getJSONArray("statewise");
        for (int i = 0; i < arr.length(); i++) {
            JSONObject obj = arr.getJSONObject(i);
            Covid cvd = new Covid();
            cvd.setActive(obj.getString("active"));
            cvd.setConfirmed(obj.getString("confirmed"));
            cvd.setDeaths(obj.getString("deaths"));
            cvd.setDeltaconfirmed(obj.getString("deltaconfirmed"));
            cvd.setDeltadeaths(obj.getString("deltadeaths"));
            cvd.setDeltarecovered(obj.getString("deltarecovered"));
            cvd.setLastupdatedtime(obj.getString("lastupdatedtime"));
            cvd.setMigratedother(obj.getString("migratedother"));
            cvd.setRecovered(obj.getString("recovered"));
            cvd.setState(obj.getString("state"));
            cvd.setStatecode(obj.getString("statecode"));
            cvd.setRecordInsertedDate(dateStr);
            repo.save(cvd);
        }
        return "success";
    }

    public Covid getStateData(String statecode) {
        return repo.findByStatecode(statecode);
    }
}
