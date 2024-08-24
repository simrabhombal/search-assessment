package com.makersharks.search_api_makersharks;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.makersharks.search_api_makersharks.beans.Supplier;
import com.makersharks.search_api_makersharks.beans.User;
import com.makersharks.search_api_makersharks.repository.SupplierRepository;
import com.makersharks.search_api_makersharks.repository.UserRepository;

@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired	
	private UserRepository userRepository;

	

	@Test
	public void testListAllTask() {
		Iterable<User> listTasks = userRepository.findAll();
		System.out.println("List has found successfully");
		listTasks.forEach(task -> System.out.println(task));
	}



	
}
