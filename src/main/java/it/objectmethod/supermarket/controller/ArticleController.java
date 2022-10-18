package it.objectmethod.supermarket.controller;

import java.util.ArrayList;
import java.util.List;

import it.objectmethod.supermarket.constants.UtilityConstants;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private IvaDao ivaDao;
    @Autowired
    private FamAssortDao famDao;

    @RequestMapping("/get")
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

        List<FamAssort> listFamAssort;

        List<Iva> listIva = ivaDao.getIva();
        listFamAssort = famDao.getFamAssort();
        model.addAttribute("ivaList", listIva);
        model.addAttribute("listFms", listFamAssort);
        model.addAttribute("articleFormRefresh", article);

        return "formIns";
    }

    @RequestMapping("/save")
    public String articleIns(@RequestParam("codice") String codArt, @RequestParam("descriz") String descr,
                             @RequestParam("pezziCart") Integer pzCart, @RequestParam("iva") Integer iva,
                             @RequestParam("fam") Integer fam, ModelMap model) {
        int result = 0;
        String message;

        Article article = Article.builder()
                .codArt(codArt)
                .descrizione(descr)
                .pzCart(pzCart)
                .idFamAss(fam)
                .build();

        if (articleDao.getArticleByCode(codArt) != null) {
            result = articleDao.update(article);
        } else {
            result = articleDao.insert(article);
        }

        if (result == 1) {
            message = UtilityConstants.INSERT_OK;
        } else {
            message = UtilityConstants.INSERT_ERROR;
        }

        model.addAttribute("message", message);
        return "forward:/getArticles";
    }

}
