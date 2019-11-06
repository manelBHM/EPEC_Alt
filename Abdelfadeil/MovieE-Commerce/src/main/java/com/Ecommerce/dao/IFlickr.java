package com.Ecommerce.dao;

import java.io.InputStream;
import com.flickr4java.flickr.test.*;
public interface IFlickr {

	public String savePhoto(InputStream inputStream, String fileName) throws Exception;

}
