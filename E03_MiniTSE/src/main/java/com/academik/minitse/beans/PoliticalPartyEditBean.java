
package com.academik.minitse.beans;

import com.academik.minitse.dao.PoliticalPartyDAO;
import com.academik.minitse.model.PoliticalParty;
import com.academik.minitse.utils.NabJSFUtil;
import java.io.IOException;
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

@ManagedBean(name = "PoliticalPartyEditBean")
@ViewScoped
public class PoliticalPartyEditBean implements Serializable {
     
    @Inject
    PoliticalPartyDAO daoParty;
    
    private PoliticalParty politicalP;
    private String tempName;
    private String tempCandidate;
            
    @PostConstruct
    public void init() {
        String idAsString = NabJSFUtil.getParameter("selected_id");
        if(idAsString == null) {
            try {
                NabJSFUtil.redirectTo("voting-places.xhtml");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return;
        }
        Long id = Long.parseLong(idAsString);
        politicalP = daoParty.findById(id);
        tempName = politicalP.getName();
        tempCandidate = politicalP.getCandidate();
        
    } 

    public String getTempName() {
        return tempName;
    }

    public String getTempCandidate() {
        return tempCandidate;
    }

    public void setTempName(String tempName) {
        this.tempName = tempName;
    }

    public void setTempCandidate(String tempCandidate) {
        this.tempCandidate = tempCandidate;
    }
    
    public String saveChanges() {
        politicalP.setName(tempName);
        politicalP.setCandidate(tempCandidate);
        politicalP = daoParty.update(politicalP);
        return "political-party";
    }
}
