package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Offers;

public interface OffersDAO {

	public int newOffer(Offers offer) throws BusinessException;
	public List<Offers> viewAllOffers() throws BusinessException;
	public List<Offers> viewStatus(int offer_id )throws BusinessException;
	public int acceptOffer(int offer_id, int user_id,int months, double rate, int car_id) throws BusinessException;
	
}
