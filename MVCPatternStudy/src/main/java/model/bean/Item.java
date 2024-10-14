package model.bean;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = "productName")
/**
 * Item 객체 비교 기준은 productName 필드값이 같으면 
 * 같은 객체로 인식하게끔 하였다. 
 */
public class Item {
	private String productName;
	private int ea;
	private int price;
}
