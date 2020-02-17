package it.objectmethod.supermarket.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.objectmethod.supermarket.dao.ArticleDao;
import it.objectmethod.supermarket.dao.FamAssortDao;
import it.objectmethod.supermarket.dao.IvaDao;
import it.objectmethod.supermarket.model.Article;
import it.objectmethod.supermarket.model.FamAssort;
import it.objectmethod.supermarket.model.Iva;

@Controller
public class ArticleController {

	@Autowired
	private ArticleDao articleDao;
	@Autowired
	private IvaDao ivaDao;
	@Autowired
	private FamAssortDao famDao;

	@RequestMapping("/getArticles")
	public String getArticles(ModelMap model) {
		List<Article> listArticle = new ArrayList<Article>();
		listArticle = articleDao.getArticles();

		model.addAttribute("articleList", listArticle);
		return "home";

	}

	@RequestMapping("/formView")
	public String formView(@RequestParam(value = "getCod", required = false) String getCod, ModelMap model) {
		Article article = null;

		if (getCod != null) {
			article = articleDao.getArticleByCode(getCod);
		}

		List<Iva> listIva;
		List<FamAssort> listFamAssort;

		listIva = ivaDao.getIva();
		listFamAssort = famDao.getFamAssort();
		model.addAttribute("ivaList", listIva);
		model.addAttribute("listFms", listFamAssort);
		model.addAttribute("articleFormRefresh", article);

		return "formIns";
	}

	@RequestMapping("/insArt")
	public String articleIns(@RequestParam("codice") String codArt, @RequestParam("descriz") String descr,
			@RequestParam("pezziCart") Integer pzCart, @RequestParam("iva") Integer iva,
			@RequestParam("fam") Integer fam, ModelMap model) {
		int result = 0;
		String message;

		Article article = new Article();
		article.setCodArt(codArt);
		article.setDescrizione(descr);
		article.setPzCart(pzCart);
		article.setIdIva(iva);
		article.setIdFamAss(fam);

		if (articleDao.getArticleByCode(article.getCodArt()) != null) {
			result = articleDao.update(article);
		} else {
			result = articleDao.insert(article);
		}

		if (result == 1) {
			message = "INSERIMENTO AVVENUTO CON SUCCESSO!";
		} else {
			message = "ERRORE INSERIMENTO!";
		}

		model.addAttribute("message", message);
		return "forward:/getArticles";
	}

}
