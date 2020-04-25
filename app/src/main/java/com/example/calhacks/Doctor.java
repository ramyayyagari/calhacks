package com.example.calhacks;

public class Doctor {

    private String docName;
    private String docPhone;
    private String website;
    private String ypURL;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String county;
    private String npiType;
    private String npiStatus;
    private String npi;
    private String specialty;
    private String fax;

    public Doctor() {

    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocPhone() {
        return docPhone;
    }

    public void setDocPhone(String docPhone) {
        this.docPhone = docPhone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getYpURL() {
        return ypURL;
    }

    public void setYpURL(String ypURL) {
        this.ypURL = ypURL;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getNpiType() {
        return npiType;
    }

    public void setNpiType(String npiType) {
        this.npiType = npiType;
    }

    public String getNpiStatus() {
        return npiStatus;
    }

    public void setNpiStatus(String npiStatus) {
        this.npiStatus = npiStatus;
    }

    public String getNpi() {
        return npi;
    }

    public void setNpi(String npi) {
        this.npi = npi;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Doctor doctor = (Doctor) o;

        return docName != null ? docName.equals(doctor.docName) : doctor.docName == null;
    }

    @Override
    public int hashCode() {
        return docName != null ? docName.hashCode() : 0;
    }
}
