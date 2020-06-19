package br.com.eshop.clientEstablishment.domain.entity;

import br.com.eshop.client.domain.entity.Client;
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
public class ClientEstablishment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "client_establishment_id_seq", sequenceName = "client_establishment_id_seq")
    @Column(name = "ID_CLIENT_ESTABLISHMENT")
    private Long id;

    @JoinColumn(name = "client", referencedColumnName = "ID_CLIENT")
    @OneToOne
    private Client client;

    @JoinColumn(name = "establishment",referencedColumnName = "ID_ESTABLISHMENT")
    @OneToOne
    private Establishment establishment;


    @Column(name = "CREATED_AT")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "UPDATE_AT")
    @UpdateTimestamp
    private LocalDateTime updateAt;
}
