package com.app.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class UserWallet {


//    @GenericGenerator(name = "table", strategy = "enhanced-table", parameters = {
//            @org.hibernate.annotations.Parameter(name = "table_name", value = "sequence_table")
//    })
//    @GeneratedValue(generator = "table", strategy=GenerationType.TABLE)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long userWalletId;

    @ManyToOne
    private User user;
}
