import java.util.*;
import java.net.*;
import java.io.*;
import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java .awt.event.*;
/*
<applet code="superserver1.java" width="100" height="100">
</applet>
*/

 class superserver1 extends JFrame 
{
 Date d;
 JTree mytree;
 DefaultMutableTreeNode line1,first,c1,sup,ssp ;
DefaultTreeModel tree1;
JTextField textField;

Container contentPane ;
 int i=-1,j;
 Vector ex=new Vector();
 ServerSocket me;
 Socket s,sser;
 superserver1.servertry1 t[] = new superserver1.servertry1[50];
 String line="", linet="";
 boolean f1,f2;
public superserver1(ServerSocket s1)
{
  me=s1;
  contentPane = getContentPane();
  contentPane.setLayout(new BorderLayout());
 
  first = new DefaultMutableTreeNode("Super Server");
 tree1=new DefaultTreeModel(first);
  sup = new DefaultMutableTreeNode("S1");
  System.out.println("Super Server is Listining");
  try
  {
    while(true)
    {
	 s = me.accept();
	 System.out.println("Connected");
     BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
     PrintWriter op=null;
     op=new PrintWriter(s.getOutputStream(),true);
// sser = new Socket(nameser,1111);
line=br.readLine();
ssp= new DefaultMutableTreeNode(line);
 mytree =new JTree(tree1);
			tree1.insertNodeInto(ssp,first,0);
//line="";
     f2=true;
     while(f2)
     {
       line=br.readLine();



       br = null;
       linet = line.substring(0,((line.length())-1));
       f1=false;
       System.out.println("size of ex is : "+ex.size());
       for(int r =0;r<ex.size();r++)
       {
          f1 = ex.elementAt(r).equals(linet);
          System.out.println("value of f1 : "+f1);
          System.out.println("i :"+ex.elementAt(r));
         if(f1==true)
         r=ex.size();
         } //end of for
         if(f1==true)
         {
         op.println("present");
          f2=false; 
         }
         else
         {
         op.println("notpresant");
      
         i++;
         ex.addElement(linet);
		
         line1 = new DefaultMutableTreeNode(linet);
		  mytree =new JTree(tree1);
			tree1.insertNodeInto(sup,first,0);
         tree1.insertNodeInto(line1,sup,0);       
         
		try
		 {
	 	    d=new Date();
            int d1,y1,m1,h,m2,s2;  
            d1=d.getDate();   m1=1+d.getMonth();   y1=1900+d.getYear();
            h =d.getHours();m2=d.getMinutes();s2=d.getSeconds();
            String dat,tim;
            dat=d1+" : "+m1+" : "+y1; tim=h+" : "+m2+" : "+s2;
            System.out.println("current date: "+d1+" : "+m1+" : "+y1);
            System.out.println("current Time: "+h+" : "+m2+" : "+s2);
    		 FileOutputStream fos1=new FileOutputStream("c:\\RootTable.txt",true);
		     fos1.write("\n".getBytes());
			 fos1.write((" The Server  is "+sup+" is connected to the Super Server ").getBytes());
			 fos1.write("  ".getBytes());
   			 fos1.write(("Date is "+dat).getBytes());
             fos1.write("  ".getBytes());
	         fos1.write(("Time is "+tim).getBytes());
			 fos1.close();
		 }
		 catch(Exception e1)
		 {
			 System.out.println(e1);
		 }

	//first.insertNodeInto(sup,first,0);  
  int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
  int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
   JScrollPane jsp = new JScrollPane(mytree,v,h);
   contentPane.add(jsp,BorderLayout.CENTER);
   textField = new JTextField(" ",20);
   contentPane.add(textField,BorderLayout.SOUTH);
       setTitle("Super Server");
        setSize(350,300);
       setVisible(true);
    

    System.out.print(i);
     System.out.print("received");
     System.out.println(line);

              (t[i]=new superserver1.servertry1(s,sser,t,line,ex)).start();

        f2=false; 

     }//else
     }      //inner while
     } //outerwhile

     }
	 catch(Exception t)
	 {
		 System.out.println(t);
     }

 }
 
 public static void main(String args[])
 {

	 ServerSocket server;
	 Socket s;
	 try
	 {
		server = new ServerSocket(6060);
	    superserver1 f = new superserver1(server);
	 }
	 catch(Exception g)
	 {
		 System.exit(1); 
	 }
 }

class servertry1 extends Thread
{
PrintStream op=null,ops = null;
Socket s,sser;
servertry1 t[] =new servertry1[50];
String new1="";
DataOutputStream output=null;

Vector ex =new Vector();
String id,id1,reqby,line1,line10,reqbyx,idx;
public servertry1(Socket s,Socket sser ,servertry1[] t,String new1,Vector ex)
{
 this.s = s;
 this.sser = sser;
 this.t = t;
 this.new1 = new1;
 this.ex = ex;
}
 public void run()
 {     System.out.println("servertry is running");
	   int length1;
        try
        {
         BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
         op=new PrintStream(s.getOutputStream());
              
		String sline=br.readLine();
        System.out.println("Sline is "+sline);

        System.out.println("connected to server");
 
        String line="";
        for(int j = 0;j<(ex.size()-1);j++)
        {
              try{
              t[j].sleep(200);
              }catch(Exception s){
				System.out.println(s);
			  }
          
         if((ex.elementAt(j))!=new1)
         {
         op.println(ex.elementAt(j)+"#"+ex.elementAt(j)+'^');
         }

         }//end of for
               for(int j = 0;j<ex.size();j++)
              {

               if(t[j]!=null)
              {
              try{
              t[j].sleep(200);
              }catch(Exception s1){
			      System.out.println(s1);  
			  }
              t[j].op.println(new1+"#"+new1);

              System.out.println("sending" +new1);

              }

              }


   while(true)
   {
         
   line = br.readLine();
   id1 = line;

   line = "";
  System.out.println(line);

   int pos=id1.indexOf('#');
   reqby= id1.substring(0,pos);
   id=id1.substring(pos+1);
   if(line.startsWith("/quit@"))
   break;
   if(id.equals(""))              //for broadcasting
   {
   System.out.println("value of id withen else: "+id);
   line = br.readLine();
   System.out.println("2"+line);
           if(line.endsWith("@"))    //MESSAGE PROCESSING IN THIS IF LOOP
           {
            for(int j = 0;j<ex.size();j++)
            {
           System.out.println(reqby+"MESSAGE");
           line10=reqby+"#"+line;
           System.out.println(line10);
           t[j].op.println(line10);
            

           }   //for loop within if
         }
        else
       {

         System.out.println("within else");
           if(line!=null)
           {
                      System.out.println(line);
					 System.out.println("The file length is"+line.length());
                     // dt=new Date();
					 int l1=0;
	                 for(int j = 0;j<ex.size();j++)
                    {
		                  t[j].op.println(line);
		            }
					line="";

           }                   //if line null
          line="";
           i=10;
 }                                    //end of else
      }                             //end of broadcasting
else                                        //for specific person
   {
   System.out.println("value of id : "+id);
   for(int i = 0;i<ex.size();i++)
   {
   System.out.println("forloop");
   System.out.println("comparing" +ex.elementAt(i) + "with" + id);
   boolean f = ex.elementAt(i).equals(id);
   if(f==true)
   {
    System.out.println("F");
   line = br.readLine();
   System.out.println("2"+line);
           if(line.endsWith("@"))    //MESSAGE PROCESSING IN THIS IF LOOP
           {
           System.out.println(reqby+"MESSAGE");
           line10=reqby+"#"+line;
           System.out.println(line10);
           t[i].op.println(line10);
           
           line = "";
           i=10;
           System.out.println(i);
           }
        else if(line.endsWith("!"))       //FILE PROCESSING
        {
        System.out.println("FileRequested"+line+"FILE");
           line1=reqby+"#"+line;
           t[i].op.println(line1);          //sending the req person
           System.out.println(line1);       

           line = "";
                   i=10;
                   System.out.println(i);
        }  //else if
         else
                 {
         System.out.println("within else");
            System.out.println("do");
           line = br.readLine();
           System.out.println("3"+line);
           if(line!=null)
           {
           if(line!="Exit")
           {
                      System.out.println(line);
                      System.out.println(i);

          t[i].op.println(line);
          line="";

           }
           else
           {

             System.out.println(line);
             System.out.println(reqby);

           ex.removeElement(reqby);
           ex.add(i,"logout");
           
           for(int m=0;m<ex.size();m++)
           {
           System.out.println(ex.elementAt(m));
           }
           }   //if exit
           }    //if line null
           System.out.println("exit from while");
         //  }while(true);
          line="";
           i=10;
        } //end of else

}//if
}//for
}
}//while
   
   }catch(Exception c){
	  System.out.println(c);
   }
}}
}
              

