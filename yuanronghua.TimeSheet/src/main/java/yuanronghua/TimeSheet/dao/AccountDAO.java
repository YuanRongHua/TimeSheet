package yuanronghua.TimeSheet.dao;

import yuanronghua.TimeSheet.vo.Account;

/**
 * @Title: AccountDAO.java
 * @Package yuanronghua.TimeSheet.dao
 * @Description: TODO(用一句话描述该文件做什么)
 * @author wb-yuanronghua
 * @date 2016年2月1日 下午1:02:31
 **/

public interface AccountDAO {
	Account query(Account account);
}
