package br.com.eshop.product.domain.entity;

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
public class Product {

    @Id
    @GeneratedValue(strategy =GenerationType.SEQUENCE)
    @SequenceGenerator(name = "product_id_seq", sequenceName = "product_id_seq")
    @Column(name = "ID_PRODUCT")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "AMOUNT")
    private Long amount;

    @Column(name = "DESCRIPTION")
    private Long description;

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
