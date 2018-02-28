package com.github;

/**
 * Created by mars on 2/25/18.
 */
public interface Electable {


    String getName();
    boolean isCitizen();
    int getAge();
    String getPartyMembership();
    CampaignIssue getCampaignFocus();
    boolean canBeElected();

}
