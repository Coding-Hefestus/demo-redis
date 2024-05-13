package com.example.demo.entity;


import com.redis.om.spring.annotations.Indexed;
import com.redis.om.spring.annotations.SchemaFieldType;
import com.redis.om.spring.annotations.SerializationHint;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

@Data
@Builder
@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@RedisHash
public class Student {

    @Id
    private Long id;

    @Indexed(alias = "User-Name")//  fieldName = "User-Name", schemaFieldType = SchemaFieldType.TAG
    private String userName;

    @Indexed
    private LocalDateTime eventTimestamp;


}
