package com.shopping.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.shopping.model.Items;
import java.util.List;


@Repository
public interface ItemRepo extends JpaRepository<Items, Integer> {
	public Items findByName(String item_name);
}
