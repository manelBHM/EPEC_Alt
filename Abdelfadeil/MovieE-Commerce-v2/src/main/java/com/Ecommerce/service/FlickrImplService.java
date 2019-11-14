package com.Ecommerce.service;

import com.Ecommerce.dao.FlickrImpl;
import com.Ecommerce.dao.IFlickr;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;

@Service
@Transactional
public class FlickrImplService implements IFlickrService {

    public IFlickr filckr = new FlickrImpl();






    @Override
    public String savePhoto(InputStream inputStream, String fileName) throws Exception {
        return filckr.savePhoto(inputStream, fileName);
    }
}
