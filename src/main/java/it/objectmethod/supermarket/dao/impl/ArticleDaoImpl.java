package it.objectmethod.supermarket.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Service;

import it.objectmethod.supermarket.dao.ArticleDao;
import it.objectmethod.supermarket.model.Article;

@Service
public class ArticleDaoImpl extends NamedParameterJdbcDaoSupport implements ArticleDao {

	@Autowired
	public ArticleDaoImpl(DataSource dataSource) {
		super();
		setDataSource(dataSource);
	}

	@Override
	public List<Article> getArticles() {

		String sql = "select a.CODART as codArt,a.DESCRIZIONE as descrizione,\r\n"
				+ " a.PZCART as pzCart, i.DESCRIZIONE as ivaDesc, f.DESCRIZIONE as famAssDesc, a.IDIVA as idIva, a.IDFAMASS as idFamAss\r\n"
				+ "from articoli a join famassort f on a.IDFAMASS = f.ID \r\n"
				+ "join iva i on a.IDIVA = i.IDIVA limit 200;";
		List<Article> listArticle = getJdbcTemplate().query(sql, new BeanPropertyRowMapper<Article>(Article.class));
		return listArticle;
	}

	@Override
	public int insert(Article article) {
		int resultInsert = 0;

		String sql = "INSERT INTO `alphashop`.`articoli` (`CODART`, `DESCRIZIONE`, `PZCART`, `IDIVA`, `IDFAMASS`) VALUES (:codice, :descriz, :pzcart, :idiva, :idfam);";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("codice", article.getCodArt());
		params.addValue("descriz", article.getDescrizione());
		params.addValue("pzcart", article.getPzCart());
		params.addValue("idiva", article.getIdIva());
		params.addValue("idfam", article.getIdFamAss());
		resultInsert = getNamedParameterJdbcTemplate().update(sql, params);
		return resultInsert;

	}

	@Override
	public int update(Article article) {
		int resultUpdate = 0;

		String sql = "UPDATE articoli SET DESCRIZIONE= :descriz, PZCART= :pzcart, IDIVA= :idiva, IDFAMASS= :idfam WHERE CODART= :codice;";
		MapSqlParameterSource params = new MapSqlParameterSource();

		params.addValue("descriz", article.getDescrizione());
		params.addValue("pzcart", article.getPzCart());
		params.addValue("idiva", article.getIdIva());
		params.addValue("idfam", article.getIdFamAss());
		params.addValue("codice", article.getCodArt());

		resultUpdate = getNamedParameterJdbcTemplate().update(sql, params);

		return resultUpdate;
	}

	@Override
	public Article getArticleByCode(String codArt) {

		Article article = null;

		String sql = "select a.CODART as codArt,a.DESCRIZIONE as descrizione,\r\n"
				+ " a.PZCART as pzCart, i.DESCRIZIONE as ivaDesc, f.DESCRIZIONE as famAssDesc, a.IDIVA as idIva, a.IDFAMASS as idFamAss\r\n"
				+ "from articoli a join famassort f on a.IDFAMASS = f.ID \r\n"
				+ "join iva i on a.IDIVA = i.IDIVA WHERE CODART = ?";
		BeanPropertyRowMapper<Article> rm = new BeanPropertyRowMapper<Article>(Article.class);
		try {
			article = getJdbcTemplate().queryForObject(sql, new Object[] { codArt }, rm);
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}

		return article;
	}

}
