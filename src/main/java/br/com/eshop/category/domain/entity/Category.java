package br.com.eshop.category.domain.entity;

import br.com.eshop.establishmentType.domain.entity.EstablishmentType;
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
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "category_id_seq",sequenceName = "category_id_seq")
    @Column(name = "ID_CATEGORY")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @JoinColumn(name = "id")
    @OneToOne(fetch = FetchType.LAZY)
    private EstablishmentType type;

    @Column(name = "CREATED_AT")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "UPDATE_AT")
    @UpdateTimestamp
    private LocalDateTime updateAt;
}
