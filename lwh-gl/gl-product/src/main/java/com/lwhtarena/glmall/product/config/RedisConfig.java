//package com.lwhtarena.glmall.product.config;

/**
 * @author liwh
 * @Title: RedisConfig
 * @Package com.lwhtarena.glmall.product.config
 * @Description:
 * @Version 1.0.0
 * @date 2020/9/9 12:12
 */
// @Configuration
// @EnableCaching
// public class RedisConfig extends CachingConfigurerSupport {
//
//     /**
//      *  自定义生成key的规则
//      *  缓存对象集合中，缓存是以 key-value 形式保存的。
//      *  当不指定缓存的key时，springboot会使用 SimpleKeyGenerator 生成 key
//      * @return
//      */
//     @Override
//     @Bean
//     public KeyGenerator keyGenerator() {
//         return new KeyGenerator() {
//             @Override
//             public Object generate(Object target, Method method, Object... params) {
//                 //格式化缓存 key 字符串
//                 StringBuilder sb = new StringBuilder();
//                 //追加类名
//                 sb.append(target.getClass().getName());
//                 //追加方法名
//                 sb.append(method.getName());
//                 //遍历参数并且追加
//                 for (Object obj : params) {
//                     sb.append(obj.toString());
//                 }
//                 System.out.println("调用Redis缓存key：" + sb.toString());
//                 return sb.toString();
//             }
//         };
//     }
//
//
//     /**
//      *  配置序列化
//      * @param redisConnectionFactory
//      * @return
//      */
//     public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//
//         RedisTemplate<Object,Object> redisTemplate = new RedisTemplate<Object, Object>();
//         redisTemplate.setConnectionFactory(redisConnectionFactory);
//         Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//
//         ObjectMapper objectMapper = new ObjectMapper();
//         objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//         objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//
//         jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
//
//         redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
//         redisTemplate.setKeySerializer(new StringRedisSerializer());
//
//         redisTemplate.afterPropertiesSet();
//         return redisTemplate;
//     }
//
//     /**
//      *  采用 RedisCacheManager 作为缓存管理器
//      */
//     @Bean
//     public CacheManager cacheManager(RedisConnectionFactory factory) {
//         RedisSerializer<String> redisSerializer = new StringRedisSerializer();
//         Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//         ObjectMapper objectMapper = new ObjectMapper();
//         objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//         objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//         jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
//
//         //配置序列化
//         RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();
//         RedisCacheConfiguration redisCacheConfiguration = config.serializeKeysWith(
//                 RedisSerializationContext.SerializationPair.fromSerializer(redisSerializer)).serializeValuesWith(
//                 RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer));
//         RedisCacheManager cacheManager = RedisCacheManager.builder(factory).cacheDefaults(
//                 redisCacheConfiguration.entryTtl(Duration.ofMinutes(5))).build();
//         return cacheManager;
//     }
//
//
// }
