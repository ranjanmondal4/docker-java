package com.app.domain;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class User {

	@Id
	@GenericGenerator(name = "mysequence", strategy = "sequence", parameters = {
			@org.hibernate.annotations.Parameter(name = "sequenceName", value = "mysequence"),
			@org.hibernate.annotations.Parameter(name = "allocationSize", value = "2"),
	})
	@GeneratedValue(generator = "mysequence", strategy=GenerationType.SEQUENCE)
	private Long userId;

	private String name;

	private Date dateOfBirth;

//	@OneToMany()
//	@JoinTable(name ="user_my_wallet")
//	private List<UserWallet> userWallets = new ArrayList<>();

//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "user_wallet_id")
//	private UserWallet userWallet;

}
