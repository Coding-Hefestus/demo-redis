package com.example.demo.entity;

import com.redis.om.spring.annotations.IndexCreationMode;
import com.redis.om.spring.annotations.Indexed;
import com.redis.om.spring.annotations.IndexingOptions;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Data
@Builder
@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@IndexingOptions(creationMode = IndexCreationMode.SKIP_IF_EXIST, indexName = "myIndexStudent")
@RedisHash
public class Student {

    @Id
    private Long id;

    @Indexed(alias = "User-Name")
    private String userName;

    @Indexed(alias = "Acct-Session-Id")
    private String acctSessionId;

}
