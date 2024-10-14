package model.db;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(exclude = "user_no")
public class UserDTO {
	private int user_no;
	private String id;
	private String password;
}
