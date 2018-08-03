package com.db.mybatis.biz;

import com.db.mybatis.dao.LotteryMapper;
import com.db.mybatis.model.Lottery;

import java.util.List;

public class LotteryService extends BaseService {
	private LotteryMapper lotteryDao;
	
	protected LotteryMapper getLotteryDao() {
		return lotteryDao;
	}
	
	protected void setLotteryDao(LotteryMapper lotteryDao) {
		this.lotteryDao = lotteryDao;
	}
	
	public LotteryService() {
		super();
		this.setLotteryDao(this.getSqlSession().getMapper(LotteryMapper.class));
	}
	
	public Lottery getLotterById(int id) {
		try {
			return this.getLotteryDao().selectByPrimaryKey(id);
		} finally {
			this.getSqlSession().close();
		}
		
	}
	
	public int getLotterMaxId() {
		try {
			return this.getLotteryDao().selectMaxId();
		} finally {
			this.getSqlSession().close();
		}
	}
	
	public Lottery getLotteryByLotteryNo(Integer lotteryNo) {
		try {
			return this.getLotteryDao().selectByLotteryNo(lotteryNo);
		} finally {
			this.getSqlSession().close();
		}
		
	}
	
	public int insertLottery(Lottery lottery) {
		try {
			return this.getLotteryDao().insert(lottery);
		} finally {
			this.getSqlSession().commit();
			this.getSqlSession().close();
		}
		
	}
	
	public int insertLotteryList(List<Lottery> lotterys) {
		try {
			int insert = 0;
			for (Lottery lottery : lotterys) {
				insert += this.getLotteryDao().insert(lottery);
			}
			return insert;
		} finally {
			this.getSqlSession().commit();
			this.getSqlSession().close();
		}
		
	}
	
	/**
	 * 获得n期数据
	 *
	 * @param n
	 * @return
	 */
	public List<Lottery> getTopLotteryList(int n) {
		int maxId = this.getLotteryDao().selectMaxId();
		int startId = maxId - n;
		List<Lottery> lotteries = this.getLotteryDao().selectListById(startId);
		return lotteries;
	}
	
	/**
	 * 获得startId以后的数据
	 *
	 * @param startId
	 * @return
	 */
	public List<Lottery> getTopLotteryListById(int startId) {
		
		List<Lottery> lotteries = this.getLotteryDao().selectListById(startId);
		return lotteries;
	}
	
	/**
	 * 根据id 以前的第n期的数据
	 *
	 * @param id
	 * @param n
	 * @return
	 */
	public List<Lottery> getTopLotteryListByRange(int id, int n) {
		int startId = id - n;
		List<Lottery> lotteries = this.getLotteryDao().selectListByRange(startId, id);
		return lotteries;
	}
	
	/**
	 * 根据lotteryNo获得以前n期数据
	 *
	 * @param lotterNo
	 * @param n
	 * @return
	 */
	public List<Lottery> getTopLotteryListByLotteryNo(int lotterNo, int n) {
		int endId = this.getLotteryByLotteryNo(lotterNo).getId();
		int startId = endId - n;
		List<Lottery> lotteries = this.getLotteryDao().selectListByRange(startId, endId);
		return lotteries;
	}
	
	/**
	 * 获得当前期以后的数据
	 *
	 * @param lotterNo
	 * @return
	 */
	public List<Lottery> getTopLotteryListByLotterNo(int lotterNo) {
		Lottery lottery = this.getLotteryDao().selectByLotteryNo(lotterNo);
		List<Lottery> lotteries = this.getLotteryDao().selectListById(lottery.getId());
		return lotteries;
	}
}
