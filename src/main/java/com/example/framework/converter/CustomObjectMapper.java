package com.example.framework.converter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;

import java.io.IOException;

public class CustomObjectMapper extends ObjectMapper {

	public CustomObjectMapper() {
		DefaultSerializerProvider.Impl serializerProvider = new DefaultSerializerProvider.Impl();
		serializerProvider.setNullValueSerializer(new NullSerializer());
		this.setSerializerProvider(serializerProvider);
	}

	/**
	 * Null 인 케이스에 맞게 vo 셋팅
	 * @author sysoft1123c
	 *
	 */
	private static class NullSerializer extends JsonSerializer<Object> {
		@Override
		public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers)
				throws IOException, JsonProcessingException {
			gen.writeString("");
		}
	}
}