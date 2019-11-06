package com.Ecommerce;
import com.flickr4java.flickr.*;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.AuthInterface;
import com.flickr4java.flickr.auth.Permission;
import com.flickr4java.flickr.uploader.UploadMetaData;
import com.flickr4java.flickr.util.IOUtilities;
import com.github.scribejava.core.model.OAuth1RequestToken;
import com.github.scribejava.core.model.OAuth1Token;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import com.Ecommerce.dao.FlickrImpl;

public class test {

	private static Flickr flickr;
	private UploadMetaData uploadeMetaData;
	private static String apiKey="fd350110ecff1d0bf11802f17cad9633";
	private static String sharedSecret="5046444f4d810a0c";
	
	
	public static void auth() throws IOException, FlickrException, ExecutionException, InterruptedException {
        InputStream in = null;
      

        Flickr flickr = new Flickr(apiKey, sharedSecret, new REST());
        Flickr.debugStream = false;
        AuthInterface authInterface = flickr.getAuthInterface();

        Scanner scanner = new Scanner(System.in);

        OAuth1RequestToken requestToken = authInterface.getRequestToken();
        System.out.println("token: " + requestToken);

        String url = authInterface.getAuthorizationUrl(requestToken, Permission.DELETE);
        System.out.println("Follow this URL to authorise yourself on Flickr");
        System.out.println(url);
        System.out.println("Paste in the token it gives you:");
        System.out.print(">>");

        String tokenKey = scanner.nextLine();
        scanner.close();

        OAuth1Token accessToken = authInterface.getAccessToken(requestToken, tokenKey);
        System.out.println("Authentication success");

        Auth auth = authInterface.checkToken(accessToken);

        // This token can be used until the user revokes it.
        System.out.println("Token: " + accessToken.getToken());
        System.out.println("Secret: " + accessToken.getTokenSecret());
        System.out.println("nsid: " + auth.getUser().getId());
        System.out.println("Realname: " + auth.getUser().getRealName());
        System.out.println("Username: " + auth.getUser().getUsername());
        System.out.println("Permission: " + auth.getPermission().getType());
    }

    public static void main(String[] args) {
        try {
        	test.auth();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
	
	
	
	

	

}
