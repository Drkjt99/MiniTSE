package com.academik.minitse.beans;

import com.academik.minitse.dao.PoliticalPartyDAO;
import com.academik.minitse.dao.VoteDAO;
import com.academik.minitse.dao.VoterDAO;
import com.academik.minitse.dao.VotingTableDAO;
import com.academik.minitse.model.PoliticalParty;
import com.academik.minitse.model.Vote;
import com.academik.minitse.model.Voter;
import com.academik.minitse.model.VotingTable;
import com.academik.minitse.model.VotingTable_;
import com.academik.minitse.utils.NabJSFUtil;
import java.io.IOException;
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
    
    @Inject
    VoteDAO dao3;
    
    @Inject
    VotingTableDAO dao4;
    
    @Inject
    PoliticalPartyDAO dao5;
    
    private List<PoliticalParty> parties;
    private Long selectedVoteOption;
    private Voter voter;
    private VotingTable votingTable = null;
    private VotingTable votingTable2;
    private String dpi = null;
    private Boolean tempVoted = false;
    private Integer tableNum;
    private String var3;
    private Long var2;    
    private Integer tempNullQuantity = 0;
    private Integer tempBlankQuantity = 0;
    private Integer counter;
    private Vote vote;

    public List<PoliticalParty> getParties() {
        parties = dao.findAll();
        return parties;
    }
    
    public void vote() throws IOException {
        //DPI validation
        try{   
            System.out.println(tempBlankQuantity);
            voter = dao2.findById(dpi);
            System.out.println(dpi);
            //votingTable2 = voter.getTable();
            //votingTable2 = dao4.findBytableNum(var2);                                
            tempVoted = voter.getVoted();            
            
            
            if(tempVoted==true /*|| votingTable == null*/){
                NabJSFUtil.redirectTo("vote-submit.xhtml");
            
                
            }else if(tempBlankQuantity > 0){
                    tempBlankQuantity = votingTable.getBlankQuantity();
                    counter = tempBlankQuantity + 1;
                    votingTable.setBlankQuantity(counter);                    
                    votingTable = dao4.updateTable(votingTable);
                    
                    
                }else if(tempNullQuantity > 0){
                    tempNullQuantity = votingTable.getNullQuantity();
                    counter = tempNullQuantity + 1;
                    votingTable.setNullQuantity(counter);
                    votingTable = dao4.updateTable(votingTable);
                    
                }
                  
                voter.setVoted(true);
                voter = dao2.update(voter);
                        
            
            
        }catch(NullPointerException x){
            System.out.println("error en el comando");
        }                  
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

    public Voter getVoter() {
        return voter;
    }

    public void setVoter(Voter voter) {
        this.voter = voter;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public String getVar3() {
        return var3;
    }

    public void setVar3(String var3) {
        this.var3 = var3;
    }

    public Boolean getTempVoted() {
        return tempVoted;
    }

    public void setTempVoted(Boolean tempVoted) {
        this.tempVoted = tempVoted;
    }

    public Integer getTableNum() {
        return tableNum;
    }

    public void setTableNum(Integer tableNum) {
        this.tableNum = tableNum;
    }

    public VotingTable getVotingTable() {
        return votingTable;
    }

    public void setVotingTable(VotingTable votingTable) {
        this.votingTable = votingTable;
    }

    public Long getVar2() {
        return var2;
    }

    public void setVar2(Long var2) {
        this.var2 = var2;
    }

    public Integer getTempNullQuantity() {
        return tempNullQuantity;
    }

    public void setTempNullQuantity(Integer tempNullQuantity) {
        this.tempNullQuantity = tempNullQuantity;
    }

    public Integer getTempBlankQuantity() {
        return tempBlankQuantity;
    }

    public void setTempBlankQuantity(Integer tempBlankQuantity) {
        this.tempBlankQuantity = tempBlankQuantity;
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public Vote getVote() {
        return vote;
    }

    public void setVote(Vote vote) {
        this.vote = vote;
    }

    public VotingTable getVotingTable2() {
        return votingTable2;
    }

    public void setVotingTable2(VotingTable votingTable2) {
        this.votingTable2 = votingTable2;
    }
    
    
}