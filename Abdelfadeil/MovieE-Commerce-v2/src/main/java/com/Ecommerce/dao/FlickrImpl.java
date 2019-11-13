package com.Ecommerce.dao;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.AuthInterface;
import com.flickr4java.flickr.auth.Permission;
import com.flickr4java.flickr.photos.Photo;
import com.flickr4java.flickr.photos.PhotoList;
import com.flickr4java.flickr.photosets.Photoset;
import com.flickr4java.flickr.prefs.PrefsInterface;
import com.flickr4java.flickr.uploader.UploadMetaData;
import com.flickr4java.flickr.uploader.Uploader;
import com.flickr4java.flickr.util.AuthStore;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.model.OAuth1Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FlickrImpl implements IFlickr {

	private static final Logger logger = LoggerFactory.getLogger(FlickrImpl.class);


	private String nsid;

	private String username;

	// private final String sharedSecret;
     @Autowired
	private  Flickr flickr;

	private AuthStore authStore;

	public boolean flickrDebug = false;

	private boolean setOrigFilenameTag = true;

	private boolean replaceSpaces = false;

	private int privacy = -1;

	HashMap<String, Photoset> allSetsMap = new HashMap<String, Photoset>();
	HashMap<String, ArrayList<String>> setNameToId = new HashMap<String, ArrayList<String>>();

	public static final SimpleDateFormat smp = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss a");
	private String setid = null;

	private String basefilename = null;

	private final PhotoList<Photo> photos = new PhotoList<Photo>();

	private final HashMap<String, Photo> filePhotos = new HashMap<String, Photo>();

	private UploadMetaData uploadeMetaData;
	private String apiKey="2d89f8efd8dab32024ceedd381e29e08";
	private String sharedSecret="928bc2bcf01e0b08";

	public FlickrImpl(Flickr flickr) {
		this.flickr = flickr;
	}


	private void connect() {
		flickr = new Flickr(apiKey, sharedSecret, new REST());
		Auth auth = new Auth();
		auth.setPermission(Permission.READ);
		auth.setToken("72157711759371071-4ccecbb17dc313cf");
		auth.setTokenSecret("678de353717b65cb");
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
		OAuth1RequestToken token = authInterface.getRequestToken();
		System.out.println("token: " + token);
        String url= authInterface.getAuthorizationUrl(token, Permission.DELETE);
       System.out.println("flow this url ");
        System.out.println(url);

        String tokenKey= JOptionPane.showInputDialog(null);
		OAuth1Token accessToken = authInterface.getAccessToken(token, tokenKey);
      System.out.println("Autentication success");
		Auth auth = null;
		try {
			auth = authInterface.checkToken(token);
		} catch (FlickrException e) {
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

	private String makeSafeFilename(String input) {
		byte[] fname = input.getBytes();
		byte[] bad = new byte[] { '\\', '/', '"', '*' };
		byte replace = '_';
		for (int i = 0; i < fname.length; i++) {
			for (byte element : bad) {
				if (fname[i] == element) {
					fname[i] = replace;
				}
			}
			if (replaceSpaces && fname[i] == ' ')
				fname[i] = '_';
		}
		return new String(fname);
	}

	public int getPrivacy() throws Exception {

		PrefsInterface prefi = flickr.getPrefsInterface();
		privacy = prefi.getPrivacy();

		return (privacy);
	}
	public String uploadfile(String filename, String inpTitle) throws Exception {
		String photoId;

		RequestContext rc = RequestContext.getRequestContext();

		if (this.authStore != null) {
			Auth auth = this.authStore.retrieve(this.nsid);
			if (auth == null) {
				this.auth();
			} else {
				rc.setAuth(auth);
			}
		}

		// PhotosetsInterface pi = flickr.getPhotosetsInterface();
		// PhotosInterface photoInt = flickr.getPhotosInterface();
		// Map<String, Collection> allPhotos = new HashMap<String, Collection>();
		/**
		 * 1 : Public 2 : Friends only 3 : Family only 4 : Friends and Family 5 : Private
		 **/
		if (privacy == -1)
			getPrivacy();

		UploadMetaData metaData = new UploadMetaData();

		if (privacy == 1)
			metaData.setPublicFlag(true);
		if (privacy == 2 || privacy == 4)
			metaData.setFriendFlag(true);
		if (privacy == 3 || privacy == 4)
			metaData.setFamilyFlag(true);

		if (basefilename == null || basefilename.equals(""))
			basefilename = filename; // "image.jpg";

		String title = basefilename;
		boolean setMimeType = true; // change during testing. Doesn't seem to be supported at this time in flickr.
		if (setMimeType) {
			if (basefilename.lastIndexOf('.') > 0) {
				title = basefilename.substring(0, basefilename.lastIndexOf('.'));
				String suffix = basefilename.substring(basefilename.lastIndexOf('.') + 1);
				// Set Mime Type if known.

				// Later use a mime-type properties file or a hash table of all known photo and video types
				// allowed by flickr.

				if (suffix.equalsIgnoreCase("png")) {
					metaData.setFilemimetype("image/png");
				} else if (suffix.equalsIgnoreCase("mpg") || suffix.equalsIgnoreCase("mpeg")) {
					metaData.setFilemimetype("video/mpeg");
				} else if (suffix.equalsIgnoreCase("mov")) {
					metaData.setFilemimetype("video/quicktime");
				}
			}
		}
		logger.debug(" File : " + filename);
		logger.debug(" basefilename : " + basefilename);

		if (inpTitle != null && !inpTitle.equals("")) {
			title = inpTitle;
			logger.debug(" title : " + inpTitle);
			metaData.setTitle(title);
		} // flickr defaults the title field from file name.

		// UploadMeta is using String not Tag class.

		// Tags are getting mangled by yahoo stripping off the = , '.' and many other punctuation characters
		// and converting to lower case: use the raw tag field to find the real value for checking and
		// for download.
		if (setOrigFilenameTag) {
			List<String> tags = new ArrayList<String>();
			String tmp = basefilename;
			basefilename = makeSafeFilename(basefilename);
			tags.add("OrigFileName='" + basefilename + "'");
			metaData.setTags(tags);

			if (!tmp.equals(basefilename)) {
				System.out.println(" File : " + basefilename + " contains special characters.  stored as " + basefilename + " in tag field");
			}
		}

		// File imageFile = new File(filename);
		// InputStream in = null;
		Uploader uploader = flickr.getUploader();

		// ByteArrayOutputStream out = null;
		try {
			// in = new FileInputStream(imageFile);
			// out = new ByteArrayOutputStream();

			// int b = -1;
			/**
			 * while ((b = in.read()) != -1) { out.write((byte) b); }
			 **/

			/**
			 * byte[] buf = new byte[1024]; while ((b = in.read(buf)) != -1) { // fos.write(read); out.write(buf, 0, b); }
			 **/

			metaData.setFilename(basefilename);
			// check correct handling of escaped value

			File f = new File(filename);
			photoId = uploader.upload(f, metaData);

			logger.debug(" File : " + filename + " uploaded: photoId = " + photoId);
		} finally {

		}

		return (photoId);
	}

}
