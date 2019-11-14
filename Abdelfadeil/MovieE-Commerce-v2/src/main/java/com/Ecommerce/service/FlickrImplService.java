package com.Ecommerce.service;

import com.Ecommerce.dao.IFlickr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.InputStream;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = IOException.class)
public class FlickrImplService implements IFlickrService {


    public IFlickr flickr;

    @Autowired
    public IFlickr getFlickr() {
        return this.flickr;
    }

    @Override
    public String savePhoto(InputStream inputStream, String fileName) throws Exception {
        return flickr.savePhoto(inputStream, fileName);
    }
}
