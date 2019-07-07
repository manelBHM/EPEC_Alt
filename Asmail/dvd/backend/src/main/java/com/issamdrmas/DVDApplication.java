package com.issamdrmas;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.issamdrmas.dao.CategoryRepository;
import com.issamdrmas.dao.GameRepository;
import com.issamdrmas.dao.MovieRepository;
import com.issamdrmas.dao.MusicRepository;
import com.issamdrmas.dao.UserRepository;
import com.issamdrmas.model.Category;
import com.issamdrmas.model.Customer;
import com.issamdrmas.model.Game;
import com.issamdrmas.model.Movie;
import com.issamdrmas.model.Music;
import com.issamdrmas.model.Product;
import com.issamdrmas.model.User;
import com.issamdrmas.services.ProductService;

@EnableJpaRepositories("com.issamdrmas.dao")
@SpringBootApplication
public class DVDApplication implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private MusicRepository musicRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	ProductService productService;
	
	public static void main(String[] args) {
		SpringApplication.run(DVDApplication.class, args);
		System.out.println("DVD App Started Successfully ...");
	}

	@Override
	public void run(String... args) throws Exception {
		
		User user = new User(null, "username", "firstname", "lastname", "email@gmail");
		User user2 = new User(null, "username2", "firstname2", "lastname2", "email@gmail2");
		User user3 = new User(null, "username3", "firstname3", "lastname3", "email@gmail3");
		userRepository.save(user);
		userRepository.save(user2);
		userRepository.save(user3);
		
		Category categoryMovies = new Category(null, "Movies", new Date(), null, null, null);
		categoryRepository.save(categoryMovies);
		
		Category categoryMusics = new Category(null, "Musics", new Date(), null, null, null);
		categoryRepository.save(categoryMusics);
		
		Category categoryGames = new Category(null, "Games", new Date(), null, null, null);
		categoryRepository.save(categoryGames);
		
		movieRepository.save(new Movie(1L, "Movie 1", "Description", 2.99, 12, "02/04/2019", "https://lesmachinesasous.club/wp-content/uploads/2018/12/basic-instinct-machine-a-sous.jpg", categoryMovies));
		movieRepository.save(new Movie(2L, "Movie 2", "Description", 2.99, 12, "02/04/2019", "https://p.mcdn.fr/files/styles/pano_s/public/images/diaporama/4/4/6/307644/1192335-inline.jpg?itok=VB1Sm9-s", categoryMovies));

		
		Music music1 = new Music(null, "Music 1", "description 1", 1.1, new Date(), categoryMusics);
		Music music2 = new Music(null, "Music 1", "description 1", 1.1, new Date(), categoryMusics);
		musicRepository.save(music1);
		musicRepository.save(music2);
		
		Game game1 = new Game(null, "Game 1", "description 1", 1.1, new Date(), categoryGames);
		Game game2 = new Game(null, "Game 1", "description 1", 1.1, new Date(), categoryGames);
		gameRepository.save(game1);
		gameRepository.save(game2);
		
	    productService.save(new Product(1L, "Best Action Movies", 300.00, "http://www.modelairplane.com/wp-content/plugins/RSSPoster_PRO/cache/1c718_the_lego_movie-200x100-e1418932515884.jpg", 
	    		"Action", "04/07/2019", 4));
        productService.save(new Product(2L, "Best Horror Movies", 200.00, "https://www.lalive.com/assets/img/Movie-Date-200x100.jpg",
        		"Action", "0/5/2019", 10));
        productService.save(new Product(3L, "Netflix could contend", 100.00, "https://newimages-1tmxd3aba43noa.stackpathdns.com/data/thumbs/full/50353/200/100/50/40/arrival-la-premiere.jpg",
        		"Action", "05/07/2019", 22));
        
        productService.save(new Product(4L, "The Best Music", 5.00, "https://thumbs.gfycat.com/WarlikeImpishEchidna-poster.jpg", 
        		"Aew Albom", "05/07/2019", 40));
        productService.save(new Product(5L, "Red for Jackson's", 3.00, "https://www.billboard.com/files/styles/article_main_image/public/stylus/95269-95152-Michael_Jackson_Thriller_album_cover.jpg",
        		"Aew Albom", "05/07/2019", 30));
        productService.save(new Product(6L, "Turn It Up: 10", 500.00, "https://jamaicans.com/wp-content/uploads/s4156~s800x800.jpg",
        		"Aew Albom", "05/07/2019", 20));
        
        productService.save(new Product(7L, "Best video games ", 30.00, "https://www.maketecheasier.com/assets/uploads/2018/05/best-free-linux-games-header-200x100.jpg",
        		"Aew Albom", "05/07/2019", 50));
        productService.save(new Product(8L, "The Best Games", 30.00, "https://incendar.com/images/menu_bdo.jpg", "Aew Albom", "05/07/2019", 10));
        productService.save(new Product(9L, "The Best PS4", 30.00, "https://www.briefingwire.com/pics/930890.jpg", "Aew Albom", "05/07/2019", 32));
		
	}


}
