package jdbc.service;

import jdbc.Conf;
import jdbc.Promo;
import jdbc.dao.PromoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PromoService extends Conf implements PromoDAO {


	@Override
	public void create(Promo promo) {

		String sqlQuery = "INSERT INTO PROMO (NAME, BENEFIT) VALUES (?, ?)";

		try (Connection connection = getConnection();
		     PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {

			preparedStatement.setLong(1, promo.getId());
			preparedStatement.setString(2, promo.getName());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Promo> getAll() {

		List<Promo> promoList = new ArrayList<>();
		String sqlQuery = "SELECT * FROM PROMO";

		try (
				Connection connection = getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sqlQuery)
				){

			while(resultSet.next()) {
				Promo promo = new Promo();
				promo.setId((int) resultSet.getLong("ID"));
				promo.setName(resultSet.getString("NAME"));

				promoList.add(promo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return promoList;
	}

	@Override
	public Promo getById(int id) {
		return null;
	}

	@Override
	public Promo update(Promo promo) {
		return null;
	}

	@Override
	public void deleteById(int id) {

	}
}
