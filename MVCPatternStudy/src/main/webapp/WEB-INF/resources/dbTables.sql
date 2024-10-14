CREATE TABLE users (
	USER_NO INT PRIMARY KEY AUTO_INCREMENT,
	ID VARCHAR(15) UNIQUE KEY NOT NULL,
	PASSWORD VARCHAR(15) NOT NULL
);

CREATE TABLE products (
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(20) NOT NULL, 
	price INT NOT NULL, 
	category VARCHAR(20) NOT NULL 
);

INSERT INTO products(name, price, category) VALUES 
("얼큰한 라면 1봉", 3000, "food"), 
("도시락 3종 세트", 12000, "food"),
("순대국", 5000, "food"),
("롤케잌", 10000, "food"),
("맨투맨", 15000, "cloth"),
("바지", 13000, "cloth"),
("신발", 60000, "cloth"),
("모자", 8000, "cloth"),
("식사용 접시", 3000, "sundries"),
("공구세트", 20000, "sundries"),
("메모장", 5000, "sundries"),
("책받침", 6000, "sundries");