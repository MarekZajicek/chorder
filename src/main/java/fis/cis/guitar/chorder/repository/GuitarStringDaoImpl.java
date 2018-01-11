package fis.cis.guitar.chorder.repository;

import fis.cis.guitar.chorder.entity.Chord;
import fis.cis.guitar.chorder.entity.GuitarString;
import fis.cis.guitar.chorder.repository.api.AbstractRepository;
import fis.cis.guitar.chorder.repository.api.ChordDao;
import fis.cis.guitar.chorder.repository.api.GuitarStringDao;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class GuitarStringDaoImpl extends AbstractRepository<GuitarString> implements GuitarStringDao {

    @Override
    public GuitarString findById(Long id) {
        return getEntityManager().find(GuitarString.class, id);
    }

    @Override
    public List<GuitarString> findAll() {
        return getEntityManager().createQuery("from GuitarString", GuitarString.class).getResultList();
    }

    @Override
    public GuitarString findByName(String name) {
        Query query = getEntityManager().createQuery("from GuitarString where name = :name", GuitarString.class);
        query.setParameter("name", name);
        return getSingleResult(query);
    }

    @Override
    public GuitarString addGuitarString(GuitarString guitarString) {
        if (findByName(guitarString.getName()) != null){
            return getEntityManager().merge(guitarString);
        } else {
            getEntityManager().persist(guitarString);
            return guitarString;
        }
    }

    @Override
    public GuitarString addGuitarString(String name, String alternativeName, String smallCapsName) {
        GuitarString guitarString = new GuitarString();
        guitarString.setName(name);
        guitarString.setAlternativeName(alternativeName);
        guitarString.setSmallCapsName(smallCapsName);
        return getEntityManager().merge(guitarString);
    }
}
