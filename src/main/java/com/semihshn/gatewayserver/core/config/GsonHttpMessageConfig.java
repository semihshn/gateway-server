package com.semihshn.gatewayserver.core.config;

import com.google.gson.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class GsonHttpMessageConfig {

    @Bean
    public GsonBuilder gsonBuilder()
    {
        return new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class,
                        (JsonSerializer<LocalDateTime>) (date, type, context) ->
                                date == null ? null : new JsonPrimitive(date.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)))
                .registerTypeAdapter(LocalDateTime.class,
                        (JsonDeserializer<LocalDateTime>) (json, type, context) ->
                                LocalDateTime.parse(json.getAsString(), DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }

    @Bean
    public Gson gson(GsonBuilder gsonBuilder)
    {
        return gsonBuilder.create();
    }

    @Bean
    public GsonHttpMessageConverter gsonHttpMessageConverter(Gson gson)
    {
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        converter.setGson(gson);
        return converter;
    }
}
