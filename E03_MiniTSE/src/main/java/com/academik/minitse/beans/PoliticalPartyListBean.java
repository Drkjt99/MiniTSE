
package com.academik.minitse.beans;

import com.academik.minitse.dao.PoliticalPartyDAO;
import com.academik.minitse.model.PoliticalParty;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 *
 * @author drk_j
 */

@ManagedBean(name = "politicalPartyListBean")
@RequestScoped
public class PoliticalPartyListBean {
       
    @Inject
    PoliticalPartyDAO daoParty;
    
    List<PoliticalParty> politicalP;
    
    public List<PoliticalParty> getAllPartys() {
        politicalP = daoParty.findAll();
        return politicalP;
    }
    
    
    public void delete(Long id) {
        daoParty.delete(id);
        politicalP = daoParty.findAll();
    }
}
