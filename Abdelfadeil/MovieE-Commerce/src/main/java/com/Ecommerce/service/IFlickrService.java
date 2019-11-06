package com.Ecommerce.service;

import java.io.InputStream;

import com.Ecommerce.dao.IFlickr;

public interface IFlickrService {


	public String savePhoto(InputStream inputStream, String fileName) throws Exception;
	
}
