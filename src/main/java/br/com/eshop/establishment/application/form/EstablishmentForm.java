package br.com.eshop.establishment.application.form;


import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EstablishmentForm {

    private String name;

    private String contact;

    private String address;

}
