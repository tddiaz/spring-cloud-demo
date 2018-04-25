package com.github.tddiaz.limitsservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableConfigurationProperties
public class LimitsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LimitsServiceApplication.class, args);
	}
}

@Configuration
class LimitsConfig {

	@Value("${limits-service.minimum}")
	private int minimum;

	@Value("${limits-service.maximum}")
	private int maximum;

	@Bean
	public LimitsBean limitsBean() {
		return new LimitsBean(minimum, maximum);
	}

}

@Data
@AllArgsConstructor
class LimitsBean {

	private int minimum;
	private int maximum;

}

@RestController
class Controller {

	@Autowired
	private LimitsBean limitsBean;

	@GetMapping("/limits")
	public ResponseEntity<Response> getLimits() {
		return ResponseEntity.ok(new Response(limitsBean.getMinimum(), limitsBean.getMaximum()));
	}
}

@Data
@AllArgsConstructor
class Response {
	private int minimum;
	private int maximum;
}