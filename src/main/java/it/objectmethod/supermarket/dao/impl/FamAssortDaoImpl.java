package it.objectmethod.supermarket.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Service;

import it.objectmethod.supermarket.dao.FamAssortDao;
import it.objectmethod.supermarket.model.FamAssort;
@Service
public class FamAssortDaoImpl extends NamedParameterJdbcDaoSupport implements FamAssortDao {
	
	@Autowired
	public FamAssortDaoImpl(DataSource dataSource)
	{
		super();
		setDataSource(dataSource);
	}

	@Override
	public List<FamAssort> getFamAssort() {

		String sql = "SELECT * FROM famassort;";
		List<FamAssort> listFamAss = getJdbcTemplate().query(sql,
				new BeanPropertyRowMapper<FamAssort>(FamAssort.class));
		return listFamAss;
	}

}
