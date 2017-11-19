package es.upm.dit.apsv.webLab.dao;

import es.upm.dit.apsv.webLab.dao.model.Publication;

public interface PublicationDAO {
		public	Publication	create(Publication	p);	
		public	Publication	read(Publication	p);	
		public	Publication	update(Publication	p);	
		public	Publication	delete(Publication	p);	
}

