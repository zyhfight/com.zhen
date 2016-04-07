package ServiceInterface;

import java.util.*;


public interface questionnaireInterface {
	public boolean insertRecord(String sql);
	public List<Object> selectRecord(String sql);

}
