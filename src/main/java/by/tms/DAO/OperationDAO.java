package by.tms.DAO;


import by.tms.DAO.interfaces.Constants;
import by.tms.DAO.interfaces.OperationInterface;
import by.tms.entity.Operation;
import by.tms.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Repository
@Component
public class OperationDAO implements OperationInterface  {
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public void save(Operation operation) {
        Session currentSession=sessionFactory.getCurrentSession();
        currentSession.save(operation);
    }

    @Override
    @Transactional
    public List<Operation> getAll() {
        Session currentSession=sessionFactory.getCurrentSession();
        Query<Operation> query =currentSession.createQuery(" from Operation",Operation.class);
        List<Operation> resultList=query.getResultList();
        return resultList;
    }



}
