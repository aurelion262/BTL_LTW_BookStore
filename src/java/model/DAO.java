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
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstoreweb"
            + "?useUnicode=true&characterEncoding=utf-8","root","0793145");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void close()
    {
        if (conn != null)
        {
            try
            {
                conn.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
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
                  +"IMAGEURL=?,RELEASEDYEAR=?,DISCOUNT=?,FINALPRICE=? "
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
            ps.setInt(10, b.getId());
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
    
    public Book getLastBook()
    {
        String sql = "SELECT * FROM BOOKSTOREWEB.TBLBOOK ORDER BY ID DESC LIMIT 1";
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
                return b;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
    
    public void createOrder(Order o)
    {
        String sql = "INSERT INTO BOOKSTOREWEB.TBLORDER (ACCOUNTID, TOTALPRICE, ISDELIVERED, ISDELIVERING, ISPAID, CREATEDDATE, ADDRESS, PHONENUMBER, CLIENTNAME) "
                   + "VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, o.getAccountId());
            ps.setInt(2, o.getTotalPrice());
            ps.setInt(3, o.getIsDelivered());
            ps.setInt(4, o.getIsDelivering());
            ps.setInt(5, o.getIsPaid());
            ps.setString(6, o.getCreatedDate());
            ps.setString(7, o.getAddress());
            ps.setString(8, o.getPhoneNumber());
            ps.setString(9, o.getClientName());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Order getOrder(int orderId)
    {
        String sql = "SELECT * FROM BOOKSTOREWEB.TBLORDER "
                   + "WHERE ID=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Order o = new Order();
                o.setId(rs.getInt("ID"));
                o.setAccountId(rs.getInt("ACCOUNTID"));
                o.setAddress(rs.getString("ADDRESS"));
                o.setCreatedDate(rs.getString("CREATEDDATE"));
                o.setIsDelivered(rs.getInt("ISDELIVERED"));
                o.setIsDelivering(rs.getInt("ISDELIVERING"));
                o.setIsPaid(rs.getInt("ISPAID"));
                o.setPhoneNumber(rs.getString("PHONENUMBER"));
                o.setTotalPrice(rs.getInt("TOTALPRICE"));
                return o;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<Order> getAllOrder()
    {
        ArrayList<Order> list = new ArrayList<>();
        String sql = "SELECT * FROM BOOKSTOREWEB.TBLORDER";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Order o = new Order();
                o.setId(rs.getInt("ID"));
                o.setClientName(rs.getString("CLIENTNAME"));
                o.setAccountId(rs.getInt("ACCOUNTID"));
                o.setAddress(rs.getString("ADDRESS"));
                o.setCreatedDate(rs.getString("CREATEDDATE"));
                o.setIsDelivered(rs.getInt("ISDELIVERED"));
                o.setIsDelivering(rs.getInt("ISDELIVERING"));
                o.setIsPaid(rs.getInt("ISPAID"));
                o.setPhoneNumber(rs.getString("PHONENUMBER"));
                o.setTotalPrice(rs.getInt("TOTALPRICE"));
                list.add(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<Order> getAllOrder(int accountId)
    {
        ArrayList<Order> list = new ArrayList<>();
        String sql = "SELECT * FROM BOOKSTOREWEB.TBLORDER "
                   + "WHERE ACCOUNTID=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, accountId);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Order o = new Order();
                o.setId(rs.getInt("ID"));
                o.setAccountId(rs.getInt("ACCOUNTID"));
                o.setAddress(rs.getString("ADDRESS"));
                o.setCreatedDate(rs.getString("CREATEDDATE"));
                o.setIsDelivered(rs.getInt("ISDELIVERED"));
                o.setIsDelivering(rs.getInt("ISDELIVERING"));
                o.setIsPaid(rs.getInt("ISPAID"));
                o.setPhoneNumber(rs.getString("PHONENUMBER"));
                o.setTotalPrice(rs.getInt("TOTALPRICE"));
                list.add(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public Order getLastOrder(int accountId)
    {
        String sql = "SELECT * FROM BOOKSTOREWEB.TBLORDER WHERE ACCOUNTID=? ORDER BY ID DESC LIMIT 1";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, accountId);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Order o = new Order();
                o.setId(rs.getInt("ID"));
                o.setAccountId(rs.getInt("ACCOUNTID"));
                o.setAddress(rs.getString("ADDRESS"));
                o.setCreatedDate(rs.getString("CREATEDDATE"));
                o.setIsDelivered(rs.getInt("ISDELIVERED"));
                o.setIsDelivering(rs.getInt("ISDELIVERING"));
                o.setIsPaid(rs.getInt("ISPAID"));
                o.setPhoneNumber(rs.getString("PHONENUMBER"));
                o.setTotalPrice(rs.getInt("TOTALPRICE"));
                return o;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void addToOrder(BooksInOrder bio)
    {
        String sql = "INSERT INTO BOOKSTOREWEB.TBLBOOKSINORDER (ORDERID, BOOKID, QUANTITY) "
                   + "VALUES (?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, bio.getOrderId());
            ps.setInt(2, bio.getBookId());
            ps.setInt(3, bio.getQuantity());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void isDelivered(int orderId, int value)
    {
        String sql = "UPDATE BOOKSTOREWEB.TBLORDER "
                   + "SET ISDELIVERED=? "
                   + "WHERE ID=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, value);
            ps.setInt(2, orderId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void isPaid(int orderId, int value)
    {
        String sql = "UPDATE BOOKSTOREWEB.TBLORDER "
                   + "SET ISPAID=? "
                   + "WHERE ID=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, value);
            ps.setInt(2, orderId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void isDelivering(int orderId, int value)
    {
        String sql = "UPDATE BOOKSTOREWEB.TBLORDER "
                   + "SET ISDELIVERING=? "
                   + "WHERE ID=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, value);
            ps.setInt(2, orderId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<BooksInOrder> getAllFromOrder(int orderId)
    {
        ArrayList<BooksInOrder> list = new ArrayList<>();
        String sql = "SELECT * FROM BOOKSTOREWEB.TBLBOOKSINORDER "
                   + "WHERE ORDERID=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                BooksInOrder bio = new BooksInOrder();
                bio.setBookId(rs.getInt("BOOKID"));
                bio.setOrderId(rs.getInt("ORDERID"));
                bio.setQuantity(rs.getInt("QUANTITY"));
                list.add(bio);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public void addToFavorite(BooksInFavorite bif)
    {
        String sql = "INSERT INTO BOOKSTOREWEB.TBLBOOKSINFAVORITE (ACCOUNTID, BOOKID) "
                   + "VALUES (?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, bif.getAccountId());
            ps.setInt(2, bif.getBookId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void removeFromFavorite(int accountId, int bookId)
    {
        String sql = "DELETE FROM BOOKSTOREWEB.TBLBOOKSINFAVORITE "
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
    
    public ArrayList<BooksInFavorite> getAllFromFavorite(int accountId)
    {
        ArrayList<BooksInFavorite> list = new ArrayList<>();
        String sql = "SELECT * FROM BOOKSTOREWEB.TBLBOOKSINFAVORITE "
                   + "WHERE ACCOUNTID=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, accountId);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                BooksInFavorite bif = new BooksInFavorite();
                bif.setBookId(rs.getInt("BOOKID"));
                bif.setAccountId(rs.getInt("ACCOUNTID"));
                list.add(bif);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public void sendFeedback(Feedback f)
    {
        String sql = "INSERT INTO BOOKSTOREWEB.TBLFEEDBACK (ACCOUNTID, NAME, MESSAGE) "
                   + "VALUES (?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, f.getAccountId());
            ps.setString(2, f.getName());
            ps.setString(3, f.getMessage());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void sendFeedback(String name, String message)
    {
        String sql = "INSERT INTO BOOKSTOREWEB.TBLFEEDBACK (NAME, MESSAGE) "
                   + "VALUES (?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, message);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
