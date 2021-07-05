package com.idrissbacha.welcomer.domain;

import com.idrissbacha.welcomer.domain.enumerations.RequestBody;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * A Request.
 */
@Entity
@Table(name = "request")
public class Request implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "body")
    private RequestBody body;

    @Column(name = "is_valid")
    private Boolean isValid;

    @Column(name = "is_delivered")
    private Boolean isDelivered;

    @Column(name = "delivery_date")
    private LocalDate deliveryDate;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @Size(max = 2000)
    @Column(name = "comment", length = 2000)
    private String comment;

    @ManyToOne
    private User createdBy;

    @ManyToOne
    private User validatedBy;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Request id(Long id) {
        this.id = id;
        return this;
    }

    public RequestBody getBody() {
        return body;
    }

    public void setBody(RequestBody body) {
        this.body = body;
    }

    public Boolean getIsValid() {
        return this.isValid;
    }

    public Request isValid(Boolean isValid) {
        this.isValid = isValid;
        return this;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }

    public Boolean getIsDelivered() {
        return this.isDelivered;
    }

    public Request isDelivered(Boolean isDelivered) {
        this.isDelivered = isDelivered;
        return this;
    }

    public void setIsDelivered(Boolean isDelivered) {
        this.isDelivered = isDelivered;
    }

    public LocalDate getDeliveryDate() {
        return this.deliveryDate;
    }

    public Request deliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
        return this;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public LocalDate getCreatedDate() {
        return this.createdDate;
    }

    public Request createdDate(LocalDate createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public String getComment() {
        return this.comment;
    }

    public Request comment(String comment) {
        this.comment = comment;
        return this;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getCreatedBy() {
        return this.createdBy;
    }

    public Request createdBy(User user) {
        this.setCreatedBy(user);
        return this;
    }

    public void setCreatedBy(User user) {
        this.createdBy = user;
    }

    public User getValidatedBy() {
        return this.validatedBy;
    }

    public Request validatedBy(User user) {
        this.setValidatedBy(user);
        return this;
    }

    public void setValidatedBy(User user) {
        this.validatedBy = user;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Request)) {
            return false;
        }
        return id != null && id.equals(((Request) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Request{" +
            "id=" + getId() +
            ", isValid='" + getIsValid() + "'" +
            ", isDelivered='" + getIsDelivered() + "'" +
            ", deliveryDate='" + getDeliveryDate() + "'" +
            ", createdDate='" + getCreatedDate() + "'" +
            ", comment='" + getComment() + "'" +
            "}";
    }
}
