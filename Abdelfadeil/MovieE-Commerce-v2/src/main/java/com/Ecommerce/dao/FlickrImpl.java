package com.Ecommerce.dao;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.AuthInterface;
import com.flickr4java.flickr.auth.Permission;
import com.flickr4java.flickr.uploader.UploadMetaData;
import org.scribe.model.Verifier;

import javax.swing.*;
import java.io.InputStream;

public class FlickrImpl implements IFlickr {

	private Flickr flickr;
	private UploadMetaData uploadeMetaData;
	private String apiKey="61f4aec3f3f1d6c084b0c65b6ee13417";
	private String sharedSecret="3657ccd24a8fad02";


	private void connect() {
		flickr = new Flickr(apiKey, sharedSecret, new REST());
		Auth auth = new Auth();
		auth.setPermission(Permission.READ);
		auth.setToken("");
		auth.setTokenSecret("");
		RequestContext requestContext = RequestContext.getRequestContext();
		requestContext.setAuth(auth);
		flickr.setAuth(auth);
	}

	@Override
	public String savePhoto(InputStream inputStream, String fileName) throws Exception{
		connect();
		uploadeMetaData.setTitle(fileName);
		String photoId = flickr.getUploader().upload(inputStream, uploadeMetaData);
		return flickr.getPhotosInterface().getPhoto(photoId).getMedium640Url();
	}

	public void auth() {
		flickr = new Flickr(apiKey, sharedSecret, new REST());
        AuthInterface authInterface = flickr.getAuthInterface();
        org.scribe.model.Token token = authInterface.getRequestToken();
       System.out.println("Token: "+ token);
        String url= authInterface.getAuthorizationUrl(token, Permission.DELETE);
       System.out.println("flow this url ");
        System.out.println(url);

        String tokenKey= JOptionPane.showInputDialog(null);
       org.scribe.model.Token tokenRequest = authInterface.getAccessToken(token, new Verifier(tokenKey));
      System.out.println("Autentication success");
        Auth auth =null;
        try {
			auth = authInterface.checkToken(tokenRequest);
		} catch (FlickrException e) {
			e.printStackTrace();
		}
	}


}
