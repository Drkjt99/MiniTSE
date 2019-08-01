package com.academik.minitse.utils;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author esvux
 */
@ManagedBean(name = "nav")
@ApplicationScoped
public class NavigationBean {
    
    private String inmediateRedirect(String url) {
        return url + "?faces-redirect=true";
    }
    
    public String goVotingPlaces() {
        return inmediateRedirect("voting-places");
    }
    
    public String goCreateVotingPlace() {
        return inmediateRedirect("voting-place-create");
    }

    public String goEditVotingPlace(Long id) {
        return inmediateRedirect("voting-place-edit") + "&selected_id=" + id;
    }

    public String goVoters() {
        return inmediateRedirect("voters");
    }

    public String goCreateVoters() {
        return inmediateRedirect("voter-create");
    }
    
    public String goEditVoter(String id) {
        return inmediateRedirect ("voter-edit") + "&selected_id=" + id;
    }
    
    public String goVoteSubmit() {
        return inmediateRedirect("vote-submit");
    }
    
    public String goPoliticalParty() {
        return inmediateRedirect ("political-party");
    }
    
    public String goCreatePoliticalParty() {
        return inmediateRedirect("political-party-create");
    }
    
    public String goEditPoliticalParty(Long id) {
        return inmediateRedirect ("political-party-edit") + "&selected_id=" + id;
    }
    
}
