//package com.lwhtarena.mk.common.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
///**
// * @author liwh
// * @Title: RedisCacheConfig
// * @Package com.lwhtarena.mk.common.config
// * @Description: 增强redis
// * @Version 1.0.0
// * @date 2020/5/19 19:02
// */
//@Configuration
//@EnableCaching
//public class RedisCacheConfig extends CachingConfigurerSupport {
//
//    @Value("${redis.cache.expiration:3600}")
//    private Long expiration;
//
//    @Bean
//    public CacheManager cacheManager(RedisConnectionFactory factory) {
////        RedisCacheManager rcm = new RedisCacheManager(redisTemplate);
////        rcm.setDefaultExpiration(expiration);
////        return rcm;
//        RedisCacheManager redisCacheManager =RedisCacheManager.create(factory);
//        return redisCacheManager;
//    }
//
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
//        RedisTemplate<String, Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(factory);
//        template.setKeySerializer(new StringRedisSerializer());
//        template.setValueSerializer(new JdkSerializationRedisSerializer());
//        return template;
//    }
//
//}
