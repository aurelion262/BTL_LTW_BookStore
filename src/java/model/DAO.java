/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Account;
import model.Book;
import model.Log;
import model.BooksInCart;

/**
 *
 * @author i1vag_000
 */
public class DAO {
    private Connection conn;
    //JDBC
    public DAO()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/bookstoreweb"
            + "?useUnicode=true&characterEncoding=utf-8","root","0793145");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String checkUsername(String s)
    {
        String sql="SELECT * FROM BOOKSTOREWEB.TBLACCOUNT WHERE USERNAME=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) return "used";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "available";
    }
    
    public void addAccount(Account a)
    {
        String sql="INSERT INTO BOOKSTOREWEB.TBLACCOUNT(NAME,USERNAME,PASSWORD,PHONENUMBER,ADDRESS,EMAIL,CREDITCARD) "
                 + "VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, a.getName());
            ps.setString(2, a.getUsername());
            ps.setString(3, a.getPassword());
            ps.setString(4, a.getPhonenumber());
            ps.setString(5, a.getAddress());
            ps.setString(6, a.getEmail());
            ps.setString(7, a.getCreditcard());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void editAccount(Account a)
    {
        String sql="UPDATE BOOKSTOREWEB.TBLACCOUNT "
                  +"SET NAME=?,USERNAME=?,PASSWORD=?,PHONENUMBER=?,ADDRESS=?,EMAIL=?,CREDITCARD=?,ROLE=? "
                  +"WHERE ID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, a.getName());
            ps.setString(2, a.getUsername());
            ps.setString(3, a.getPassword());
            ps.setString(4, a.getPhonenumber());
            ps.setString(5, a.getAddress());
            ps.setString(6, a.getEmail());
            ps.setString(7, a.getCreditcard());
            ps.setString(8, a.getRole());
            ps.setInt(9, a.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void removeAccount(int id)
    {
        try {
            String sql="DELETE FROM BOOKSTOREWEB.TBLACCOUNT WHERE ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Get all accounts
    public ArrayList<Account> getAccount()
    {
        ArrayList<Account> list = new ArrayList<>();
        String sql = "SELECT * FROM BOOKSTOREWEB.TBLACCOUNT";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Account a = new Account();
                a.setId(rs.getInt("ID"));
                a.setUsername(rs.getString("USERNAME"));
                a.setPassword(rs.getString("PASSWORD"));
                a.setRole(rs.getString("ROLE"));
                a.setAddress(rs.getString("ADDRESS"));
                a.setCreditcard(rs.getString("CREDITCARD"));
                a.setEmail(rs.getString("EMAIL"));
                a.setName(rs.getString("NAME"));
                a.setPhonenumber(rs.getString("PHONENUMBER"));
                list.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    //For log in
    public Account getAccount(String username, String password)
    {
        try {
            String sql="SELECT * FROM BOOKSTOREWEB.TBLACCOUNT "
                      +"WHERE USERNAME=? AND PASSWORD=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                Account a = new Account();
                a.setId(rs.getInt("ID"));
                a.setUsername(rs.getString("USERNAME"));
                a.setPassword(rs.getString("PASSWORD"));
                a.setRole(rs.getString("ROLE"));
                a.setAddress(rs.getString("ADDRESS"));
                a.setCreditcard(rs.getString("CREDITCARD"));
                a.setEmail(rs.getString("EMAIL"));
                a.setName(rs.getString("NAME"));
                a.setPhonenumber(rs.getString("PHONENUMBER"));
                return a;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //Get account by ID
    public Account getAccount(int id)
    {
        String sql = "SELECT * FROM BOOKSTOREWEB.TBLACCOUNT WHERE ID=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Account a = new Account();
                a.setId(rs.getInt("ID"));
                a.setUsername(rs.getString("USERNAME"));
                a.setPassword(rs.getString("PASSWORD"));
                a.setRole(rs.getString("ROLE"));
                a.setAddress(rs.getString("ADDRESS"));
                a.setCreditcard(rs.getString("CREDITCARD"));
                a.setEmail(rs.getString("EMAIL"));
                a.setName(rs.getString("NAME"));
                a.setPhonenumber(rs.getString("PHONENUMBER"));
                return a;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //Get account by username
    public Account getAccount(String username)
    {
        String sql = "SELECT * FROM BOOKSTOREWEB.TBLACCOUNT WHERE USERNAME=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Account a = new Account();
                a.setId(rs.getInt("ID"));
                a.setUsername(rs.getString("USERNAME"));
                a.setPassword(rs.getString("PASSWORD"));
                a.setRole(rs.getString("ROLE"));
                a.setAddress(rs.getString("ADDRESS"));
                a.setCreditcard(rs.getString("CREDITCARD"));
                a.setEmail(rs.getString("EMAIL"));
                a.setName(rs.getString("NAME"));
                a.setPhonenumber(rs.getString("PHONENUMBER"));
                return a;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //Get all accounts' IDs
    public ArrayList<Integer> getAccountId()
    {
        ArrayList<Integer> id = new ArrayList<>();
        String sql = "SELECT ID FROM TBLACCOUNT";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                id.add(rs.getInt("ID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
    
    public void addBook(Book b)
    {
        String sql="INSERT INTO BOOKSTOREWEB.TBLBOOK(NAME, AUTHOR, PUBLISHER, CATEGORY, DESCRIPTION, IMAGEURL, RELEASEDYEAR, DISCOUNT, FINALPRICE) "
                 + "VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, b.getName());
            ps.setString(2, b.getAuthor());
            ps.setString(3, b.getPublisher());
            ps.setString(4, b.getCategory());
            ps.setString(5, b.getDescription());
            ps.setString(6, b.getImageurl());
            ps.setInt(7, b.getReleasedyear());
            ps.setInt(8, b.getDiscount());
            ps.setInt(9, b.getFinalprice());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void editBook(Book b)
    {
        String sql="UPDATE BOOKSTOREWEB.TBLBOOK "
                  +"SET NAME=?,AUTHOR=?,PUBLISHER=?,CATEGORY=?,DESCRIPTION=?, "
                  +"IMAGERURL=?,RELEASEDYEAR=?,DISCOUNT=?,FINALPRICE=? "
                  +"WHERE ID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, b.getName());
            ps.setString(2, b.getAuthor());
            ps.setString(3, b.getPublisher());
            ps.setString(4, b.getCategory());
            ps.setString(5, b.getDescription());
            ps.setString(6, b.getImageurl());
            ps.setInt(7, b.getReleasedyear());
            ps.setInt(8, b.getDiscount());
            ps.setInt(9, b.getFinalprice());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void removeBook(int id)
    {
        try {
            String sql="DELETE FROM BOOKSTOREWEB.TBLBOOK WHERE ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Get all Books
    public ArrayList<Book> getBook()
    {
        ArrayList<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM BOOKSTOREWEB.TBLBOOK";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Book b = new Book();
                b.setId(rs.getInt("ID"));
                b.setAuthor(rs.getString("AUTHOR"));
                b.setCategory(rs.getString("CATEGORY"));
                b.setDescription(rs.getString("DESCRIPTION"));
                b.setDiscount(rs.getInt("DISCOUNT"));
                b.setFinalprice(rs.getInt("FINALPRICE"));
                b.setImageurl(rs.getString("IMAGEURL"));
                b.setName(rs.getString("NAME"));
                b.setPublisher(rs.getString("PUBLISHER"));
                b.setReleasedyear(rs.getInt("RELEASEDYEAR"));
                list.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<Book> getSaleOffBook()
    {
        ArrayList<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM BOOKSTOREWEB.TBLBOOK ORDER BY DISCOUNT DESC LIMIT 7";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Book b = new Book();
                b.setId(rs.getInt("ID"));
                b.setAuthor(rs.getString("AUTHOR"));
                b.setCategory(rs.getString("CATEGORY"));
                b.setDescription(rs.getString("DESCRIPTION"));
                b.setDiscount(rs.getInt("DISCOUNT"));
                b.setFinalprice(rs.getInt("FINALPRICE"));
                b.setImageurl(rs.getString("IMAGEURL"));
                b.setName(rs.getString("NAME"));
                b.setPublisher(rs.getString("PUBLISHER"));
                b.setReleasedyear(rs.getInt("RELEASEDYEAR"));
                list.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<Book> getBestSellingBook()
    {
        ArrayList<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM BOOKSTOREWEB.TBLBOOK ORDER BY SOLD DESC LIMIT 7";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Book b = new Book();
                b.setId(rs.getInt("ID"));
                b.setAuthor(rs.getString("AUTHOR"));
                b.setCategory(rs.getString("CATEGORY"));
                b.setDescription(rs.getString("DESCRIPTION"));
                b.setDiscount(rs.getInt("DISCOUNT"));
                b.setFinalprice(rs.getInt("FINALPRICE"));
                b.setImageurl(rs.getString("IMAGEURL"));
                b.setName(rs.getString("NAME"));
                b.setPublisher(rs.getString("PUBLISHER"));
                b.setReleasedyear(rs.getInt("RELEASEDYEAR"));
                list.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public Book getBook(int id)
    {
        String sql = "SELECT * FROM BOOKSTOREWEB.TBLBOOK WHERE ID=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Book b = new Book();
                b.setId(rs.getInt("ID"));
                b.setAuthor(rs.getString("AUTHOR"));
                b.setCategory(rs.getString("CATEGORY"));
                b.setDescription(rs.getString("DESCRIPTION"));
                b.setDiscount(rs.getInt("DISCOUNT"));
                b.setFinalprice(rs.getInt("FINALPRICE"));
                b.setImageurl(rs.getString("IMAGEURL"));
                b.setName(rs.getString("NAME"));
                b.setPublisher(rs.getString("PUBLISHER"));
                b.setReleasedyear(rs.getInt("RELEASEDYEAR"));
                return b;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<Book> getBookByName(String name)
    {
        ArrayList<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM BOOKSTOREWEB.TBLBOOK "
                    +"WHERE NAME LIKE '%"+name+"%'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Book b = new Book();
                b.setId(rs.getInt("ID"));
                b.setAuthor(rs.getString("AUTHOR"));
                b.setCategory(rs.getString("CATEGORY"));
                b.setDescription(rs.getString("DESCRIPTION"));
                b.setDiscount(rs.getInt("DISCOUNT"));
                b.setFinalprice(rs.getInt("FINALPRICE"));
                b.setImageurl(rs.getString("IMAGEURL"));
                b.setName(rs.getString("NAME"));
                b.setPublisher(rs.getString("PUBLISHER"));
                b.setReleasedyear(rs.getInt("RELEASEDYEAR"));
                list.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<Book> getBookByAuthor(String author)
    {
        ArrayList<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM BOOKSTOREWEB.TBLBOOK "
                    +"WHERE AUTHOR LIKE '%"+author+"%'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Book b = new Book();
                b.setId(rs.getInt("ID"));
                b.setAuthor(rs.getString("AUTHOR"));
                b.setCategory(rs.getString("CATEGORY"));
                b.setDescription(rs.getString("DESCRIPTION"));
                b.setDiscount(rs.getInt("DISCOUNT"));
                b.setFinalprice(rs.getInt("FINALPRICE"));
                b.setImageurl(rs.getString("IMAGEURL"));
                b.setName(rs.getString("NAME"));
                b.setPublisher(rs.getString("PUBLISHER"));
                b.setReleasedyear(rs.getInt("RELEASEDYEAR"));
                list.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<Book> getBookByCategory(String category)
    {
        ArrayList<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM BOOKSTOREWEB.TBLBOOK "
                    +"WHERE CATEGORY LIKE '%"+category+"%'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Book b = new Book();
                b.setId(rs.getInt("ID"));
                b.setAuthor(rs.getString("AUTHOR"));
                b.setCategory(rs.getString("CATEGORY"));
                b.setDescription(rs.getString("DESCRIPTION"));
                b.setDiscount(rs.getInt("DISCOUNT"));
                b.setFinalprice(rs.getInt("FINALPRICE"));
                b.setImageurl(rs.getString("IMAGEURL"));
                b.setName(rs.getString("NAME"));
                b.setPublisher(rs.getString("PUBLISHER"));
                b.setReleasedyear(rs.getInt("RELEASEDYEAR"));
                list.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<Book> getBook(int floorPrice, int ceilingPrice)
    {
        ArrayList<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM BOOKSTOREWEB.TBLBOOK "
                    +"WHERE FINALPRICE > ? AND FINALPRICE < ? "
                    +"ORDER BY FINALPRICE";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, floorPrice);
            ps.setInt(2, ceilingPrice);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Book b = new Book();
                b.setId(rs.getInt("ID"));
                b.setAuthor(rs.getString("AUTHOR"));
                b.setCategory(rs.getString("CATEGORY"));
                b.setDescription(rs.getString("DESCRIPTION"));
                b.setDiscount(rs.getInt("DISCOUNT"));
                b.setFinalprice(rs.getInt("FINALPRICE"));
                b.setImageurl(rs.getString("IMAGEURL"));
                b.setName(rs.getString("NAME"));
                b.setPublisher(rs.getString("PUBLISHER"));
                b.setReleasedyear(rs.getInt("RELEASEDYEAR"));
                list.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<String> getCategory()
    {
        ArrayList<String> list = new ArrayList<>();
        try {
            String sql = "SELECT DISTINCT CATEGORY FROM BOOKSTOREWEB.TBLBOOK";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                list.add(rs.getString("CATEGORY"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<String> getAuthor()
    {
        ArrayList<String> list = new ArrayList<>();
        try {
            String sql = "SELECT DISTINCT AUTHOR FROM BOOKSTOREWEB.TBLBOOK";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                list.add(rs.getString("AUTHOR"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public void addLog(Log l)
    {
        String sql = "INSERT INTO BOOKSTOREWEB.TBLLOG(ACCOUNTID,DATE,ACTION,OBJECTTYPE,OBJECTID,DETAIL) "
                    +"VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(2, l.getDate());
            ps.setInt(1, l.getAccountId());
            ps.setString(3, l.getAction());
            ps.setString(4, l.getObjectType());
            ps.setInt(5, l.getObjectId());
            ps.setString(6, l.getDetail());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Log> getLog()
    {
        ArrayList<Log> list = new ArrayList<>();
        String sql = "SELECT * FROM BOOKSTOREWEB.TBLLOG";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Log l = new Log();
                l.setAccountId(rs.getInt("ACCOUNTID"));
                l.setDate(rs.getString("DATE"));
                l.setAction(rs.getString("ACTION"));
                l.setId(rs.getInt("ID"));
                l.setObjectId(rs.getInt("OBJECTID"));
                l.setObjectType(rs.getString("OBJECTTYPE"));
                l.setDetail(rs.getString("DETAIL"));
                list.add(l);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public BooksInCart getFromCart(int accountId, int bookId)
    {
        
        String sql = "SELECT * FROM BOOKSTOREWEB.TBLBOOKSINCART "
                   + "WHERE ACCOUNTID=? AND BOOKID=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, accountId);
            ps.setInt(2, bookId);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                BooksInCart bic = new BooksInCart();
                bic.setAccountId(rs.getInt("ACCOUNTID"));
                bic.setBookId(rs.getInt("BOOKID"));
                bic.setQuantity(rs.getInt("QUANTITY"));
                return bic;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<BooksInCart> getAllFromCart(int accountId)
    {
        ArrayList<BooksInCart> list = new ArrayList<>();
        String sql = "SELECT * FROM BOOKSTOREWEB.TBLBOOKSINCART "
                   + "WHERE ACCOUNTID=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, accountId);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                BooksInCart bic = new BooksInCart();
                bic.setAccountId(rs.getInt("ACCOUNTID"));
                bic.setBookId(rs.getInt("BOOKID"));
                bic.setQuantity(rs.getInt("QUANTITY"));
                list.add(bic);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public void addToCart(BooksInCart bic)
    {
        String sql = "INSERT INTO BOOKSTOREWEB.TBLBOOKSINCART (ACCOUNTID, BOOKID, QUANTITY) "
                   + "VALUES (?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, bic.getAccountId());
            ps.setInt(2, bic.getBookId());
            ps.setInt(3, bic.getQuantity());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void editBooksInCart(BooksInCart bic)
    {
        String sql = "UPDATE BOOKSTOREWEB.TBLBOOKSINCART "
                   + "SET QUANTITY=? "
                   + "WHERE ACCOUNTID=? AND BOOKID=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, bic.getQuantity());
            ps.setInt(2, bic.getAccountId());
            ps.setInt(3, bic.getBookId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void removeAllFromCart(int accountId)
    {
        String sql = "DELETE FROM BOOKSTOREWEB.TBLBOOKSINCART "
                   + "WHERE ACCOUNTID=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, accountId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void removeFromCart(int accountId, int bookId)
    {
        String sql = "DELETE FROM BOOKSTOREWEB.TBLBOOKSINCART "
                   + "WHERE ACCOUNTID=? AND BOOKID=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, accountId);
            ps.setInt(2, bookId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
