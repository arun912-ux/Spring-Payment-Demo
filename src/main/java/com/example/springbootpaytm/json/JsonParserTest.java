//package com.example.springbootpaytm.json;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//public class JsonParserTest {
//
//    static ObjectMapper mapper = new ObjectMapper();
//
//
//    public static void parseJsonString() throws JsonProcessingException {
//
//        String jsonArrayString = "{\"responseList\":[{\"EFF-DT\":\"2025-01-15\", \"ATR-VAL-DC\":\"***\"}]}";
//
//        String jsonString = "{\"EFF-DT\":\"2025-01-15\", \"ATR-VAL-DC\":\"***\"}";
//
//        TypeReference<ResponseRO<QualifierNvpRO>> typeReference = new TypeReference<ResponseRO<QualifierNvpRO>>() {
//        };
//
//        ResponseRO<QualifierNvpRO> responseRO = mapper.readValue(jsonArrayString, typeReference);
//
//        log.info("Json mapped object {}", responseRO);
//
//
//        jsonArrayString = "{\"responseList\" : [ { \"PRD-SVC-LOC-CD\" : \"TX\" }, { \"START-DATE\" : \"2022-05-03\" } ]}";
//
//        TypeReference<ResponseRO<LocationRO>> typeReference1 = new TypeReference<>() {
//        };
//
//        ResponseRO<LocationRO> responseRO1 = mapper.readValue(jsonArrayString, typeReference1);
//
//        log.info("Json mapped object {}", responseRO1);
//
//    }
//
//
//
//}
