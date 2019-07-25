package com.academik.minitse.beans;

import com.academik.minitse.dao.PoliticalPartyDAO;
import com.academik.minitse.dao.VoterDAO;
import com.academik.minitse.model.PoliticalParty;
import com.academik.minitse.model.Voter;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author esvux
 */
@ManagedBean(name = "voteSubmitBean")
@RequestScoped
public class VoteSubmitBean {
    
    @Inject
    PoliticalPartyDAO dao;
    
    @Inject
    VoterDAO dao2;
    
    private List<PoliticalParty> parties;
    private Long selectedVoteOption;
    private Voter var1;
    private String dpi;
    private String var3;

    public List<PoliticalParty> getParties() {
        parties = dao.findAll();
        return parties;
    }

    public void setParties(List<PoliticalParty> parties) {
        this.parties = parties;
    }

    public Long getSelectedVoteOption() {
        return selectedVoteOption;
    }

    public void setSelectedVoteOption(Long selectedVoteOption) {
        this.selectedVoteOption = selectedVoteOption;
    }
    
    public void vote() {
        var1 = dao2.findById(dpi);
        System.out.print(var1);
        var3 = var1.getDpi();
        System.out.print(var3);
        
        if(var1.equals(var3)){
            System.out.println("error" );
            
        }
        
        System.out.println("Usted esta votando por: " + selectedVoteOption);
    }

    public void setVar1(Voter var1) {
        this.var1 = var1;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public void setVar3(String var3) {
        this.var3 = var3;
    }

    public Voter getDpi() {
        return var1;
    }

    public String getdpi() {
        return dpi;
    }

    public String getVar3() {
        return var3;
    } 
    
}

