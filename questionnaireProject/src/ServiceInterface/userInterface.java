package ServiceInterface;

import java.util.List;

public interface userInterface {
	public boolean addUser(Object obj);
	public List<Object> selectUser(String sql,Object obj);
	public boolean deleteUser(String str);
}
