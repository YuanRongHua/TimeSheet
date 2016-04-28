package yuanronghua.TimeSheet.dao;

import yuanronghua.TimeSheet.vo.Boss;

/**
 * @Title: BossDAO.java
 * @Package yuanronghua.TimeSheet.dao
 * @Description: TODO(用一句话描述该文件做什么)
 * @author wb-yuanronghua
 * @date 2016年2月2日 下午4:31:50
 **/

public interface BossDAO {

	Boss queryBoss(String boss_name);

	int insertBoss(Boss boss);

}
