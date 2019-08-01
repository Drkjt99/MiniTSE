package com.academik.minitse.dao;

import com.academik.minitse.model.Vote;
import com.academik.minitse.model.VotingTable;
import java.util.List;
import javax.enterprise.inject.Typed;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

/**
 *
 * @author drk_j
 */

@RequestScoped
public class VotingTableDAO {
    
    @PersistenceContext (unitName = "MiniTSE_PU")
    EntityManager em;
     /*      
    @Transactional
    public List<VotingTable> findByTable(VotingTable table) {
        //JPQL
        TypedQuery<VotingTable> query = em.createQuery(
                "SELECT v FROM votingTable v WHERE v.tableNum = :tabla", 
                VotingTable.class
        );
        query.setParameter("tabla", table);
        List<VotingTable> result = query.getResultList();
        return result;
    }*/
    
    @Transactional
    public VotingTable findBytableNum(Long id) {
        VotingTable table = em.find(VotingTable.class, id);
        return table;
    }
    
    @Transactional
    public VotingTable updateTable(VotingTable place) {
        VotingTable updated = em.merge(place);
        return updated;
    }
}
