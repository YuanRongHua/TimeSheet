package yuanronghua.TimeSheet.dao;

import java.util.List;

import yuanronghua.TimeSheet.common.Query;
import yuanronghua.TimeSheet.vo.TimeSheet;

/**
 * @Title: TimeSheetDAO.java
 * @Package yuanronghua.TimeSheet.dao
 * @Description: TODO(用一句话描述该文件做什么)
 * @author wb-yuanronghua
 * @date 2016年1月12日 下午12:42:29
 **/

public interface TimeSheetDAO {

	int queryAllCount();

	List<TimeSheet> query(Query query);

	int add(TimeSheet timeSheet);

	int remove(TimeSheet timeSheet);

	void update(TimeSheet timeSheet);

	List<TimeSheet> queryByDate(Query query);
}
