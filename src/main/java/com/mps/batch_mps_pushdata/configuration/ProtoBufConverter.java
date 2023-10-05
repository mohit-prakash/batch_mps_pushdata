//package com.mps.batch_mps_pushdata.configuration;
//
//import com.google.protobuf.InvalidProtocolBufferException;
//import com.google.protobuf.Struct;
//import com.google.protobuf.util.JsonFormat;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
//
//@Configuration
//public class ProtoBufConverter {
//
//    public Struct convertJsonToProtobuf(String json) throws InvalidProtocolBufferException {
//        Struct.Builder builder = Struct.newBuilder();
//        JsonFormat.parser().ignoringUnknownFields().merge(json,builder);
//        Struct protobuf = builder.build();
//        return protobuf;
//    }
//}
