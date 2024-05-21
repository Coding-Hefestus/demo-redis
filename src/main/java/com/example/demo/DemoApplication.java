package com.example.demo;

import com.example.demo.stress_test.Holder;
import com.example.demo.stress_test.SchedulerStressTest;
import com.example.demo.stress_test.Utils;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.redis.lettucemod.api.StatefulRedisModulesConnection;
//import com.redis.lettucemod.api.sync.RedisModulesCommands;
//import com.redis.lettucemod.cluster.api.StatefulRedisModulesClusterConnection;
//import com.redis.lettucemod.protocol.TopKCommandType;
//import com.redis.lettucemod.search.Document;
//import com.redis.lettucemod.search.SearchOptions;
//import com.redis.lettucemod.search.SearchResults;
//import com.redis.lettucemod.search.Sort;
//import io.lettuce.core.RedisClient;
//import io.lettuce.core.api.StatefulRedisConnection;
//import io.lettuce.core.support.ConnectionPoolSupport;
import com.redis.om.spring.annotations.EnableRedisEnhancedRepositories;
import jakarta.annotation.Resource;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.connection.RedisCommands;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.HashOperations;
//import org.springframework.data.redis.hash.HashMapper;
//import org.springframework.data.redis.hash.ObjectHashMapper;
//import redis.clients.jedis.CommandArguments;
//import redis.clients.jedis.Jedis;


import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
//import com.redis.om.spring.RediSearchIndexer;
//import com.redis.om.spring.annotations.EnableRedisEnhancedRepositories;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.dao.DataAccessException;
//import org.springframework.data.domain.ExampleMatcher;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.redis.connection.RedisConnection;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisCallback;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
//import org.springframework.data.repository.query.FluentQuery;
//import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import redis.clients.jedis.JedisPooled;
//import redis.clients.jedis.search.Query;
//import redis.clients.jedis.search.RediSearchCommands;
//import redis.clients.jedis.search.SearchResult;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//import com.redis.lettucemod.RedisModulesClient;

@SpringBootApplication
@ComponentScan(
		basePackages = {"com.example.demo.*"},
		basePackageClasses = {DemoApplication.class})
//@AllArgsConstructor
@EnableRedisEnhancedRepositories(basePackages = {"com.example.demo.*"})
//@EnableRedisRepositories(basePackages = {"com.example.demo.*"})
@EnableScheduling
@RestController
@RequestMapping("test")
public class DemoApplication implements CommandLineRunner {

	//private final ObjectMapper objectMapper;
	@Autowired
	private StudentRepository studentRepository;

	//private final RedisTemplate<Long, Student> redisTemplate;
	//private final RediSearchCommands rediSearchCommands;
//	private final JedisConnectionFactory jedisPooled;

	//private final StatefulRedisModulesConnection<String, String> connection;
	//private final StatefulRedisModulesConnection<String, String> connection;
//	private final GenericObjectPool<StatefulRedisModulesConnection<String, String>> pool;
	//GenericObjectPool<StatefulRedisModulesConnection<String, String>> pool;
	//private RedisProperties properties;
	//private final com.redis.lettucemod.api.StatefulRedisModulesConnection<String, String> connection;
	//com.redis.lettucemod.api.sync.RedisModulesCommands
	//private final JedisPooled jedisPooled;

	//@Autowired
	//@Resource(name = "redisTemplate")
	//private final HashOperations<Student, byte[], byte[]> hashOperations;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/get2")
	public String get2(){
		List<Student> pera = studentRepository.findByUserName("pera");
		System.out.println(pera);
		return "A";
	}

//	@GetMapping("/get")
//	public List<Holder> getEntity() throws Exception {
//		String escape = Utils.escape("DEU.DGW.test1", true);
//		System.out.println(escape);
//		System.out.println();
//		//for jedis
////		Jedis jedis = null;
////		RedisProperties.Pool pool = null; //properties.createRe
////		JedisConnectionFactory x = null; //radius:acct:index:acct-idx //myIndex
//		//SearchResults<String, String> myIndex = connection.sync().ftSearch("radius:acct:index:acct-idx", "@User\\-Name:{DEU\\.DGW\\.test316}");
//		System.out.println();
//		//Query query = new Query("@User\\-Name:{pera}");
//
//		//SearchResult sr = jedisPooled.ftSearch("myIndex", query);
//		//ObjectHashMapper mapper = new ObjectHashMapper();
//		//Object o = executeCommand("FT.SEARCH", "com.example.demo.entity.StudentIdx".getBytes(), "@User\\-Name:{pera}".getBytes(), "SORTBY".getBytes(), "Event-Timestamp".getBytes(), "DESC".getBytes(), "LIMIT".getBytes(), "0".getBytes(), "1".getBytes());
//		//var o = executeCommand("FT.SEARCH", "myIndex".getBytes(), "@User\\-Name:{pera}".getBytes());
//	//	var s = executeCommand2("FT.SEARCH", "myIndex".getBytes(), "@User\\-Name:{pera}".getBytes(), "LIMIT".getBytes(), "0".getBytes(), "1".getBytes());
//		//var x = (ArrayList) o;
//		//Map<byte[], byte[]> loadedHash = ( Map<byte[], byte[]>) x.get(3);
//		//Student student = (Student) mapper.fromHash(loadedHash);
//		TopKCommandType query = TopKCommandType.QUERY;
//		//SearchOptions<String, String> options = SearchOptions.builder().f
//		//FT.SEARCH radius:acct:index:acct-idx "@Event\\-Timestamp:[1 99999999999999999]" LIMIT 10 10 RETURN 1 Event-Timestamp
//		try (StatefulRedisModulesConnection<String, String> connection = pool.borrowObject()) { // (3)
//			RedisModulesCommands<String, String> commands = connection.sync();
//			//List<String> keys = commands.keys("*");
//			//FT.SEARCH radius:acct:index:acct-idx "@Event\\-Timestamp:[1 99999999999999999]" LIMIT 10 10 RETURN 1 Event-Timestamp
//			//SearchResults<String, String> documents = commands.ftSearch("radius:acct:index:acct-idx", SearchOptions<String>builde); //"@Event\\-Timestamp:[1 99999999999999999]" LIMIT 10 10 RETURN 1 Event-Timestamp
//			var searchOptions = SearchOptions.<String, String>builder().returnFields("User-Name","Event-Timestamp")
//															 	       .limit(0, 24000)
//															 	       .sortBy(SearchOptions.SortBy.asc("Event-Timestamp"))
//															 	       .build();
//			SearchResults<String, String> documents = commands.ftSearch("radius:acct:index:acct-idx",
//															              "@Event\\-Timestamp:[1 99999999999999999]",
//																		searchOptions);
//
//			//List<String> collect = documents.stream().map(Document::entrySet).flatMap(Collection::stream).map(Map.Entry::getValue).toList();
//
//			//SearchResults<String, String> searchResults = commands.ftSearch("radius:acct:index:acct-idx", "@User\\-Name:{DEU\\.DGW\\.test316}");
//
//			return documents.stream().map(Holder::new).collect(Collectors.toList());
//			//return objectMapper.writeValueAsString(collect);
//		} catch (Exception e) { //(RedisCommandExecutionException e
//			e.printStackTrace();
//		} finally {
//
//		}
//
//		return null;
//	}

	@GetMapping("/status")
	public String getStatus(){
		return "Total exceptions count: " + SchedulerStressTest.exceptionCounter.get() + "\n" +
			   "Last seen exception: " + SchedulerStressTest.lastException.get();
	}

	public void testLettuce(){
//		RedisModulesClient client = RedisModulesClient.create("redis://localhost:6379"); // (1)
//		StatefulRedisModulesConnection<String, String> connection = client.connect(); // (2)
//		RedisModulesCommands<String, String> commands = connection.sync(); // (3)
//
//		commands.ftSearch()

	}



	@GetMapping("/save")
	public String saveEntity(){
		//studentRepository.save(Student.builder().userName("pera").build());
		return "a";
	}


	@Override
	public void run(String... args) throws Exception {

	}

//	public Object executeCommand2(String command, byte[]... parts) {
//
//		//redisTemplate.getClientList().get(0).get
//		return redisTemplate.opsForHash().getOperations().execute(new RedisCallback<Object>() {
//			@Override
//			public Object doInRedis(RedisConnection connection) throws DataAccessException {
//
//				return (Object) connection.commands().execute(command, parts);
//			}
//
//		});
//	}


//	public Object executeCommand(String command, byte[]... parts) {
//
//		return redisTemplate.execute(connection ->
//				connection.execute(command, parts), true
//		);
//	}

	/*
	@Bean
	public JedisPooled jedisPooled(RedisConnectionFactory connectionFactory) {
	    return new JedisPooled("localhost", 6379);
	}
	 */
}
