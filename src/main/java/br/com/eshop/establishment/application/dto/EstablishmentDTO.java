package br.com.eshop.establishment.application.dto;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EstablishmentDTO {


    private String name;

    private String contact;

    private String address;


    private LocalDateTime createdAt;


    private LocalDateTime updateAt;
}
