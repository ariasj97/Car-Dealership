package com.app.service;

import java.util.List;

import com.app.dao.OffersDAO;
import com.app.dao.impl.OffersDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Cars;
import com.app.model.Offers;

public class OffersServiceImpl {

	
	private OffersDAO offersDAO = new OffersDAOImpl();
	
	public int newOffer(Offers offer) throws BusinessException{
		int valid=0;
		try {
			if(offersDAO.newOffer(offer) !=0) {
				valid = 1;
			}
		}catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		return valid;
	}
	
	public List<Offers> viewAllOffers() throws BusinessException {
		List<Offers> allOffers= null;
		allOffers = offersDAO.viewAllOffers();
		return allOffers;
	}
	
	public List<Offers> viewStatus(int offer_id) throws BusinessException {
		List<Offers> allOffers= null;
		allOffers = offersDAO.viewStatus(offer_id);
		return allOffers;
	}
}
