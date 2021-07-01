package com.idrissbacha.welcomer.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.idrissbacha.welcomer.config.Constants;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.BatchSize;

/**
 * A user.
 */
@Entity
@Table(name = "jhi_user")
public class User extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Pattern(regexp = Constants.LOGIN_REGEX)
    @Size(min = 1, max = 50)
    @Column(length = 50, unique = true, nullable = false)
    private String login;

    @JsonIgnore
    @NotNull
    @Size(min = 60, max = 60)
    @Column(name = "password_hash", length = 60, nullable = false)
    private String password;

    @Size(max = 50)
    @Column(name = "first_name", length = 50)
    private String firstName;

    @Size(max = 50)
    @Column(name = "last_name", length = 50)
    private String lastName;

    @Email
    @Size(min = 5, max = 254)
    @Column(length = 254, unique = true)
    private String email;

    @NotNull
    @Column(nullable = false)
    private boolean activated = false;

    @Size(min = 2, max = 10)
    @Column(name = "lang_key", length = 10)
    private String langKey;

    @Size(max = 256)
    @Column(name = "image_url", length = 256)
    private String imageUrl;

    @Column(name = "date_embauche")
    private Instant dateEmbauche;

    @Column(name = "instalation_date")
    private Instant instalationDate;

    @Size(max = 50)
    @Column(name = "phone_number", length = 50)
    private String phoneNumber;

    @NotNull
    @Column(name = "is_on_boarding", nullable = false)
    private boolean isOnBoarding;

    @NotNull
    @Column(name = "is_off_boarding", nullable = false)
    private boolean isOffBoarding;

    @NotNull
    @Column(name = "is_expatriation", nullable = false)
    private boolean isExpatriation;

    @Column(name = "date_off_boarding")
    private Instant dateOffBoarding;

    @Size(max = 50)
    @Column(name = "ticket_off_boarding", length = 50)
    private String ticketOffBoarding;

    @Column(name = "date_expatriation")
    private Instant dateExpatriation;

    @Size(max = 50)
    @Column(name = "ticket_expatriation", length = 50)
    private String ticketExpatriation;

    @Size(max = 50)
    @Column(name = "ancien_matricule", length = 50)
    private String ancienMatricule;

    @Size(max = 50)
    @Column(name = "nouveau_matricule", length = 50)
    private String nouveauMatricule;

    @Size(max = 50)
    @Column(name = "contact_it_siteDepart", length = 50)
    private String contactItSiteDepart;

    @Size(max = 50)
    @Column(name = "contact_it_site_arrivee", length = 50)
    private String contactItSiteArrivee;

    @Size(max = 50)
    @Column(name = "remarque_rh", length = 50)
    private String remarqueRh;

    @Column(name = "first_call_back_day")
    private Instant firstCallBackDay;

    @Column(name = "integration_date")
    private Instant integrationDate;

    @Size(max = 2000)
    @Column(name = "comment", length = 2000)
    private String comment;

    @Size(max = 20)
    @Column(name = "activation_key", length = 20)
    @JsonIgnore
    private String activationKey;

    @Size(max = 20)
    @Column(name = "reset_key", length = 20)
    @JsonIgnore
    private String resetKey;

    @Column(name = "reset_date")
    private Instant resetDate = null;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "jhi_user_authority",
        joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") },
        inverseJoinColumns = { @JoinColumn(name = "authority_name", referencedColumnName = "name") }
    )
    @BatchSize(size = 20)
    private Set<Authority> authorities = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    // Lowercase the login before saving it in database
    public void setLogin(String login) {
        this.login = StringUtils.lowerCase(login, Locale.ENGLISH);
    }

    public Instant getInstalationDate() {
        return instalationDate;
    }

    public void setInstalationDate(Instant instalationDate) {
        this.instalationDate = instalationDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public String getActivationKey() {
        return activationKey;
    }

    public void setActivationKey(String activationKey) {
        this.activationKey = activationKey;
    }

    public String getResetKey() {
        return resetKey;
    }

    public void setResetKey(String resetKey) {
        this.resetKey = resetKey;
    }

    public Instant getResetDate() {
        return resetDate;
    }

    public void setResetDate(Instant resetDate) {
        this.resetDate = resetDate;
    }

    public String getLangKey() {
        return langKey;
    }

    public void setLangKey(String langKey) {
        this.langKey = langKey;
    }

    public Instant getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(Instant dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isOnBoarding() {
        return isOnBoarding;
    }

    public void setOnBoarding(boolean onBoarding) {
        isOnBoarding = onBoarding;
    }

    public boolean isOffBoarding() {
        return isOffBoarding;
    }

    public void setOffBoarding(boolean offBoarding) {
        isOffBoarding = offBoarding;
    }

    public boolean isExpatriation() {
        return isExpatriation;
    }

    public void setExpatriation(boolean expatriation) {
        isExpatriation = expatriation;
    }

    public Instant getDateOffBoarding() {
        return dateOffBoarding;
    }

    public void setDateOffBoarding(Instant dateOffBoarding) {
        this.dateOffBoarding = dateOffBoarding;
    }

    public String getTicketOffBoarding() {
        return ticketOffBoarding;
    }

    public void setTicketOffBoarding(String ticketOffBoarding) {
        this.ticketOffBoarding = ticketOffBoarding;
    }

    public Instant getDateExpatriation() {
        return dateExpatriation;
    }

    public void setDateExpatriation(Instant dateExpatriation) {
        this.dateExpatriation = dateExpatriation;
    }

    public String getTicketExpatriation() {
        return ticketExpatriation;
    }

    public void setTicketExpatriation(String ticketExpatriation) {
        this.ticketExpatriation = ticketExpatriation;
    }

    public String getAncienMatricule() {
        return ancienMatricule;
    }

    public void setAncienMatricule(String ancienMatricule) {
        this.ancienMatricule = ancienMatricule;
    }

    public String getNouveauMatricule() {
        return nouveauMatricule;
    }

    public void setNouveauMatricule(String nouveauMatricule) {
        this.nouveauMatricule = nouveauMatricule;
    }

    public String getContactItSiteDepart() {
        return contactItSiteDepart;
    }

    public void setContactItSiteDepart(String contactItSiteDepart) {
        this.contactItSiteDepart = contactItSiteDepart;
    }

    public String getContactItSiteArrivee() {
        return contactItSiteArrivee;
    }

    public void setContactItSiteArrivee(String contactItSiteArrivee) {
        this.contactItSiteArrivee = contactItSiteArrivee;
    }

    public String getRemarqueRh() {
        return remarqueRh;
    }

    public void setRemarqueRh(String remarqueRh) {
        this.remarqueRh = remarqueRh;
    }

    public Instant getFirstCallBackDay() {
        return firstCallBackDay;
    }

    public void setFirstCallBackDay(Instant firstCallBackDay) {
        this.firstCallBackDay = firstCallBackDay;
    }

    public Instant getIntegrationDate() {
        return integrationDate;
    }

    public void setIntegrationDate(Instant integrationDate) {
        this.integrationDate = integrationDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        return id != null && id.equals(((User) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "User{" +
            "login='" + login + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            ", imageUrl='" + imageUrl + '\'' +
            ", activated='" + activated + '\'' +
            ", langKey='" + langKey + '\'' +
            ", activationKey='" + activationKey + '\'' +
            "}";
    }
}
