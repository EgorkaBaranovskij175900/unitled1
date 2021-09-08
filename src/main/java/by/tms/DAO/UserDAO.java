package by.tms.DAO;

import by.tms.DAO.interfaces.UserInterface;
import by.tms.entity.User;
import lombok.NoArgsConstructor;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.annotation.Documented;
import java.util.List;
@Repository
@Component
@NoArgsConstructor
@Service
public class UserDAO implements UserInterface  {

	private  SessionFactory sessionFactory;
    @Autowired
	public UserDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	@Transactional
	public void save(User user) {
		Session currentSession=sessionFactory.openSession();
		currentSession.save(user);

	}

	@Override
	@Transactional
	public List<User> getAll() {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<User> query =currentSession.createQuery("from User",User.class);
		List<User> resultList=query.getResultList();
		return resultList;
	}

	@Override
	@Transactional
	public boolean existByUserName(String username) {
		boolean rez=false;
		Session currentSession=sessionFactory.getCurrentSession();
		Query<User> existUser=currentSession.createQuery("from User where username =:username",User.class);
		if(existUser!=null){
			rez=true;
		}
		return rez;
	}

	@Override
	@Transactional
	public User findByUsername(String username) {
		Session currentSession=sessionFactory.getCurrentSession();
		Query<User> existUser=currentSession.createQuery("from User where username =:username",User.class);
		existUser.setParameter("username",username);
		User singleResult=existUser.getSingleResult();
		return singleResult;
	}
}
