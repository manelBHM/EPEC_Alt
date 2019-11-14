package com.Ecommerce.service;

import java.io.InputStream;

public interface IFlickrService {

    public String savePhoto(InputStream inputStream, String fileName) throws Exception;
}
