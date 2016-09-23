package BC_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.Map.Entry;
import BC_1.*;


class CreatingTables
{
	
	CreatingTables()
	{
		
	}
	
	
	
	public void CreateTable()throws Exception 
	{
		String url = "jdbc:oracle:thin:@"+Main.ipsource+":1521:XE"; 
	        String id = "hr"; 
	        String pw = "hr"; 
	        Statement stmt = null; 
	        Connection conn = null; 
	        ResultSet rs = null;
      
        try
        { 
        	   Class.forName( "oracle.jdbc.driver.OracleDriver" ); 
                 conn = DriverManager.getConnection( url, id, pw ); 
                 stmt = conn.createStatement(); 
                 
                 stmt.execute("Create table bartotalscore(barid varchar(30), barsum number(2,0))");
                 stmt.executeUpdate("Create table barcomment(BarID varchar2(30), BarComments varchar2(1000), Stars number(3,0))");
                 
                  stmt.executeUpdate("Create table Couponbooth(numbers varchar2(100), duds varchar2(100))");

                 stmt.executeUpdate("Create table bar(identi varchar2(20), names varchar2(30),photo varchar2(30),phone varchar2(20),address varchar2(20),typeofBar varchar2(20), Barprice number(2,0),Baratmos number(2,0),times varchar(20), rest varchar(20), smoke varchar(20), restroom varchar(20), explains varchar2(4000))");
                  stmt.executeUpdate("create table Chat_Request (ids varchar2(20), friend varchar2(20))");
           
                 stmt.executeUpdate(
                 		"Create table Bar_Client(ids varchar2(20),"
                 		+ "pws varchar2(20),"
                 		+ "name varchar2(20),"
                 		+ "region varchar2(20),"
                 		+ "jumin varchar2(20),"
                 		+ "jumin2 varchar2(20),"
                 		+ "job varchar2(20),"
                 		+ "tt1 varchar2(20),"
                 		+ "tt2 varchar2(20),"
                 		+ "tt3 varchar2(20),"
                 		+ "email varchar2(100),"
                 		+ "juso varchar2(20),"
                 		+ "barm number(2,0),"
                 		+ "barc number(2,0),"
                 		+" levels number(2,0)"
                 		+ ")");
           	             
                
                   stmt.executeUpdate("create table friendrequest(name varchar2(20), friend varchar2(20))");
 
        } 
        
        catch( SQLException e ) 
        { 
            throw new SQLException( e.getMessage(), e.getCause() ); 
        } 
        catch( ClassNotFoundException e ) 
        { 
            throw new ClassNotFoundException( e.getMessage(), e.getCause() ); 
        } 
        finally
        { 
            if( stmt != null ) 
                try
                { 
                    stmt.close(); 
                    conn.close(); 
                } 
                catch( SQLException e ) 
                { 
                } 
        } 
	}		
}

class SendingBarImages

{
String buffingid;

     SendingBarImages(String buffingid) throws Exception
     {
    	 this.buffingid=buffingid;
    	 
         Statement s;
         Connection c;		
         FileInputStream fis;
         PreparedStatement ps;

         File file; 
         String url = "jdbc:oracle:thin:@"+Main.ipsource+":1521:XE"; 
         String id = "hr"; 
         String pw = "hr"; 

         try
         {
               Class.forName("oracle.jdbc.driver.OracleDriver");
               c=DriverManager.getConnection(url, id, pw);
               s=c.createStatement();	
               s.execute("Create table ImageBarTable(ImageName varchar2(20), Image_No number(10),Photo blob)");
               s.executeUpdate("alter table ImageBarTable add constraint pk_ImageName primary key(imageName)");
         }

         
         catch(Exception e1) 
        {
               e1.printStackTrace();
        }	

		
         try
        {		
               file=new File("Bar_Image/"+buffingid+".png");
               fis=new FileInputStream(file);

               Class.forName("oracle.jdbc.driver.OracleDriver");
               c=DriverManager.getConnection(url, id, pw);

               s=c.createStatement();

               ps=c.prepareStatement("insert into imageBartable values('"+buffingid+"',?,?)");

               ps.setInt(1,2);

               ps.setBinaryStream(2,fis,(int)file.length());

               System.out.println("success");

               ps.execute();

               ps.close();

               c.close();

         }

         catch(Exception e)

         {

               e.printStackTrace();

         }

     }

}	

class FindRankingID
{
	String tempid;

		FindRankingID(String tempid) throws Exception 
	    { 
			this.tempid=tempid;

	        Statement stmt=null; 
	        Connection conn=null; 
	        String url = "jdbc:oracle:thin:@"+Main.ipsource+":1521:XE"; 
	        String id = "hr"; 
	        String pw = "hr"; 
	        	
	        
	        try
	        { 
	            Class.forName( "oracle.jdbc.driver.OracleDriver" ); 
	            conn = DriverManager.getConnection( url, id, pw ); 
	  
	            stmt = conn.createStatement(); 
	            String sql = "SELECT * FROM bar_client"; 
	  
	            ResultSet rs = stmt.executeQuery( sql ); 
	  
	            while( rs.next() ) 
	            { 
	            	  String ids = rs.getString("ids" ); 
	                
	            	  if(ids.equals(tempid))
	            	  {
	            		  String region = rs.getString( "region" ); 
	            		  int barm = rs.getInt("barm");
	            		  int barc = rs.getInt("barc");
	                 
	            		  RankCal.usersid=ids;
	            		  RankCal.usersregion=region;
	            		  RankCal.usersbarm=barm;
	            		  RankCal.usersbarc=barc;
	            	  }
	            } 
	           
	            rs.close(); 
	        } 
	        catch( SQLException e ) 
	        { 
	            throw new SQLException( e.getMessage(), e.getCause() ); 
	        } 
	        catch( ClassNotFoundException e ) 
	        { 
	            throw new ClassNotFoundException( e.getMessage(), e.getCause() ); 
	        } 
	        finally
	        { 
	            if( stmt != null ) 
	                try
	                { 
	                    stmt.close(); 
	                    conn.close(); 
	                } 
	                catch( SQLException e ) 
	                { 
	                } 
	        } 
	    } 
}


class ReceiveBarImages {  

	 ReceiveBarImages() throws Exception
	 
	 {  

	try{  

	Class.forName("oracle.jdbc.driver.OracleDriver");  

	Connection con=DriverManager.getConnection(  

	"jdbc:oracle:thin:@"+Main.ipsource+":1521:xe","hr","hr");  

	      

	PreparedStatement ps=con.prepareStatement("select * from imagebartable");  

	ResultSet rs=ps.executeQuery();  

	while(rs.next()){//now on 1st row  

	String name =rs.getString("imagename");

	Blob b=rs.getBlob(3);//2 means 2nd column data  

	byte barr[]=b.getBytes(1,(int)b.length());//1 means first image  

	              

	FileOutputStream fout=new FileOutputStream("Bar_Image/"+name+".png");  

	fout.write(barr);  

	fout.close();  

	}

	System.out.println("ok");  

	con.close();  

	}catch (Exception e) {e.printStackTrace();  }  
	}  

}  


class SendingImages

	{
	String buffingid;
	
	     SendingImages(String buffingid) throws Exception
	     {
	    	 this.buffingid=buffingid;
	    	 ResultSet rs = null;

	         Statement s = null;
	         Connection c;		
	         FileInputStream fis;
	         PreparedStatement ps;

	         File file; 
	         String url = "jdbc:oracle:thin:@"+Main.ipsource+":1521:XE"; 
	         String id = "hr"; 
	         String pw = "hr"; 


	         try
	         {
   	 		   
	        	  String sql = "select count(*) from bar where ImageName ='" +buffingid+"'";

   	 		   rs = s.executeQuery(sql);
   	 		   rs.next();
   	 		   int cnt =rs.getInt(1);
   	 		   rs.close();
   	 	   
   	 		   if(cnt==0)
   	 		   {   
	        	 
	               Class.forName("oracle.jdbc.driver.OracleDriver");
	               c=DriverManager.getConnection(url, id, pw);
	               s=c.createStatement();	
	               s.execute("Create table ImageTable(ImageName varchar2(20), Image_No number(10),Photo blob)");
	               s.executeUpdate("alter table ImageTable add constraint pk_ImageName primary key(imageName)");
	         }

	         }
	         catch(Exception e1) 
	        {
	               e1.printStackTrace();
	        }	

			
	         try
	        {		
	        	 
	        	 
	               file=new File("BC_1_image/"+buffingid+"_1.png");
	               fis=new FileInputStream(file);

	               Class.forName("oracle.jdbc.driver.OracleDriver");
	               c=DriverManager.getConnection(url, id, pw);

	               s=c.createStatement();

	               ps=c.prepareStatement("insert into imagetable values('"+buffingid+"',?,?)");

	               ps.setInt(1,2);

	               ps.setBinaryStream(2,fis,(int)file.length());

	               System.out.println("success");

	               ps.execute();

	               ps.close();

	               c.close();

	         }

	         catch(Exception e)

	         {

	               e.printStackTrace();

	         }

	     }

	}	


	 class ReceiveImages {  

		 ReceiveImages() throws Exception
		 
		 {  

		try{  

		Class.forName("oracle.jdbc.driver.OracleDriver");  

		Connection con=DriverManager.getConnection(  

		"jdbc:oracle:thin:@"+Main.ipsource+":1521:xe","hr","hr");  

		      

		PreparedStatement ps=con.prepareStatement("select * from imagetable");  

		ResultSet rs=ps.executeQuery();  

		while(rs.next()){//now on 1st row  

		String name =rs.getString("imagename");

		Blob b=rs.getBlob(3);//2 means 2nd column data  

		byte barr[]=b.getBytes(1,(int)b.length());//1 means first image  

		              

		FileOutputStream fout=new FileOutputStream("BC_1_image/"+name+"_1.png");  

		fout.write(barr);  

		fout.close();  

		}

		System.out.println("ok");  

		con.close();  

		}catch (Exception e) {e.printStackTrace();  }  
		}  

	}  


class Bar
{
	String id, name, photo, phone, address, typeofBar,
	time, rest, smoke, restroom, explain;
	int Barprice, BarAtmos;

	static TreeMap ranking = new TreeMap();
	
	static HashMap Bars2 = new HashMap();
	HashMap Bars = new HashMap();

	
	static String [] specificInfo = new String[5]; 
	
	static int barnum=0; //total number of Bars 

	
	public Bar(String id, String name, String photo, String phone, String address, 
			String typeofBar, int Barprice, int BarAtmos,
			String time, String rest, String smoke, String restroom, String explain) {
	
		
		Bars.put(id, new BarInfo(name, photo, phone, address, typeofBar, Barprice, BarAtmos,
				time, rest, smoke, restroom, explain));
		
		Bars2.put(id, new BarInfo(name, photo, phone, address, typeofBar, Barprice, BarAtmos,
				time, rest, smoke, restroom, explain));
		
		Iterator its = Bars.entrySet().iterator();
		
		while(its.hasNext())
		{
			Map.Entry e = (Entry) its.next();			
			BarInfo temp = (BarInfo) e.getValue();
			System.out.println(e.getKey()+" : "+temp.photo);
		}
		
		
	}	
}


class BarRefresh 
{
 public	void BarRefreshs()throws Exception 
	{
	 	ResultSet rs = null;
	    Statement stmt = null; 
        Connection conn = null; 
        String url = "jdbc:oracle:thin:@"+Main.ipsource+":1521:XE"; 
        String id = "hr"; 
        String pw = "hr"; 
  

        try
        { 
            Class.forName( "oracle.jdbc.driver.OracleDriver" ); 
            conn = DriverManager.getConnection( url, id, pw ); 
 
            stmt = conn.createStatement(); 
   
    		Iterator its2 = Bar.Bars2.entrySet().iterator();
    		
    		while(its2.hasNext())
    		{
    			Map.Entry ee = (Entry) its2.next();
    			BarInfo eee = (BarInfo) ee.getValue();
    			
    			
    			String bufid = (String) ee.getKey();
    			String bufname = eee.name;
    			String bufphoto = eee.photo;
    			String bufphone = eee.phone;
    			String bufaddress = eee.address;
    			String buftypeofbar = eee.typeofBar;
    			int barprice = eee.Barprice;
    			int baratmos = eee.BarAtmos;
    			String rest = eee.rest;
    			String time = eee.time;
    			String smoke = eee.smoke;
    			String restroom = eee.restroom;
    			String explain = eee.explain;
    			
    		     String sql = "select count(*) from bar where identi ='" +bufid+"'";
    	 		   
    		     
    	 		   rs = stmt.executeQuery(sql);
    	 		   rs.next();
    	 		   int cnt =rs.getInt(1);
    	 		   rs.close();
    	 	   
    	 		   if(cnt==0)
    	 		   {   
    	 			   System.out.println(eee.name+ " before going to the Oracle");
    	 			   stmt.executeUpdate("INSERT INTO bar " + "VALUES ('"+bufid+"','"+bufname+"','"+bufphoto+"','"+bufphone+"','"+bufaddress+"','"+buftypeofbar+"',"+barprice+",2,'"+baratmos+"','"+rest+"','"+smoke+"','"+restroom+"','"+explain+"')");  
    	 		   }
    	 		   }
            	conn.close();
           } 
        catch( SQLException e ) 
        { 
            throw new SQLException( e.getMessage(), e.getCause() ); 
        } 
        catch( ClassNotFoundException e ) 
        { 
            throw new ClassNotFoundException( e.getMessage(), e.getCause() ); 
        } 
        finally
        { 
            if( stmt != null ) 
                try
                { 
                    stmt.close(); 
                    conn.close(); 
                } 
                catch( SQLException e ) 
                { 
                } 
        } 
	}
}

class BarRecieveRefreshed
{ 
    BarRecieveRefreshed() throws Exception 
    { 
  
        Statement stmt=null; 
        Connection conn=null; 
        String url = "jdbc:oracle:thin:@"+Main.ipsource+":1521:XE"; 
        String id = "hr"; 
        String pw = "hr"; 
        
  
        Class.forName( "oracle.jdbc.driver.OracleDriver" ); 
   /* 
        conn = DriverManager.getConnection( url, id, pw ); 
        stmt = conn.createStatement();
        stmt.execute(
        		"Create table bar(identi varchar2(20), names varchar2(30),photo varchar2(30),phone varchar2(20),address varchar2(20),typeofBar varchar2(20), Barprice number(2,0),Baratmos number(2,0),times varchar(20), rest varchar(20), smoke varchar(20), restroom varchar(20), explains varchar2(4000))");
       
        */
   //creating tables which is proven to be successful 
        
        try
        { 
            Class.forName( "oracle.jdbc.driver.OracleDriver" ); 
            conn = DriverManager.getConnection( url, id, pw ); 
  
            stmt = conn.createStatement(); 
            String sql = "SELECT * FROM bar"; 
  
            ResultSet rs = stmt.executeQuery( sql ); 
  
            while( rs.next() ) 
            { 
            	  String identi = rs.getString("identi" ); 
                  String names = rs.getString( "names" ); 
                  String photo = rs.getString("photo");
                  String phone = rs.getString("phone");
                  String address = rs.getString("address");
                  String typeofbar = rs.getString("typeofbar");
                  int barprice = rs.getInt("barprice");
                  int baratmos = rs.getInt("baratmos");
                  String times = rs.getString("times");
                  String rest = rs.getString("rest");
                  String smoke = rs.getString("smoke");
                  String restroom = rs.getString("restroom");
                  String explains = rs.getString("explains");
                  
                  System.out.println( identi + "\t" + names+" before entering the bars2 Hashmap"); 
            	
                  Bar.Bars2.put(identi, new BarInfo(names, photo, phone,address,typeofbar,barprice,baratmos,times,rest,smoke,restroom,explains));
            } 
           
            rs.close(); 
        } 
        catch( SQLException e ) 
        { 
            throw new SQLException( e.getMessage(), e.getCause() ); 
        } 
        catch( ClassNotFoundException e ) 
        { 
            throw new ClassNotFoundException( e.getMessage(), e.getCause() ); 
        } 
        finally
        { 
            if( stmt != null ) 
                try
                { 
                    stmt.close(); 
                    conn.close(); 
                } 
                catch( SQLException e ) 
                { 
                } 
        } 
    } 
} 

class BarInfo
{
	String name, photo, phone, address, typeofBar, 
	time, rest, smoke, restroom, explain;
	int Barprice, BarAtmos;
	
	public BarInfo(String name, String photo, String phone, String address, 
			String typeofBar, int Barprice, int BarAtmos,
			String time, String rest, String smoke, String restroom, String explain) 
	{
		this.name=name;
		this.photo=photo;
		this.phone=phone;
		this.address=address;
		this.typeofBar=typeofBar;
		this.Barprice=Barprice;
		this.BarAtmos=BarAtmos;
		this.time=time;
		this.rest=rest;
		this.smoke=smoke;
		this.restroom=restroom;
		this.explain=explain;
	}
}


class removeBoothOracle
{
	String removedCoupon;
	
	removeBoothOracle(String removedCoupon)
	{
		this.removedCoupon=removedCoupon;
	}
	
	
	public void CouponDestroy()throws Exception 
	{
		String url = "jdbc:oracle:thin:@"+Main.ipsource+":1521:XE"; 
	        String id = "hr"; 
	        String pw = "hr"; 
	        Statement stmt = null; 
	        Connection conn = null; 
	        ResultSet rs = null;
      
        try
        { 
        	   Class.forName( "oracle.jdbc.driver.OracleDriver" ); 
                 conn = DriverManager.getConnection( url, id, pw ); 
                 stmt = conn.createStatement(); 
                       	             
               //DELETE FROM TABLE1 WHERE ID IN (SELECT ID FROM TABLE1_PURGE);  
               //delete from (select ID from TABLE1 where ID=1000001356443294);  
                 stmt.execute("delete from(select numbers from couponbooth where numbers='"+removedCoupon+"')");
        } 
        
        
        catch( SQLException e ) 
        { 
            throw new SQLException( e.getMessage(), e.getCause() ); 
        } 
        catch( ClassNotFoundException e ) 
        { 
            throw new ClassNotFoundException( e.getMessage(), e.getCause() ); 
        } 
        finally
        { 
            if( stmt != null ) 
                try
                { 
                    stmt.close(); 
                    conn.close(); 
                } 
                catch( SQLException e ) 
                { 
                } 
        } 
	}		

}


class BarCouponbooth
{
	static int [] CouponNumbers = new int [4];
	
	String num;
	String name;
	static TreeMap BarCoupons = new TreeMap();

	
	BarCouponbooth(String num, String name)
	{
		this.num=num;
		this.name=name;
	
		BarCoupons.put(num, name);
		
		System.out.println(BarCoupons+"  from the Class BarCouponbooth");
	}
}

class BarTotalScore
{
	static HashMap bartotalbox = new HashMap();
	
	BarTotalScore(String id, int sum)
	{
		bartotalbox.put(id, sum);
	}
}


class totalScoresend
{
	ResultSet rs = null;
    Statement stmt = null; 
    Connection conn = null; 
    String url = "jdbc:oracle:thin:@"+Main.ipsource+":1521:XE"; 
    String id = "hr"; 
    String pw = "hr"; 

    totalScoresend() throws Exception
    {
    try
    { 
        Class.forName( "oracle.jdbc.driver.OracleDriver" ); 
        conn = DriverManager.getConnection( url, id, pw ); 

        stmt = conn.createStatement(); 

		Iterator its2 = BarTotalScore.bartotalbox.entrySet().iterator();
		
		while(its2.hasNext())
		{
			Map.Entry ee = (Entry) its2.next();
			
			
		     String sql = "select count(*) from bartotalscore where barid ='" +ee.getKey()+"'";
	 		   
		     
	 		   rs = stmt.executeQuery(sql);
	 		   rs.next();
	 		   int cnt =rs.getInt(1);
	 		   rs.close();
	 	   
	 		   if(cnt==0)
	 		   {   
	 			   System.out.println(ee.getKey()+ " before going to the bartotalscore Oracle");
	 			   stmt.executeUpdate("INSERT INTO bartotalscore " + "VALUES ('"+ee.getKey()+"',"+ee.getValue()+")");
	 		   }
	 		   }
		
        	conn.close();
       } 
    catch( SQLException e ) 
    { 
        throw new SQLException( e.getMessage(), e.getCause() ); 
    } 
    catch( ClassNotFoundException e ) 
    { 
        throw new ClassNotFoundException( e.getMessage(), e.getCause() ); 
    } 
    finally
    { 
        if( stmt != null ) 
            try
            { 
                stmt.close(); 
                conn.close(); 
            } 
            catch( SQLException e ) 
            { 
            } 
    } 
}	
		
}

class bartotalreceive
{
	bartotalreceive() throws Exception 
{ 

    Statement stmt=null; 
    Connection conn=null; 
    String url = "jdbc:oracle:thin:@"+Main.ipsource+":1521:XE"; 
    String id = "hr"; 
    String pw = "hr"; 
    
    //BarTotalScore.bartotalbox.clear();

    Class.forName( "oracle.jdbc.driver.OracleDriver" ); 

    try
    { 
        Class.forName( "oracle.jdbc.driver.OracleDriver" ); 
        conn = DriverManager.getConnection( url, id, pw ); 

        stmt = conn.createStatement(); 
        String sql = "SELECT * FROM bartotalscore"; 

        ResultSet rs = stmt.executeQuery( sql ); 

        while( rs.next() ) 
        { 
        	String barid = rs.getString("barid");
        	int sum = rs.getInt("barsum");
    		
        	System.out.println(barid + "receiving from Oracle");  
         
        	new BarTotalScore(barid, sum);
          	
        } 
       
        rs.close(); 
    } 
    catch( SQLException e ) 
    { 
        throw new SQLException( e.getMessage(), e.getCause() ); 
    } 
    catch( ClassNotFoundException e ) 
    { 
        throw new ClassNotFoundException( e.getMessage(), e.getCause() ); 
    } 
    finally
    { 
        if( stmt != null ) 
            try
            { 
                stmt.close(); 
                conn.close(); 
            } 
            catch( SQLException e ) 
            { 
            } 
    } 
} 	
}


class BarComment
{
	String id_bar, comments; 
	int stars;
	
	static HashMap commentbox = new HashMap();
	
	public BarComment(String id_bar, String comments, int stars) {
		this.id_bar = id_bar;
		this.comments = comments;
		this.stars = stars;
		
		commentbox.put(id_bar, new BarCommentInput(comments,stars));
	
	}
}

class BarCommentInput
{
	String comments;
	int stars;
	
	public BarCommentInput(String comments, int stars) {
		this.comments = comments;
		this.stars = stars;
	} 	
}

class BarCommentSend
{

	ResultSet rs = null;
    Statement stmt = null; 
    Connection conn = null; 
    String url = "jdbc:oracle:thin:@"+Main.ipsource+":1521:XE"; 
    String id = "hr"; 
    String pw = "hr"; 

    BarCommentSend() throws Exception
    {
    try
    { 
        Class.forName( "oracle.jdbc.driver.OracleDriver" ); 
        conn = DriverManager.getConnection( url, id, pw ); 

        stmt = conn.createStatement(); 

		Iterator its2 = BarComment.commentbox.entrySet().iterator();
		
		while(its2.hasNext())
		{
			Map.Entry ee = (Entry) its2.next();
			BarCommentInput eee = (BarCommentInput) ee.getValue();
			
			
			
		     String sql = "select count(*) from barcomment where barid ='" +ee.getKey()+"'";
	 		   
		     
	 		   rs = stmt.executeQuery(sql);
	 		   rs.next();
	 		   int cnt =rs.getInt(1);
	 		   rs.close();
	 	   
	 		   if(cnt==0)
	 		   {   
	 			   System.out.println(ee.getKey()+ " before going to the BarComment Oracle");
	 			   stmt.executeUpdate("INSERT INTO barcomment " + "VALUES ('"+ee.getKey()+"','"+eee.comments+"',"+eee.stars+")");
	 		   }
	 		   }
		
        	conn.close();
       } 
    catch( SQLException e ) 
    { 
        throw new SQLException( e.getMessage(), e.getCause() ); 
    } 
    catch( ClassNotFoundException e ) 
    { 
        throw new ClassNotFoundException( e.getMessage(), e.getCause() ); 
    } 
    finally
    { 
        if( stmt != null ) 
            try
            { 
                stmt.close(); 
                conn.close(); 
            } 
            catch( SQLException e ) 
            { 
            } 
    } 
}	
		
}

class BarComentRecieve
{

	BarComentRecieve() throws Exception 
{ 

    Statement stmt=null; 
    Connection conn=null; 
    String url = "jdbc:oracle:thin:@"+Main.ipsource+":1521:XE"; 
    String id = "hr"; 
    String pw = "hr"; 
    
    //BarComment.commentbox.clear();

    Class.forName( "oracle.jdbc.driver.OracleDriver" ); 

    try
    { 
        Class.forName( "oracle.jdbc.driver.OracleDriver" ); 
        conn = DriverManager.getConnection( url, id, pw ); 

        stmt = conn.createStatement(); 
        String sql = "SELECT * FROM barcomment"; 

        ResultSet rs = stmt.executeQuery( sql ); 

        while( rs.next() ) 
        { 
        	String barid = rs.getString("barid");
        	String barcomments = rs.getString("barcomments");
        	int stars = rs.getInt("stars");
    		
        	System.out.println(barid + "receiving from Oracle");  
         
        	new BarComment(barid, barcomments, stars);
          	
        } 
       
        rs.close(); 
    } 
    catch( SQLException e ) 
    { 
        throw new SQLException( e.getMessage(), e.getCause() ); 
    } 
    catch( ClassNotFoundException e ) 
    { 
        throw new ClassNotFoundException( e.getMessage(), e.getCause() ); 
    } 
    finally
    { 
        if( stmt != null ) 
            try
            { 
                stmt.close(); 
                conn.close(); 
            } 
            catch( SQLException e ) 
            { 
            } 
    } 
} 
}

class MenuInfo 
{
	static HashMap MenuInfos = new HashMap();

	String id;
	String [] menus;
	
	public MenuInfo(String id, String[] menus)
	{
		this.id=id;
		this.menus=menus;
		
		MenuInfos.put(id, menus);
		System.out.println(MenuInfos.entrySet()+" from the Database");
	}
}


class client1Photos
{
	static HashMap clientPhoto = new HashMap();

	client1Photos(String id, String photos)
	{
		
		
	}
}

class clientChatRequest
{
	String urid;
	String friend;
	
	clientChatRequest(String urid, String friend)
	{
		this.urid=urid;
		this.friend=friend;
	}
	
	public void clientSendOracles()throws Exception 
	{
		String url = "jdbc:oracle:thin:@"+Main.ipsource+":1521:XE"; 
	        String id = "hr"; 
	        String pw = "hr"; 
	        Statement stmt = null; 
	        Connection conn = null; 
	        ResultSet rs = null;
      
        try
        { 
        	   Class.forName( "oracle.jdbc.driver.OracleDriver" ); 
                 conn = DriverManager.getConnection( url, id, pw ); 
                 stmt = conn.createStatement(); 
        
              //   stmt.execute("create table Chat_Request (ids varchar2(20), friend varchar2(20))");
               	             
    		  stmt.executeUpdate("INSERT INTO Chat_Request " + "VALUES ('"+urid+"', '"+friend+"')");
    		  
        } 
        
        catch( SQLException e ) 
        { 
            throw new SQLException( e.getMessage(), e.getCause() ); 
        } 
        catch( ClassNotFoundException e ) 
        { 
            throw new ClassNotFoundException( e.getMessage(), e.getCause() ); 
        } 
        finally
        { 
            if( stmt != null ) 
                try
                { 
                    stmt.close(); 
                    conn.close(); 
                } 
                catch( SQLException e ) 
                { 
                } 
        } 
	}	
}


//

class chatrequestDestroy
{
	String myid;
	
	chatrequestDestroy(String myid)
	{
		this.myid=myid;
	}
	
	public void chatreDestroy()throws Exception 
	{
		String url = "jdbc:oracle:thin:@"+Main.ipsource+":1521:XE"; 
	        String id = "hr"; 
	        String pw = "hr"; 
	        Statement stmt = null; 
	        Connection conn = null; 
	        ResultSet rs = null;
      
        try
        { 
        	   Class.forName( "oracle.jdbc.driver.OracleDriver" ); 
                 conn = DriverManager.getConnection( url, id, pw ); 
                 stmt = conn.createStatement(); 
                       	             
               //DELETE FROM TABLE1 WHERE ID IN (SELECT ID FROM TABLE1_PURGE);  
               //delete from (select ID from TABLE1 where ID=1000001356443294);  
                 stmt.execute("delete from(select ids from chat_request where ids='"+myid+"')");

        } 
        
        catch( SQLException e ) 
        { 
            throw new SQLException( e.getMessage(), e.getCause() ); 
        } 
        catch( ClassNotFoundException e ) 
        { 
            throw new ClassNotFoundException( e.getMessage(), e.getCause() ); 
        } 
        finally
        { 
            if( stmt != null ) 
                try
                { 
                    stmt.close(); 
                    conn.close(); 
                } 
                catch( SQLException e ) 
                { 
                } 
        } 
	}		
}

class chatrequestInArray
{
	chatrequestInArray() throws Exception 
    { 
  
        Statement stmt=null; 
        Connection conn=null; 
        String url = "jdbc:oracle:thin:@"+Main.ipsource+":1521:XE"; 
        String id = "hr"; 
        String pw = "hr"; 
        
  
        Class.forName( "oracle.jdbc.driver.OracleDriver" ); 
        
        try
        { 
            Class.forName( "oracle.jdbc.driver.OracleDriver" ); 
            conn = DriverManager.getConnection( url, id, pw ); 
  
            stmt = conn.createStatement(); 
            String sql = "SELECT * FROM chat_request"; 
  
            ResultSet rs = stmt.executeQuery( sql ); 
  
            while( rs.next() ) 
            { 
            	  String name = rs.getString("ids" ); 
                  String friend = rs.getString( "friend" ); 
               
                  System.out.println( name + "\t" + friend+" before Receiving friendrequest form oracle"); 
                  client1.Requested.add(name);
              //    client1.ChatRequested.put(friend,name);

            } 
           
            rs.close(); 
        } 
        catch( SQLException e ) 
        { 
            throw new SQLException( e.getMessage(), e.getCause() ); 
        } 
        catch( ClassNotFoundException e ) 
        { 
            throw new ClassNotFoundException( e.getMessage(), e.getCause() ); 
        } 
        finally
        { 
            if( stmt != null ) 
                try
                { 
                    stmt.close(); 
                    conn.close(); 
                } 
                catch( SQLException e ) 
                { 
                } 
        } 
    } 
}



class client1 
{
	static ArrayList Requested = new ArrayList(); //for chat server connection for 1 : 1 
	static String LoggedID = "";
	static HashMap ChatRequested = new HashMap();
	static HashMap ClientRequestedDemo = new HashMap();
	
	String id, pw, name, region, jumin1, 
	jumin2, job, tt1, tt2, tt3, email,
	juso; 
	
	int barc, barm, rank;

	static HashMap clients = new HashMap();
	static String [] ID = new String[100]; 
	static String [] PWD =new String[100];
	static int num=0;
	
			
	public client1(String id, String pw, String name, String region, String jumin1, 
			String jumin2, String job, String tt1, String tt2, String tt3, String email,
			String juso, int barc, int barm, int rank)
	{
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.region = region;
		this.jumin1 = jumin1;
		this.jumin2 = jumin2;
		this.job = job;
		this.tt1= tt1;
		this.tt2 = tt2;
		this.tt3 = tt3;
		this.email = email;
		this.juso = juso;
		this.barc = barc;
		this.barm = barm;
		this.rank = rank;		
		
		
	clients.put(id, new client1input(pw, name, region, jumin1, 
						jumin2, job, tt1, tt2, tt3, email,
						juso, barc, barm, 0));
	
	
	
	Iterator it = clients.entrySet().iterator();
	
	while(it.hasNext())
	{
		Map.Entry e = (Entry) it.next();
		System.out.println(e.getKey()+" "+e.getValue()+" collected from the data");	
		
		client1input bufclient = (client1input) e.getValue();
		
		ID[num]=(String) e.getKey();
		PWD[num]=bufclient.pw;
	}
	
		System.out.println("Static saved : "+ID[num]+" "+PWD[num]);
		num+=1;	
	}
	
	
}

class clientPasswordFind
{
	String urname;
	String Jumin1;
	String Jumin2;
	
    clientPasswordFind(String urname, String Jumin1, String Jumin2) throws Exception 
    { 
		this.urname=urname;
		this.Jumin1 = Jumin1;
		this.Jumin2 = Jumin2;
		
        Statement stmt=null; 
        Connection conn=null; 
        String url = "jdbc:oracle:thin:@"+Main.ipsource+":1521:XE"; 
        String id = "hr"; 
        String pw = "hr"; 
        
        Class.forName( "oracle.jdbc.driver.OracleDriver" ); 
       
        try
        { 
            Class.forName( "oracle.jdbc.driver.OracleDriver" ); 
            conn = DriverManager.getConnection( url, id, pw ); 
  
            stmt = conn.createStatement(); 
            String sql = "SELECT * FROM bar_client"; 
  
            ResultSet rs = stmt.executeQuery( sql ); 
  
            while( rs.next() ) 
            { 
            	  String name = rs.getString("name" ); 
            	  String jumin1 = rs.getString("jumin" ); 
            	  String jumin2 = rs.getString("jumin2" ); 
            	  String ids = rs.getString("ids");            
            	  
            	  
            	  System.out.println(urname+" : "+name+ " before chekcking your id");
            	  System.out.println(jumin1+" : "+Jumin1+ " before chekcking your id");

            	  
            	  if(name.equals(urname)&&jumin1.equals(Jumin1)&&jumin2.equals(Jumin2))
            	  {
            		  System.out.println(ids+ "identical has been found");
            		  Main.Checking.setText(ids+ " is your ID");
            	  }
            } 
           
            rs.close(); 
        } 
        catch( SQLException e ) 
        { 
            throw new SQLException( e.getMessage(), e.getCause() ); 
        } 
        catch( ClassNotFoundException e ) 
        { 
            throw new ClassNotFoundException( e.getMessage(), e.getCause() ); 
        } 
        finally
        { 
            if( stmt != null ) 
                try
                { 
                    stmt.close(); 
                    conn.close(); 
                } 
                catch( SQLException e ) 
                { 
                } 
        } 
    } 	
    
    String outputs(String ids)
    {
    	return ids;
    }
}



class clientPWDFind
{
	String security1;
	String security2;
	String email;
	
    clientPWDFind(String security1, String security2, String email) throws Exception 
    { 
		this.security1=security1;
		this.security2 = security2;
		this.email = email;
		
        Statement stmt=null; 
        Connection conn=null; 
        String url = "jdbc:oracle:thin:@"+Main.ipsource+":1521:XE"; 
        String id = "hr"; 
        String pw = "hr"; 
        
        Class.forName( "oracle.jdbc.driver.OracleDriver" ); 
       
        try
        { 
            Class.forName( "oracle.jdbc.driver.OracleDriver" ); 
            conn = DriverManager.getConnection( url, id, pw ); 
  
            stmt = conn.createStatement(); 
            String sql = "SELECT * FROM bar_client"; 
  
            ResultSet rs = stmt.executeQuery( sql ); 
  
            while( rs.next() ) 
            { 
            	  String jumin1 = rs.getString("jumin" ); 
            	  String jumin2 = rs.getString("jumin2" ); 
            	  String emails = rs.getString("email");            
            	  String pws = rs.getString("pws");
            	  
            	if(emails.equals(email)&&jumin1.equals(security1)&&jumin2.equals(security2))
            	{
            		Main.PWDChecking.setText("Check Email");
            		new SendMailPassword(emails, pws);
            	}
            } 
            rs.close(); 
        } 
        catch( SQLException e ) 
        { 
            throw new SQLException( e.getMessage(), e.getCause() ); 
        } 
        catch( ClassNotFoundException e ) 
        { 
            throw new ClassNotFoundException( e.getMessage(), e.getCause() ); 
        } 
        finally
        { 
            if( stmt != null ) 
                try
                { 
                    stmt.close(); 
                    conn.close(); 
                } 
                catch( SQLException e ) 
                { 
                } 
        } 
    } 	
    
    String outputs(String ids)
    {
    	return ids;
    }
}


class CommentCollector
{
	String tempbar;
	
	CommentCollector(String tempbar) throws Exception 
    { 
		this.tempbar=tempbar;
        Statement stmt=null; 
        Connection conn=null; 
        String url = "jdbc:oracle:thin:@"+Main.ipsource+":1521:XE"; 
        String id = "hr"; 
        String pw = "hr"; 
        
        Class.forName( "oracle.jdbc.driver.OracleDriver" ); 
       
        try
        { 
            Class.forName( "oracle.jdbc.driver.OracleDriver" ); 
            conn = DriverManager.getConnection( url, id, pw ); 
  
            stmt = conn.createStatement(); 
            String sql = "SELECT * FROM barcomment"; 
  
            ResultSet rs = stmt.executeQuery( sql ); 
  
            while( rs.next() ) 
            { 
            	  String barid = rs.getString("BarID");
            	  String comments = rs.getString("barcomments" ); 
            	  int stars =  rs.getInt("stars");
            	  
            	  
            	  int buffer =barid.lastIndexOf('_');
            	  String buffedbarid = barid.substring(0,buffer);
            	  String bufferwriter = barid.substring(buffer+1);
            	  
            	  	if(tempbar.equals(buffedbarid))
            		{
            	  		System.out.println("CommentCollector SpecificComments : "+barid);
                  		new SpecificComments(barid, comments, stars);
            		}
            	
            } 
            rs.close(); 
        } 
        catch( SQLException e ) 
        { 
            throw new SQLException( e.getMessage(), e.getCause() ); 
        } 
        catch( ClassNotFoundException e ) 
        { 
            throw new ClassNotFoundException( e.getMessage(), e.getCause() ); 
        } 
        finally
        { 
            if( stmt != null ) 
                try
                { 
                    stmt.close(); 
                    conn.close(); 
                } 
                catch( SQLException e ) 
                { 
                } 
        } 
    } 	
    
    String outputs(String ids)
    {
    	return ids;
    }
}

class SpecificComments
{
	String comments, id; int stars;
	static HashMap tempcomment = new HashMap();
	
	SpecificComments(String id, String comments, int stars)
	{		
		this.comments = comments;
		this.stars = stars;
		this.id=id;
		
		System.out.println("SpecificComments/ HashMap tempcomment : "+id);
		tempcomment.put(id, new SpecificCommentsinput(comments, stars));	
		
		System.out.println(tempcomment+ " HashMap Tempcomment");
	}
}

class SpecificCommentsinput
{
	int stars;
	String comments;
	
	SpecificCommentsinput(String comments, int stars)
	{
		this.stars=stars;
		this.comments=comments;
		
	}

}




class SendMailPassword
{
	String email;
	String pws;
	
	SendMailPassword(String email, String pws)
	{
		this.email=email;
		this.pws =pws;
		
		new zSendMail(email, pws);		
	}
}



class clientSendOracle
{
	public void clientSendOracles()throws Exception 
	{
		String url = "jdbc:oracle:thin:@"+Main.ipsource+":1521:XE"; 
	        String id = "hr"; 
	        String pw = "hr"; 
	        Statement stmt = null; 
	        Connection conn = null; 
	        ResultSet rs = null;
      
        try
        { 
        	   Class.forName( "oracle.jdbc.driver.OracleDriver" ); 
                 conn = DriverManager.getConnection( url, id, pw ); 
                 stmt = conn.createStatement(); 
         /*
               stmt.execute(
               		"Create table Bar_Client(ids varchar2(20),"
               		+ "pws varchar2(20),"
               		+ "name varchar2(20),"
               		+ "region varchar2(20),"
               		+ "jumin varchar2(20),"
               		+ "jumin2 varchar2(20),"
               		+ "job varchar2(20),"
               		+ "tt1 varchar2(20),"
               		+ "tt2 varchar2(20),"
               		+ "tt3 varchar2(20),"
               		+ "email varchar2(20),"
               		+ "juso varchar2(20),"
               		+ "barm number(2,0),"
               		+ "barc number(2,0),"
               		+" levels number(2,0)"
               		+ ")");
               	             
            /*
              	clients.put(id, new client1input(pw, name, region, jumin1, 
						jumin2, job, tt1, tt2, tt3, email,
						juso, barc, barm, 0));
              */
          
    		Iterator its2 = client1.clients.entrySet().iterator();
    	
    		System.out.println(client1.clients+" before oracle and the iterator");
    		    		
    		while(its2.hasNext())
    		{
    			Map.Entry ee = (Entry) its2.next();
    			client1input eee = (client1input) ee.getValue();
    			
    			String bufid = (String) ee.getKey();
    			String bufname = eee.name;
    			String bufpw = eee.pw;
    			String region = eee.region;
    			String jumin1 =eee.jumin1;
    			String jumin2=eee.jumin2;
    			String job=eee.job;
    			String tt1=eee.tt1;
    			String tt2=eee.tt2;
    			String tt3 = eee.tt3;
    			String email= eee.email;
    			String juso = eee.juso;
    			int barc = eee.barc;
    			int barm = eee.barm;
    			int level =0;
    			
    		   System.out.println(eee.name+ " before going to the Oracle");
               
    		   String sql = "select count(*) from  Bar_Client  where ids ='" +bufid+"'";
    		   
    		   rs = stmt.executeQuery(sql);
    		   rs.next();
    		   int cnt =rs.getInt(1);
    		   rs.close();
    		   
    		   if(cnt==0)
    		   {
    		   stmt.executeUpdate("INSERT INTO Bar_Client " + "VALUES ('"+bufid+"','"
               		+ bufpw+"','"
               		+ bufname+"','"
               		+ region+"','"
               		+ jumin1+"','"
               		+ jumin2+"','"
               		+ job+"','"
               		+ tt1+"','"
               		+ tt2+"','"
               		+ tt3+"','"
               		+ email+"','"
               		+ juso+"',"
               		+ barm+","
               		+ barc+","
               		+ level+")");  
    		}
    		}
    		
                    } 
        
        catch( SQLException e ) 
        { 
            throw new SQLException( e.getMessage(), e.getCause() ); 
        } 
        catch( ClassNotFoundException e ) 
        { 
            throw new ClassNotFoundException( e.getMessage(), e.getCause() ); 
        } 
        finally
        { 
            if( stmt != null ) 
                try
                { 
                    stmt.close(); 
                    conn.close(); 
                } 
                catch( SQLException e ) 
                { 
                } 
        } 
	}	
}

class clientReceiveOracle
{
	clientReceiveOracle() throws Exception 
	    { 
	  
	        Statement stmt=null; 
	        Connection conn=null; 
	        String url = "jdbc:oracle:thin:@"+Main.ipsource+":1521:XE"; 
	        String id = "hr"; 
	        String pw = "hr"; 
	        
	  
	        Class.forName( "oracle.jdbc.driver.OracleDriver" ); 
	  
	       
	        try
	        { 
	            Class.forName( "oracle.jdbc.driver.OracleDriver" ); 
	            conn = DriverManager.getConnection( url, id, pw ); 
	  
	            stmt = conn.createStatement(); 
	            String sql = "SELECT * FROM bar_client"; 
	  
	            ResultSet rs = stmt.executeQuery( sql ); 
	  
	            while( rs.next() ) 
	            { 
	            	  String ids = rs.getString("ids" ); 
	            	  String pws = rs.getString("pws" ); 
	            	  String name = rs.getString("name" ); 
	            	  String region = rs.getString("region" ); 
	            	  String jumin1 = rs.getString("jumin" ); 
	            	  String jumin2 = rs.getString("jumin2" ); 
	            	  String job = rs.getString("job" ); 
	            	  String tt1 = rs.getString("tt1"); 
	            	  String tt2 = rs.getString("tt2"); 
	            	  String tt3 = rs.getString("tt3"); 
	            	  String email = rs.getString("email"); 
	            	  String juso = rs.getString("juso"); 
	            	  int barm = rs.getInt("barm"); 
	            	  int barc = rs.getInt("barc"); 
	            	  int level = rs.getInt("levels"); 
	        		
	            	System.out.println(ids + "receiving from Oracle");  
	              	client1.clients.put(ids, new client1input(pws, name, region, jumin1, 
    						jumin2, job, tt1, tt2, tt3, email,
    						juso, barc, barm, level));
	              	
	            } 
	           
	            rs.close(); 
	        } 
	        catch( SQLException e ) 
	        { 
	            throw new SQLException( e.getMessage(), e.getCause() ); 
	        } 
	        catch( ClassNotFoundException e ) 
	        { 
	            throw new ClassNotFoundException( e.getMessage(), e.getCause() ); 
	        } 
	        finally
	        { 
	            if( stmt != null ) 
	                try
	                { 
	                    stmt.close(); 
	                    conn.close(); 
	                } 
	                catch( SQLException e ) 
	                { 
	                } 
	        } 
	    } 

}

class client1input
{
	String pw, name, region, jumin1, 
	jumin2, job, tt1, tt2, tt3, email,
	juso; 
	
	int barc, barm, rank;

	
	public client1input(String pw, String name, String region, String jumin1,
			String jumin2, String job, String tt1, String tt2, String tt3,
			String email, String juso, int barc, int barm, int rank) {

		this.pw = pw;
		this.name = name;
		this.region = region;
		this.jumin1 = jumin1;
		this.jumin2 = jumin2;
		this.job = job;
		this.tt1 = tt1;
		this.tt2 = tt2;
		this.tt3 = tt3;
		this.email = email;
		this.juso = juso;
		this.barc = barc;
		this.barm = barm;
		this.rank =rank;	
	}
}

class clientCoupon
{
	String id;
	String explain;
	
	static HashMap clientCoupons = new HashMap();
	
	clientCoupon(String id, String explain)
	{
		this.id=id;
		this.explain = explain;

		clientCoupons.put(id, explain);
	}
}


class UsedCouponsClass 
{
	static HashMap UsedCouponsArray = new HashMap();
	
	String id;
	String Barname;
	
	UsedCouponsClass(String id, String Barname) 
	{
		this.id=id;
		this.Barname=Barname;

		UsedCouponsArray.put(id, new UsedCouponsInput(id, Barname));
	}
}



class UsedCouponsInput
{
	String ID;
	String Barname;
	public UsedCouponsInput(String id, String barname) {
		Barname = barname;
		ID = id;
	}
}


class clientFriend
{
      static HashMap clientFriends = new HashMap();
	  String name, pwd;
	
	  clientFriend(String name, String pwd)
	  {
		 this.name = name;
		 this.pwd = pwd;
			 
			clientFriends.put(name, new clientFriendInput(name,pwd));
	  }
}

class clientFriendInput
{
	  String name, pwd;
		
	  clientFriendInput(String name, String pwd)
	  {
		 this.name = name;
		 this.pwd = pwd;
	  }	
}


class clientFriendrequest
{
	String name, friend;
	static ArrayList FriendRequesting = new ArrayList();
	
	clientFriendrequest(String name, String friend)
	{
		this.name=name;
		this.friend=friend;
	
		FriendRequesting.add(new clientFriendrequestinput(name,friend));
		
	}
}


class clientFriendrequestDemo
{
	String name, friend;
	static HashMap FriendRequestingDemo = new HashMap();
	
	clientFriendrequestDemo(String name, String friend)
	{
		this.name=name;
		this.friend=friend;
	
		FriendRequestingDemo.put(friend,name);		
	}
}

class clientFrinedrequestSend
{
 	ResultSet rs = null;
    Statement stmt = null; 
    Connection conn = null; 
    String url = "jdbc:oracle:thin:@"+Main.ipsource+":1521:XE"; 
    String id = "hr"; 
    String pw = "hr"; 

  void clientFrinedrequestSends() throws Exception
    {
    try
    { 
        Class.forName( "oracle.jdbc.driver.OracleDriver" ); 
        conn = DriverManager.getConnection( url, id, pw ); 
        stmt = conn.createStatement(); 
       
        //thing that works all the time 
        //stmt.execute("create table friendrequest(name varchar2(20), friend varchar2(20))");
        
        
		Iterator its2 = clientFriendrequest.FriendRequesting.iterator();
		
		while(its2.hasNext())
		{
			clientFriendrequestinput eee = (clientFriendrequestinput) its2.next();
			
	 			   System.out.println(eee.name+ " before going to the Oracle");
	 			   stmt.executeUpdate("INSERT INTO friendrequest " + "VALUES ('"+eee.name+"','"+eee.friend+"')");
	 			   stmt.executeUpdate("INSERT INTO friendrequest " + "VALUES ('"+eee.friend+"','"+eee.name+"')");
	   
		}
	 		   
        	conn.close();
       } 
    catch( SQLException e ) 
    { 
        throw new SQLException( e.getMessage(), e.getCause() ); 
    } 
    catch( ClassNotFoundException e ) 
    { 
        throw new ClassNotFoundException( e.getMessage(), e.getCause() ); 
    } 
    finally
    { 
        if( stmt != null ) 
            try
            { 
                stmt.close(); 
                conn.close(); 
            } 
            catch( SQLException e ) 
            { 
            } 
    } 
    }
    
}


class clientFrinedrequestReceives
{ 
 clientFrinedrequestReceives() throws Exception 
    { 
  
        Statement stmt=null; 
        Connection conn=null; 
        String url = "jdbc:oracle:thin:@"+Main.ipsource+":1521:XE"; 
        String id = "hr"; 
        String pw = "hr"; 
        
  
        Class.forName( "oracle.jdbc.driver.OracleDriver" ); 
        
        try
        { 
            Class.forName( "oracle.jdbc.driver.OracleDriver" ); 
            conn = DriverManager.getConnection( url, id, pw ); 
  
            stmt = conn.createStatement(); 
            String sql = "SELECT * FROM friendrequest"; 
  
            ResultSet rs = stmt.executeQuery( sql ); 
  
            
            
            while( rs.next() ) 
            { 
            	  String name = rs.getString("name" ); 
                  String friend = rs.getString( "friend" ); 
               
                  System.out.println( name + "\t" + friend+" before Receiving friendrequest form oracle"); 
                  clientFriendrequest.FriendRequesting.add(new clientFriendrequestinput(name,friend));      
                  client1.ClientRequestedDemo.put(name, friend); 
       
                  
            } 
           
            rs.close(); 
        } 
        catch( SQLException e ) 
        { 
            throw new SQLException( e.getMessage(), e.getCause() ); 
        } 
        catch( ClassNotFoundException e ) 
        { 
            throw new ClassNotFoundException( e.getMessage(), e.getCause() ); 
        } 
        finally
        { 
            if( stmt != null ) 
                try
                { 
                    stmt.close(); 
                    conn.close(); 
                } 
                catch( SQLException e ) 
                { 
                } 
        } 
    } 
} 


class clientFriendrequestDestroy
{
	String bufid; //myid 
	
	clientFriendrequestDestroy(String bufid)
	{
		  this.bufid=bufid;
	}
	
  public void clientFriendrequestDestroys() throws Exception
	{
	  Statement stmt=null; 
      Connection conn=null; 
      String url = "jdbc:oracle:thin:@"+Main.ipsource+":1521:XE"; 
      String id = "hr"; 
      String pw = "hr"; 
            
      try
      { 
          Class.forName( "oracle.jdbc.driver.OracleDriver" ); 
          conn = DriverManager.getConnection( url, id, pw ); 
          stmt = conn.createStatement(); 
         
          //thing that works all the time 
          stmt.execute("delete from(select friend from friendrequest where friend='"+bufid+"')");
             
      } 
      catch( SQLException e ) 
      { 
          throw new SQLException( e.getMessage(), e.getCause() ); 
      } 
      catch( ClassNotFoundException e ) 
      { 
          throw new ClassNotFoundException( e.getMessage(), e.getCause() ); 
      } 
      finally
      { 
          if( stmt != null ) 
              try
              { 
                  stmt.close(); 
                  conn.close(); 
              } 
              catch( SQLException e ) 
              { 
              } 
      } 
  } 
	
	
}


class CouponBoothSend 
{
 public	void CouponBoothSend()throws Exception 
	{
	 	ResultSet rs = null;
	    Statement stmt = null; 
        Connection conn = null; 
        String url = "jdbc:oracle:thin:@"+Main.ipsource+":1521:XE"; 
        String id = "hr"; 
        String pw = "hr"; 
  

        try
        { 
            Class.forName( "oracle.jdbc.driver.OracleDriver" ); 
            conn = DriverManager.getConnection( url, id, pw ); 
 
            stmt = conn.createStatement(); 
   
    		Iterator its2 = BarCouponbooth.BarCoupons.entrySet().iterator();
    		
    		while(its2.hasNext())
    		{
    			Map.Entry ee = (Entry) its2.next();
    			    			
    			String num = (String) ee.getKey();
    			String dud = (String) ee.getValue();
    			
    			
    		    String sql = "select count(*) from couponbooth where numbers ='"+num+"'";
    	 		   
    	 		   rs = stmt.executeQuery(sql);
    	 		   rs.next();
    	 		   int cnt =rs.getInt(1);
    	 		   rs.close();
    	 	   
    	 		   if(cnt==0)
    	 		   {   
    	 			   stmt.executeUpdate("INSERT INTO couponbooth " + "VALUES ('"+num+"','"+dud+"')");
    	 		   }
    	 		   }
            	conn.close();
           } 
        catch( SQLException e ) 
        { 
            throw new SQLException( e.getMessage(), e.getCause() ); 
        } 
        catch( ClassNotFoundException e ) 
        { 
            throw new ClassNotFoundException( e.getMessage(), e.getCause() ); 
        } 
        finally
        { 
            if( stmt != null ) 
                try
                { 
                    stmt.close(); 
                    conn.close(); 
                } 
                catch( SQLException e ) 
                { 
                } 
        } 
	}
}

class couponboothreceive
{
	couponboothreceive() throws Exception 
    { 
  
        Statement stmt=null; 
        Connection conn=null; 
        String url = "jdbc:oracle:thin:@"+Main.ipsource+":1521:XE"; 
        String id = "hr"; 
        String pw = "hr"; 
        
        BarCouponbooth.BarCoupons.clear();
        
        Class.forName( "oracle.jdbc.driver.OracleDriver" ); 
        
        
        try
        { 
            Class.forName( "oracle.jdbc.driver.OracleDriver" ); 
            conn = DriverManager.getConnection( url, id, pw ); 
  
            stmt = conn.createStatement(); 
            String sql = "SELECT * FROM couponbooth"; 
  
            ResultSet rs = stmt.executeQuery( sql ); 
  
            
            while( rs.next() ) 
            { 
            	  String numbers = rs.getString("numbers" ); 
                  String duds = rs.getString( "duds" ); 
               
                  BarCouponbooth.BarCoupons.put(numbers, duds);
            } 
           
            rs.close(); 
        } 
        catch( SQLException e ) 
        { 
            throw new SQLException( e.getMessage(), e.getCause() ); 
        } 
        catch( ClassNotFoundException e ) 
        { 
            throw new ClassNotFoundException( e.getMessage(), e.getCause() ); 
        } 
        finally
        { 
            if( stmt != null ) 
                try
                { 
                    stmt.close(); 
                    conn.close(); 
                } 
                catch( SQLException e ) 
                { 
                } 
        } 
    } 	

}


class clientFriendrequestinput
{
	String name;
	String friend;
	clientFriendrequestinput(String name, String friend)
	{
		this.name=name;
		this.friend=friend;
	}
}


class clientRealFriends
{
	static HashMap realfriends = new HashMap();
	

	clientRealFriends(String one, String two)
	{
		realfriends.put(one,two);
	}
}


class Coupons
{
	String id, Cname, Cex, Clength;
	int num;
	static HashMap MyCoupon = new HashMap();
	static int CouponNum=0;
	
  //////////////////////// Personal Coupon Booth
	
	Coupons(String id, String Cname, String Cex, String Clength, int num)
	{
		this.Cname=Cname;
		this.Cex=Cex;
		this.Clength=Clength;		
		this.num=num;
		
		MyCoupon.put(id,new CouponsInput(id, Cname, Cex, Clength, num));
	}
}



class CouponsInput
{
	String Cname, Cex, Clength, id;
	int num;
	CouponsInput(String id, String Cname, String Cex, String Clength, int num)
	{
		this.id=id;
		this.Cname=Cname;
		this.Cex=Cex;
		this.Clength=Clength;		
		this.num=num;
	}
}



public class Database {
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//default info
		
	    new Bar("May","DumbBar", "Bar_Image/Norana.png", "010-231-2312", "1location","TypeofBar",90,100,"asdf","no","rest","explain", "title");

		new client1("testID", "dsfsdf", "sdfsdf", "sdfsdf", "dsfsdf", 
				"dfsdf", "dsfsdf", "dfsdfsd", "dsfsdf", "sdfdsf", "sfsdfsd",
				"dsfdsfsd", 12, 10, 0);		
	
		new  BarComment("test", "dfsdfsdfdsfasdfasdfsdf", 30);
		
		new BarTotalScore("dsfdsf", 30);

		
	try {
		
//	new totalScoresend();	
//	new BarCommentSend();
	//new removeBoothOracle("Sauda/LovelyCoupon_5").CouponDestroy();	
	
	//	new ReceiveBarImages();
	//	new SendingBarImages("May");
	//	new BarRefresh().BarRefreshs();	
	//	new ReceiveImages();
	//	new SendingImages("Max");
	//	new clientReceiveOracle();
		
	 new CreatingTables().CreateTable();
	//	new clientSendOracle().clientSendOracles();

		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
}
