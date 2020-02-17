package it.objectmethod.supermarket.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.objectmethod.supermarket.dao.ArticleDao;
import it.objectmethod.supermarket.model.Article;
import it.objectmethod.supermarket.model.ArticleCart;

@Controller
public class CartController {

	@Autowired
	private ArticleDao articleDao;

	@SuppressWarnings("unchecked")
	@RequestMapping("/addCart")
	public String addToCart(@RequestParam(value = "codArt", required = false) String codArt, ModelMap model,
			HttpServletRequest request) {

		Article article = this.articleDao.getArticleByCode(codArt);
		ArticleCart articleCart = new ArticleCart(article);
		HttpSession session = request.getSession();
		String messageCart = null;
		Map<String, ArticleCart> cart = new HashMap<String, ArticleCart>();
		if (session.getAttribute("cart") != null) {
			cart = (Map<String, ArticleCart>) session.getAttribute("cart");
		}

		if (cart.containsKey(codArt)) {
			articleCart = cart.get(codArt);
		} else {
			article = this.articleDao.getArticleByCode(codArt);

		}
		articleCart.setQuantita(articleCart.getQuantita() + 1);
		cart.put(codArt, articleCart);
		session.setAttribute("cart", cart);
		messageCart = "ARTICOLO AGGIUNTO AL CARRELLO!";

		model.addAttribute("messageInsertCart", messageCart);
		return "forward:/getArticles";
	}

	@RequestMapping("/viewArticlesToCart")
	public String viewCart() {

		return "viewCart";
	}

}
