package Repository;

import Entity.Product;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;


public class Database {
    private Connection connection;

    public Database() throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/store_data?characterEncoding=UTF8&user=leo&password=leonsio505L");
    }

    public Product getProduct(String id) throws SQLException {
        PreparedStatement st = connection.prepareStatement("Select * from products where productid = '" + id + "';");
        ResultSet res = st.executeQuery();
        Product myProd = null;
        while(res.next()){
             myProd = Product.getInstance(res.getString("productid"),res.getString("name"),res.getString("imagefile"),Double.valueOf(res.getString("price")));
        }
        return myProd;
    }


    public Set<Product> getAll() throws SQLException {
        Set<Product> prods = new HashSet<>();
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM products;");
        if(connection == null)return null;
        ResultSet res = stm.executeQuery();
        while(res.next()){
            prods.add(getProduct(res.getString(1)));
        }
        return prods;
    }


}
