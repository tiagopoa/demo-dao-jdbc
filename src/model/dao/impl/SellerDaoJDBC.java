package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {

	private Connection conn;

	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
		st = conn.prepareStatement("SELECT seller.*, department.Name as DepName"
				+ " FROM seller INNER JOIN department"
				+ " ON seller.DepartmentId = department.Id"
				+ " WHERE seller.Id = ?");
		
		st.setInt(1, id);		
		rs = st.executeQuery();
		if (rs.next()) {
			Seller seller = instantiateSeller(rs,instantiateDepartment(rs));
			return seller;
		} 
		return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}	
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {
		Seller obj = new Seller(rs.getInt("id"), 
				rs.getString("name"), 
				rs.getString("email"), 
				rs.getDate("birthDate"), 
				rs.getDouble("baseSalary"),
				dep);
				return obj;
	}

	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department dep = new Department(rs.getInt("DepartmentId"),
				rs.getString("DepName"));
		return dep;
	}

	@Override
	public List<Seller> findAll() {
		
		return null;
	}

}
