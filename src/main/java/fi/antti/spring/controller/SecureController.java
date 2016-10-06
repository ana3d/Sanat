package fi.antti.spring.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		List<Kayttaja> pisteet = kdao.haeKaikkiPisteet();
		model.addAttribute("sanat", sanat);
		model.addAttribute("pisteet", pisteet);
		logger.info("Haettu kaikki k‰ytt‰j‰t & sanat tietokannasta");

		return "secure/main";
	}
	
	@RequestMapping(value = "/LisaaUusiKayttaja", method = RequestMethod.GET)
	public String lisaaKayttajaGET( @ModelAttribute(value="kayttaja") @Valid Kayttaja kayttaja, BindingResult result, Model model) {
		
			return "secure/addUser";

	}	
	
	@RequestMapping(value = "/LisaaUusiKayttaja", method = RequestMethod.POST)
	public String lisaaKayttaja( @ModelAttribute(value="kayttaja") @Valid Kayttaja kayttaja, BindingResult result, Model model) {
		
		List<Sana> sanat = sdao.haeKaikki();
		List<Kayttaja> pisteet = kdao.haeKaikkiPisteet();
		model.addAttribute("sanat", sanat);
		model.addAttribute("pisteet", pisteet);	
		kdao.talleta(kayttaja);
		logger.info("Haettu kaikki sanat & k‰ytt‰jien pisteet tietokannasta");
		
		
		if (result.hasErrors()) {
			
			logger.info("Joku kentt‰ ei mennyt l‰pi validoinnista");
			return "secure/addUser";
		} else {
			
			logger.info("Lis‰‰ uusi paino nappia on painettu. Tuupataan tietokantaan");
			return "secure/main";
		}
	}
	
	
	@RequestMapping(value = "/LisaaSana", method = RequestMethod.GET)
	public String lisaaSanaGET( @ModelAttribute(value="sana") @Valid Sana sana, BindingResult result, Model model) {
		
			List<Kayttaja> kayttajat = kdao.haeKaikkiKayttajat();
			model.addAttribute("kayttajat", kayttajat);
			return "secure/addWord";

	}	
	
	@RequestMapping(value = "/LisaaSana", method = RequestMethod.POST)
	public String lisaaSana( @ModelAttribute(value="sana") @Valid Sana sana, BindingResult result, Model model) {
		
		List<Sana> sanat = sdao.haeKaikki();
		List<Kayttaja> pisteet = kdao.haeKaikkiPisteet();
		List<Kayttaja> kayttajat = kdao.haeKaikkiKayttajat();
		model.addAttribute("sanat", sanat);
		model.addAttribute("pisteet", pisteet);
		model.addAttribute("kayttajat", kayttajat);
		logger.info("Haettu kaikki sanat & k‰ytt‰j‰ien pisteet tietokannasta");
		
		
		if (result.hasErrors()) {
			logger.info("Joku kentt‰ ei mennyt l‰pi validoinnista");
			
			return "secure/addWord";
		} else {
			sdao.talleta(sana);
			logger.info("Lis‰‰ uusi paino nappia on painettu. Tuupataan tietokantaan");
			return "secure/main";
		}
	}
	

	
	
	

}
