package com.Ecommerce.dao;

import java.io.InputStream;

import javax.swing.JOptionPane;


import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.flickr4java.flickr.*;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.AuthInterface;
import com.flickr4java.flickr.auth.Permission;
import com.flickr4java.flickr.uploader.UploadMetaData;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.model.OAuth1Token;

import antlr.Token;

public class FlickrImpl extends Flickr implements IFlickr {

	public FlickrImpl(String apiKey, String sharedSecret, Transport transport) {
		super(apiKey, sharedSecret, transport);
		// TODO Auto-generated constructor stub
	}

	private static Flickr flickr;
	private UploadMetaData uploadeMetaData;
	private String apiKey="61f4aec3f3f1d6c084b0c65b6ee13417";
	private String sharedSecret="3657ccd24a8fad02";
	
	
	private void connect() {
		flickr = new Flickr(apiKey, sharedSecret, new REST());
		Auth auth = new Auth();
		auth.setPermission(Permission.READ);
		auth.setToken("72157711105036826-9a17bec703b20a2e");
		auth.setTokenSecret("f00f5f50bb6bd08f");
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
	
	public  void auth() {
		flickr = new Flickr(apiKey, sharedSecret, new REST());
		 Flickr.debugStream = false;
        AuthInterface authInterface = flickr.getAuthInterface();
        OAuth1RequestToken requestToken = authInterface.getRequestToken();
        System.out.println("token: " + requestToken);
        String url = authInterface.getAuthorizationUrl(requestToken, Permission.DELETE);
        System.out.println("Follow this URL to authorise yourself on Flickr");
        System.out.println(url);
        System.out.println("Paste in the token it gives you:");
        System.out.print(">>");

        OAuth1Token accessToken = authInterface.getAccessToken(requestToken, apiKey);
        System.out.println("Authentication success");
        Auth auth=null;
		try {
			auth = authInterface.checkToken(accessToken);
		} catch (FlickrException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // This token can be used until the user revokes it.
        System.out.println("Token: " + accessToken.getToken());
        System.out.println("Secret: " + accessToken.getTokenSecret());
        System.out.println("nsid: " + auth.getUser().getId());
        System.out.println("Realname: " + auth.getUser().getRealName());
        System.out.println("Username: " + auth.getUser().getUsername());
        System.out.println("Permission: " + auth.getPermission().getType());
    
      
	}
	
	
	
	
}
