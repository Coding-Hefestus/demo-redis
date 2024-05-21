package com.example.demo.stress_test;

//import com.redis.lettucemod.search.Document;
import lombok.Data;

@Data
public class Holder {

    private String userName;
    private String eventTimestamp;

    public Holder(String userName, String eventTimestamp) {
        this.userName = userName;
        this.eventTimestamp = eventTimestamp;
    }

//    public Holder(Document<String, String> document){
//        this.userName = document.get("User-Name");
//        this.eventTimestamp = document.get("Event-Timestamp");
//    }
}
