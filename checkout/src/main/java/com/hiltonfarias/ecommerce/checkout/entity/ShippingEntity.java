package com.hiltonfarias.ecommerce.checkout.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Audited
@EntityListeners(AuditingEntityListener.class)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShippingEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String address;

    @Column
    private String complement;

    @Column
    private String country;

    @Column
    private String state;

    @Column
    private String cep;

    @OneToMany(mappedBy = "shipping")
    private CheckoutEntity checkout;
}
