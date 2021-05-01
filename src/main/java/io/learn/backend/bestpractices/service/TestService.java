package io.learn.backend.bestpractices.service;

import java.util.Arrays;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.learn.backend.bestpractices.bean.TestRestAPI;

@Service
public class TestService {

    @Autowired
    private TestRestAPI component;

    @Autowired
    private RestTemplate rt;

    @Value("${weather.api.host}")
    private String host;

    @Value("${weather.api.app.id}")
    private String appId;

    public TestRestAPI getTemperature(String city) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        String url = host + city + "&APPID=" + appId;
        String result = rt.exchange(url, HttpMethod.GET, entity, String.class).getBody();

        if (result != null) {
            try {
                JSONObject json = new JSONObject(result);
                component.setTemperature(json.getJSONObject("main").getString("temp"));
                component.setLatitude(json.getJSONObject("coord").getString("lat"));
                component.setLongitude(json.getJSONObject("coord").getString("lon"));
                component.setDescription(json.getJSONArray("weather").getJSONObject(0).getString("description"));
                component.setPressure(json.getJSONObject("main").getString("pressure"));
                component.setHumidity(json.getJSONObject("main").getString("humidity"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return component;
    }
}
