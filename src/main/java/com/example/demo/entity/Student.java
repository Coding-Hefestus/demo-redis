package com.example.demo.entity;


import com.redis.om.spring.annotations.Indexed;
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

    @Indexed
    private String userName;

    @Indexed
    private LocalDateTime eventTimestamp;


}
