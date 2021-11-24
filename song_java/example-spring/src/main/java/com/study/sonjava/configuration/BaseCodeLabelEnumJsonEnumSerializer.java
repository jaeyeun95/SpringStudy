package com.study.sonjava.configuration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.study.sonjava.mvc.domain.BaseCodeLabelEnum;

// JSON 변환시 BaseCodeLabelEnum 클래스에 대한 변환을 동일하게 처리
public class BaseCodeLabelEnumJsonEnumSerializer extends JsonSerializer<BaseCodeLabelEnum> {

    @Override
    public void serialize(BaseCodeLabelEnum value, JsonGenerator jsonGenerator, SerializerProvider provider)
            throws IOException {
                Map<String, Object> map = new HashMap<>();
                map.put("code", value.code());
                map.put("label", value.label());
                jsonGenerator.writeObject(map);
        
    }}
