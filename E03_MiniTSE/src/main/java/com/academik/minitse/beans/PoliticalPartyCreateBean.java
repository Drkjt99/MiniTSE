
package com.academik.minitse.beans;

import com.academik.minitse.dao.PoliticalPartyDAO;
import com.academik.minitse.model.PoliticalParty;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;


/**
 *
 * @author drk_j
 */
@ManagedBean(name = "PoliticalPartyCreateBean")
@ViewScoped
public class PoliticalPartyCreateBean implements Serializable {
    
    @Inject
    PoliticalPartyDAO daoParty;

    private Long selectedPoliticalPartyId;
    private String PartyName;
    private String Candidate;
    private List<PoliticalParty> allPoliticalP;

    public void setSelectedPoliticalPartyId(Long selectedPoliticalPartyId) {
        this.selectedPoliticalPartyId = selectedPoliticalPartyId;
    }

    public void setPartyName(String PartyName) {
        this.PartyName = PartyName;
    }

    public void setCandidate(String Candidate) {
        this.Candidate = Candidate;
    }

    public void setAllPoliticalP(List<PoliticalParty> allPoliticalP) {
        this.allPoliticalP = allPoliticalP;
    }

    public Long getSelectedPoliticalPartyId() {
        return selectedPoliticalPartyId;
    }

    public String getPartyName() {
        return PartyName;
    }

    public String getCandidate() {
        return Candidate;
    }

    public List<PoliticalParty> getAllPoliticalP() {
        return allPoliticalP;
    }

    @PostConstruct
    public void init() {
        allPoliticalP = daoParty.findAll();
    }

    public String register(){
        PoliticalParty pp = new PoliticalParty();
        pp.setId(selectedPoliticalPartyId);
        pp.setName(PartyName);
        pp.setCandidate(Candidate);
        daoParty.register(pp);
        return "political-party";
    }
}
