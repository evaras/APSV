package es.upm.dit.apsv.webLab.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import es.upm.dit.apsv.webLab.dao.model.Publication;
import es.upm.dit.apsv.webLab.dao.model.Researcher;

public class ResearcherDAOImpl implements ResearcherDAO {
	private static ResearcherDAOImpl instance;
	
	private ResearcherDAOImpl () {
	}
	
	public static ResearcherDAOImpl getInstance() {
		if (instance == null)
			instance = new ResearcherDAOImpl();
		return instance;
	}

	@Override
	public Researcher create(Researcher r) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.save(r);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
		return r;

	}

	@Override
	public Researcher read(Researcher r) {
		Session session = SessionFactoryService.get().openSession();
		Researcher res = null; 
		try {
			res = (Researcher) session
					.createQuery("select r from Researcher r where r.id= :id")
					.setParameter("id", r.getId())
					.uniqueResult();
		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
		return res;
	}

	@Override
	public Researcher update(Researcher r) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.update(r);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
		return r;
	}

	@Override
	public Researcher delete(Researcher r) {
		Session session = SessionFactoryService.get().openSession();
		try {
			session.beginTransaction();
			session.delete(r);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
		return r;
	}

	@Override
	public List<Researcher> readAll() {
		Session	session	=	SessionFactoryService.get().openSession();	
	 	List<Researcher>	res	=	new	ArrayList<>();	
	 	try	{	
			res.addAll(session.createQuery("select	r	from	Researcher	r")	
					.getResultList());	
	 	}	catch	(Exception	e)	{	
			throw	e;	
	 	}	finally	{	
			session.close();	
	 	}	
	 	return	res;	
	}
	
	

}
