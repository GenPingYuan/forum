package com.forum;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.forum.entity.dto.enums.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableAutoConfiguration
public class IwebApplication {

	//private static Logger _log = LoggerFactory.getLogger(IwebApplication.class);

	public static void main(String[] args) {
	//	_log.info(State.VALID.getValue());
		SpringApplication.run(IwebApplication.class, args);
	}
}
