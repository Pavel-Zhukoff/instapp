package ru.instapp.instapp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "instagram_account")
@Getter
@Setter
public class IAccountDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iaccount_id")
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "token", nullable = false)
    private String token;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "token_creation_date")
    private Calendar tokenCreationDate;


    @ManyToOne(targetEntity = AccountDomain.class)
    @JoinColumn(name = "account_id")
    private AccountDomain account;


    @OneToMany(targetEntity = PostDomain.class, mappedBy = "instagramAccount", fetch = FetchType.LAZY)
    @OrderBy("creationDate desc")
    private List<PostDomain> posts;
}
