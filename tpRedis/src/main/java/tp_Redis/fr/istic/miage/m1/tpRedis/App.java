package tp_Redis.fr.istic.miage.m1.tpRedis;

import redis.clients.jedis.Jedis;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
    	Jedis jedis = new Jedis("localhost");

        jedis.set("foo", "bar");

        String value = jedis.get("foo");

       
        System.err.println(value);    
        
        System.out.println("************************************************");
        
        
        Jedis jedis2 = new Jedis("localhost");

        System.out.println(jedis2.get("counter"));

        jedis2.incr("counter");

        System.out.println(jedis2.get("counter"));
        
        
        
        
        
        
        System.out.println("************************************************");
        
        String cacheKey = "cachekey";

        Jedis jedis3 = new Jedis("localhost");

        // adding a new key

        jedis3.set(cacheKey, "cached value");

        // setting the TTL in seconds

        jedis3.expire(cacheKey, 15);

        // Getting the remaining ttl

        System.out.println("TTL:" + jedis3.ttl(cacheKey));

        Thread.sleep(1000);

        System.out.println("TTL:" + jedis3.ttl(cacheKey));

        // Getting the cache value

        System.out.println("Cached Value:" + jedis3.get(cacheKey));

        // Wait for the TTL finishs

        Thread.sleep(15000);

        // trying to get the expired key

        System.out.println("Expired Key:" + jedis3.get(cacheKey));
        
        
        
        System.out.println("************************************************");
        
    	String cacheKey2 = "languages";

        Jedis jedis4 = new Jedis("localhost");

        // Adding a set as value

        jedis4.sadd(cacheKey2, "Java");

        jedis4.sadd(cacheKey2, "C#");

        jedis4.sadd(cacheKey2, "Python");// SADD

        // Getting all values in the set: SMEMBERS

        System.out.println("Languages: " + jedis4.smembers(cacheKey2));

        // Adding new values

        jedis4.sadd(cacheKey2, "Java");

        jedis4.sadd(cacheKey2, "Ruby");

        // Getting the values... it doesn't allow duplicates

        System.out.println("Languages: " + jedis4.smembers(cacheKey2)); 
    }
}
