package hello.config;

import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.datasource.MyDataSource;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class MyDataSourceValueConfig {

	@Value("${my.datasource.url}")
	private String url; 			// 접속 url
	@Value("${my.datasource.username}")
	private String username; 		// 이름
	@Value("${my.datasource.password}")
	private String password; 		// 비밀번호
	@Value("${my.datasource.etc.max-connection}")
	private int maxConnection; 		// 최대 연결수
	@Value("${my.datasource.etc.timeout}")
	private Duration timeout; 		// 응답 지연시 타임아웃
	@Value("${my.datasource.etc.options}")
	private List<String> options; 	// 연결시 사용하는 기타 옵션들

	@Bean
	public MyDataSource myDataSource1() {
		return new MyDataSource(url, username, password, maxConnection, timeout, options);
	}

	@Bean
	public MyDataSource myDataSource2(
		@Value("${my.datasource.url}") String url,
		@Value("${my.datasource.username}") String username,
		@Value("${my.datasource.password}") String password,
		@Value("${my.datasource.etc.max-connection}") int maxConnection,
		@Value("${my.datasource.etc.timeout}") Duration timeout,
		@Value("${my.datasource.etc.options}") List<String> options
	) {
		return new MyDataSource(url, username, password, maxConnection, timeout, options);
	}

}
