package com.algaworks.algasensors.temperature.processing.api.config.jackson;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleModule;
import io.hypersistence.tsid.TSID;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** Classe responsável pelo Bean de configuração da classe custom TSIDToStringSerializer que criamos **/

@Configuration
public class TSIDJacksonConfig {

    @Bean
    public Module tsidModule() {
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(TSID.class, new TSIDToStringSerializer());
        return simpleModule;
    }

}
