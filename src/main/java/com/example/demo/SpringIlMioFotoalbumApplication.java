package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.auth.pojo.Role;
import com.example.demo.auth.pojo.User;
import com.example.demo.auth.service.RoleService;
import com.example.demo.auth.service.UserService;
import com.example.demo.pojo.Foto;
import com.example.demo.service.FotoService;

@SpringBootApplication
public class SpringIlMioFotoalbumApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringIlMioFotoalbumApplication.class, args);
	}

	@Autowired
	FotoService fotoService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserService userService;

	@Override
	public void run(String... args) throws Exception {

		Role roleSuperAdmin = new Role("SUPERADMIN");

		roleService.save(roleSuperAdmin);

		final String pws = new BCryptPasswordEncoder().encode("123");

		User userSuperAdmin = new User("supadmin", pws, roleSuperAdmin);

		userService.save(userSuperAdmin);

		Role roleAdmin = new Role("ADMIN");

		roleService.save(roleAdmin);

		User userAdmin1 = new User("admin1", pws, roleAdmin);

		userService.save(userAdmin1);

		User userAdmin2 = new User("admin2", pws, roleAdmin);

		userService.save(userAdmin2);

		User userAdmin3 = new User("admin3", pws, roleAdmin);

		userService.save(userAdmin3);

		Foto f1 = new Foto("img1", "Wedding image",
				"https://assets.vogue.com/photos/6457fe35c943a2672e3e6c65/16:9/w_3697,h_2079,c_limit/vg-125.jpg",
				userAdmin1);

		fotoService.save(f1);

		Foto f2 = new Foto("img2", "Festival image",
				"https://mandalnews.com/wp-content/uploads/2020/10/Festivel-Amravati-Mandal.jpeg", userAdmin2);

		fotoService.save(f2);

		Foto f3 = new Foto("img3", "Rolling loud image",
				"https://townsquare.media/site/838/files/2023/04/attachment-rolling-loud-miami-2022.jpeg", userAdmin2);

		fotoService.save(f3);

		Foto f4 = new Foto("img4", "Birthday",
				"https://static.wixstatic.com/media/348da1_f64d60d2555b4634b8af6e3f107b3689~mv2.jpg/v1/fill/w_2500,h_1573,al_c/348da1_f64d60d2555b4634b8af6e3f107b3689~mv2.jpg",
				userAdmin2);

		fotoService.save(f4);

		Foto f5 = new Foto("img5", "Pool party",
				"https://mybayutcdn.bayut.com/mybayut/wp-content/uploads/Pool-party-in-dubai-_-Cover-10-10-22.jpg",
				userAdmin1);

		fotoService.save(f5);

		Foto f6 = new Foto("img6", "Sun set",
				"https://media.istockphoto.com/id/1172427455/photo/beautiful-sunset-over-the-tropical-sea.jpg?s=612x612&w=0&k=20&c=i3R3cbE94hdu6PRWT7cQBStY_wknVzl2pFCjQppzTBg=",
				userAdmin1);

		fotoService.save(f6);

		Foto f7 = new Foto("img7", "Oscar night",
				"https://eventaddicted.com/storage/2022/03/eventaddicted-digital-magazine-eventi-Oscar-2022-Hollywood-oscar_2022_cast_coda_afp-scaled.jpg",
				userAdmin2);

		fotoService.save(f7);

		Foto f8 = new Foto("img8", "Events",
				"https://d3vhc53cl8e8km.cloudfront.net/hello-staging/wp-content/uploads/2017/12/22223742/Events-1200x630.jpg",
				userAdmin1);

		fotoService.save(f8);

		Foto f9 = new Foto("img9", "Protest",
				"https://media.cnn.com/api/v1/images/stellar/prod/230502174123-uk-public-order-act-coronation-intl.jpg?c=4x3",
				userAdmin1);

		fotoService.save(f9);

	}

}
