drop database db_grupo4_labo4;
CREATE database db_grupo4_labo4;
use db_grupo4_labo4;

create table provincias (
	id int not null auto_increment,
    nombre varchar(50) not null,
    PRIMARY KEY (id)
);
INSERT INTO provincias (nombre) VALUES ('Buenos Aires');
INSERT INTO provincias (nombre) VALUES ('Catamarca');
INSERT INTO provincias (nombre) VALUES ('Chaco');
INSERT INTO provincias (nombre) VALUES ('Chubut');
INSERT INTO provincias (nombre) VALUES ('CÃ³rdoba');
INSERT INTO provincias (nombre) VALUES ('Corrientes');
INSERT INTO provincias (nombre) VALUES ('Entre RÃ­os');
INSERT INTO provincias (nombre) VALUES ('Formosa');
INSERT INTO provincias (nombre) VALUES ('Jujuy');
INSERT INTO provincias (nombre) VALUES ('La Pampa');
INSERT INTO provincias (nombre) VALUES ('La Rioja');
INSERT INTO provincias (nombre) VALUES ('Mendoza');
INSERT INTO provincias (nombre) VALUES ('Misiones');
INSERT INTO provincias (nombre) VALUES ('NeuquÃ©n');
INSERT INTO provincias (nombre) VALUES ('RÃ­o Negro');
INSERT INTO provincias (nombre) VALUES ('Salta');
INSERT INTO provincias (nombre) VALUES ('San Juan');
INSERT INTO provincias (nombre) VALUES ('San Luis');
INSERT INTO provincias (nombre) VALUES ('Santa Cruz');
INSERT INTO provincias (nombre) VALUES ('Santa Fe');
INSERT INTO provincias (nombre) VALUES ('Santiago del Estero');
INSERT INTO provincias (nombre) VALUES ('Tierra del Fuego');
INSERT INTO provincias (nombre) VALUES ('TucumÃ¡n');


create table localidades (
	id int not null auto_increment,
    nombre varchar(50) not null,
    idprovincia int not null,
    PRIMARY KEY (id),
    FOREIGN KEY (idprovincia) REFERENCES provincias(id)
    
);
INSERT INTO localidades (nombre, idprovincia) VALUES ('General Pacheco', 1);
INSERT INTO localidades (nombre, idprovincia) VALUES ('Tigre', 1);
INSERT INTO localidades (nombre, idprovincia) VALUES ('San Fernando', 1);
INSERT INTO localidades (nombre, idprovincia) VALUES ('San Isidro', 1);
INSERT INTO localidades (nombre, idprovincia) VALUES ('MartÃ­nez', 1);
INSERT INTO localidades (nombre, idprovincia) VALUES ('La Lucila', 1);
INSERT INTO localidades (nombre, idprovincia) VALUES ('Olivos', 1);
INSERT INTO localidades (nombre, idprovincia) VALUES ('Vicente Lopez', 1);
INSERT INTO localidades (nombre, idprovincia) VALUES ('Parque Chacabuco', 1);
INSERT INTO localidades (nombre, idprovincia) VALUES ('Boedo', 1);
INSERT INTO localidades (nombre, idprovincia) VALUES ('MorÃ³n', 1);
INSERT INTO localidades (nombre, idprovincia) VALUES ('ItuzaingÃ³', 1);
INSERT INTO localidades (nombre, idprovincia) VALUES ('Retiro', 1);
INSERT INTO localidades (nombre, idprovincia) VALUES ('Balvanera', 1);
INSERT INTO localidades (nombre, idprovincia) VALUES ('Avellaneda', 1);
INSERT INTO localidades (nombre, idprovincia) VALUES ('Quilmes', 1);

create table alumnos (
	id int not null auto_increment,
    dni varchar (30) not null,
    nombre varchar(50) not null,
    apellido varchar(50) not null,
    fechanacimiento date not null,
    direccion varchar(50) not null,
    idlocalidad int not null,
    email varchar(100) not null,
    telefono varchar(30),
    activo boolean not null,
    PRIMARY KEY (id),
    UNIQUE KEY (dni),
    FOREIGN KEY (idlocalidad) REFERENCES localidades(id)
);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (1,33743011,"Beatrice","Bryan","1976/03/04","augue.ut@mollisDuis.net","Apdo.:216-5971 Ut, Avda.",5,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (2,34498347,"Stacy","Hinton","1996/07/01","Donec@dignissimlacusAliquam.edu","Apartado nÃºm.: 247, 1450 Ut Ctra.",1,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (3,35618563,"Madeline","Lewis","1996/07/22","aliquet.sem.ut@tellusAeneanegestas.net","Apdo.:817-4273 Ante C.",7,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (4,48056097,"Amir","Mcclain","1999/03/06","a.purus.Duis@urna.co.uk","Apartado nÃºm.: 449, 5633 Libero. Ctra.",14,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (5,37088695,"Maggie","Britt","1979/09/13","orci.lobortis.augue@orciPhasellusdapibus.co.uk","Apdo.:725-2417 Interdum ",15,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (6,31735712,"Vincent","Sharp","1975/11/10","aliquet.diam@mus.edu","6880 Facilisis, C.",1,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (7,27432482,"Bradley","Schmidt","2008/01/18","luctus@aarcuSed.edu","7181 Sed Calle",12,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (8,47584420,"Andrew","Dejesus","1995/05/18","erat.in@facilisiSed.ca","Apartado nÃºm.: 898, 552 Metus. Avenida",8,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (9,32701913,"Wang","Dejesus","1993/10/10","libero.mauris@Donecegestas.ca","Apartado nÃºm.: 313, 2364 Posuere Avda.",5,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (10,35305191,"Charity","Salazar","1979/06/20","suscipit@aliquamiaculis.com","Apartado nÃºm.: 799, 4606 Non, C/",11,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (11,32321237,"Aphrodite","Acosta","1994/08/30","risus@Duis.org","Apartado nÃºm.: 905, 5931 Maecenas Avda.",9,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (12,47315693,"Asher","Taylor","1993/06/08","massa.Vestibulum.accumsan@utmiDuis.ca","Apdo.:904-8852 Lorem Carretera",6,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (13,31799826,"Macon","Fischer","1979/11/29","augue@iaculisenimsit.org","658-4661 Quis, Calle",15,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (14,40079242,"Tarik","Nicholson","2006/05/05","natoque.penatibus@nequeInornare.ca","Apartado nÃºm.: 475, 4655 Vestibulum C.",14,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (15,45254043,"Bruno","Parker","1993/07/14","luctus.et.ultrices@ridiculusmusAenean.ca","Apartado nÃºm.: 915, 3815 Ultricies Avenida",2,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (16,28970211,"Macaulay","Buckner","2007/08/31","nunc.sed.pede@cubiliaCuraePhasellus.edu","3043 Dui, C.",5,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (17,43122390,"Flynn","Vargas","1982/10/06","malesuada.fames@Donec.org","Apartado nÃºm.: 832, 8368 Ultrices C/",10,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (18,40795775,"Honorato","Mills","1984/05/10","vestibulum.Mauris.magna@enim.ca","247-3292 Cras C/",11,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (19,40876546,"Raya","Delgado","1983/11/30","dictum.ultricies.ligula@metusvitae.org","613-9968 Ornare, Avenida",12,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (20,47292325,"Julian","Hughes","1990/05/07","posuere@ante.ca","Apdo.:609-8458 Ultrices Av.",15,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (21,39947446,"Cain","Franco","1974/10/10","elit.pellentesque@et.com","Apartado nÃºm.: 833, 4049 Vitae, Calle",9,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (22,27972062,"Ezekiel","Bruce","1978/11/20","mauris.sapien.cursus@ligulaconsectetuerrhoncus.com","449-5461 Orci. C.",8,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (23,30636038,"Rafael","Frost","1976/11/11","Integer.id@mattis.net","2336 Sit Av.",5,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (24,47546566,"Kylan","Pollard","2006/09/24","fermentum.vel.mauris@semelitpharetra.ca","Apdo.:860-701 Et C/",12,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (25,48218560,"Ivy","Noel","1984/07/13","lorem.semper.auctor@convallisconvallisdolor.ca","980-5845 Cursus ",4,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (26,28433801,"Winter","Campos","1983/10/08","scelerisque.mollis@sagittisplacerat.co.uk","3116 Lacus Ctra.",4,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (27,29636227,"Hoyt","Foley","1983/01/02","massa.Quisque@augueSed.net","7078 Vitae C.",5,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (28,29052463,"Donovan","Orr","1997/04/22","lorem.vehicula@fringilla.org","Apdo.:880-362 Curae; Avda.",2,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (29,47503209,"Kirk","Garner","1980/07/29","dis.parturient.montes@eratinconsectetuer.edu","6857 Tincidunt ",8,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (30,27592665,"Giacomo","Jacobson","1976/02/08","arcu.Vestibulum@etnetuset.co.uk","7951 Sed Calle",4,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (31,40292957,"Cooper","Mcdaniel","1995/07/19","eget.volutpat@utaliquamiaculis.edu","Apdo.:956-9798 Mauris ",2,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (32,49003587,"Reuben","Powers","1981/08/21","Aenean.eget@aliquetPhasellusfermentum.org","6872 Quis C/",6,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (33,35980110,"Zachary","Hatfield","2001/07/03","Phasellus.dapibus@fermentum.co.uk","Apartado nÃºm.: 958, 3071 Mauris C.",15,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (34,37449808,"Kareem","Hopkins","2010/05/12","consectetuer.ipsum.nunc@urna.org","Apartado nÃºm.: 179, 3147 Quis Avda.",8,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (35,32849144,"Charity","Mcleod","1985/06/10","Vivamus@nisi.net","5308 Sit C.",3,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (36,42554191,"Mechelle","Rich","2007/02/10","Aenean.eget.metus@nectempusscelerisque.edu","570 Etiam C/",4,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (37,47510631,"Vera","Gates","1996/07/04","mi.enim.condimentum@dictum.org","605-8738 Luctus Carretera",9,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (38,49005869,"Vivian","Sargent","1983/12/02","Duis.at.lacus@Maurisnondui.net","621-6378 Sed Carretera",7,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (39,46558619,"Avram","Fletcher","1993/12/11","parturient.montes@enimCurabiturmassa.net","2759 Magna. C.",6,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (40,30713518,"Hamilton","Rios","1992/04/14","eleifend.vitae.erat@posuereenim.com","445-7450 Leo. C/",7,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (41,43814891,"Dominic","Tran","1991/11/30","magna@vulputateeu.org","Apdo.:243-5698 Malesuada. Avda.",4,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (42,47270332,"Gary","Noble","2004/01/18","auctor@mollis.org","588-2836 Lorem Avda.",14,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (43,27170439,"Colleen","Saunders","1986/11/21","in.hendrerit@tempus.ca","Apartado nÃºm.: 213, 5576 Turpis. Ctra.",14,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (44,40487981,"Tucker","Cervantes","1996/01/16","risus.Nunc.ac@QuisquevariusNam.org","2976 Tristique Avda.",6,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (45,40582639,"Idola","Baird","2003/06/29","Mauris.magna.Duis@egetvolutpatornare.co.uk","Apdo.:603-5791 Nascetur C/",3,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (46,27823025,"Constance","Shelton","1993/06/17","Nulla.tempor@SuspendisseduiFusce.ca","Apartado nÃºm.: 324, 2256 Proin ",13,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (47,48068928,"Ciara","Dodson","2005/12/01","massa@auctorvelit.co.uk","5194 Vulputate, Carretera",13,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (48,40935196,"Oleg","Hardin","2000/04/20","quis.diam@ornare.net","Apartado nÃºm.: 157, 5303 Lorem Ctra.",11,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (49,31805343,"Castor","Herrera","1978/12/29","auctor.velit.Aliquam@sodalespurus.ca","Apdo.:913-8179 Orci, Avda.",1,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (50,42833160,"Ira","Cote","2009/12/09","mi.pede.nonummy@gravida.ca","Apartado nÃºm.: 777, 2328 Et Avenida",9,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (51,27363580,"Baker","Ward","2002/08/19","nibh.Aliquam.ornare@sociisnatoque.co.uk","439-4627 Turpis Ctra.",8,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (52,49992925,"Chandler","Burton","2008/07/19","diam@gravidasit.ca","1678 Suspendisse Carretera",1,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (53,27957814,"Melvin","Sanchez","1975/07/26","tempus.scelerisque.lorem@malesuadafames.org","813-9174 Donec Carretera",5,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (54,43574668,"Madaline","Carney","2005/03/23","nulla@quis.net","666-7066 Lorem Calle",13,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (55,31441232,"Ella","Whitney","1990/12/01","amet.consectetuer.adipiscing@mattis.net","8497 Maecenas C/",2,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (56,36031017,"Lester","Vazquez","1979/02/23","semper.dui.lectus@seddolor.edu","Apartado nÃºm.: 922, 4203 Elementum, ",8,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (57,33375047,"Dakota","Stanley","1997/09/29","lacinia.Sed.congue@dolorFuscefeugiat.co.uk","9443 Enim, Av.",9,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (58,33533728,"Virginia","Bright","2002/02/08","Aliquam.nisl@quamelementum.edu","4613 Nam C.",12,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (59,37115676,"Shad","Raymond","1977/02/26","nisi@adipiscingelit.ca","Apartado nÃºm.: 325, 3353 Elit Calle",1,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (60,30430575,"Amela","Mcdonald","1992/01/09","nunc@cursusluctusipsum.org","Apdo.:423-5293 Neque C.",8,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (61,41927522,"Amethyst","Rice","2002/03/29","nunc.Quisque@mi.net","Apartado nÃºm.: 981, 3430 Augue Avda.",14,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (62,44251152,"Kylynn","Landry","1981/08/19","auctor.nunc.nulla@auctorvitae.edu","877-8039 Eget C/",9,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (63,48280612,"Alexander","Moon","1974/01/19","Ut.semper@sempererat.org","Apdo.:377-2269 Amet Calle",12,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (64,32432370,"Cassandra","Hughes","1983/12/12","felis@Nunclectuspede.net","Apartado nÃºm.: 626, 7858 Dui. Avda.",12,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (65,34495755,"Xaviera","Stephens","1982/04/23","felis.Donec.tempor@diameu.ca","145 Ultricies C/",4,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (66,40428944,"Jolie","Daniel","1998/09/30","Nunc.sed.orci@lobortisrisus.com","609-7609 At, Carretera",2,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (67,46214709,"Ginger","Frank","1983/12/18","vehicula.et.rutrum@pharetra.edu","Apartado nÃºm.: 927, 5408 Euismod Calle",8,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (68,46482884,"Natalie","Torres","2006/06/30","sagittis@accumsansedfacilisis.co.uk","Apartado nÃºm.: 964, 7329 Eget C/",6,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (69,42462622,"Edward","Stephenson","1981/03/07","luctus@tacitisociosqu.org","Apdo.:999-6269 Vitae ",6,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (70,33408111,"Lev","Jensen","1978/07/26","a.dui.Cras@mus.edu","Apdo.:698-2266 In Calle",4,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (71,44896210,"Emily","Kline","1984/02/14","neque@Curabiturconsequat.org","259 Nisi Ctra.",15,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (72,35612282,"Vaughan","Casey","1979/08/25","luctus.lobortis.Class@neque.edu","Apartado nÃºm.: 203, 5252 Ante Ctra.",13,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (73,39569905,"Hyatt","Bolton","1992/02/24","libero@Nullaeu.edu","4416 Eget Avenida",3,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (74,33086322,"May","Blair","1976/07/30","magna.Ut.tincidunt@inconsectetuer.com","7994 Mus. ",2,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (75,32872467,"Orlando","Wood","2007/07/16","pede.nonummy@mollisnon.co.uk","Apartado nÃºm.: 113, 6110 Cras C/",15,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (76,37775995,"Alfonso","Fuller","1975/10/30","at@orciluctuset.com","Apartado nÃºm.: 100, 8050 Elementum Calle",4,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (77,42793169,"Teagan","Sanders","1988/09/09","eget@lobortisClassaptent.ca","Apdo.:663-2482 Phasellus Ctra.",4,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (78,35453152,"Macy","Mcconnell","1984/12/05","eros.Nam@metusVivamuseuismod.com","Apartado nÃºm.: 988, 979 Vivamus Avenida",12,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (79,30522012,"Allen","Wiggins","1975/08/25","lobortis.mauris@id.com","Apdo.:999-1126 Est. Carretera",10,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (80,47557408,"Kaseem","Waller","1984/07/30","lacus.Ut@nasceturridiculusmus.com","9507 Eget Avda.",7,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (81,46475986,"Charlotte","Gutierrez","1978/02/16","Donec@idsapien.net","Apdo.:287-6311 Et ",10,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (82,34248275,"Fredericka","Savage","1990/12/18","tempor.diam.dictum@duiquis.net","Apartado nÃºm.: 505, 6966 Arcu Calle",4,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (83,34195958,"Honorato","Soto","2006/01/20","ac@temporlorem.ca","Apartado nÃºm.: 154, 3112 Dignissim Avenida",15,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (84,29886332,"Lamar","Slater","2010/03/14","auctor.non.feugiat@Vestibulum.org","Apdo.:575-5202 Non, Ctra.",4,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (85,38533548,"Quin","Dillard","1975/03/20","varius@sagittis.ca","Apdo.:521-5631 Sodales ",1,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (86,27604113,"Hiram","Craig","1980/07/17","Sed.auctor.odio@vitae.edu","Apdo.:523-825 Elit, Ctra.",7,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (87,49711042,"Nadine","Morales","1997/01/15","Sed.eget@erosnectellus.edu","1154 Nullam Carretera",3,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (88,45024474,"Raja","Hammond","2009/07/31","molestie@pede.co.uk","686 Accumsan Av.",10,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (89,44658449,"Quin","Slater","1980/09/11","amet.metus.Aliquam@Aenean.com","Apartado nÃºm.: 214, 7587 Consequat Avenida",11,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (90,34938139,"Jerome","Gray","2010/04/12","sem.vitae.aliquam@Pellentesque.org","9823 Commodo C/",15,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (91,33869843,"Shad","Delaney","1984/02/28","porttitor.tellus.non@magnis.co.uk","Apdo.:826-3231 Commodo C/",12,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (92,40168664,"Leslie","Gonzalez","1997/11/15","massa.Mauris.vestibulum@Donecvitaeerat.net","633-9025 Sagittis Carretera",12,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (93,31188272,"Hector","Dudley","2007/07/26","erat.eget@eleifendegestasSed.net","607-8781 Fames Av.",11,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (94,40310695,"Adara","Gallagher","1983/05/05","magna@orci.co.uk","6006 Gravida Calle",7,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (95,32080182,"Zelda","Huber","1974/11/12","fermentum.metus@nonvestibulumnec.com","279-7562 Tellus. Ctra.",5,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (96,44043391,"Carolyn","Shepherd","2001/01/27","ante.blandit.viverra@ultricies.com","107-4087 Nunc Ctra.",15,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (97,30292164,"Aristotle","Mclean","2004/04/26","auctor@nascetur.org","7756 Cum C.",4,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (98,49798009,"Emery","Watson","1992/09/02","Cras@sodaleselit.com","Apdo.:167-9541 Posuere Carretera",3,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (99,32472771,"Hop","Knapp","1984/04/24","feugiat.nec@dolorFuscemi.ca","2726 Eget Avenida",6,true);
INSERT INTO `alumnos` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,activo) VALUES (100,47170637,"Mallory","Price","2002/04/01","non.lacinia.at@eratvitae.net","7303 Luctus. Avda.",13,true);


create table docentes (
	id int not null auto_increment,
    dni int not null,
    nombre varchar(50) not null,
    apellido varchar(50) not null,
    fechanacimiento date not null,
    direccion varchar(50) not null,
    idlocalidad int not null,
    email varchar(100) not null,
	activo boolean not null,
    telefono varchar(50) not null,
    PRIMARY KEY (id),
    UNIQUE KEY (dni),
    FOREIGN KEY (idlocalidad) REFERENCES localidades(id)
);
INSERT INTO `docentes` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,`activo`,`telefono`) VALUES (1,33526896,"Tamara","Herrera","1991/02/22","risus.Duis.a@loremluctus.net","Apdo.:222-4402 Cum Carretera",11,true,4740110);
INSERT INTO `docentes` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,`activo`,`telefono`) VALUES (2,46256673,"Heidi","Branch","1994/06/06","parturient.montes@ipsum.co.uk","Apartado nÃºm.: 361, 6308 Et Calle",4,true,4740111);
INSERT INTO `docentes` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,`activo`,`telefono`) VALUES (3,46174566,"Otto","Stephens","2009/03/11","nec.ante.Maecenas@tellusjusto.org","476-5145 Morbi Ctra.",6,true,4740112);
INSERT INTO `docentes` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,`activo`,`telefono`) VALUES (4,31617922,"Keefe","Moran","2009/05/11","blandit.congue@mollisDuis.com","2067 Cras Carretera",4,true,4740113);
INSERT INTO `docentes` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,`activo`,`telefono`) VALUES (5,46418078,"Karyn","Pruitt","1996/12/20","ligula.Nullam@loremvehiculaet.net","702-3260 Sed ",13,true,4740114);
INSERT INTO `docentes` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,`activo`,`telefono`) VALUES (6,30730506,"Kasimir","Weber","1994/12/17","Curabitur@ametconsectetuer.co.uk","Apdo.:772-1799 Morbi Avda.",11,true,4740115);
INSERT INTO `docentes` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,`activo`,`telefono`) VALUES (7,41568614,"Kiara","Kelly","2007/03/19","luctus@blanditmattis.edu","169-4915 Arcu. Ctra.",3,true,4740116);
INSERT INTO `docentes` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,`activo`,`telefono`) VALUES (8,41599198,"Peter","Mccarty","2009/09/29","risus.a@nonummyacfeugiat.edu","Apdo.:955-5717 Posuere Carretera",14,true,4740117);
INSERT INTO `docentes` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,`activo`,`telefono`) VALUES (9,41775524,"Virginia","Briggs","1987/10/03","lectus.a@nasceturridiculus.com","5348 Aenean C/",1,true,4740118);
INSERT INTO `docentes` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,`activo`,`telefono`) VALUES (10,27536291,"Patience","Terrell","1994/12/18","tellus.lorem@Quisque.com","639-1738 Arcu. Avenida",7,true,4740119);
INSERT INTO `docentes` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,`activo`,`telefono`) VALUES (11,46634799,"Fletcher","Buckley","1978/01/10","Ut.tincidunt@tincidunttempus.org","3190 Gravida C/",4,true,4740120);
INSERT INTO `docentes` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,`activo`,`telefono`) VALUES (12,30566284,"Amelia","Hebert","1978/01/03","et@liberomaurisaliquam.org","Apartado nÃºm.: 545, 2912 Sollicitudin Carretera",7,true,4740121);
INSERT INTO `docentes` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,`activo`,`telefono`) VALUES (13,39614928,"Mercedes","Stokes","1991/04/12","nonummy.ultricies@Proin.edu","1885 Fermentum Av.",1,true,4740122);
INSERT INTO `docentes` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,`activo`,`telefono`) VALUES (14,34658279,"Keelie","Compton","1981/09/22","urna.Nullam@cubiliaCurae.co.uk","1069 Tincidunt ",8,true,4740123);
INSERT INTO `docentes` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,`activo`,`telefono`) VALUES (15,42492962,"Jana","Lara","1996/10/24","sapien.molestie.orci@felisNullatempor.org","Apdo.:448-7107 Duis C.",10,true,4740124);
INSERT INTO `docentes` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,`activo`,`telefono`) VALUES (16,38655917,"Bertha","Booker","1978/08/29","justo.faucibus@nuncnulla.com","Apartado nÃºm.: 893, 4441 Arcu. ",2,true,4740125);
INSERT INTO `docentes` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,`activo`,`telefono`) VALUES (17,41843050,"Karleigh","Tate","1993/01/14","Etiam@a.com","396-8363 Metus. Calle",14,true,4740139);
INSERT INTO `docentes` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,`activo`,`telefono`) VALUES (18,28261869,"Wang","Farley","1976/02/27","Mauris.non.dui@Donecconsectetuermauris.edu","Apdo.:213-2686 Mattis Av.",6,true,4740126);
INSERT INTO `docentes` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,`activo`,`telefono`) VALUES (19,41151887,"Tyrone","Spencer","2004/06/03","ultricies.ligula.Nullam@semmollis.net","Apartado nÃºm.: 880, 6018 Amet, Av.",2,true,4740127);
INSERT INTO `docentes` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,`activo`,`telefono`) VALUES (20,38335006,"Sarah","Mosley","1995/05/25","mauris.eu.elit@leoelementum.co.uk","1115 Id, ",1,true,4740128);
INSERT INTO `docentes` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,`activo`,`telefono`) VALUES (21,42472692,"Lunea","Blevins","1980/03/26","In@necmalesuadaut.org","1306 Eu C/",1,true,4740129);
INSERT INTO `docentes` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,`activo`,`telefono`) VALUES (22,45151978,"Jessica","Mcclure","1975/06/11","ac@pede.org","4276 Aenean Avenida",9,true,4740130);
INSERT INTO `docentes` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,`activo`,`telefono`) VALUES (23,36021580,"Natalie","Oneil","1985/11/19","id.nunc.interdum@loremsemperauctor.edu","Apdo.:996-2699 Vel, Avda.",1,true,4740131);
INSERT INTO `docentes` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,`activo`,`telefono`) VALUES (24,43005770,"Louis","Wolf","1983/02/15","ac.eleifend@nullaDonec.com","487-2889 Augue Avenida",12,true,4740132);
INSERT INTO `docentes` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,`activo`,`telefono`) VALUES (25,47590391,"Cyrus","Morton","1983/12/26","Cras@tellusfaucibus.net","Apartado nÃºm.: 915, 2469 Sapien. Ctra.",15,true,4740133);
INSERT INTO `docentes` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,`activo`,`telefono`) VALUES (26,33756293,"Bell","Gould","1977/07/07","sit@commodotincidunt.net","Apdo.:273-9710 Massa. Calle",6,true,4740134);
INSERT INTO `docentes` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,`activo`,`telefono`) VALUES (27,29941709,"Zeus","Hess","1984/09/16","dui.Fusce@sedlibero.com","5256 Sit C/",2,true,4740135);
INSERT INTO `docentes` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,`activo`,`telefono`) VALUES (28,49170364,"Iliana","Carlson","2000/08/29","venenatis.lacus.Etiam@vel.org","Apdo.:110-7395 Donec Carretera",3,true,4740136);
INSERT INTO `docentes` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,`activo`,`telefono`) VALUES (29,31773068,"Brendan","Case","1985/10/03","egestas.rhoncus@vitaemauris.org","Apartado nÃºm.: 764, 5901 Fusce C/",14,true,4740137);
INSERT INTO `docentes` (`id`,`dni`,`nombre`,`apellido`,`fechanacimiento`,`email`,`direccion`,`idlocalidad`,`activo`,`telefono`) VALUES (30,47318799,"Demetria","Ruiz","1974/04/22","Donec@feugiat.edu","280-4012 Sollicitudin ",1,true,4740138);

create table materias(
	id int not null auto_increment,
    nombre varchar(50) not null,
    PRIMARY KEY (id)
);
INSERT INTO materias (nombre) VALUES ('Laboratorio I');
INSERT INTO materias (nombre) VALUES ('Laboratorio II');
INSERT INTO materias (nombre) VALUES ('Laboratorio III');
INSERT INTO materias (nombre) VALUES ('Laboratorio IV');
INSERT INTO materias (nombre) VALUES ('Programacion I');
INSERT INTO materias (nombre) VALUES ('Programacion II');
INSERT INTO materias (nombre) VALUES ('Programacion III');
INSERT INTO materias (nombre) VALUES ('ARSO');
INSERT INTO materias (nombre) VALUES ('Matematica');
INSERT INTO materias (nombre) VALUES ('Metodologia');
INSERT INTO materias (nombre) VALUES ('Legislacion');
INSERT INTO materias (nombre) VALUES ('Contabilidad');

create table cursos(
	id int not null auto_increment,
    cuatrimestre varchar(30) not null,
    anio varchar(30) not null,
    idmateria int not null,
    iddocente int not null,
    activo bool not null,
    PRIMARY KEY (id),
    FOREIGN KEY (idmateria) REFERENCES materias(id),
    FOREIGN KEY (iddocente) REFERENCES docentes(id)
);

INSERT INTO cursos (cuatrimestre, anio, idmateria, iddocente, activo) VALUES ("1ro", "2018", 1, 4, true);
INSERT INTO cursos (cuatrimestre, anio, idmateria, iddocente, activo) VALUES ("2do", "2018", 2, 4, true);
INSERT INTO cursos (cuatrimestre, anio, idmateria, iddocente, activo) VALUES ("2do", "2018", 8, 4, true);
INSERT INTO cursos (cuatrimestre, anio, idmateria, iddocente, activo) VALUES ("1ro", "2019", 3, 4, true);
INSERT INTO cursos (cuatrimestre, anio, idmateria, iddocente, activo) VALUES ("2do", "2019", 4, 4, true);


create table alumnos_x_cursos (
	idalumno int not null,
    idcurso int not null,
    nombre_alumno varchar(30),
    apellido_alumno varchar(30),
    nota1 int,
    nota2 int,
    nota3 int,
    nota4 int,
    aprobado boolean,
    FOREIGN KEY (idalumno) REFERENCES alumnos(id),
    FOREIGN KEY (idcurso) REFERENCES cursos(id),
    PRIMARY KEY (idalumno, idcurso)
);

INSERT INTO alumnos_x_cursos (idalumno, idcurso, nota1, nota2, nota3, nota4, aprobado, nombre_alumno, apellido_alumno) VALUES (1, 1, 7, 5, 9, 7, true,"Beatrice","Bryan");
INSERT INTO alumnos_x_cursos (idalumno, idcurso, nota1, nota2, nota3, nota4, aprobado, nombre_alumno, apellido_alumno) VALUES (1, 2, 7, 6, 7, 8, true,"Beatrice","Bryan");
INSERT INTO alumnos_x_cursos (idalumno, idcurso, nota1, nota2, nota3, nota4, aprobado, nombre_alumno, apellido_alumno) VALUES (1, 3, 9, 8, 9, 10, true,"Beatrice","Bryan");
INSERT INTO alumnos_x_cursos (idalumno, idcurso, nota1, nota2, nota3, nota4, aprobado, nombre_alumno, apellido_alumno) VALUES (1, 4, 4, 7, 9, 9, true,"Beatrice","Bryan");

create table usuarios (
	idusuario int not null auto_increment,
    iddocente int,
	usuario varchar (50) not null,
    clave varchar(50) not null,
    estado bool not null,
    FOREIGN KEY (iddocente) REFERENCES docentes(id),
    PRIMARY KEY (idusuario)
);

INSERT INTO usuarios (idusuario, usuario, clave, estado) VALUES ('1','administrator', 'A1234.', true);
INSERT INTO usuarios (idusuario, iddocente, usuario, clave, estado) VALUES ('2', 1, 'therrera','123465', true);

create table docentesXcursos (
	id_docente int not null,
    id_curso int not null,
	FOREIGN KEY (id_docente) REFERENCES docentes(id),
    FOREIGN KEY (id_curso) REFERENCES cursos(id)
);