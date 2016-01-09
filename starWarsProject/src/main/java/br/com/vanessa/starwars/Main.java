package br.com.vanessa.starwars;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.vanessa.starwars.api.model.People;

import com.google.common.collect.Lists;

@RestController
@ComponentScan({"br.com.vanessa.starwars", "br.com.vanessa.startwars.api"})
@SpringBootApplication
public class Main {
	
	private RestTemplate rest = new RestTemplate();
	
	
	@RequestMapping("/")
	public void home() {
		String URI = "http://swapi.co/api/people/1";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(Lists.newArrayList((new MappingJackson2HttpMessageConverter())));
        HttpHeaders headers = new HttpHeaders();
        headers.set("User-Agent", "Mozilla/5.0");
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<People> response = restTemplate.exchange(URI, HttpMethod.GET, entity, People.class);
        People apiRoot = response.getBody();
        System.out.println("sampleRestTemplate:" + apiRoot.toString());
    }
	
		
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Main.class, args);
	}
}