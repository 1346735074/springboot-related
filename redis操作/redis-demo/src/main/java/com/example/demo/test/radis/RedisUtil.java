package com.example.demo.test.radis;

import com.example.demo.test.radis.error.RedisException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * redis工具类
 *
 * @author wxy
 * @date 2018-08-30 下午8:00
 */
@Component
public class RedisUtil {
    private static final Logger logger = LoggerFactory.getLogger(RedisUtil.class);

//    @Resource
    private JedisPool jedisPool;

    public void setJedisPool(JedisPool jedisPool){
        this.jedisPool = jedisPool;
    }





    /**
     * set value
     *
     * @param key
     * @param value
     */
    public void set(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key, value);
        } catch (Exception e) {
            logger.error("RedisUtil set exception. key:{},value:{}", key, value, e);
            throw new RedisException(e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * get value
     *
     * @param key
     * @return
     */
    public String get(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.get(key);
        } catch (Exception e) {
            logger.error("RedisUtil get exception. key:{}", key, e);
            throw new RedisException(e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 设置key的过期时间
     *
     * @param key
     * @param seconds
     * @return
     */
    public void expire(String key, int seconds) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.expire(key, seconds);
        } catch (Exception e) {
            logger.error("RedisUtil expire exception. key:{}", key, e);
            throw new RedisException(e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }

    }

    /**
     * 判断是否存在
     *
     * @param key
     * @return
     */
    public boolean exists(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.exists(key);
        } catch (Exception e) {
            logger.error("RedisUtil exists exception. key:{}", key, e);
            throw new RedisException(e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * @param keys
     * @return
     */
    public void del(String... keys) {

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.del(keys);
        } catch (Exception e) {
            logger.error("RedisUtil del exception. keys:{}", keys, e);
            throw new RedisException(e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }

    }

    /**
     * set if not exists，若key已存在，则setnx不做任何操作
     *
     * @param key
     * @param value
     * @return
     */
    public boolean setnx(String key, String value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.setnx(key, value) > 0;
        } catch (Exception e) {
            logger.error("RedisUtil setnx exception. key:{},value:{}", key, value, e);
            throw new RedisException(e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }

    }

    /**
     * 在列表key的头部插入元素
     *
     * @param key
     * @param values
     * @return
     */
    public Long lpush(String key, String... values) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.lpush(key, values);
        } catch (Exception e) {
            logger.error("RedisUtil lpush exception. key:{}", key, e);
            throw new RedisException(e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }

    }

    /**
     * 在列表key的尾部插入元素
     *
     * @param key
     * @param values
     * @return
     */
    public Long rpush(String key, String... values) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.rpush(key, values);
        } catch (Exception e) {
            logger.error("RedisUtil rpush exception. key:{}", key, e);
            throw new RedisException(e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 返回列表中从索引start至end的元素
     * @param key
     * @param start
     * @param end
     * @return
     */
    public List<String> lrange(String key, long start, long end) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.lrange(key, start, end);
        } catch (Exception e) {
            logger.error("RedisUtil lrange exception. key:{}", key, e);
            throw new RedisException(e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }

    }


    /**
     * set 集合
     * @param key 键
     * @param values 值
     * @return 成功1 失败0
     */
    public Long sadd(String key, String... values) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.sadd(key, values);
        } catch (Exception e) {
            logger.error("RedisUtil sadd exception. key:{}", key, e);
            throw new RedisException(e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 显示set集合中的元素内容
     *
     * @param key 键
     * @return set集合
     */
    public Set<String> smembers(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.smembers(key);
        } catch (Exception e) {
            logger.error("RedisUtil smembers exception. key:{}", key, e);
            throw new RedisException(e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 列表中元素个数
     * @param key
     * @return
     */
    public Long llen(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.llen(key);
        } catch (Exception e) {
            logger.error("RedisUtil llen exception. key:{}", key, e);
            throw new RedisException(e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 移除等于value的元素<br/><br/> 当count>0时，从表头开始查找，移除count个；<br/> 当count=0时，从表头开始查找，移除所有等于value的；<br/>
     * 当count<0时，从表尾开始查找，移除count个
     *
     * @param key
     * @param count
     * @param value
     */
    public Long lrem(String key, long count, String value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.lrem(key, count, value);
        } catch (Exception e) {
            logger.error("RedisUtil lrem exception. key:{}", key, e);
            throw new RedisException(e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 对列表进行修剪
     *
     * @param key
     * @param start
     * @param end
     */
    public String ltrim(String key, long start, long end) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.ltrim(key, start, end);
        } catch (Exception e) {
            logger.error("RedisUtil ltrim exception. key:{}", key, e);
            throw new RedisException(e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 缓存Map赋值
     *
     * @param key
     * @param field
     * @param value
     */
    public Long hset(String key, String field, String value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.hset(key, field, value);
        } catch (Exception e) {
            logger.error("RedisUtil hset exception. key:{}", key, e);
            throw new RedisException(e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * @param key
     * @param field
     * @return
     */
    public String hget(String key, String field) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.hget(key, field);
        } catch (Exception e) {
            logger.error("RedisUtil hget exception. key:{}", key, e);
            throw new RedisException(e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * @param key
     * @param field
     * @return
     */
    public boolean hexists(String key, String field) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.hexists(key, field);
        } catch (Exception e) {
            logger.error("RedisUtil hget exception. key:{}", key, e);
            throw new RedisException(e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * @param key
     * @param field
     * @return
     */
    public Long hdel(String key, String field) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.hdel(key, field);
        } catch (Exception e) {
            logger.error("RedisUtil hget exception. key:{}", key, e);
            throw new RedisException(e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * @param key
     * @return
     */
    public Map<String, String> hgetAll(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.hgetAll(key);
        } catch (Exception e) {
            logger.error("RedisUtil hgetAll exception. key:{}", key, e);
            throw new RedisException(e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * zadd
     *
     * @param key
     * @param score
     * @param member
     * @return
     */
    public Long zadd(String key, double score, String member) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.zadd(key, score, member);
        } catch (Exception e) {
            logger.error("RedisUtil zadd exception. key:{}", key, e);
            throw new RedisException(e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * zrevrange
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public Set<String> zrevrange(String key, long start, long end) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.zrevrange(key, start, end);
        } catch (Exception e) {
            logger.error("RedisUtil zadd exception. key:{}", key, e);
            throw new RedisException(e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * zrank
     *
     * @param key
     * @param member
     * @return
     */
    public Long zrank(String key, String member) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.zrank(key, member);
        } catch (Exception e) {
            logger.error("RedisUtil zadd exception. key:{}", key, e);
            throw new RedisException(e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 分布式自增数
     *
     * @param key
     * @return
     */
    public Long incr(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.incr(key);
        } catch (Exception e) {
            logger.error("RedisUtil incr exception. key:{}", key, e);
            throw new RedisException(e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 分布式自减数
     *
     * @param key
     * @return
     */
    public Long decr(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            return jedis.decr(key);
        } catch (Exception e) {
            logger.error("RedisUtil incr exception. key:{}", key, e);
            throw new RedisException(e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }
}
