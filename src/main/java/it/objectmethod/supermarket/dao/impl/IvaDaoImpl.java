package it.objectmethod.supermarket.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Service;

import it.objectmethod.supermarket.dao.IvaDao;
import it.objectmethod.supermarket.model.Iva;
@Service
public class IvaDaoImpl extends NamedParameterJdbcDaoSupport implements IvaDao {
	
	@Autowired
	public IvaDaoImpl(DataSource dataSource)
	{
		super();
		setDataSource(dataSource);
	}

	@Override
	public List<Iva> getIva() {

		String sql = "SELECT * FROM iva;";
		List<Iva> listIva = getJdbcTemplate().query(sql, new BeanPropertyRowMapper<Iva>(Iva.class));
		return listIva;
	}

}
