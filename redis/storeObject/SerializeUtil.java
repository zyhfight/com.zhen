package redis.storeObject;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 序列化工具类：提供对象的序列化和反序列化工作
 * 
 * @author zhenyonghe
 *
 */
public class SerializeUtil {
	// 序列化
	public static byte[] serialize(Object object) throws IOException {
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try {
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			byte[] bytes = baos.toByteArray();
			return bytes;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (baos != null) {
				baos.close();
			}
			if (oos != null) {
				oos.close();
			}
		}
		return null;

	}

	public static Object unserialize(byte[] bytes) throws IOException {
		ByteArrayInputStream bais = null;
		ObjectInputStream ois = null;
		try {
			bais = new ByteArrayInputStream(bytes);
			ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bais != null) {
				bais.close();
			}
			if (ois != null) {
				ois.close();
			}
		}
		return null;
	}
}
