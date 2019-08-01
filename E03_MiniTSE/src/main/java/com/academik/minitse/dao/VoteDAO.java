
package com.academik.minitse.dao;



import com.academik.minitse.model.VotingTable;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author drk_j
 */

@RequestScoped
public class VoteDAO {
    
    @PersistenceContext(unitName="MiniTSE_PU")
    EntityManager em;
    
   public VotingTable findById(Long id) {
        VotingTable table = em.find(VotingTable.class, id);
        return table;
    }
    
}
