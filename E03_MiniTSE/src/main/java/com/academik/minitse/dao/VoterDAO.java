package com.academik.minitse.dao;

import com.academik.minitse.model.Voter;
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
public class VoterDAO {
    
    @PersistenceContext(unitName = "MiniTSE_PU")
    EntityManager em;
    
    @Transactional
    public void register(Voter newVoter){
        em.persist(newVoter);
    }

    @Transactional
    public List<Voter> findAll() {
        //JPQL
        TypedQuery<Voter> query = em.createQuery(
                //Equivalente a SELECT * FROM votante
                "SELECT v FROM Voter v", 
                Voter.class
        );
        List<Voter> result = query.getResultList();
        return result;
    }
    
    public Voter findById(String dpi) {
        Voter place = em.find(Voter.class, dpi);
        return place;
    }
    
    @Transactional
    public void delete(String dpi) {
        Voter voterToDelete = em.find(Voter.class, dpi);
        em.remove(voterToDelete);
    }
    
    @Transactional
    public Voter update(Voter place) {
        Voter updated = em.merge(place);
        return updated;
    }
    
}
