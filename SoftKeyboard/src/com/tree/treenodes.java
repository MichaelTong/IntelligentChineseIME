package com.tree;

import java.util.LinkedList;

public class treenodes {
    String data;  
    treenodes parent;  
    LinkedList<treenodes> childlist;  
     
    treenodes()  
    {  
        data = null;  
        childlist = new LinkedList<treenodes>();  
        parent = null;  
    }
    
    treenodes(String a)  
    {  
        data = a;  
        childlist = new LinkedList<treenodes>();  
        parent = null;  
    }  
    
    public void addvalue(String in)
    {
    	this.data = in;
    }
    
    public void printvalue()
    {
    	System.out.print(this.data);
    }
    
    public void adddata(String in)
    {
    	String[] datas = in.split(";");
    	for(int i = 0 ;i < datas.length; i++)
    	{
    		this.addonedata(datas[i]);
    	}
    }
    public void addonedata(String a) 
    {
    	char[] temp = a.toCharArray();
    	treenodes tree = this ;
    	for(int i = 1 ; i < temp.length ; i++)
    	{
    		int index = tree.contains(String.valueOf(temp[i]));
    		if(index==-1)
    		{
    			treenodes t = new treenodes(String.valueOf(temp[i]));
    			tree.childlist.add(t);
        		tree = t;
    		}
    		else
    		{
    			treenodes tem = tree.childlist.get(index);
        		tree = tem;
    		}
    		
    	}
    }
    public int contains(String value) //查询某树是否含有value值的子树,不存在返回-1，存在返回其index
    {
    	if(!this.childlist.isEmpty())
    		for(int i = 0 ; i < this.childlist.size(); i++)
    		{
    			treenodes t = this.childlist.get(i);  
    			if(t.data.equals(value))
    				return i;
    		}
    	return -1;
    }
    
    //最大匹配位置
    public int matchmax(char[] c)
    {
    	int l = 1;
    	if(c.length>1)
    	{	
    		treenodes t = this ; 
    		for(int i = 1; i<c.length ; i++)
    		{
    			int index = t.contains(String.valueOf(c[i]));
    			if(index >= 0)
    			{
    				if(!t.childlist.isEmpty())
    					t = t.childlist.get(index);
    				l++;
    			}
    			else
    				return l;
    		}
    		return l;
    	}
    	else
    		return l;
    }
}
