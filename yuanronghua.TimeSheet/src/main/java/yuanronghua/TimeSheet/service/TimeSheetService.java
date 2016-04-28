package yuanronghua.TimeSheet.service;

import yuanronghua.TimeSheet.common.PageList;
import yuanronghua.TimeSheet.common.Query;
import yuanronghua.TimeSheet.vo.Account;
import yuanronghua.TimeSheet.vo.TimeSheet;

/**
 * @Title: TimeSheetService.java
 * @Package yuanronghua.TimeSheet.service
 * @Description: TODO(用一句话描述该文件做什么)
 * @author wb-yuanronghua
 * @date 2016年1月12日 下午12:49:03
 **/

public interface TimeSheetService {

	public PageList query(Query query);

	public void add(TimeSheet timeSheet);

	public void remove(TimeSheet timeSheet);

	public void update(TimeSheet timeSheet);

	public Account login(Account account);

	public PageList queryByDate(Query query);

}
