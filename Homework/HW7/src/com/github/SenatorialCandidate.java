package com.github;

/**
 * Created by mars on 2/25/18.
 */
public class SenatorialCandidate implements Electable {
    String name = "";
    boolean citizen = false;
    int age = -1;
    String partyMembership = "";
    CampaignIssue campaignFocus = CampaignIssue.NO_FOCUS;

    SenatorialCandidate(String name, boolean citizenship, int age, String party){
        this.name = name;
        this.citizen = citizenship;
        this.age = age;
        this.partyMembership = party;
    }

    SenatorialCandidate(String name,boolean citizenship, int age, String party, CampaignIssue campaignFocus){
        this.name = name;
        this.citizen = citizenship;
        this.age = age;
        this.partyMembership = party;
        this.campaignFocus = campaignFocus;

    }

    void updateCampaignFocus (CampaignIssue issue){
        this.campaignFocus = issue;

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public boolean isCitizen() {
        return this.citizen;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String getPartyMembership() {
        return this.partyMembership;
    }

    @Override
    public CampaignIssue getCampaignFocus() {
        return this.campaignFocus;
    }

    @Override
    public boolean canBeElected() {
        if (partyMembership != null && citizen && name != "" && age >= 30){
            return true;
        }
        return false;
    }

}
