package ru.instapp.instapp.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "media")
@Getter
@Setter
public class MediaDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "media_id")
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date", nullable = false)
    private Calendar creationDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "media_type", nullable = false)
    private MediaType mediaType;

    @ManyToOne(targetEntity = PostDomain.class)
    @JoinColumn(name = "post_id")
    private PostDomain post;

    public enum MediaType {
        PHOTO, VIDEO;
    }
}
