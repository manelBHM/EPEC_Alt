package com.Ecommerce.dao;

import java.io.InputStream;

public interface IFlickr {

	public String savePhoto(InputStream inputStream, String fileName) throws Exception;
	public void connect();
	public void auth();
}
