package es.upm.dit.apsv.webLab.dao;

import org.hibernate.Session;

import es.upm.dit.apsv.webLab.dao.model.Publication;

public class PublicationDAOImpl implements PublicationDAO{
	
	private static PublicationDAOImpl instance;
	
	private PublicationDAOImpl () {
	}
	
	public static PublicationDAOImpl getInstance() {
		if (instance == null)
			instance = new PublicationDAOImpl();
		return instance;
	}
	
	@Override
	public Publication create(Publication p) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(p);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
		return p;
	}

	@Override
	public Publication read(Publication p) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			Publication pub = (Publication) session
					.createQuery("select p from Researcher p where p.id= :id")
					.setParameter("id", p.getId())
					.uniqueResult();

			session.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
		return p;
	}

	@Override
	public Publication update(Publication p) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(p);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
		return p;
	}

	@Override
	public Publication delete(Publication p) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(p);;
			session.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
		return p;
	}

}
