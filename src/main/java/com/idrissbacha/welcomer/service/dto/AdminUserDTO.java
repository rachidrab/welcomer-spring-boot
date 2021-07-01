package com.idrissbacha.welcomer.service.dto;

import com.idrissbacha.welcomer.config.Constants;
import com.idrissbacha.welcomer.domain.Authority;
import com.idrissbacha.welcomer.domain.User;
import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.constraints.*;

/**
 * A DTO representing a user, with his authorities.
 */
public class AdminUserDTO {

    private Long id;

    @NotBlank
    @Pattern(regexp = Constants.LOGIN_REGEX)
    @Size(min = 1, max = 50)
    private String login;

    @Size(max = 50)
    private String firstName;

    @Size(max = 50)
    private String lastName;

    @Email
    @Size(min = 5, max = 254)
    private String email;

    @Size(max = 256)
    private String imageUrl;


    private Instant dateEmbauche;

    @Size(max = 50)
    private String phoneNumber;

    private boolean isOnBoarding;

    private boolean isOffBoarding;

    private boolean isExpatriation;

    private Instant dateOffBoarding;

    private String ticketOffBoarding;

    private Instant dateExpatriation;

    private String ticketExpatriation;

    private String ancienMatricule;

    private String nouveauMatricule;

    private String contactItSiteDepart;

    private String contactItSiteArrivee;

    private String remarqueRh;

    // au cas ou l'utilisateur est en: isOnBoarding ou isExpatriation
    private Instant firstCallBackDay;

    private Instant integrationDate;

    private Instant instalationDate;

    private String comment;

    private boolean activated = false;

    @Size(min = 2, max = 10)
    private String langKey;

    private String createdBy;

    private Instant createdDate;

    private String lastModifiedBy;

    private Instant lastModifiedDate;

    private Set<String> authorities;

    public AdminUserDTO() {
        // Empty constructor needed for Jackson.
    }

    public AdminUserDTO(User user) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.activated = user.isActivated();
        this.imageUrl = user.getImageUrl();
        this.langKey = user.getLangKey();
        this.createdBy = user.getCreatedBy();
        this.createdDate = user.getCreatedDate();
        this.lastModifiedBy = user.getLastModifiedBy();
        this.dateEmbauche = user.getDateEmbauche();
        this.phoneNumber = user.getPhoneNumber();
        this.isOnBoarding = user.isOnBoarding();
        this.isOffBoarding = user.isOffBoarding();
        this.isExpatriation = user.isExpatriation();
        this.dateOffBoarding = user.getDateOffBoarding();
        this.ticketOffBoarding = user.getTicketOffBoarding();
        this.dateExpatriation = user.getDateExpatriation();
        this.ticketExpatriation = user.getTicketExpatriation();
        this.ancienMatricule = user.getAncienMatricule();
        this.nouveauMatricule = user.getNouveauMatricule();
        this.contactItSiteDepart = user.getContactItSiteDepart();
        this.contactItSiteArrivee = user.getContactItSiteArrivee();
        this.remarqueRh = user.getRemarqueRh();
        this.firstCallBackDay = user.getFirstCallBackDay();
        this.integrationDate = user.getIntegrationDate();
        this.instalationDate = user.getInstalationDate();
        this.comment = user.getComment();
        this.lastModifiedDate = user.getLastModifiedDate();
        this.authorities = user.getAuthorities().stream().map(Authority::getName).collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public String getLangKey() {
        return langKey;
    }

    public void setLangKey(String langKey) {
        this.langKey = langKey;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Instant getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Instant lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
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

    public Instant getInstalationDate() {
        return instalationDate;
    }

    public void setInstalationDate(Instant instalationDate) {
        this.instalationDate = instalationDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AdminUserDTO{" +
            "login='" + login + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            ", imageUrl='" + imageUrl + '\'' +
            ", activated=" + activated +
            ", langKey='" + langKey + '\'' +
            ", createdBy=" + createdBy +
            ", createdDate=" + createdDate +
            ", lastModifiedBy='" + lastModifiedBy + '\'' +
            ", lastModifiedDate=" + lastModifiedDate +
            ", authorities=" + authorities +
            "}";
    }
}
