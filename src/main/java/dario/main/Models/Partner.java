package dario.main.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Locale;

@Entity
public class Partner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String companyName;
    private String reference;
    private Locale locale;
    private Date expirationTime;

    public Partner (){}

    public Partner(String companyName, String reference, Locale locale, Date expirationTime) {
        this.companyName = companyName;
        this.reference = reference;
        this.locale = locale;
        this.expirationTime = expirationTime;
    }

    public Long getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public Date getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
    }

    @Override
    public String toString() {
        return "Partner{" +
                "companyName='" + companyName + '\'' +
                ", reference='" + reference + '\'' +
                ", locale=" + locale +
                ", expirationTime=" + expirationTime +
                '}';
    }
}
