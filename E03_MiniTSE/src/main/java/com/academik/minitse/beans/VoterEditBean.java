
package com.academik.minitse.beans;

import com.academik.minitse.dao.VoterDAO;
import com.academik.minitse.dao.VotingTableDAO;
import com.academik.minitse.model.Voter;
import com.academik.minitse.model.VotingTable;
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

@ManagedBean (name = "VoterEditBean")
@ViewScoped
public class VoterEditBean implements Serializable {
    
    @Inject
    VoterDAO daoVoter;
    
    @Inject 
    VotingTableDAO daoVotingT;
    
    private Voter voter;
    private String tempFirstName;
    private String tempLastName;
    private String tempAddress;
    private String tempExtraAddress;
    private Long var1;
    private VotingTable votingTable;
    private Integer selectedVotingTableId;
    private List<VotingTable> allVotingTables;
    
    @PostConstruct
    public void init() {
        String idAsString = NabJSFUtil.getParameter("selected_id");
        if(idAsString == null) {
            try {
                NabJSFUtil.redirectTo("voters.xhtml");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return;
        }
        String id = idAsString;
        voter = daoVoter.findById(id);
        tempFirstName = voter.getFirstName();
        tempLastName = voter.getLastName();       
        tempAddress = voter.getAddress();
        tempExtraAddress = voter.getExtraAddress();  
        
    } 
    
    public Voter getVoter() {
        return voter;
    }

    public void setVoter(Voter voter) {
        this.voter = voter;
    }

    public String getTempFirstName() {
        return tempFirstName;
    }

    public void setTempFirstName(String tempFirstName) {
        this.tempFirstName = tempFirstName;
    }

    public String getTempLastName() {
        return tempLastName;
    }

    public void setTempLastName(String tempLastName) {
        this.tempLastName = tempLastName;
    }

    public String getTempAddress() {
        return tempAddress;
    }

    public void setTempAddress(String tempAddress) {
        this.tempAddress = tempAddress;
    }

    public String getTempExtraAddress() {
        return tempExtraAddress;
    }

    public void setTempExtraAddress(String tempExtraAddress) {
        this.tempExtraAddress = tempExtraAddress;
    }

    public Long getVar1() {
        return var1;
    }

    public void setVar1(Long var1) {
        this.var1 = var1;
    }

    public VotingTable getVotingTable() {
        return votingTable;
    }

    public void setVotingTable(VotingTable votingTable) {
        this.votingTable = votingTable;
    }

    public Integer getSelectedVotingTableId() {
        return selectedVotingTableId;
    }

    public void setSelectedVotingTableId(Integer selectedVotingTableId) {
        this.selectedVotingTableId = selectedVotingTableId;
    }

    public List<VotingTable> getAllVotingTables() {
        return allVotingTables;
    }

    public void setAllVotingTables(List<VotingTable> allVotingTables) {
        this.allVotingTables = allVotingTables;
    }
     
   public void Cambiando() {                
        
    }
   
    public String saveChanges() {
        votingTable = daoVotingT.findBytableNum(var1);
        voter.setTable(votingTable);
        voter.setFirstName(tempFirstName);
        voter.setLastName(tempLastName);
        voter.setAddress(tempAddress);
        voter.setExtraAddress(tempExtraAddress);  
        voter = daoVoter.update(voter);         
        return "voters";
    }  
}
