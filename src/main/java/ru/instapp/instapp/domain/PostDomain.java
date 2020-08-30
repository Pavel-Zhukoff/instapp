package ru.instapp.instapp.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "post")
@Getter
@Setter
@ToString(of = {"id", "capiton", "creationDate", "publicationDate"})
public class PostDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(name = "capiton", columnDefinition = "TEXT")
    private String capiton;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date", nullable = false)
    private Calendar creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "publication_date", nullable = false)
    private Calendar publicationDate;

    @ManyToOne(targetEntity = IAccountDomain.class)
    @JoinColumn(name = "iaccount_id")
    private IAccountDomain instagramAccount;

    @OneToMany(targetEntity = MediaDomain.class, mappedBy = "post", fetch = FetchType.LAZY)
    private List<MediaDomain> medias;
}
