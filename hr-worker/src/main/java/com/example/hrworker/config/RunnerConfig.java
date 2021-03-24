package com.example.hrworker.config;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.hrworker.entities.Worker;
import com.example.hrworker.repositories.WorkerRepository;

@Configuration
public class RunnerConfig implements CommandLineRunner {
	@Autowired
	private WorkerRepository repo;
	
	private static final Logger logger = LoggerFactory.getLogger(RunnerConfig.class);
	
	@Override
	public void run(String... args) throws Exception {
		if (repo.count() == 0) {
			List<Worker> workers = repo.saveAll(Arrays.asList(
					new Worker(null, "Bob", 200.0),
					new Worker(null, "Maria", 300.0),
					new Worker(null, "Alex", 250.0)));
			workers.forEach(x -> {logger.info("new: {}", x);});
		} else {
			repo.findAll().forEach(x -> {logger.info("old: {}", x);});
		}
	}

}
