package com.hackerrank.sample.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.sample.dto.StringResponse;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

@RestController
public class SampleController {
	 private static final Logger LOG= LoggerFactory.getLogger(SampleController.class);
	 Cache cache ;
	 @PostConstruct
		public void initialize() {
			cacheManager = new CacheManager(this.getClass().getResource("/ehcache.xml"));
			cache = cacheManager.getCache("counter");
		}
	 
	@RequestMapping(path = "/defaultHello", method = RequestMethod.GET)
	public ResponseEntity<StringResponse> createWeather() {
		StringResponse response = new StringResponse("Default Hello World!");
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@RequestMapping(path = "/add/{counter}", method = RequestMethod.GET)
	public ResponseEntity<Integer> add(@PathVariable(name = "counter") Integer counterInput) {
		StringResponse response = new StringResponse("added");
		addToCache(counterInput);
		return ResponseEntity.status(HttpStatus.OK).body(counterInput);
	}
	
	
	private void addToCache(int counter2) {
		cache.put(new Element(counter2, counter2*counter2));
		LOG.info(counter2 +" , "+counter2*counter2);
	}
	
	private CacheManager cacheManager;
	
	
	
	@RequestMapping(path = "/get", method = RequestMethod.GET)
	public ResponseEntity<StringResponse> get() {
		  for (Object key: cache.getKeys()) {
			    Element element = cache.get(key);
			    LOG.info("get : key="+element.getKey()+"  value: "+element.getValue());
		  }

		StringResponse response = new StringResponse("add");
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
