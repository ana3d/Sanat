-- MUISTA! console encoding latin1

INSERT INTO
	authority
VALUES
	(2,'ROLE_ADMIN'),
	(1,'ROLE_USER');
	

INSERT INTO
	webuser2
VALUES
	(1,'matti','1b320d1d4fca16462b0052e2b465c56d1111f6153670c73409e1d0b7b1f7867ff97fa12c1d465f35',1,'Matti','Meikkis'),
	(2,'aada','7fc74013565cfcf10dd379f964215c866627cdfcf2606ade05323d1273456f6915c2d73cde88e24b',1,'Aada','Admini'),
	(3,'sulkis','ed76cc1f4065d274332dfc909b6a6043e3734d2fb86d53ca6d170bd72a588ff82f7658f56c99ec08', 1, 'Sulkis', 'Kuppi'),
	(4,'anttiryokkynen', '2d7c081a82d29d9ea3ef26a012391cff62436166d31c99269d1d2e296ed1fdf331e63a35bdd189f2', 1, 'Antti', 'Ryökkynen'),
	(5,'sanat', '4be4fbfb99cca8e099c5a52aedfb1cda16180df232a5394e19cb5614265077226493d43c2ea60c2e', 1, 'Sana', 'Sovellus');
	
	
INSERT INTO
	webuser2_authority
VALUES
	(1,1,1),
	(2,2,1),
	(3,2,2),
	(4,3,1),
	(5,4,1),
	(6,5,1);
	
INSERT INTO sana_henkilot (nimi)
	VALUES
	("Antti"),
	("Mikko"),
	("Joonas");
	
INSERT INTO 
	sanat (aika, sana, seloste, kayttaja_id)
VALUES
	(now(), "duck", "ankka", 1),
	(now(), "goose", "hanhi", 1),
	(now(), "cat", "kissa", 2),
	(now(), "application", "ohjelmisto", 3);
	
-- Hae käyttäjien sanamäärä
SELECT t2.id id, t2.nimi nimi, COUNT(kayttaja_id) AS lkm 
FROM sanat t1 
JOIN sana_henkilot t2 ON t2.id = kayttaja_id
GROUP BY kayttaja_id ORDER BY lkm DESC;

-- Hae sanat käyttäjittäin.
SELECT t1.id, aika, sana, seloste, t2.nimi nimi 
FROM sanat t1
JOIN sana_henkilot t2 ON kayttaja_id = t2.id;







