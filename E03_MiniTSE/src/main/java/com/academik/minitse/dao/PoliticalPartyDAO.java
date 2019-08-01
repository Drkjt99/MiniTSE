package com.academik.minitse.dao;

import com.academik.minitse.model.PoliticalParty;
import java.util.List;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

/**
 *
 * @author esvux
 */
@RequestScoped
public class PoliticalPartyDAO {

    @PersistenceContext(unitName = "MiniTSE_PU")
    EntityManager em;
    
    @Transactional
    public void register(PoliticalParty newPoliticalParty){
        em.persist(newPoliticalParty);
    }

    @Transactional
    public List<PoliticalParty> findAll() {
        //JPQL
        TypedQuery<PoliticalParty> query = em.createQuery(
                "SELECT pp FROM PoliticalParty pp", 
                PoliticalParty.class
        );
        List<PoliticalParty> result = query.getResultList();
        return result;
    }
    
    public PoliticalParty findById(Long id) {
        PoliticalParty place = em.find(PoliticalParty.class, id);
        return place;
    }
    
    @Transactional
    public PoliticalParty update(PoliticalParty place) {
        PoliticalParty updated = em.merge(place);
        return updated;
    }
    
    @Transactional
    public void delete(Long id) {
        PoliticalParty partyToDelete = em.find(PoliticalParty.class, id);
        em.remove(partyToDelete);
    }
    
}
