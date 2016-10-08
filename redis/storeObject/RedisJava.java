package redis.storeObject;

import java.io.IOException;

import redis.clients.jedis.Jedis;

public class RedisJava {
	private static Jedis jedis=new Jedis("localhost");
	public static void main(String[] args) {
		System.out.println("Connection to server sucessfully!");
		System.out.println("Server is running:"+jedis.ping());
		Person person=new Person(100, "alan");
		setObject(person.getId(), person);
		Person person2= getObject(person.getId());
		System.out.println(person2.getId()+":"+person2.getName());
		
	}
	//将对象序列化，并将二进制数据存入redis
	public static void setObject(int id,Person person){
		try {
			jedis.set(("person"+person.getId()).getBytes(), SerializeUtil.serialize(person));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//从redis取出二进制数据，并反序列化出对象
	public static Person getObject(int id){
		byte[] bytes=jedis.get(("person"+id).getBytes());
		try {
			Person person=(Person)SerializeUtil.unserialize(bytes);
			return person;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
