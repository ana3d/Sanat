package fi.antti.spring.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.antti.spring.bean.Kayttaja;
import fi.antti.spring.bean.Sana;
import fi.antti.spring.dao.KayttajaDAO;
import fi.antti.spring.dao.SanaDAO;

@Controller
@RequestMapping(value = "/secure")
public class SecureController {
	
	final static Logger logger = LoggerFactory.getLogger(Controller.class);
	
	
	@Inject
	private SanaDAO sdao;
	
	public SanaDAO getDao() {
		return sdao;
	}

	public void setDao(SanaDAO sdao) {
		this.sdao = sdao;
	}
	
	@Inject
	private KayttajaDAO kdao;
	
	public KayttajaDAO getKDao() {
		return kdao;
	}

	public void setKDao(KayttajaDAO kdao) {
		this.kdao = kdao;
	}
	
	

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String paasivu(Model model) {
		
		List<Sana> sanat = sdao.haeKaikki();
		List<Kayttaja> pisteet = kdao.haeKaikki();
		model.addAttribute("sanat", sanat);
		model.addAttribute("pisteet", pisteet);
		logger.info("Haettu kaikki käyttäjät & sanat tietokannasta");
		
		
		
		
		return "secure/main";
	}
	

	
	
	

}
