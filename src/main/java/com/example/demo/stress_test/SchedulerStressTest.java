package com.example.demo.stress_test;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.common.collect.Lists;
//import com.redis.lettucemod.api.StatefulRedisModulesConnection;
//import com.redis.lettucemod.api.sync.RedisModulesCommands;
//import com.redis.lettucemod.search.Field;
//import com.redis.lettucemod.search.SearchOptions;
//import com.redis.lettucemod.search.SearchResults;
//import io.lettuce.core.RedisCommandExecutionException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

//import com.redis.lettucemod.search.TagField;
//import static com.redis.query.Query.geo;
//import static com.redis.query.Query.numeric;
//import static com.redis.query.Query.tag;
//import static com.redis.query.Query.term;
//import static com.redis.query.Query.text;
//import static com.redis.query.Query.vector;
//import static org.junit.Assert.assertEquals;
//
//import org.junit.jupiter.api.Test;
//
//import com.redis.search.query.filter.Condition;
//import com.redis.search.query.filter.Distance;
//import com.redis.search.query.filter.GeoCoordinates;
//import com.redis.search.query.filter.NumericBoundary;
//import com.redis.search.query.filter.NumericField;
//import com.redis.search.query.filter.VectorField;
@Slf4j
@Component
public class SchedulerStressTest {

    //Event-Timestamp -> 1715947439 oldest MIN
    //Event-Timestamp -> 1716727601 latest MAX
    private static final String MAX_TIME = " 1716727601";
    public static final AtomicInteger exceptionCounter = new AtomicInteger(0);
    public static final AtomicReference<String> lastException = new AtomicReference<>();

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    @Qualifier("stressTestThreadPoolTaskExecutor")
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

//    @Autowired
//    private GenericObjectPool<StatefulRedisModulesConnection<String, String>> pool;

    //@Scheduled(fixedDelay = 300000L, initialDelay = 1000L)
    public void run() throws IOException {

//        List<Holder> data = Utils.load(Holder.class, objectMapper,"/username_event-timestamps.json");
//
//        List<List<Holder>> partitions = Lists.partition(data, 2400);
//
//        for(List<Holder> partition : partitions){
//
//            threadPoolTaskExecutor.execute(() ->
//
//                partition.forEach(holder -> {
//                    try (StatefulRedisModulesConnection<String, String> connection = pool.borrowObject()) {
//                        RedisModulesCommands<String, String> commands = connection.sync();
//                        SearchOptions.Builder<String, String> builder1 = SearchOptions.<String, String>builder();
//                        /*
//                        findBy().userName().and().eventTimestamp().
//
//                         */
//
//                        var searchQuery = "@User\\-Name:{" + Utils.escape(holder.getUserName()) + "} @Event\\-Timestamp:[" + holder.getEventTimestamp() + MAX_TIME + "]";
//
//                        var searchOptions = SearchOptions.<String, String>builder() .returnFields("Event-Timestamp")
//                                .limit(0, 100000)
//                                .sortBy(SearchOptions.SortBy.desc("Event-Timestamp"))
//
//                                .build();
//
//                        SearchResults<String, String> documents = commands.ftSearch(
//                                "radius:acct:index:acct-idx", //index
//                                searchQuery,
//                                searchOptions);
//
//                        SearchOptions.Builder<String, String> builder = SearchOptions.<String, String>builder();
//
//                        log.info("received documents size of {}", documents.getCount());
//                    } catch (RedisCommandExecutionException redisException){
//                        log.error("Unexpected RedisCommandExecutionException :: ", redisException);
//                        exceptionCounter.incrementAndGet();
//                        lastException.set(redisException.getMessage());
//                    } catch (Exception e) {
//                        log.error("Unexpected Exception :: ", e);
//                        exceptionCounter.incrementAndGet();
//                        lastException.set(e.getMessage());
//                    }
//                }));
//        }

//        threadPoolTaskExecutor.getThreadPoolExecutor().shutdown();
//        try {
//            if (!threadPoolTaskExecutor.getThreadPoolExecutor().awaitTermination(130000L, TimeUnit.SECONDS)) {
//                log.warn("Thread pool hasn't completed in time! Processing of search queries is about to be shutdown now!");
//               // exceptionCounter.incrementAndGet();
//              //  lastException.set("Thread pool hasn't completed in time!");
//            }
//        } catch (InterruptedException ex) {
//            log.error("Processing messages is interrupted. About to shutdown now!");
//            //exceptionCounter.incrementAndGet();
//            //lastException.set(ex.getMessage());
//            Thread.currentThread().interrupt();
//        }






    }
}

/*
 executorService.shutdown();
                try {
                    if (!executorService.awaitTermination(getSchedulerConfiguration().getAwaitTime(), TimeUnit.SECONDS)) {
                        log.info("Processing messages is about to be shutdown now!");
                        smsRepository.updateMessagesToPending();
                        executorService.shutdownNow();
                    }
                } catch (InterruptedException ex) {
                    log.info("Processing messages is interrupted. About to shutdown now!");
                    smsRepository.updateMessagesToPending();
                    executorService.shutdownNow();
                    Thread.currentThread().interrupt();
                }
 */
