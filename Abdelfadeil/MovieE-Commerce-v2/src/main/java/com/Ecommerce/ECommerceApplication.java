package com.Ecommerce;

import com.Ecommerce.dao.*;
import com.Ecommerce.entities.*;
import com.Ecommerce.service.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class ECommerceApplication implements CommandLineRunner {

	@Autowired
	private RepositoryRestConfiguration config;
	@Autowired
	private ArticleRespository articleRespository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private AccountServiceImpl accountService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private AdresseRepository adresseRepository;
	@Autowired
	private PanierRepository panierRepository;
	@Autowired
	private LigneCommandeRespository ligneCommandeRespository;
	@Autowired
	private PanierService panierService;
    @Autowired
    public SendingMailService emailService;
    @Autowired
    public CommandeRepository commandeRepository;
    @Autowired
	private ICommande commande;
	@Autowired
	private MouvStockService mouvStockService;
	@Autowired
	public MovementStockRepository stockRepository;

    @Autowired
    public IArticleService articleService;

	static Logger logger = Logger.getLogger(ECommerceApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}

	// @Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ECommerceApplication.class);
	}

	@Override
	public void run(String... args) throws Exception {



	//flickr.auth();
/*
		Panier p = new Panier();

		AppRole role2 = new AppRole();
		AppRole role1 = new AppRole();
		role1.setRoleName("USER");
		role2 = roleRepository.save(role1);
		role2.setRoleName("ADMIN");
		role1 =roleRepository.save(role2);

		//UserForm user = new UserForm();
		AppUser user = new AppUser();
		user.setUsername("admin");
		user.setPassword(bCryptPasswordEncoder.encode("1234"));
		user.setCredentialsNonExpired(true);
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setIsActive(true);
		user.setEmail("abdalfadeil@gmail.com");
		logger.debug("main class");
		user.getRoles().add(role1);
		user.getRoles().add(role2);
		user = userRepository.save(user);
		p.setUser(user);

		p=panierRepository.save(p);
		user=userRepository.save(user);
		System.out.println(user);
		System.out.println(p);

		Article a1 = new Article();
		Article a2 = new Article();
        a1.setPrix(40);
		a2.setPrix(20);
        a1.setQuantity(15);
        a2.setQuantity(15);

            a1 = articleService.AddArticle(a1);
            a2 = articleService.AddArticle(a2);


        mouvStockService.enteeArticle(a1);
		mouvStockService.enteeArticle(a2);

        panierService.AddArticlePanier( user.getUsername(), a1);
        panierService.AddArticlePanier( user.getUsername(), a2);
    /*

    Commande c = new Commande();
		c= commandeRepository.save(c);
        c.setAppUser(user);
        c.setArticles(p.getItems());
        c = commandeRepository.save(c);
     */
	/*	Commande c = commande.passerCommande("admin");
		System.out.println("///////*******/////////// la commande ");
	/*	System.out.println(c);
		System.out.println("///////*******/////////// la total de la commande  ");
		//System.out.println(commande.getTotal(c));
		//UserForm userForm
		//System.out.println(p);
		//p=panierRepository.findByUserId(user.getId());
		/*System.out.println("p.getItems() *****************");
		System.out.println("Id de panier    "+p.getId() + "  Id de user   "+user.getId());
		System.out.println(p.getItems());
		//accountService.saveUser(user);
		System.out.println("/////////// comandes ///////////");
        System.out.println(commande.getAllCommandesClient("admin"));


        ///////////////////////////
		Panier p1 = new Panier();
*/




		//UserForm user = new UserForm();
	/*	AppUser user1 = new AppUser();
		user1.setUsername("user");
		user1.setPassword(bCryptPasswordEncoder.encode("1234"));
		user1.setCredentialsNonExpired(true);
		user1.setAccountNonExpired(true);
		user1.setAccountNonLocked(true);
		user1.setIsActive(true);
		user1.setEmail("abcd@gmail.com");
		logger.debug("main class");
		user1.getRoles().add(role2);
		user1 = userRepository.save(user1);
		p1.setUser(user1);

		p1=panierRepository.save(p1);
		user1=userRepository.save(user1);
		System.out.println(user1);
		System.out.println(p1);


		LigneCommande l11 = new LigneCommande();
		LigneCommande l21 = new LigneCommande();
		l11.setQuantite(2);
		l21.setQuantite(2);

		l11.setArticle(a1);
		l21.setArticle(a2);

		l11 = ligneCommandeRespository.save(l11);
		l21 = ligneCommandeRespository.save(l21);

		p1.getItems().put(l11.getIdLigneCommande(), l11);
		p1.getItems().put(l21.getIdLigneCommande(), l21);

		p1= panierRepository.save(p1);
		*/
    /*

    Commande c = new Commande();
		c= commandeRepository.save(c);
        c.setAppUser(user);
        c.setArticles(p.getItems());
        c = commandeRepository.save(c);
     */
	/*	C ommande c1 = commande.passerCommande("user");
		System.out.println("///////*******/////////// la commande user");
	/*	System.out.println(c1);
		System.out.println("///////*******/////////// la total de la commande user ");
	/*	System.out.println(commande.getTotal(c1));
		//UserForm userForm
		System.out.println(p1);
		p1=panierRepository.findByUserId(user1.getId());
		System.out.println("p1.getItems() *****************");
		System.out.println("Id de panier 1    "+p1.getId() + "  Id de user  user "+user1.getId());
		System.out.println(p1.getItems());
		//accountService.saveUser(user);
		System.out.println("/////////// comandes user ///////////");
		System.out.println(commande.getAllCommandesClient("user"));

		////////////////////////////////
		System.out.println("/////////// mouvement de stock ///////////");
		List<MouvementStock> mvs = stockRepository.findAll();
		mvs.forEach(m-> {
			System.out.println(m.toString());
		});

		a1.setQuantity(15);
		a2.setQuantity(15);

		 a1 = articleService.AddArticle(a1);
		a2 = articleService.AddArticle(a2);

		System.out.println("/////////// Articles ///////////");
		List<Article> aticles = articleRespository.findAll();
		aticles.forEach(a-> {
			System.out.println(a.toString());
		});

        logger.debug("msg de debogage");
		logger.info("msg d'information");
		logger.warn("msg d'avertissement");
		logger.error("msg d'erreur");
		logger.fatal("msg d'erreur fatale");
****/
		/*
		 * AppUser user=userRepository.getOne((long) 3);
		 * 
		 * Panier p= panierRepository.getOne(1l); LigneCommande arCom = null;
		 * List<LigneCommande> articles =(List<LigneCommande>) p.getItems();
		 * 
		 * for (int i = 0; i < articles.size(); i++) {
		 * System.out.println(articles.get(i).getIdLigneCommande()+
		 * " "+articles.get(i).getQuantite()+" "+articles.get(i).getArticle().getName())
		 * ; }
		 */
			
		/*
		 * System.out.println(user); user.getRoles().clear(); userRepository.save(user);
		 * System.out.println("user 3 "+user); //userRepository.delete(user);
		 * 
		 * System.out.println("user 3 after deleted "+userRepository.getOne((long) 3));
		 */
		/*
		 * Adresse a1 = new Adresse(); Adresse a2 = new Adresse(); Adresse a3 = new
		 * Adresse(); Adresse a4 = new Adresse(); Adresse a5 = new Adresse();
		 * 
		 * a1.setPays("Italie"); a1.setVille("Rome"); a2.setPays("France");
		 * a2.setVille("Paris"); a3.setPays("Soudan"); a3.setVille("Khartoum");
		 * a4.setPays("Espagne"); a4.setVille("Madrid"); a5.setPays("Quatar");
		 * a5.setVille("Doha");
		 * 
		 * adresseRepository.save(a1); adresseRepository.save(a2);
		 * adresseRepository.save(a3); adresseRepository.save(a4);
		 * adresseRepository.save(a5);
		 * 
		 * 
		 * Panier p1 = new Panier(); Panier p2 = new Panier(); Panier p3 = new Panier();
		 * Panier p4 = new Panier(); Panier p5 = new Panier();
		 * 
		 * panierRepository.save(p1); panierRepository.save(p2);
		 * panierRepository.save(p3); panierRepository.save(p4);
		 * panierRepository.save(p5);
		 * 
		 * 
		 * 
		 * AppRole r1 = new AppRole(null, "USER"); AppRole r2 = new AppRole(null,
		 * "ADMIN"); accountService.saveRole(r1); accountService.saveRole(r2);
		 * 
		 * AppUser u1 = new AppUser(); AppUser u2 = new AppUser();
		 * 
		 * u1.setUsername("admin"); u1.setPassword("1234"); u2.setUsername("user");
		 * u2.setPassword("1234");
		 * 
		 * accountService.saveUser(u1); accountService.saveUser(u2);
		 * 
		 * 
		 * 
		 * u1.getAdresses().add(a1); u1.getAdresses().add(a2); u1.getAdresses().add(a5);
		 * 
		 * u2.getAdresses().add(a3); u2.getAdresses().add(a4);
		 * 
		 * adresseRepository.save(a1); adresseRepository.save(a2);
		 * adresseRepository.save(a3); adresseRepository.save(a4);
		 * adresseRepository.save(a5);
		 * 
		 * 
		 * accountService.saveUser(u1); accountService.saveUser(u2);
		 * 
		 * 
		 * accountService.addRoleToUser(u1.getUsername(), r1.getRoleName());
		 * accountService.addRoleToUser(u1.getUsername(), r2.getRoleName());
		 * accountService.addRoleToUser(u2.getUsername(), r2.getRoleName());
		 * 
		 * 
		 * u1.setPanier(p1); u2.setPanier(p2);
		 * 
		 * 
		 * 
		 * accountService.saveUser(u1); accountService.saveUser(u2);
		 */
		
		/*
		 * Random rn = new Random();
		 * 
		 * for (int i = 0; i < 3; i++) { Category c1 = new Category();
		 * c1.setName(rn.toString()); c1.setDescription(rn.toString());
		 * categoryRepository.save(c1);
		 * 
		 * for (int x = 0; x < 10; x++) { Article a = new Article();
		 * a.setName(rn.toString()); a.setDescription(rn.toString());
		 * a.setPrice(rn.nextInt()*100); a.setQuantity(rn.nextInt()); a.setCategory(c1);
		 * articleRespository.save(a);
		 * 
		 * }
		 * 
		 * }
		 * 
		 * for (int i = 0; i < 10; i++) {
		 * 
		 * LigneCommande lc1 = new LigneCommande(); lc1.setPrix(100);
		 * lc1.setQuantite(99); ligneCommandeRespository.save(lc1); Article ar = new
		 * Article(); articleRespository.save(ar); Article a =
		 * articleRespository.getOne(i+1L); lc1.setArticle(a); lc1.setPrix(452);
		 * lc1.setQuantite(854); LigneCommande lc = panierService.AddArticlePanier(lc1,
		 * 1L); }
		 */

		// panierService.AddArticle(lc, 1L);
		// System.out.println(lc.getIdLigneCommande() +" : "+lc.getPrix() +" : "+
		// lc.getQuantite());
		// System.out.println(lc.getArticle().getIdArticle());

		/*
		 * List<LigneCommande> listPanier = (List<LigneCommande>)
		 * panierService.getAllArticlesPanier(1L);
		 * 
		 * for (int i = 0; i < listPanier.size(); i++) {
		 * System.out.println(listPanier.get(i).getIdLigneCommande() + " : " +
		 * listPanier.get(i).getPrix() + " : " + listPanier.get(i).getQuantite());
		 * System.out.println(listPanier.get(i).getArticle().getIdArticle()); }
		 */

		// Collection<LigneCommande> list = panierService.getAllArticlesPanier(1L);
		// listPanier.removeAll(listPanier);

		// List<LigneCommande> listPanier2 = (List<LigneCommande>)
		// panierService.getAllArticlesPanier(1L);

		/*
		 * System.out.println("Start deleting ..."); for (int i = 0; i <
		 * listPanier.size(); i++) {
		 * System.out.println(listPanier.get(i).getIdLigneCommande() + " : " +
		 * listPanier.get(i).getPrix() + " : " + listPanier.get(i).getQuantite());
		 * System.out.println(listPanier.get(i).getArticle().getIdArticle());
		 * 
		 * } System.out.println("fin deleting ...");
		 */
		/*
		 * LigneCommande lc = panierService.getArticle(1L);
		 * 
		 * panierService.DeleteArtcle(lc.getIdLigneCommande());
		 */

		/*
		 * Random rn = new Random();
		 * 
		 * for (int i = 0; i < 3; i++) { Category c1 = new Category();
		 * c1.setName("RAB DANCE"); c1.setDescription("AERPUOII :"); Category c2=
		 * categoryRepository.save(c1);
		 * 
		 * for (int x = 0; x < 10; x++) {
		 * 
		 * Article a = new Article(); a.setName("HIB HOB ");
		 * a.setDescription("HIB HOB MUSIQUE"); a.setPrice(rn.nextInt()*100);
		 * a.setQuantity(rn.nextInt()); articleRespository.save(a); a.setCategory(c2);
		 * articleRespository.save(a);
		 * 
		 * }
		 * 
		 * }
		 */
        // emailService.sendSimpleMessage("dadeil.dev1@gmail.com", "abdalfadeil@gmail.com", "Body de mail test", "le text de l'email ici .....");

        config.exposeIdsFor(Article.class, Category.class, Commande.class, Panier.class, AppUser.class);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
