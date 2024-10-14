package jdbc.dao;

import jdbc.Promo;

import java.util.List;

public interface PromoDAO {

	void create(Promo promo);

	List<Promo> getAll();

	Promo getById(int id);

	Promo update(Promo promo);

	void deleteById(int id);
}
