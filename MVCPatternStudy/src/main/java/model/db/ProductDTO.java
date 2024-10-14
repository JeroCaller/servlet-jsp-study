package model.db;

import lombok.Data;

@Data
public class ProductDTO {
	private String name;
	private int price;
	private String category;
}
