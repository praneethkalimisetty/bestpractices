package io.learn.backend.bestpractices.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Covid {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String active;
    private String confirmed;
    private String deaths;
    private String deltaconfirmed;
    private String deltadeaths;
    private String deltarecovered;
    private String lastupdatedtime;
    private String migratedother;
    private String recovered;
    private String state;
    private String statecode;
    private String recordInsertedDate;

    public Covid(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getDeltaconfirmed() {
        return deltaconfirmed;
    }

    public void setDeltaconfirmed(String deltaconfirmed) {
        this.deltaconfirmed = deltaconfirmed;
    }

    public String getDeltadeaths() {
        return deltadeaths;
    }

    public void setDeltadeaths(String deltadeaths) {
        this.deltadeaths = deltadeaths;
    }

    public String getDeltarecovered() {
        return deltarecovered;
    }

    public void setDeltarecovered(String deltarecovered) {
        this.deltarecovered = deltarecovered;
    }

    public String getLastupdatedtime() {
        return lastupdatedtime;
    }

    public void setLastupdatedtime(String lastupdatedtime) {
        this.lastupdatedtime = lastupdatedtime;
    }

    public String getMigratedother() {
        return migratedother;
    }

    public void setMigratedother(String migratedother) {
        this.migratedother = migratedother;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStatecode() {
        return statecode;
    }

    public void setStatecode(String statecode) {
        this.statecode = statecode;
    }

    public String getRecordInsertedDate() {
        return recordInsertedDate;
    }

    public void setRecordInsertedDate(String recordInsertedDate) {
        this.recordInsertedDate = recordInsertedDate;
    }

    @Override
    public String toString() {
        return "Covid [active=" + active + ", confirmed=" + confirmed + ", deaths=" + deaths + ", deltaconfirmed="
                + deltaconfirmed + ", deltadeaths=" + deltadeaths + ", deltarecovered=" + deltarecovered + ", id=" + id
                + ", lastupdatedtime=" + lastupdatedtime + ", migratedother=" + migratedother + ", recovered="
                + recovered + ", state=" + state + ", statecode=" + statecode + ", recordInsertedDate=" + recordInsertedDate + "]";
    }
}
