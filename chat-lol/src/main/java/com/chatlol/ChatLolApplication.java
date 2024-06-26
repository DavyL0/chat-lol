package com.chatlol;

import com.chatlol.application.AskChampionUseCase;
import com.chatlol.application.ListChampionsUseCase;
import com.chatlol.domain.ports.ChampionsRepository;
import com.chatlol.domain.ports.GenerativeAiApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class ChatLolApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatLolApplication.class, args);
	}
	@Bean
	public ListChampionsUseCase provideListChampionsUseCase(ChampionsRepository repository){
		return new ListChampionsUseCase(repository);
	}

	@Bean
	public AskChampionUseCase provideAskChampionsUseCase(ChampionsRepository repository,
														 GenerativeAiApi genAiApi){
		return new AskChampionUseCase(repository,genAiApi);
	}
}

