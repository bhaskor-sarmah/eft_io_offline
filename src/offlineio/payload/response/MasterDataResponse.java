/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offlineio.payload.response;

import java.util.List;

/**
 *
 * @author Bhaskor
 */
public class MasterDataResponse {

    private String pass;

    private List<AddressType> addressTypeList;

    private List<Country> countryList;

    private List<State> stateList;

    private List<District> districtList;

    private List<Thana> thanaList;

    private List<Lac> lacList;

    private List<Village> villageList;

    private List<Relation> relationList;

    private List<Gender> genderList;

    private List<MaritalStatus> maritalStatusList;

    private List<Occupation> occupationList;

    private List<Religion> religionList;

    private List<Document> docList;

    private List<EmploymentType> employementTypeList;

    private List<Route> routeList;

    public MasterDataResponse() {
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public List<AddressType> getAddressTypeList() {
        return addressTypeList;
    }

    public void setAddressTypeList(List<AddressType> addressTypeList) {
        this.addressTypeList = addressTypeList;
    }

    public List<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }

    public List<State> getStateList() {
        return stateList;
    }

    public void setStateList(List<State> stateList) {
        this.stateList = stateList;
    }

    public List<District> getDistrictList() {
        return districtList;
    }

    public void setDistrictList(List<District> districtList) {
        this.districtList = districtList;
    }

    public List<Thana> getThanaList() {
        return thanaList;
    }

    public void setThanaList(List<Thana> thanaList) {
        this.thanaList = thanaList;
    }

    public List<Lac> getLacList() {
        return lacList;
    }

    public void setLacList(List<Lac> lacList) {
        this.lacList = lacList;
    }

    public List<Village> getVillageList() {
        return villageList;
    }

    public void setVillageList(List<Village> villageList) {
        this.villageList = villageList;
    }

    public List<Relation> getRelationList() {
        return relationList;
    }

    public void setRelationList(List<Relation> relationList) {
        this.relationList = relationList;
    }

    public List<Gender> getGenderList() {
        return genderList;
    }

    public void setGenderList(List<Gender> genderList) {
        this.genderList = genderList;
    }

    public List<MaritalStatus> getMaritalStatusList() {
        return maritalStatusList;
    }

    public void setMaritalStatusList(List<MaritalStatus> maritalStatusList) {
        this.maritalStatusList = maritalStatusList;
    }

    public List<Occupation> getOccupationList() {
        return occupationList;
    }

    public void setOccupationList(List<Occupation> occupationList) {
        this.occupationList = occupationList;
    }

    public List<Religion> getReligionList() {
        return religionList;
    }

    public void setReligionList(List<Religion> religionList) {
        this.religionList = religionList;
    }

    public List<Document> getDocList() {
        return docList;
    }

    public void setDocList(List<Document> docList) {
        this.docList = docList;
    }

    public List<EmploymentType> getEmployementTypeList() {
        return employementTypeList;
    }

    public void setEmployementTypeList(List<EmploymentType> employementTypeList) {
        this.employementTypeList = employementTypeList;
    }

    public List<Route> getRouteList() {
        return routeList;
    }

    public void setRouteList(List<Route> routeList) {
        this.routeList = routeList;
    }

}
