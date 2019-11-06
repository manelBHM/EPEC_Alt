package com.Ecommerce.service;

import java.io.InputStream;

import com.Ecommerce.dao.IFlickr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IFlickrServiceImpl implements IFlickrService {


	private IFlickr myFlickr;

	@Override
	public String savePhoto(InputStream inputStream, String fileName) throws Exception {
		return myFlickr.savePhoto(inputStream, fileName);
	}

}
