package fis.cis.guitar.chorder.repository;

import fis.cis.guitar.chorder.entity.Chord;
import fis.cis.guitar.chorder.repository.api.AbstractRepository;
import fis.cis.guitar.chorder.repository.api.ChordDao;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ChordDaoImpl extends AbstractRepository<Chord> implements ChordDao{

    @Override
    public Chord findById(Long id) {
        return getEntityManager().find(Chord.class, id);
    }

    @Override
    public List<Chord> findAll() {
        return getEntityManager().createQuery("from Chord", Chord.class).getResultList();
    }

    @Override
    public Chord findByName(String name) {
        Query query = getEntityManager().createQuery("from Chord where name = :name", Chord.class);
        query.setParameter("name", name);
        return getSingleResult(query);
    }

    @Override
    public List<Chord> findByNameLike(String name) {
        Query query = getEntityManager().createQuery("from Chord where name like :name", Chord.class);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }

    @Override
    public Chord addChord(Chord chord) {
        if (findByName(chord.getName()) != null){
            return getEntityManager().merge(chord);
        } else {
            getEntityManager().persist(chord);
            return chord;
        }
    }
}
