package br.com.eshop.image.domain.entity;

import br.com.eshop.establishment.domain.entity.Establishment;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "image_id_seq", sequenceName = "image_id_seq")
    @Column(name = "ID_IMAGE")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TYPE")
    private String type;

    @JoinColumn(name = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Establishment establishment;

    @Column(name = "CREATED_AT")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "UPDATE_AT")
    @UpdateTimestamp
    private LocalDateTime updateAt;
}
