package service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bean.BusInfoBean;
import bean.CrowdedBean;

@Service
public class BusService {

	@Autowired
	private SqlSession sqlSession;

	public void busInsert(String carNo, int oneValue) {
		CrowdedBean bean = new CrowdedBean(carNo, oneValue);
		sqlSession.insert("busSQL.busInsert", bean);
	}

	public List<CrowdedBean> busGetAll(CrowdedBean bean) {
		List<CrowdedBean> list = sqlSession.selectList("busSQL.busList",bean);
		return list;
	}

	public int busGetCrowded(String carNo) {
		int i = sqlSession.selectOne("busSQL.busSelect", carNo);
		return i;
	}

	public boolean busCarNo(String carNo) {
		boolean bool= false;
		if(sqlSession.selectOne("busSQL.busBool", carNo) != null) {
			bool =true;
			System.out.println(sqlSession.selectOne("busSQL.busBool", carNo).toString());
		}
		return bool;
	}

	public void busCrowdedUpdate(CrowdedBean bean) {
		sqlSession.update("busSQL.busUpdate", bean);
	}
}
