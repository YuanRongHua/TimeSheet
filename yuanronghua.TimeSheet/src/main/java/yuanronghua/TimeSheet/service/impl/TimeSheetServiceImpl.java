package yuanronghua.TimeSheet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yuanronghua.TimeSheet.common.PageList;
import yuanronghua.TimeSheet.common.Query;
import yuanronghua.TimeSheet.dao.AccountDAO;
import yuanronghua.TimeSheet.dao.BossDAO;
import yuanronghua.TimeSheet.dao.TimeSheetDAO;
import yuanronghua.TimeSheet.service.TimeSheetService;
import yuanronghua.TimeSheet.vo.Account;
import yuanronghua.TimeSheet.vo.Boss;
import yuanronghua.TimeSheet.vo.TimeSheet;

/**
 * @Title: TimeSheetServiceImpl.java
 * @Package yuanronghua.TimeSheet.service.impl
 * @Description: TODO(用一句话描述该文件做什么)
 * @author wb-yuanronghua
 * @date 2016年1月12日 下午12:54:34
 **/
@Service
public class TimeSheetServiceImpl implements TimeSheetService {

	@Autowired
	private TimeSheetDAO timeSheetDAO;

	@Autowired
	private AccountDAO accountDAO;

	@Autowired
	private BossDAO bossDAO;

	public PageList query(Query query) {
		PageList pageList = new PageList();
		int count = timeSheetDAO.queryAllCount();
		List<TimeSheet> list = timeSheetDAO.query(query);
		pageList.setCount(count);
		pageList.setList(list);
		return pageList;
	}

	public void add(TimeSheet timeSheet) {
		Boss boss = null;
		boss = bossDAO.queryBoss(timeSheet.getBoss_name());
		if (boss == null) {
			boss = new Boss();
			boss.setName(timeSheet.getBoss_name());
			bossDAO.insertBoss(boss);
		}
		timeSheet.setBoss_id(boss.getId());
		timeSheetDAO.add(timeSheet);
	}

	public void remove(TimeSheet timeSheet) {
		timeSheetDAO.remove(timeSheet);

	}

	public void update(TimeSheet timeSheet) {
		Boss boss = null;
		boss = bossDAO.queryBoss(timeSheet.getBoss_name());
		if (boss == null) {
			boss = new Boss();
			boss.setName(timeSheet.getBoss_name());
			bossDAO.insertBoss(boss);
		}
		timeSheet.setBoss_id(boss.getId());
		timeSheetDAO.update(timeSheet);
	}

	public Account login(Account account) {
		return accountDAO.query(account);
	}

	@Override
	public PageList queryByDate(Query query) {
		PageList pageList = new PageList();
		List<TimeSheet> list = timeSheetDAO.queryByDate(query);
		pageList.setList(list);
		pageList.setCount(list.size());
		return pageList;

	}
}
