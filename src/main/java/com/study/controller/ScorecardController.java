package com.study.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.study.dto.ScorecardDTO;

@RestController
@EnableBinding(Sink.class)
/*@EnableOAuth2Sso*/
@EnableResourceServer
public class ScorecardController {
	
	@Value("${server.port}")
	private int port;
	
	private ScorecardDTO score;
	
	@RequestMapping(value="/getScore", method=RequestMethod.GET)
	public String getScorecard() {
		return "Score : " + this.score.getRuns()+"/" +this.score.getWickets() + " From port : " + port;
		//return "hello Suprasanna!!!";
	}
	
	@StreamListener(target=Sink.INPUT)
	public void handleOrders(ScorecardDTO score) {
		System.out.println("inside the scorecard service");
		this.score = score;
	}
	
}
