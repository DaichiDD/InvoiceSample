package sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sample.dto.InvoiceDto;
import sample.util.DBUtil;

public class InvoiceDao {

	private Connection connection;

	public InvoiceDao() throws InstantiationException, IllegalAccessException {
		connection = DBUtil.getConnection();
	}

	public void create(InvoiceDto invoice) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO invoices(title,detail,totalFee,deleteFlg,updated_at) values (?, ?, ?, ?, ?)");

			preparedStatement.setString(1, invoice.getTitle());
			preparedStatement.setString(2, invoice.getDetail());
			preparedStatement.setInt(3, Integer.parseInt(invoice.getTotalfee()));
			preparedStatement.setBoolean(4, false);
			preparedStatement.setDate(5, new java.sql.Date(new Date().getTime()));
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int invoiceId) {

	}

	public void update(InvoiceDto invoice) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update incoices set title=?, detail=?, totalFee=?, updated_at=? where id = ?");

			preparedStatement.setString(1, invoice.getTitle());
			preparedStatement.setString(2, invoice.getDetail());
			preparedStatement.setInt(3, Integer.parseInt(invoice.getTotalfee()));
			preparedStatement.setDate(4, new java.sql.Date(new Date().getTime()));
			preparedStatement.setInt(5, Integer.parseInt(invoice.getInvoiceId()));
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

	public List<InvoiceDto> selectAll() {
		List<InvoiceDto> invoices = new ArrayList<InvoiceDto>();

		try {
			Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery("SELECT * FROM invoices");

			while(rs.next()) {
				InvoiceDto invoice = new InvoiceDto();
				invoice.setInvoiceId(rs.getString("id"));
				invoice.setTitle(rs.getString("title"));
				invoice.setDetail(rs.getString("detail"));
				invoice.setTotalfee(String.valueOf(rs.getInt("totalFee")));
				invoice.setUpdate_date(rs.getDate("updated_at"));
				invoices.add(invoice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return invoices;
	}

	public InvoiceDto selectById(int invoiceId) {
		InvoiceDto invoice = new InvoiceDto();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(
							"select * from invoices where id=? and delete_flg=0");
			preparedStatement.setInt(1, invoiceId);

			ResultSet rs = preparedStatement.executeQuery();

			while(rs.next()) {
				invoice.setInvoiceId(rs.getString("id"));
				invoice.setTitle(rs.getString("title"));
				invoice.setDetail(rs.getString("detail"));
				invoice.setTotalfee(String.valueOf(rs.getInt("totalFee")));
				invoice.setUpdate_date(rs.getTimestamp("updated_at"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return invoice;
	}

}
